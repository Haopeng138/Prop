package Dominio.Logica;

import java.util.*;

import Dominio.Estructura.Autor;
import Dominio.Estructura.Documento;
import Dominio.Utils.BinaryTree;
import Dominio.Utils.ParseNode;

public class ControladorBusqueda {

    public ArrayList<Autor> buscarPorPrefijo(TreeSet<Autor> autores, String prefix) {
        return BusquedaPorPrefijo.buscar(autores, prefix);
    }

    public Set<Documento> buscarPorExpresion(String expresion){
        BinaryTree<ParseNode> bTree = new BinaryTree<ParseNode>();
        Set<Documento> documentos = new HashSet<>();
        return BusquedaPorExpresion.buscar(bTree,documentos);
    }

    public ArrayList<Documento> buscarPorSimilitud(Documento D,int K, ArrayList<ArrayList<Double>> frecResult){
        return BusquedaPorSimilitud.buscar(D,K,frecResult);
    }
}
