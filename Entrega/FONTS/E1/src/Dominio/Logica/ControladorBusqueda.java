package Dominio.Logica;

import java.util.*;

import Dominio.Estructura.Autor;
import Dominio.Estructura.Libreria;
import Dominio.Utils.DocumentHeader;

public class ControladorBusqueda {

    public static ArrayList<Autor> buscarPorPrefijo(TreeSet<Autor> autores, String prefix) {
        return BusquedaPorPrefijo.buscar(autores, prefix);
    }

    public static ArrayList<DocumentHeader> buscarPorExpresion(String expresion, Libreria libreria) {
        try {
            BusquedaPorExpresion busquedaPorExpresion = new BusquedaPorExpresion();
            return busquedaPorExpresion.buscar(expresion, libreria);
        } catch (Exception e) {
            System.out.println("Ha habido un error en la busqueda por expresion");
            e.printStackTrace();
            return new ArrayList<DocumentHeader>();
        }
    }

    public static ArrayList<DocumentHeader> buscarPorSimilitud(DocumentHeader header, int K, Libreria libreria) {
        return BusquedaPorSimilitud.buscar(header, K, libreria);
    }
}
