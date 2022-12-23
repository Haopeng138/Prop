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
     * @param name El nombre del titulo
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Titulo that = (Titulo) o;
        return name.equals(that.getName());
    }
}
