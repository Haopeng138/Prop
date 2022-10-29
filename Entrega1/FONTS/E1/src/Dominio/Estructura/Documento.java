package Dominio.Estructura;

public class Documento {
    private String contenido;
    private Autor autor;
    private Titulo titulo;
    public Documento(String autor,String titulo, String contenido){
        this.autor = new Autor(autor);
        this.titulo = new Titulo(titulo);
        this.contenido = contenido;
    }
    public void modificarAutor(String autor){
        this.autor.setName(autor);
    }
    public void modificarTitulo(String titulo){
        this.titulo.setName(titulo);
    }
    public void modificarContenido(String contenido){
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
}
