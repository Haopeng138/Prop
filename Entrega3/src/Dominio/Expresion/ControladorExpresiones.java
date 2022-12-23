package Dominio.Expresion;

import java.util.HashMap;

public class ControladorExpresiones {

    HashMap<String, Expresion> expresiones;

    /**
     * Constructora vacia
     */
    public ControladorExpresiones() {
        this.expresiones = new HashMap<String, Expresion>();
    }

    /**
     * @param expresiones Constructora a partir de expresiones
     */
    public ControladorExpresiones(HashMap<String, Expresion> expresiones) {
        this.expresiones = expresiones;
    }

    /**
     * @return Las expresiones que hay
     */
    public HashMap<String, Expresion> getExpresiones() {
        return expresiones;
    }

    /**
     * @param alias El alias de una expresion
     * @return La expresion
     */
    public Expresion get(String alias) {
        if (!expresiones.containsKey(alias)) {
            System.out.println("Expresion no encontrada");
            return null;
        }
        return expresiones.get(alias);
    }

    /**
     * @param alias     El alias de la expresion a añadir
     * @param expresion La expresion
     * @throws ExpresionException Si la expresion es incorrecta
     */
    public void add(String alias, String expresion) throws ExpresionException {
        // this could be surrounded in a try catch, to check if expresion is valid
        expresiones.put(alias, new Expresion(expresion));
    }

    /**
     * @param alias El alias de la expresion a modificar
     * @param expr La nueva expresion
     * @return Si se ha modificado la expresion
     */
    public Boolean updateExpresion(String alias, String expr) {
        if (!expresiones.containsKey(alias)) {
            return false;
        }
        try {
            Expresion expresion = new Expresion(expr);
            expresiones.put(alias, expresion);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @param alias El alias de la expresion a borrar
     * @return Si se ha borrado la expresion
     */
    public Boolean remove(String alias) {
        if (!expresiones.containsKey(alias)) {
            return false;
        }
        expresiones.remove(alias);
        return true;
    }

    /**
     * @param alias El alias de la expresion
     * @return La expresion como string
     */
    public String getAsString(String alias) {
        if (!expresiones.containsKey(alias)) {
            System.out.println("Expresion no encontrada");
            return null;
        }
        return expresiones.get(alias).getExpresion();
    }
}
