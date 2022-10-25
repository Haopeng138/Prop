package Dominio.Expresion;

import java.util.ArrayDeque;
import java.util.Deque;

public class Expresion {

    private String alias;
    private String expresion;

    public Expresion(String expresion,String alias) {
        this.expresion = expresion;
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }

    public String getExpresion() {
        return expresion;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setExpresion(String expresion) {
        this.expresion = expresion;
    }

    /**
     * @param expr Una expresión
     * @return true si está bien balanceada,
     * falso en caso contrario
     */
    private boolean areBracketsBalanced(String expr)
    {
        // Using ArrayDeque is faster than using Stack class
        Deque<Character> stack = new ArrayDeque<Character>();

        // Traversing the Expression
        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);

            if (x == '(' || x == '{') {
                // Push the element in the stack
                stack.push(x);
                continue;
            }

            // If current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
            if (stack.isEmpty()) return false;
            char check;
            switch (x) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;

                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }

        // Check Empty Stack
        return (stack.isEmpty());
    }



}
