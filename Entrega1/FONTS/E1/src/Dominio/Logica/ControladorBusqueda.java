package Dominio.Logica;

import java.util.*;

import Dominio.Estructura.Autor;
import Dominio.Estructura.Documento;
import Dominio.Estructura.Documentos;
import Dominio.Utils.BinaryTree;
import Dominio.Utils.ParseNode;

public class ControladorBusqueda {

    public static ArrayList<Autor> buscarPorPrefijo(TreeSet<Autor> autores, String prefix) {
        return BusquedaPorPrefijo.buscar(autores, prefix);
    }

    public static Set<Documento> buscarPorExpresion(String expresion){
        BinaryTree<ParseNode> bTree = new BinaryTree<ParseNode>();
        Set<Documento> documentos = new HashSet<>();
        return BusquedaPorExpresion.buscar(bTree,documentos);
    }

    public static ArrayList<Documento> buscarPorSimilitud(Documento D, int K){
        ArrayList<ArrayList<Documentos.InfoModificado>> frecResult = Documentos.getFrecResult();
        return BusquedaPorSimilitud.buscar(D,K,frecResult);
    }
}
