package Dominio.Estructura;

/**
 * Clase Autor
 */
public class Autor {
    private String name;

    /**
     * @param name
     * Constructor
     */
    public Autor (String name){
        this.name = name;
    }

    /**
     * @return el nombre de el autor
     */
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
