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
    private Boolean estado;


    public Documento(String autor,String titulo, String contenido){
        this.autor = new Autor(autor);
        this.titulo = new Titulo(titulo);
        this.contenido = contenido;
        this.estado = true;
    }
    public void setAutor(String autor){
        this.autor.setName(autor);
    }
    public void setTitulo(String titulo){
        this.titulo.setName(titulo);
    }
    public void setContenido(String contenido){
        this.contenido = contenido;
    }

    public String getAutor() {
        return autor.getName();
    }

    public String getContenido() {
        return contenido;
    }

    public String getTitulo() {
        return titulo.getName();
    }

    public static ArrayList<String> stringToArrayList(String contenido) {
        //ArrayList<String> separator = new ArrayList<>(Arrays.asList(".", ";", ",", " ", "(", ")", "{", "}", "!", "?", ":"));
        String contenidoMinusculas = contenido.toLowerCase();
        ArrayList<String> doc = new ArrayList<String>(Arrays.asList(contenidoMinusculas.split("[,. ¿?;:()¡!{}...]+")));
        return doc;
    }

    public static Boolean existe(ArrayList<String> doc, String p) {
        for (String palabra : doc) {
            if (p.equalsIgnoreCase(palabra)) return true;
        }
        return false;
    }
    public Boolean existePalabra(String palabra) {
        ArrayList<String> doc = new ArrayList<String>();
        doc = stringToArrayList(contenido);
        return existe(doc, palabra);
    }

    public Boolean existeString(String conjuntoPalabras) {
        ArrayList<String> conjPalabras = new ArrayList<String>();
        conjPalabras = stringToArrayList(conjuntoPalabras);
        int numeroPalabra = conjPalabras.size();
        for (int i = 0; i < conjPalabras.size(); ++i) {

        }
    }
}
