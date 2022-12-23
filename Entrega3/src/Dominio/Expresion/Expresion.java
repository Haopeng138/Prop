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
     * Método que devuelve la expresión booleana
     *
     * @return La expresión booleana
     */
    public String getExpresion() {
        return expresion;
    }

    /**
     * Método para modificar una expresión
     * 
     * @param expresion Una expresión
     * @throws ExpresionException Expresión Inválida: compruebe los parentesis
     */
    public void setExpresion(String expresion) throws ExpresionException {
        if (areBracketsBalanced(expresion)) {
            this.expresion = expresion;
        } else {
            throw new ExpresionException("Expresion Invalida");
        }
    }

    /**
     * Método para confirmar si la expresióon está bien escrita
     * 
     * @param expr Una expresión
     * @return true si está bien balanceada, falso en el caso contrario
     */
    private boolean areBracketsBalanced(String expr) {
        Deque<Character> stack = new ArrayDeque<Character>();
        boolean open = true;
        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);
            if (x == '(' || x == '{') {
                stack.push(x);
                continue;
            }
            if (open && x == '"') {
                stack.push(x);
                open = false;
                continue;
            }

            char check;
            switch (x) {
                case ')':
                    try {
                        check = stack.pop();
                        if (check == '{' || check == '"')
                            return false;
                    } catch (Exception error) {
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
        return (stack.isEmpty());
    }
}
