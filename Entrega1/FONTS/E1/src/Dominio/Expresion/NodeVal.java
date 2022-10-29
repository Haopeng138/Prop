package Dominio.Expresion;

public class NodeVal {
    NODE_TYPE label;
    Object val;

    NodeVal(NODE_TYPE label, Object val) {
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
