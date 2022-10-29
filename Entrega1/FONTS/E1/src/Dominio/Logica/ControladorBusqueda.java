package Dominio.Logica;

import java.util.ArrayList;
import java.util.TreeSet;

import Dominio.Estructura.Autor;
import Dominio.Estructura.Documento;

public class ControladorBusqueda {

    public ArrayList<Autor> buscarPorPrefijo(TreeSet<Autor> autores, String prefix) {
        return BusquedaPorPrefijo.buscar(autores, prefix);
    }

    public ArrayList<Documento> buscarPorExpresion(String expresion){
        return BusquedaPorExpresion.buscar(expresion);
    }

    public ArrayList<Documento> buscarPorSimilitud(Documento D,int K){
        return BusquedaPorSimilitud.buscar(D,K);
    }
}
