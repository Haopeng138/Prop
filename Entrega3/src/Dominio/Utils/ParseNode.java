package Dominio.Utils;

public class ParseNode {
    public NODE_TYPE label;
    public Object val;

    /**
     * Método
     *
     * @param label El tipo de nodo
     * @param val   El valor del nodo
     */
    public ParseNode(NODE_TYPE label, Object val) {
        this.label = label;
        this.val = val;
    }

    /**
     * Los tipos de nodos que pueden haber
     */
    public enum NODE_TYPE {
        OPERATOR,
        CONTAIN,
        MATCH
    }

    /**
     * Los tipos de operatores que pueden haber
     */
    public enum OPERATOR {
        AND,
        OR,
        NOT
    }
}

