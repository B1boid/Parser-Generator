package grammar;

public class GrammarRule {
    private String name;
    private String code;

    GrammarRule(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return (code.isEmpty()) ? code : code.substring(2, code.length() - 2);
    }
}

