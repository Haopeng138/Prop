package Dominio.Expresion;

public class ParseNode {
    NODE_TYPE label;
    Object val;

    ParseNode(NODE_TYPE label, Object val) {
        this.label = label;
        this.val = val;
    }

    enum NODE_TYPE {
        OPERATOR,
        CONTAIN,
        MATCH
    }

    enum OPERATOR {
        AND,
        OR,
        NOT
    }
}
