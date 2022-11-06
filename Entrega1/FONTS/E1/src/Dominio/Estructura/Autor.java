package Dominio.Estructura;

public class Autor implements Comparable<Autor> {

    /**
     * Atributos de clase Autor
     */
    private String name;

    /**
     * Constructor por defecto de la clase
     * @param name Nombre del autor
     */
    public Autor(String name) {
        this.name = name;
    }

    /**
     * @return El nombre del autor
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica el nombre del autor
     * @param name Nombre al cual quieres modificar
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;

    }

    /**
     * Compara con el nombre del autor lexicograficamente
     * @param a Autor a ser comparado
     * @return
     */
    @Override
    public int compareTo(Autor a) {
        return name.compareTo(a.getName());
    }
}
