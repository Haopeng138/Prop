package Dominio.Utils;

public class ParseNode {
    public NODE_TYPE label;
    public Object val;

    public ParseNode(NODE_TYPE label, Object val) {
        this.label = label;
        this.val = val;
    }

    public enum NODE_TYPE {
        OPERATOR,
        CONTAIN,
        MATCH
    }

    public enum OPERATOR {
        AND,
        OR,
        NOT
    }
}
