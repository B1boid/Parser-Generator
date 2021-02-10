package Calc;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class CalcParser {
    private CalcLexicalAnalyzer lexer;

    public Node parse(String input) throws ParseException {
        this.lexer = new CalcLexicalAnalyzer(input);
        lexer.nextToken();
        return vAddSub();
    }

    public static class Node {
        public int val;

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

    public Node vMinus() throws ParseException {
        Node res = new Node("vMinus", Rule.vMinus);
        switch(lexer.getCurTokenRule()) {
            case SUB: {
                Node SUB = new Node(lexer.getCurTokenName(), Rule.SUB);
                res.children.add(SUB);
                checkToken(Rule.SUB);
                Node vMinus = vMinus();
                res.children.add(vMinus);
                res.val = -vMinus.val;
                break;
            }
            case NUM: {
                Node vPow = vPow();
                res.children.add(vPow);
                res.val = vPow.val;
                break;
            }
            case R_OPEN: {
                Node vPow = vPow();
                res.children.add(vPow);
                res.val = vPow.val;
                break;
            }
            default:
                throw new ParseException("Illegal token:" + lexer.getCurTokenName(), lexer.getCurPos());
        }
        return res;
    }

    public Node vMulDiv() throws ParseException {
        Node res = new Node("vMulDiv", Rule.vMulDiv);
        switch(lexer.getCurTokenRule()) {
            case SUB: {
                Node vMinus = vMinus();
                res.children.add(vMinus);
                Node wMulDiv = wMulDiv(vMinus.val);
                res.children.add(wMulDiv);
                res.val = wMulDiv.val;
                break;
            }
            case NUM: {
                Node vMinus = vMinus();
                res.children.add(vMinus);
                Node wMulDiv = wMulDiv(vMinus.val);
                res.children.add(wMulDiv);
                res.val = wMulDiv.val;
                break;
            }
            case R_OPEN: {
                Node vMinus = vMinus();
                res.children.add(vMinus);
                Node wMulDiv = wMulDiv(vMinus.val);
                res.children.add(wMulDiv);
                res.val = wMulDiv.val;
                break;
            }
            default:
                throw new ParseException("Illegal token:" + lexer.getCurTokenName(), lexer.getCurPos());
        }
        return res;
    }

    public Node vPow() throws ParseException {
        Node res = new Node("vPow", Rule.vPow);
        switch(lexer.getCurTokenRule()) {
            case NUM: {
                Node vExpr = vExpr();
                res.children.add(vExpr);
                Node wPow = wPow();
                res.children.add(wPow);
                res.val = (int) Math.pow(vExpr.val, wPow.val);
                break;
            }
            case R_OPEN: {
                Node vExpr = vExpr();
                res.children.add(vExpr);
                Node wPow = wPow();
                res.children.add(wPow);
                res.val = (int) Math.pow(vExpr.val, wPow.val);
                break;
            }
            default:
                throw new ParseException("Illegal token:" + lexer.getCurTokenName(), lexer.getCurPos());
        }
        return res;
    }

    public Node wAddSub(int acc) throws ParseException {
        Node res = new Node("wAddSub", Rule.wAddSub);
        switch(lexer.getCurTokenRule()) {
            case ADD: {
                Node ADD = new Node(lexer.getCurTokenName(), Rule.ADD);
                res.children.add(ADD);
                checkToken(Rule.ADD);
                Node vMulDiv = vMulDiv();
                res.children.add(vMulDiv);
                Node wAddSub = wAddSub(acc + vMulDiv.val);
                res.children.add(wAddSub);
                res.val = wAddSub.val;
                break;
            }
            case SUB: {
                Node SUB = new Node(lexer.getCurTokenName(), Rule.SUB);
                res.children.add(SUB);
                checkToken(Rule.SUB);
                Node vMulDiv = vMulDiv();
                res.children.add(vMulDiv);
                Node wAddSub = wAddSub(acc - vMulDiv.val);
                res.children.add(wAddSub);
                res.val = wAddSub.val;
                break;
            }
            case R_CLOSE:
                res.val = acc;
                break;
            case END:
                res.val = acc;
                break;
            default:
                throw new ParseException("Illegal token:" + lexer.getCurTokenName(), lexer.getCurPos());
        }
        return res;
    }

    public Node wPow() throws ParseException {
        Node res = new Node("wPow", Rule.wPow);
        switch(lexer.getCurTokenRule()) {
            case POW: {
                Node POW = new Node(lexer.getCurTokenName(), Rule.POW);
                res.children.add(POW);
                checkToken(Rule.POW);
                Node vPow = vPow();
                res.children.add(vPow);
                res.val = vPow.val;
                break;
            }
            case DIV:
                res.val = 1;
                break;
            case ADD:
                res.val = 1;
                break;
            case SUB:
                res.val = 1;
                break;
            case R_CLOSE:
                res.val = 1;
                break;
            case MUL:
                res.val = 1;
                break;
            case END:
                res.val = 1;
                break;
            default:
                throw new ParseException("Illegal token:" + lexer.getCurTokenName(), lexer.getCurPos());
        }
        return res;
    }

    public Node wMulDiv(int acc) throws ParseException {
        Node res = new Node("wMulDiv", Rule.wMulDiv);
        switch(lexer.getCurTokenRule()) {
            case MUL: {
                Node MUL = new Node(lexer.getCurTokenName(), Rule.MUL);
                res.children.add(MUL);
                checkToken(Rule.MUL);
                Node vMinus = vMinus();
                res.children.add(vMinus);
                Node wMulDiv = wMulDiv(acc * vMinus.val);
                res.children.add(wMulDiv);
                res.val = wMulDiv.val;
                break;
            }
            case DIV: {
                Node DIV = new Node(lexer.getCurTokenName(), Rule.DIV);
                res.children.add(DIV);
                checkToken(Rule.DIV);
                Node vMinus = vMinus();
                res.children.add(vMinus);
                Node wMulDiv = wMulDiv(acc / vMinus.val);
                res.children.add(wMulDiv);
                res.val = wMulDiv.val;
                break;
            }
            case ADD:
                res.val = acc;
                break;
            case SUB:
                res.val = acc;
                break;
            case R_CLOSE:
                res.val = acc;
                break;
            case END:
                res.val = acc;
                break;
            default:
                throw new ParseException("Illegal token:" + lexer.getCurTokenName(), lexer.getCurPos());
        }
        return res;
    }

    public Node vExpr() throws ParseException {
        Node res = new Node("vExpr", Rule.vExpr);
        switch(lexer.getCurTokenRule()) {
            case NUM: {
                Node NUM = new Node(lexer.getCurTokenName(), Rule.NUM);
                res.children.add(NUM);
                checkToken(Rule.NUM);
                res.val = Integer.parseInt(NUM.getName());
                break;
            }
            case R_OPEN: {
                Node R_OPEN = new Node(lexer.getCurTokenName(), Rule.R_OPEN);
                res.children.add(R_OPEN);
                checkToken(Rule.R_OPEN);
                Node vAddSub = vAddSub();
                res.children.add(vAddSub);
                Node R_CLOSE = new Node(lexer.getCurTokenName(), Rule.R_CLOSE);
                res.children.add(R_CLOSE);
                checkToken(Rule.R_CLOSE);
                res.val = vAddSub.val;
                break;
            }
            default:
                throw new ParseException("Illegal token:" + lexer.getCurTokenName(), lexer.getCurPos());
        }
        return res;
    }

    public Node vAddSub() throws ParseException {
        Node res = new Node("vAddSub", Rule.vAddSub);
        switch(lexer.getCurTokenRule()) {
            case SUB: {
                Node vMulDiv = vMulDiv();
                res.children.add(vMulDiv);
                Node wAddSub = wAddSub(vMulDiv.val);
                res.children.add(wAddSub);
                res.val = wAddSub.val;
                break;
            }
            case NUM: {
                Node vMulDiv = vMulDiv();
                res.children.add(vMulDiv);
                Node wAddSub = wAddSub(vMulDiv.val);
                res.children.add(wAddSub);
                res.val = wAddSub.val;
                break;
            }
            case R_OPEN: {
                Node vMulDiv = vMulDiv();
                res.children.add(vMulDiv);
                Node wAddSub = wAddSub(vMulDiv.val);
                res.children.add(wAddSub);
                res.val = wAddSub.val;
                break;
            }
            default:
                throw new ParseException("Illegal token:" + lexer.getCurTokenName(), lexer.getCurPos());
        }
        return res;
    }

}