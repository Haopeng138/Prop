package Dominio.Logica;

import java.util.*;

import Dominio.Estructura.Autor;
import Dominio.Estructura.Libreria;
import Dominio.Utils.DocumentHeader;

public class ControladorBusqueda {

    /**
     * @param autores Los autores ordenados
     * @param prefix El prefijo con el que buscar
     * @return Los autores que empiezan por el prefijo
     */
    public static ArrayList<Autor> buscarPorPrefijo(TreeSet<Autor> autores, String prefix) {
        return BusquedaPorPrefijo.buscar(autores, prefix);
    }

    /**
     * @param expresion La expresion con la que buscar
     * @param libreria La libreria de documentos
     * @return Los documentos que cumplen la expresion
     */
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

    /**
     * @param header El header del documento que comparar
     * @param K El numero de documentos a devolver
     * @param libreria La libreria de documentos
     * @return Los k documentos mas similares
     */
    public static ArrayList<DocumentHeader> buscarPorSimilitud(DocumentHeader header, int K, Libreria libreria) {
        return BusquedaPorSimilitud.buscar(header, K, libreria);
    }
}
