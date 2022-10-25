package Dominio.Estructura;

public class Autor implements Comparable<Autor> {
    private String name;

    public Autor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Autor a) {
        return name.compareTo(a.getName());
    }
}
