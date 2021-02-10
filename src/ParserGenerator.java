import grammar.*;
import org.apache.commons.lang3.text.StrSubstitutor;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;

class ParserGenerator {

    private Grammar grammar;
    private Map<String, HashSet<String>> first = new HashMap<>();
    private Map<String, HashSet<String>> follow = new HashMap<>();

    ParserGenerator(Grammar grammar) {
        this.grammar = grammar;
    }


    private void constructFirst() {
        Map<List<String>, HashSet<String>> firstR = new HashMap<>();

        for (GrammarRule rule : grammar.getGrammarRules()) {
            first.put(rule.getName(), new HashSet<>());
            if (rule instanceof TokenRule) {
                firstR.put(List.of(rule.getName()), new HashSet<>());
            } else {
                firstR.put(((ParseRule) rule).getChildrenNames(), new HashSet<>());
            }
        }
        boolean changed = true;
        while (changed) {
            changed = false;
            for (GrammarRule rule : grammar.getGrammarRules()) {
                String name = rule.getName();
                HashSet<String> last = new HashSet<>(first.get(name));
                if (rule instanceof TokenRule) {
                    first.get(name).add(name);
                    firstR.get(List.of(name)).add(name);
                } else {
                    ArrayList<String> children = ((ParseRule) rule).getChildrenNames();
                    first.get(name).addAll(first.get(children.get(0)));
                    firstR.get(children).addAll(first.get(children.get(0)));
                }
                changed = !last.equals(first.get(name)) || changed;
            }
        }
    }

    private HashSet<String> constructFollow() {
        HashSet<String> parseRulesNames = new HashSet<>();
        for (GrammarRule rule : grammar.getGrammarRules()) {
            follow.put(rule.getName(), new HashSet<>());
            if (rule instanceof ParseRule) {
                parseRulesNames.add(rule.getName());
            }
        }
        follow.get(grammar.getGrammarRules().get(0).getName()).add("END");
        boolean changed = true;
        while (changed) {
            changed = false;
            for (GrammarRule rule : grammar.getGrammarRules()) {
                if (rule instanceof ParseRule) {
                    ArrayList<String> children = ((ParseRule) rule).getChildrenNames();
                    for (int i = 0; i < children.size(); i++) {
                        if (parseRulesNames.contains(children.get(i))) {
                            String name = children.get(i);
                            HashSet<String> last = new HashSet<>(follow.get(name));
                            String tmp = (children.size() != i + 1) ? children.get(i + 1) : "EPS";
                            HashSet<String> hs = new HashSet<>(first.get(tmp));
                            hs.remove("EPS");
                            follow.get(name).addAll(hs);
                            if (first.get(tmp).contains("EPS")) {
                                follow.get(name).addAll(follow.get(rule.getName()));
                            }
                            changed = !last.equals(follow.get(name)) || changed;
                        }
                    }
                }
            }
        }

        return parseRulesNames;
    }


    void generate() throws IOException {
        constructFirst();
        HashSet<String> parseRulesNames = constructFollow();
        Map<String, StringBuilder> content = new HashMap<>();
        String t = "    ";
        String t2 = "        ";
        String t3 = "            ";
        String t4 = "                ";
        String gramName = grammar.getGrammarName();
        for (GrammarRule grammarRule : grammar.getGrammarRules()) {
            if (grammarRule instanceof ParseRule) {
                ParseRule parseRule = (ParseRule) grammarRule;

                String name = parseRule.getName();

                if (!content.containsKey(name)) {
                    String arg = parseRule.getArgument();
                    Map<String, String> valuesMap = Map.of("name", name, "arg", arg, "t", t, "t2", t2);
                    StringBuilder initSb = new StringBuilder(new StrSubstitutor(valuesMap).replace(
                            "${t}public Node ${name}(${arg}) throws ParseException {\n" +
                                    "${t2}Node res = new Node(\"${name}\", Rule.${name});\n" +
                                    "${t2}switch(lexer.getCurTokenRule()) {\n"));
                    content.put(name, initSb);
                }

                StringBuilder res = content.get(name);


                HashSet<String> tokens = first.get(parseRule.getChildrenNames().get(0));
                for (String token : tokens) {
                    if (token.equals("EPS")) {
                        for (String fol : follow.get(name)) {
                            Map<String, String> valuesMap = Map.of("t3", t3, "t4", t4);
                            res.append(new StrSubstitutor(valuesMap).replace(
                                    "${t3}case " + fol + ":\n" +
                                            "${t4}" + parseRule.getCode() +
                                            "\n${t4}break;\n"));
                        }
                    } else {
                        String caseStr = "            case " + token + ": {\n";
                        res.append(caseStr);
                        for (Entry<String, String> child : parseRule.getChildren()) {
                            String curRule = child.getKey();
                            if (parseRulesNames.contains(curRule)) {
                                String curArg = child.getValue();
                                Map<String, String> valuesMap = Map.of("curRule", curRule, "curArg", curArg, "t4", t4);
                                res.append(new StrSubstitutor(valuesMap).replace(
                                        "${t4}Node ${curRule} = ${curRule}${curArg};\n" +
                                                "${t4}res.children.add(${curRule});\n"
                                ));
                            } else {
                                Map<String, String> valuesMap = Map.of("curRule", curRule, "t4", t4);
                                res.append(new StrSubstitutor(valuesMap).replace(
                                        "${t4}Node ${curRule} = new Node(lexer.getCurTokenName(), Rule.${curRule});\n" +
                                                "${t4}res.children.add(${curRule});\n" +
                                                "${t4}checkToken(Rule.${curRule});\n"));
                            }
                        }
                        Map<String, String> valuesMap = Map.of("t3", t3, "t4", t4);
                        res.append(new StrSubstitutor(valuesMap).replace(
                                "${t4}" + parseRule.getCode() + "\n${t4}break;\n${t3}}\n"));
                    }
                }
                content.put(name, res);
            }
        }

        StringBuilder allNodes = new StringBuilder();
        StringBuilder vars = new StringBuilder();
        for (String var : grammar.getGrammarVars()) {
            vars.append("        public ").append(var).append("\n");
        }
        Map<String, String> valuesMap = Map.of("name", gramName, "vars", vars.toString(),
                "startRule", grammar.getGrammarRules().get(0).getName(),
                "t", t, "t2", t2, "t3", t3, "t4", t4);
        String fileString = Files.readString(Paths.get("templates/GeneratorTemplate"));
        String code = new StrSubstitutor(valuesMap).replace(fileString);
        allNodes.append(code);
        for (StringBuilder val : content.values()) {
            String nodeEnd = "${t3}default:\n" +
                    "${t4}throw new ParseException(\"Illegal token:\" + lexer.getCurTokenName(), lexer.getCurPos());\n" +
                    "${t2}}\n" +
                    "${t2}return res;\n" +
                    "${t}}\n";
            allNodes.append(val.toString()).append(new StrSubstitutor(valuesMap).replace(nodeEnd)).append("\n");
        }
        allNodes.append("}");

        PrintWriter printWriter = new PrintWriter(new FileWriter("generated/" + gramName + "/" + gramName + "Parser.java"));
        printWriter.print(allNodes.toString());
        printWriter.close();


    }
}
