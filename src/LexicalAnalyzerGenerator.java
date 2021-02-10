import grammar.Grammar;
import grammar.GrammarRule;

import grammar.TokenRule;
import org.apache.commons.lang3.text.StrSubstitutor;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

class LexicalAnalyzerGenerator {
    private Grammar curGrammar;

    LexicalAnalyzerGenerator(Grammar curGrammar) {
        this.curGrammar = curGrammar;
    }

    void generate() throws IOException {
        StringBuilder patternBuilder = new StringBuilder();
        patternBuilder.append("\"");
        StringBuilder tokensBuilder = new StringBuilder();
        String skip = "";
        for (GrammarRule rule : curGrammar.getGrammarRules()) {
            if (rule instanceof TokenRule) {
                if (rule.getName().equals("SKIP")) {
                    skip = " = new ArrayList<>(Collections.singletonList(Rule." + rule.getName() + "))";
                }
                TokenRule curRule = (TokenRule) rule;
                patternBuilder.append("(").append(curRule.getPattern()).append(")|");
                tokensBuilder.append("\n     entry(Rule.").append(curRule.getName()).append(", ")
                        .append("Pattern.compile(\"").append(curRule.getPattern()).append("\")),");
            }
        }
        patternBuilder.deleteCharAt(patternBuilder.toString().length() - 1).append("\"");
        tokensBuilder.deleteCharAt(tokensBuilder.toString().length() - 1);
        String allPatterns = patternBuilder.toString().replace("\\", "\\\\");
        String tokens = tokensBuilder.toString().replace("\\", "\\\\");

        String name = curGrammar.getGrammarName();
        Map<String, String> valuesMap = Map.of("name", name, "allPatterns", allPatterns, "tokens", tokens, "skip", skip);

        String fileString = Files.readString(Paths.get("templates/LexicalAnalyzerTemplate"));
        String code = new StrSubstitutor(valuesMap).replace(fileString);

        PrintWriter printWriter = new PrintWriter(new FileWriter("generated/" + name + "/" + name + "LexicalAnalyzer.java"));
        printWriter.print(code);
        printWriter.close();


    }


}
