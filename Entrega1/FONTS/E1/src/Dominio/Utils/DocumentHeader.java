package Dominio.Utils;

import Dominio.Estructura.Autor;
import Dominio.Estructura.Titulo;

public class DocumentHeader {
    Autor autor;
    Titulo titulo;

    public DocumentHeader(Autor a, Titulo t) {
        autor = a;
        titulo = t;
    }

    public Autor getAutor() {
        return autor;
    }

    public Titulo getTitulo() {
        return titulo;
    }
}
