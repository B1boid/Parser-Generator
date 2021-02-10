import grammar.Grammar;
import grammar.GrammarRule;
import grammar.TokenRule;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

class RuleGenerator {
    private Grammar curGrammar;

    RuleGenerator(Grammar curGrammar) {
        this.curGrammar = curGrammar;
    }

    void generate() throws IOException {
        StringBuilder ruleBuilder = new StringBuilder();
        StringBuilder tokenBuilder = new StringBuilder();
        StringBuilder parseBuilder = new StringBuilder();
        HashSet<String> rules = new HashSet<>();
        for (GrammarRule rule : curGrammar.getGrammarRules()) {
            if (!rules.contains(rule.getName())) {
                if (rule instanceof TokenRule) {
                    tokenBuilder.append("   ").append(rule.getName()).append(",\n");
                } else {
                    parseBuilder.append("   ").append(rule.getName()).append(",\n");
                }
                rules.add(rule.getName());
            }
        }

        ruleBuilder.append("package ").append(curGrammar.getGrammarName())
                .append(";\n\npublic enum Rule {\n   END,\n").append(tokenBuilder.toString()).append("\n")
                .append(parseBuilder.toString()).append("}");

        PrintWriter printWriter = new PrintWriter(new FileWriter("generated/" + curGrammar.getGrammarName() + "/Rule.java"));
        printWriter.print(ruleBuilder.toString());
        printWriter.close();
    }

}
