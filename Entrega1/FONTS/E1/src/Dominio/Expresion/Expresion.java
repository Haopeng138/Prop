package Dominio.Expresion;

import java.util.ArrayDeque;
import java.util.Deque;

public class Expresion {

    private String expresion;

    public Expresion(String expresion) throws ExpresionException {
        // if (isValid)
        // else maybe create a new type of Exception and throw that. Invalid Expresion
        // exception.
        if (areBracketsBalanced(expresion)){
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
     * @param expresion Una expresión
     * @throws ExpresionException Expresion Invalida: compruebe los parentesis
     */
    public void setExpresion(String expresion) throws ExpresionException{
        if (areBracketsBalanced(expresion)){
            this.expresion = expresion;
        } else {
            throw new ExpresionException("Expresion Invalida");
        }
    }

    /**
     * Metodo para confirmar si la expresion está bien escrita
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
            }
        }

        // Check Empty Stack
        return (stack.isEmpty());
    }



}
