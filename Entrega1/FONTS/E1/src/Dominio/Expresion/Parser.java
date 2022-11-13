package Dominio.Expresion;

import Dominio.Utils.BinaryTree;
import Dominio.Utils.ParseNode;
import Dominio.Utils.ParseNode.NODE_TYPE;
import Dominio.Utils.ParseNode.OPERATOR;

public class Parser {
    public static BinaryTree<ParseNode> parse(String expr) throws Exception {
        int ptr = 0;
        BinaryTree<ParseNode> root = new BinaryTree<ParseNode>();
        BinaryTree<ParseNode> currNode = root;
        while (ptr < expr.length()) {
            char c = expr.charAt(ptr);
            switch (c) {
                case '|': {
                    BinaryTree<ParseNode> newRoot = new BinaryTree<ParseNode>();
                    newRoot.val = new ParseNode(NODE_TYPE.OPERATOR, OPERATOR.OR);
                    newRoot.left = root;
                    newRoot.right = parse(expr.substring(ptr + 1));
                    return newRoot;
                }
                case '&': {
                    BinaryTree<ParseNode> newRoot = new BinaryTree<ParseNode>();
                    newRoot.val = new ParseNode(NODE_TYPE.OPERATOR, OPERATOR.AND);
                    newRoot.left = root;
                    newRoot.right = parse(expr.substring(ptr + 1));
                    return newRoot;
                }
                case '!': {
                    currNode.val = new ParseNode(NODE_TYPE.OPERATOR, OPERATOR.NOT);
                    currNode.right = null;
                    currNode.left = new BinaryTree<ParseNode>();
                    currNode = currNode.left;
                    break;
                }
                case '(': {
                    int nextPtr = ptr + 1 + findNext(expr.substring(ptr + 1), ')');
                    BinaryTree<ParseNode> toCopyBecauseJavaSucks = parse(expr.substring(ptr + 1, nextPtr));
                    currNode.val = toCopyBecauseJavaSucks.val;
                    currNode.left = toCopyBecauseJavaSucks.left;
                    currNode.right = toCopyBecauseJavaSucks.right;
                    ptr = nextPtr;
                    break;
                }
                case '{': {
                    int nextPtr = ptr + 1 + findNext(expr.substring(ptr + 1), '}');
                    currNode.val = new ParseNode(NODE_TYPE.CONTAIN, getWords(expr.substring(ptr + 1, nextPtr)));
                    currNode.left = null;
                    currNode.right = null;
                    ptr = nextPtr;
                    break;
                }
                case '"': {
                    int nextPtr = ptr + 1 + findNext(expr.substring(ptr + 1), '"');
                    currNode.val = new ParseNode(NODE_TYPE.MATCH, expr.substring(ptr + 1, nextPtr));
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
                    currNode.val = new ParseNode(NODE_TYPE.CONTAIN, getWords(expr.substring(ptr, nextPtr)));
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

    private static int findNext(String expr, char c) throws Exception {
        int nextPtr = 0;
        char match = Matches.match(c);
        int count = 0;
        while (nextPtr < expr.length()) {
            if (expr.charAt(nextPtr) == c) {
                if (count == 0) {
                    return nextPtr;
                } else {
                    count--;
                }
            }
            if (expr.charAt(nextPtr) == match) {
                count++;
            }
            nextPtr++;
        }
        if (nextPtr == 0) {
            throw new Exception("No closing token found: " + c);
        }
        return nextPtr;
    }

    private static int findNextOrEnd(String expr, char c) {
        try {
            int nextPtr = findNext(expr, c);
            return nextPtr;
        } catch (Exception e) {
            return expr.length();
        }
    }

    protected static class Matches {
        protected static char match(char c) {
            switch (c) {
                case ')': {
                    return '(';
                }
                case '}': {
                    return '{';
                }
                case '"': {
                    return '"';
                }
                default: {
                    return ' ';
                }
            }
        }
    }
}
