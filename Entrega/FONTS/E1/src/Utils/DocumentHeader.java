package Utils;

import Dominio.Estructura.Autor;
import Dominio.Estructura.Titulo;

public class DocumentHeader {
    Autor autor;
    Titulo titulo;

    public DocumentHeader(Autor a, Titulo t) {
        autor = a;
        titulo = t;
    }

    public DocumentHeader(String a, String t) {
        autor = new Autor(a);
        titulo = new Titulo(t);
    }

    public Autor getAutor() {
        return autor;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    /**
     * Compara que coincida el nombre del autor y del titulo
     * 
     * @param o header a ser comparado
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DocumentHeader that = (DocumentHeader) o;
        return autor.equals(that.getAutor()) && titulo.equals(that.getTitulo());
    }
}
