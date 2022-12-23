package Dominio.Expresion;

import java.util.ArrayDeque;
import java.util.Deque;

public class Expresion {

    private String expresion;

    /**
     * Constructora de la clase dada una expresión booleaana
     *
     * @param expresion Una expresión booleana
     * @throws ExpresionException Si la expresión booleana es incorrecta
     */
    public Expresion(String expresion) throws ExpresionException {
        if (areBracketsBalanced(expresion)) {
            this.expresion = expresion;
        } else {
            throw new ExpresionException("Expresion Invalida");
        }

    }

    /**
     * Método que devuelve la expresión
     *
     * @return La expresión booleana
     */
    public String getExpresion() {
        return expresion;
    }

    /**
     * Método para modificar una expresion
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

}
