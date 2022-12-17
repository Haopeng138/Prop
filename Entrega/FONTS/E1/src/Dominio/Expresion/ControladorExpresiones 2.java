package Dominio.Expresion;

import java.util.HashMap;

public class ControladorExpresiones {

    HashMap<String, Expresion> expresiones;

    public ControladorExpresiones() {
        this.expresiones = new HashMap<String, Expresion>();
    }

    public HashMap<String, Expresion> getExpresiones() {
        return expresiones;
    }

    public ControladorExpresiones(HashMap<String, Expresion> expresiones) {
        this.expresiones = expresiones;
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

    public String getAsString(String alias) {
        if (!expresiones.containsKey(alias)) {
            System.out.println("Expresion no encontrada");
            return null;
        }
        return expresiones.get(alias).getExpresion();
    }
}
