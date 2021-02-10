package CDecl;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Map.Entry;
import static java.util.Map.entry;


public class CDeclLexicalAnalyzer {

    private Token curToken;
    private int curPos;

    private String input;
    private int length;

    private Pattern availablePatterns = Pattern.compile("(;)|(,)|((\\bint\\b|\\bdouble\\b|\\bfloat\\b|\\bbool\\b))|([A-Za-z_][A-Za-z0-9_]*)|(\\*)|([ \\n\\t\\r]+)|()");

    private List<Entry<Rule, Pattern>> tokenRules = new ArrayList<>(Arrays.asList(
     entry(Rule.SEMICOLON, Pattern.compile(";")),
     entry(Rule.COMMA, Pattern.compile(",")),
     entry(Rule.TYPE_NAME, Pattern.compile("(\\bint\\b|\\bdouble\\b|\\bfloat\\b|\\bbool\\b)")),
     entry(Rule.VAR_NAME, Pattern.compile("[A-Za-z_][A-Za-z0-9_]*")),
     entry(Rule.POINTER, Pattern.compile("\\*")),
     entry(Rule.SKIP, Pattern.compile("[ \\n\\t\\r]+")),
     entry(Rule.EPS, Pattern.compile(""))));

    private List<Rule> skipRules = new ArrayList<>(Collections.singletonList(Rule.SKIP));

    private static class Token {
        private Rule rule;
        private String name;

        Token(Rule rule, String name) {
            this.rule = rule;
            this.name = name;
        }

        Rule getRule() {
            return rule;
        }

        String getName() {
            return name;
        }
    }

    public CDeclLexicalAnalyzer(String input){
        this.curToken = new Token(Rule.EPS, "");
        this.curPos = 0;
        this.input = input;
        this.length = input.length();
    }

    public Rule getCurTokenRule() {
        return curToken.getRule();
    }

    public String getCurTokenName() {
        return curToken.getName();
    }

    public int getCurPos() {
        return curPos;
    }

    public void nextToken() throws ParseException {
        if (curPos == length) {
            curToken = new Token(Rule.END, "");
            return;
        }
        char curChar = input.charAt(curPos);
        curPos += 1;
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(curChar);
        String curStr = sBuilder.toString();
        if (availablePatterns.matcher(curStr).matches()) {
            Rule curRule = getCurRule(curStr);
            String prevStr = curStr;
            Rule prevRule = curRule;
            while (curPos < length) {
                curChar = input.charAt(curPos);
                curPos += 1;
                sBuilder.append(curChar);
                curStr = sBuilder.toString();
                curRule = getCurRule(curStr);
                if (availablePatterns.matcher(curStr).matches()) {
                    prevStr = curStr;
                    prevRule = curRule;
                } else {
                   curPos -= 1;
                    if (skipRules.contains(prevRule)){
                        nextToken();
                        return;
                    }
                    curToken = new Token(prevRule, prevStr);
                    return;
                }
            }
            curToken = new Token(curRule, curStr);
        } else {
            throw new ParseException("Illegal token " + curStr, curPos);
        }
    }

    private Rule getCurRule(String curStr) {
        for (Entry<Rule, Pattern> rule : tokenRules){
            if (rule.getValue().matcher(curStr).matches()){
                return rule.getKey();
            }
        }
        return Rule.EPS;
    }

}