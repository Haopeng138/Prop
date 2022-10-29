package Dominio.Expresion;

import java.util.HashMap;

public class ControladorExpresiones {

    HashMap<String, Expresion> expresiones; // prob better to hashMap by alias

    public void add(String alias, String expresion) {
        // this could be surrounded in a try catch, to check if expresion is valid
        expresiones.put(alias, new Expresion(expresion));
    }

    public Boolean updateAlias(String oldAlias, String newAlias) {
        if (!expresiones.containsKey(oldAlias)) {
            return false;
        }
        Expresion expresion = expresiones.get(oldAlias);
        expresiones.remove(oldAlias);
        expresiones.put(newAlias, expresion);
        return true;
    }

    public Boolean updateExpresion(String alias, String expr) {
        if (!expresiones.containsKey(alias)) {
            return false;
        }
        try {
            Expresion expresion = new Expresion(expr);
            expresiones.put(alias, expresion);
            return true;

        } catch (Exception e) {
            return false; // Not clear if it's cuz alias is not in map;
            // prob better -> throw new InvalidExpressionException();
        }
    }

    public Boolean remove(String alias) {
        if (!expresiones.containsKey(alias)) {
            return false;
        }
        expresiones.remove(alias);
        return true;
    }

    // Handle error on creating expresion
    public BinaryTree<ParseNode> parseFromStringExpr(String expr) {
        Expresion expresion = new Expresion(expr);
        // if this doesn't throw anything...
        // else we need to say it's invalid in some way
        // throw new InvalidExpressionException();
        return Parser.parse(expr);
    }

    public BinaryTree<ParseNode> parseFromAlias(String alias) {
        if (!expresiones.containsKey(alias)) {
            return null;
        }
        Expresion expresion = expresiones.get(alias);
        return Parser.parse(expresion.getExpresion());
    }

    public static void main(String[] args) {
        BinaryTree<ParseNode> bT = Parser.parse("{p1 p2 p3} & (“hola adéu” | pep) & !joan");
    }
}
