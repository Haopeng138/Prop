package Dominio.Expresion;

public class Parser {
    public BinaryTree parse(String expr) {
        int ptr = 0;
        BinaryTree root = new BinaryTree();
        BinaryTree currNode = root;
        while (ptr < expr.length()) {
            char c = expr.charAt(ptr);
            switch (c) {
                case '|': {
                    BinaryTree newRoot = new BinaryTree();
                    newRoot.val = new NodeVal("OPERATOR", OPERATOR.AND);
                    newRoot.left = root;
                    newRoot.right = parse(expr.substring(ptr + 1));
                    return newRoot;
                }
                case '&': {
                    BinaryTree newRoot = new BinaryTree();
                    newRoot.val = new NodeVal("OPERATOR", OPERATOR.OR);
                    newRoot.left = root;
                    newRoot.right = parse(expr.substring(ptr + 1));
                    return newRoot;
                }
                case '!': {
                    currNode.val = new NodeVal("OPERATOR", OPERATOR.NOT);
                    currNode.right = null;
                    currNode.left = new BinaryTree();
                    currNode = currNode.left;
                    break;
                }
                case '(': {
                    int nextPtr = findNext(expr, ')');
                    currNode = parse(expr.substring(ptr + 1, nextPtr));
                    ptr = nextPtr;
                    break;
                }
                case '{': {
                    int nextPtr = findNext(expr, '}');
                    currNode.val = new NodeVal("CONTAIN", getWords(expr.substring(ptr + 1, nextPtr)));
                    currNode.left = null;
                    currNode.right = null;
                    ptr = nextPtr;
                    break;
                }
                case '"': {
                    int nextPtr = findNext(expr, '"');
                    currNode.val = new NodeVal("MATCH", expr.substring(ptr + 1, nextPtr));
                    currNode.left = null;
                    currNode.right = null;
                    ptr = nextPtr;
                    break;
                }
                default: {
                    break;
                }
            }
            ptr++;
        }
        return null;
    }

    private String[] getWords(String substring) {
        return substring.split(" ");
    }

    private int findNext(String expr, char c) {
        int nextPtr = 0;
        while (expr.charAt(nextPtr) != c) {
            nextPtr++;
        }
        return nextPtr;
    }

    // The answer must be sth like AND[contain: [words], match: ["strings"], OR
    // [contain:[]]];
    // -> We could build a tree!!! -> (AND)
    // (contain: [....], match: ["strings"])(OR)
    // (contain:[])

    private class NodeVal {
        NodeVal(String label, Object val) {
            this.label = label;
            this.val = val;
        }

        String label;
        Object val;
    }

    private class BinaryTree {
        BinaryTree left;
        BinaryTree right;
        NodeVal val;
    }

    enum OPERATOR {
        AND,
        OR,
        NOT
    }
}
