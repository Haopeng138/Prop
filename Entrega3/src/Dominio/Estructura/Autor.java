package Dominio.Estructura;

public class Autor implements Comparable<Autor> {

    /**
     * Atributos de clase Autor
     */
    private String name;

    public Autor() {

    }

    /**
     * Constructor por defecto de la clase
     *
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
     *
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
     *
     * @param aut Autor a ser comparado
     * @return
     */
    @Override
    public int compareTo(Autor aut) {
        return name.compareTo(aut.getName());
    }

    /**
     * Compara que coincida el nombre del autor
     *
     * @param obj Autor a ser comparado
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Autor that = (Autor) obj;
        return name == that.getName();
    }
}