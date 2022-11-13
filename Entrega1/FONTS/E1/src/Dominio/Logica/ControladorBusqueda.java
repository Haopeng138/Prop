package Dominio.Logica;

import java.util.*;

import Dominio.Estructura.Autor;
import Dominio.Estructura.Libreria;
import Dominio.Expresion.Expresion;
import Dominio.Utils.BinaryTree;
import Dominio.Utils.DocumentHeader;
import Dominio.Utils.ParseNode;

public class ControladorBusqueda {

    public ArrayList<Autor> buscarPorPrefijo(TreeSet<Autor> autores, String prefix) {
        return BusquedaPorPrefijo.buscar(autores, prefix);
    }

    public ArrayList<DocumentHeader> buscarPorExpresion(Expresion expresion, Libreria libreria) {
        try {
            BinaryTree<ParseNode> bTree = new BinaryTree<ParseNode>();
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
