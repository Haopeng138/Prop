package Dominio.Expresion;

import Dominio.Expresion.NodeVal.OPERATOR;
import Dominio.Expresion.NodeVal.NODE_TYPE;

public class Parser {
    public static BinaryTree<NodeVal> parse(String expr) {
        int ptr = 0;
        BinaryTree<NodeVal> root = new BinaryTree<NodeVal>();
        BinaryTree<NodeVal> currNode = root;
        while (ptr < expr.length()) {
            char c = expr.charAt(ptr);
            switch (c) {
                case '|': {
                    BinaryTree<NodeVal> newRoot = new BinaryTree<NodeVal>();
                    newRoot.val = new NodeVal(NODE_TYPE.OPERATOR, OPERATOR.OR);
                    newRoot.left = root;
                    newRoot.right = parse(expr.substring(ptr + 1));
                    return newRoot;
                }
                case '&': {
                    BinaryTree<NodeVal> newRoot = new BinaryTree<NodeVal>();
                    newRoot.val = new NodeVal(NODE_TYPE.OPERATOR, OPERATOR.AND);
                    newRoot.left = root;
                    newRoot.right = parse(expr.substring(ptr + 1));
                    return newRoot;
                }
                case '!': {
                    currNode.val = new NodeVal(NODE_TYPE.OPERATOR, OPERATOR.NOT);
                    currNode.right = null;
                    currNode.left = new BinaryTree<NodeVal>();
                    currNode = currNode.left;
                    break;
                }
                case '(': {
                    int nextPtr = ptr + 1 + findNext(expr.substring(ptr + 1), ')');
                    BinaryTree<NodeVal> toCopyBecauseJavaSucks = parse(expr.substring(ptr + 1, nextPtr));
                    currNode.val = toCopyBecauseJavaSucks.val;
                    currNode.left = toCopyBecauseJavaSucks.left;
                    currNode.right = toCopyBecauseJavaSucks.right;
                    ptr = nextPtr;
                    break;
                }
                case '{': {
                    int nextPtr = ptr + 1 + findNext(expr.substring(ptr + 1), '}');
                    currNode.val = new NodeVal(NODE_TYPE.CONTAIN, getWords(expr.substring(ptr + 1, nextPtr)));
                    currNode.left = null;
                    currNode.right = null;
                    ptr = nextPtr;
                    break;
                }
                case '“': {
                    int nextPtr = ptr + 1 + findNext(expr.substring(ptr + 1), '”');
                    currNode.val = new NodeVal(NODE_TYPE.MATCH, expr.substring(ptr + 1, nextPtr));
                    currNode.left = null;
                    currNode.right = null;
                    ptr = nextPtr;
                    break;
                }
                case ' ': {
                    break;
                }
                default: {
                    int nextPtr = ptr + 1 + findNextOrEnd(expr.substring(ptr + 1), ' ');
                    currNode.val = new NodeVal(NODE_TYPE.CONTAIN, getWords(expr.substring(ptr, nextPtr)));
                    currNode.left = null;
                    currNode.right = null;
                    ptr = nextPtr;
                    break;
                }
            }
            ptr++;
        }
        return root;
    }

    private static String[] getWords(String words) {
        return words.split(" ");
    }

    private static int findNext(String expr, char c) {
        int nextPtr = 0;
        while (expr.charAt(nextPtr) != c) {
            nextPtr++;
        }
        return nextPtr;
    }

    private static int findNextOrEnd(String expr, char c) {
        try {
            int nextPtr = findNext(expr, c);
            return nextPtr;
        } catch (StringIndexOutOfBoundsException e) {
            return expr.length();
        }
    }
}
