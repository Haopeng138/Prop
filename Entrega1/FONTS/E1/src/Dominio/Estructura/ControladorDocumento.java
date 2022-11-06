package Dominio.Estructura;

import Dominio.Logica.BusquedaPorExpresion;
import Dominio.Logica.BusquedaPorSimilitud;

import java.util.ArrayList;
import java.util.TreeSet;

public class ControladorDocumento extends BusquedaPorSimilitud {

    Autores autores;
    Documentos documentos;

    public void createDocument(Autor a, Titulo t) {

    }

    public ArrayList<Autor> getAutores() {
        return autores.getAutores();
    }

    public TreeSet<Autor> getOrderedAutores() {
        return autores.getOrderedAutores();
    }

    public ArrayList<Titulo> getTitles(Autor a) {
        return autores.getTitles(a);
    }
}
