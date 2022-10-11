package Dominio;
import Dominio.Autor;
import Dominio.Titulo;
public class Documento {
    private String contenido;
    private Autor autor;
    private Titulo titulo;
    public Documento(String autor,String titulo, String contenido){
        this.autor = new Autor(autor);
        this.titulo = new Titulo(titulo);
        this.contenido = contenido;
    }

}
