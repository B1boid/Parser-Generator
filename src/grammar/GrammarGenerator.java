package grammar;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map.Entry;

import static java.util.Map.entry;

public class GrammarGenerator {
    private String path;

    public GrammarGenerator(String path) {
        this.path = path;
    }

    private ArrayList<String> generateVars(gramParser.InputGrammarContext inputGrammar) {
        ArrayList<String> vars = new ArrayList<>();
        for (grammar.gramParser.VarContext curVar : inputGrammar.vars().var()) {
            vars.add(curVar.WORD(0) + " " + curVar.WORD(1) + ";");
        }
        return vars;
    }

    private void generateParseRules(String name, String arg, ArrayList<GrammarRule> rules,
                                    grammar.gramParser.CurRulesContext ctxRules) {
        if (ctxRules.OR() == null) {
            ArrayList<Entry<String, String>> children = new ArrayList<>();
            String code = "";
            if (ctxRules.CODE() != null) {
                code = ctxRules.CODE().getText();
            }
            for (grammar.gramParser.NameContext child : ctxRules.name()) {
                String curArg = "()";
                String curName;
                if (child.TOKEN() == null) {
                    if (child.ARG() != null) {
                        curArg = child.ARG().getText();
                    }
                    curName = child.WORD().getText();
                } else {
                    curName = child.TOKEN().getText();
                }
                children.add(entry(curName, curArg));
            }
            rules.add(new ParseRule(name, code, arg, children));
        } else {
            generateParseRules(name, arg, rules, ctxRules.curRules(0));
            generateParseRules(name, arg, rules, ctxRules.curRules(1));
        }

    }

    private ArrayList<GrammarRule> generateRules(gramParser.InputGrammarContext inputGrammar) {
        ArrayList<GrammarRule> rules = new ArrayList<>();
        for (grammar.gramParser.CurRuleContext curRule : inputGrammar.allRules().curRule()) {
            if (curRule.tokenRule() != null) {
                String regex = curRule.tokenRule().REG_EXPR().getText();
                String code = "";
                if (curRule.tokenRule().CODE() != null) {
                    code = curRule.tokenRule().CODE().getText();
                }
                rules.add(new TokenRule(curRule.tokenRule().TOKEN().getText(), code,
                        regex.substring(1, regex.length() - 1)));
            } else {
                String arg = "";
                if (curRule.parseRule().argInit() != null) {
                    arg = curRule.parseRule().argInit().WORD(0) + " " + curRule.parseRule().argInit().WORD(1);
                }
                generateParseRules(curRule.parseRule().WORD().getText(), arg, rules, curRule.parseRule().curRules());
            }

        }
        rules.add(new TokenRule("EPS", "",""));
        return rules;
    }


    public Grammar generate() throws IOException {
        String fileString = Files.readString(Paths.get(path));
        gramLexer lexer = new gramLexer(CharStreams.fromString(fileString));
        TokenStream tokens = new CommonTokenStream(lexer);
        gramParser parser = new gramParser(tokens);
        gramParser.InputGrammarContext inputGrammar = parser.inputGrammar();
        return new Grammar(inputGrammar.gramName().WORD().getText(),generateVars(inputGrammar), generateRules(inputGrammar));
    }

}
