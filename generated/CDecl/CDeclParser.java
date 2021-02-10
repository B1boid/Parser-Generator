package CDecl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class CDeclParser {
    private CDeclLexicalAnalyzer lexer;

    public Node parse(String input) throws ParseException {
        this.lexer = new CDeclLexicalAnalyzer(input);
        lexer.nextToken();
        return vars();
    }

    public static class Node {
        public String val;

        private String name;
        private Rule rule;
        private List<Node> children = new ArrayList<>();

        public Node(String name, Rule rule) {
            this.name = name;
            this.rule = rule;
        }

        public List<Node> getChildren() {
            return children;
        }

        public String getName() {
            return name;
        }

        public Rule getRule() {
            return rule;
        }
    }

    private void checkToken(Rule expectedRule) throws ParseException {
        Rule curRule = lexer.getCurTokenRule();
        if (expectedRule != curRule) {
            throw new ParseException("Expected token: " + expectedRule.name() + ", but given " + curRule.name(), lexer.getCurPos());
        }
        lexer.nextToken();
    }

    public Node restNames() throws ParseException {
        Node res = new Node("restNames", Rule.restNames);
        switch(lexer.getCurTokenRule()) {
            case COMMA: {
                Node COMMA = new Node(lexer.getCurTokenName(), Rule.COMMA);
                res.children.add(COMMA);
                checkToken(Rule.COMMA);
                Node name = name();
                res.children.add(name);
                Node restNames = restNames();
                res.children.add(restNames);
                res.val = COMMA.getName() + name.val + restNames.val;
                break;
            }
            case SEMICOLON:
                res.val = "";
                break;
            default:
                throw new ParseException("Illegal token:" + lexer.getCurTokenName(), lexer.getCurPos());
        }
        return res;
    }

    public Node name() throws ParseException {
        Node res = new Node("name", Rule.name);
        switch(lexer.getCurTokenRule()) {
            case POINTER: {
                Node POINTER = new Node(lexer.getCurTokenName(), Rule.POINTER);
                res.children.add(POINTER);
                checkToken(Rule.POINTER);
                Node name = name();
                res.children.add(name);
                res.val = POINTER.getName() + name.val;
                break;
            }
            case VAR_NAME: {
                Node VAR_NAME = new Node(lexer.getCurTokenName(), Rule.VAR_NAME);
                res.children.add(VAR_NAME);
                checkToken(Rule.VAR_NAME);
                res.val = VAR_NAME.getName();
                break;
            }
            default:
                throw new ParseException("Illegal token:" + lexer.getCurTokenName(), lexer.getCurPos());
        }
        return res;
    }

    public Node vars() throws ParseException {
        Node res = new Node("vars", Rule.vars);
        switch(lexer.getCurTokenRule()) {
            case TYPE_NAME: {
                Node TYPE_NAME = new Node(lexer.getCurTokenName(), Rule.TYPE_NAME);
                res.children.add(TYPE_NAME);
                checkToken(Rule.TYPE_NAME);
                Node name = name();
                res.children.add(name);
                Node restNames = restNames();
                res.children.add(restNames);
                Node SEMICOLON = new Node(lexer.getCurTokenName(), Rule.SEMICOLON);
                res.children.add(SEMICOLON);
                checkToken(Rule.SEMICOLON);
                Node vars = vars();
                res.children.add(vars);
                res.val = TYPE_NAME.getName() + " " + name.val + restNames.val + ";\n" + vars.val;
                break;
            }
            case END:
                res.val = "";
                break;
            default:
                throw new ParseException("Illegal token:" + lexer.getCurTokenName(), lexer.getCurPos());
        }
        return res;
    }

}