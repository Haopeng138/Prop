package Dominio.Expresion;

import java.util.HashMap;

import Dominio.Utils.BinaryTree;
import Dominio.Utils.ParseNode;

public class ControladorExpresiones {

    HashMap<String, Expresion> expresiones; // prob better to hashMap by alias

    public ControladorExpresiones() {
        this.expresiones = new HashMap<String, Expresion>();
    }

    public Expresion get(String alias) {
        if (!expresiones.containsKey(alias)) {
            System.out.println("Expresion no encontrada");
            return null;
        }
        return expresiones.get(alias);
    }

    public void add(String alias, String expresion) throws ExpresionException {
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

    public BinaryTree<ParseNode> parseFromAlias(String alias) throws Exception {

        if (!expresiones.containsKey(alias)) {
            return null;
        }
        Expresion expresion = expresiones.get(alias);
        return Parser.parse(expresion.getExpresion());

    }

    public String getAsString(String alias) {
        if (!expresiones.containsKey(alias)) {
            System.out.println("Expresion no encontrada");
            return null;
        }
        return expresiones.get(alias).getExpresion();
    }
}
