package grammar;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class ParseRule extends GrammarRule {
    private String argument;
    private ArrayList<Entry<String, String>> children;

    ParseRule(String name, String code, String argument, ArrayList<Entry<String, String>> children) {
        super(name, code);
        this.argument = argument;
        this.children = children;
    }


    public String getArgument() {
        return argument;
    }

    public ArrayList<Entry<String, String>> getChildren() {
        return children;
    }

    public ArrayList<String> getChildrenNames(){
        return children.stream().map(Entry::getKey).collect(Collectors.toCollection(ArrayList::new));
    }
}
