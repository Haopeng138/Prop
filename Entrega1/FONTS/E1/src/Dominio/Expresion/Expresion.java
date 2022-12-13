package Dominio.Expresion;

import java.util.ArrayDeque;
import java.util.Deque;

import Dominio.Utils.BinaryTree;
import Dominio.Utils.ParseNode;
import Dominio.Utils.ParseNode.NODE_TYPE;
import Dominio.Utils.ParseNode.OPERATOR;

public class Expresion {

    private String expresion;

    public Expresion(String expresion) throws ExpresionException {
        if (areBracketsBalanced(expresion)) {
            this.expresion = expresion;
        } else {
            throw new ExpresionException("Expresion Invalida");
        }

    }

    public String getExpresion() {
        return expresion;
    }

    /**
     * Metodo para modificar una expresion
     * 
     * @param expresion Una expresión
     * @throws ExpresionException Expresion Invalida: compruebe los parentesis
     */
    public void setExpresion(String expresion) throws ExpresionException {
        if (areBracketsBalanced(expresion)) {
            this.expresion = expresion;
        } else {
            throw new ExpresionException("Expresion Invalida");
        }
    }

    /**
     * Metodo para confirmar si la expresion está bien escrita
     * 
     * @param expr Una expresión
     * @return true si está bien balanceada,
     *         falso en caso contrario
     */
    private boolean areBracketsBalanced(String expr) {
        // Using ArrayDeque is faster than using Stack class
        Deque<Character> stack = new ArrayDeque<Character>();

        boolean open = true;
        // Traversing the Expression
        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);

            if (x == '(' || x == '{') {
                // Push the element in the stack
                stack.push(x);
                continue;
            }

            if (open && x == '"') {
                stack.push(x);
                open = false;
                continue;
            }

            // If current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.

            char check;
            switch (x) {
                case ')':
                    try {
                        check = stack.pop();
                        if (check == '{' || check == '"')
                            return false;
                    } catch (Exception error) {
                        // Error cuando no hay nada
                        return false;
                    }

                    break;

                case '}':
                    try {
                        check = stack.pop();
                        if (check == '(' || check == '"')
                            return false;
                    } catch (Exception error) {
                        return false;
                    }

                    break;
                case '"':
                    try {
                        check = stack.pop();
                        if (check == '(' || check == '{')
                            return false;
                        open = true;
                    } catch (Exception error) {
                        return false;
                    }

                    break;
            }
        }
        // Check Empty Stack
        return (stack.isEmpty());
    }

    public BinaryTree<ParseNode> parse() throws Exception {
        return parse(expresion);
    }

    private BinaryTree<ParseNode> parse(String expr) throws Exception {
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

    private String[] getWords(String words) {
        return words.split(" ");
    }

    private int findNext(String expr, char c) throws Exception {
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

    private int findNextOrEnd(String expr, char c) {
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
