package Dominio.Estructura;

public class Titulo {
    private String name;

    public Titulo(){

    }
    public Titulo(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
}
