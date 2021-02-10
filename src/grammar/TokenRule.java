package grammar;

public class TokenRule extends GrammarRule {
    private String pattern;

    TokenRule(String name, String code, String pattern) {
        super(name, code);
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}