package Dominio.Expresion;

import java.util.HashMap;

public class ControladorExpresiones {

    HashMap<String, Expresion> expresiones;

    /**
     * Constructora vacía
     */
    public ControladorExpresiones() {
        this.expresiones = new HashMap<String, Expresion>();
    }

    /**
     * Constructora dado un conjunto de expresiones
     *
     * @param expresiones Un conjunto de expresiones
     */
    public ControladorExpresiones(HashMap<String, Expresion> expresiones) {
        this.expresiones = expresiones;
    }

    /**
     * Método que devuelve el conjunto de expresiones que hay en el sistema
     *
     * @return El conjunto de expresiones que hay en el sistema
     */
    public HashMap<String, Expresion> getExpresiones() {
        return expresiones;
    }

    /**
     * Método que devuelve la expresión booleana dada su alia
     *
     * @param alias El alias de una expresión
     * @return La expresión booleana
     */
    public Expresion get(String alias) {
        if (!expresiones.containsKey(alias)) {
            System.out.println("Expresion no encontrada");
            return null;
        }
        return expresiones.get(alias);
    }

    /**
     * Método que añade una expresión boolean junto su alia
     *
     * @param alias     El alias de la expresión a añadir
     * @param expresion La expresión booleana
     * @throws ExpresionException Si la expresión booleana es incorrecta
     */
    public void add(String alias, String expresion) throws ExpresionException {
        expresiones.put(alias, new Expresion(expresion));
    }

    /**
     * Método que verifica si ha modificado correctamente la expresión
     *
     * @param alias El alias de la expresión a modificar
     * @param expr La nueva expresión
     * @return True si se ha modificado la expresión, false en el caso contrario
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
     * Método que verifica si ha borrado correctamente la expresión
     *
     * @param alias El alias de la expresión a borrar
     * @return True si se ha borrado la expresión, false en el caso contrario
     */
    public Boolean remove(String alias) {
        if (!expresiones.containsKey(alias)) {
            return false;
        }
        expresiones.remove(alias);
        return true;
    }

    /**
     * Método que devuelve la expresión como String
     *
     * @param alias El alias de la expresión
     * @return La expresión como String
     */
    public String getAsString(String alias) {
        if (!expresiones.containsKey(alias)) {
            System.out.println("Expresion no encontrada");
            return null;
        }
        return expresiones.get(alias).getExpresion();
    }
}