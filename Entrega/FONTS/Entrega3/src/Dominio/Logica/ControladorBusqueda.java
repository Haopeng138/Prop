package Dominio.Logica;

import java.util.*;

import Dominio.Estructura.Autor;
import Dominio.Estructura.Libreria;
import Dominio.Utils.DocumentHeader;

public class ControladorBusqueda {

    /**
     * Método que devuelve el conjunto de autores cuyo nombre empieza por perfijo
     *
     * @param autores    Los autores ordenados
     * @param prefix     El prefijo con el que buscar
     * @return Los autores que empiezan por el "prefix"
     */
    public static ArrayList<Autor> buscarPorPrefijo(TreeSet<Autor> autores, String prefix) {
        return BusquedaPorPrefijo.buscar(autores, prefix);
    }

    /**
     * Método que devuelve el conjunto de documentos que cumplan la expresión booleana
     *
     * @param expresion   La expresión con la que buscar
     * @param libreria    La librería de documentos
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
     * Método que devuelve el conjunto de k documentos más similares a un documento determinado
     *
     * @param header     El header del documento que comparar
     * @param K          El número de documentos a devolver
     * @param libreria   La librería de documentos
     * @return Los k documentos más similares
     */
    public static ArrayList<DocumentHeader> buscarPorSimilitud(DocumentHeader header, int K, Libreria libreria) {
        return BusquedaPorSimilitud.buscar(header, K, libreria);
    }
}
