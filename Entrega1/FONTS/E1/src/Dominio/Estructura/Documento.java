package Dominio.Estructura;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Documento {
    /**
     * Atributos de clase Documento
     */
    private String contenido;
    private Autor autor;
    private Titulo titulo;
    private Boolean estado;

    public Documento() {
    }

    /**
     * Método de creación de un documento
     * 
     * @param autor     Nombre del autor
     * @param titulo    Nombre del título
     * @param contenido Contenido del documento
     */

    public Documento(String autor, String titulo, String contenido) {
        this.autor = new Autor(autor);
        this.titulo = new Titulo(titulo);
        this.contenido = contenido;
    }

    /**
     * Método para actualizar el nombre del autor
     * 
     * @param autor Nombre nuevo del autor
     */
    public void setAutor(String autor) {
        this.autor.setName(autor);
    }

    /**
     * Método para actualizar el nombre del título
     * 
     * @param titulo Nombre nuevo del título
     */
    public void setTitulo(String titulo) {
        this.titulo.setName(titulo);
    }

    /**
     * Método para actualizar el contenido
     * 
     * @param contenido Contenido nuevo
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }


    /**
     * Método para devolver el nombre del autor
     * 
     * @return Nombre de autor
     */
    public String getAutor() {
        return autor.getName();
    }

    /**
     * Método para devolver el nombre del título
     * 
     * @return Nombre de título
     */
    public String getTitulo() {
        return titulo.getName();
    }

    /**
     * Método para devolver el contenido
     * 
     * @return Contenido
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Método para convertir un String en un ArrayList
     *
     * @return Contenido del documento en ArrayList
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
     * @param conjuntoPalabras Un conjunto de palabras
     * @return True, si el conjunto "conjuntoPalabras" está en el contenido
     *         False, en el caso contrario
     */
    // Búsqueda de un string en el contenido
    public Boolean existeString(String conjuntoPalabras) {
        int midaString = conjuntoPalabras.length();
        int i = 0;
        int j = 0;
        while (i < contenido.length() && j < midaString) {
            if (conjuntoPalabras.charAt(j) == contenido.charAt(i)) {
                ++i;
                ++j;
            } else {
                if (i + 1 < contenido.length() && conjuntoPalabras.charAt(j) != contenido.charAt(i + 1)) {
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