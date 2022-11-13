package Dominio.Logica;

import java.util.*;

import Dominio.Estructura.Autor;
import Dominio.Estructura.Libreria;
import Dominio.Utils.BinaryTree;
import Dominio.Utils.DocumentHeader;
import Dominio.Utils.ParseNode;

public class ControladorBusqueda {

    public static ArrayList<Autor> buscarPorPrefijo(TreeSet<Autor> autores, String prefix) {
        return BusquedaPorPrefijo.buscar(autores, prefix);
    }

    public static ArrayList<DocumentHeader> buscarPorExpresion(BinaryTree<ParseNode> bTree, Libreria libreria) {
        try {
            BusquedaPorExpresion busquedaPorExpresion = new BusquedaPorExpresion();
            return busquedaPorExpresion.buscar(bTree, libreria);
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
