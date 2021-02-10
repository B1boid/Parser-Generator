package grammar;

import java.util.ArrayList;

public class Grammar {
    private String name;
    private ArrayList<GrammarRule> rules;
    private ArrayList<String> vars;

    Grammar(String name,ArrayList<String> vars, ArrayList<GrammarRule> rules) {
        this.name = name;
        this.vars = vars;
        this.rules = rules;
    }

    public String getGrammarName(){
        return name;
    }

    public ArrayList<GrammarRule> getGrammarRules(){
        return rules;
    }

    public ArrayList<String> getGrammarVars(){
        return vars;
    }
}

