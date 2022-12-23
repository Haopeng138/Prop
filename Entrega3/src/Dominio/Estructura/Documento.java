package Dominio.Estructura;

import java.util.ArrayList;
import java.util.Arrays;

public class Documento {
    /**
     * Atributos de clase Documento
     */
    private String contenido;
    private Autor autor;
    private Titulo titulo;

    public Documento() {
    }

    /**
     * Método de creación de un documento
     *
     * @param aut   Un nombre del autor
     * @param tit   Un título
     * @param cont  Un contenido
     */

    public Documento(String aut, String tit, String cont) {
        this.autor = new Autor(aut);
        this.titulo = new Titulo(tit);
        this.contenido = cont;
    }

    /**
     * Método para actualizar el nombre del autor
     *
     * @param aut Un nombre nuevo del autor
     */
    public void setAutor(String aut) {
        this.autor.setName(aut);
    }

    /**
     * Método para actualizar el título
     *
     * @param tit Un título nuevo
     */
    public void setTitulo(String tit) {
        this.titulo.setName(tit);
    }

    /**
     * Método para actualizar el contenido
     *
     * @param cont Un contenido nuevo
     */
    public void setContenido(String cont) {
        this.contenido = cont;
    }

    /**
     * Método para devolver el nombre del autor
     *
     * @return El nombre de autor
     */
    public String getAutor() {
        return autor.getName();
    }

    /**
     * Método para devolver el título
     *
     * @return El título
     */
    public String getTitulo() {
        return titulo.getName();
    }

    /**
     * Método para devolver el contenido
     *
     * @return El contenido
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Método para convertir un String en un ArrayList
     *
     * @return El contenido del documento en ArrayList
     */
    public ArrayList<String> stringToArrayList() {
        // ArrayList<String> separator = new ArrayList<>(Arrays.asList(".", ";", ",", "
        // ", "(", ")", "{", "}", "!", "?", ":"));
        String contenidoMinusculas = contenido.toLowerCase();
        ArrayList<String> doc = new ArrayList<String>(Arrays.asList(contenidoMinusculas.split("[,. ¿?;:()¡!{}...]+")));
        return doc;
    }

    /**
     * Método para verificar la existencia de un String en el contenido
     *
     * @param conjPalabras Un conjunto de palabras
     * @return True, si el conjunto "conjPalabras" está en el contenido
     *         False, en el caso contrario
     */
    public Boolean existeString(String conjPalabras) {
        int midaString = conjPalabras.length();
        int i = 0;
        int j = 0;
        while (i < contenido.length() && j < midaString) {
            if (conjPalabras.charAt(j) == contenido.charAt(i)) {
                ++i;
                ++j;
            } else {
                if (i + 1 < contenido.length() && conjPalabras.charAt(j) != contenido.charAt(i + 1)) {
                    ++i;
                    j = 0;
                } else {
                    ++i;
                    j = 0;
                }
            }
        }
        return j == midaString;
    }
}