package Dominio.Estructura;

public class Titulo {
    private String name;

    public Titulo() {
    }

    /**
     * Método constructor de la clase
     *
     * @param name El nombre del título
     */
    public Titulo(String name) {
        this.name = name;
    }

    /**
     * Método que modifica el título
     *
     * @param name El título nuevo
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método que devuelve el título
     *
     * @return El título
     */
    public String getName() {
        return name;
    }

    /**
     * Método que devuelve el título
     *
     * @return El título en String
     */
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Titulo that = (Titulo) obj;
        return name.equals(that.getName());
    }
}