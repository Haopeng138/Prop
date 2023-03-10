package Dominio.Logica;

import java.util.ArrayList;
import java.util.TreeSet;

import Dominio.Estructura.Autor;

public class BusquedaPorPrefijo {
    /**
     * Metodo que busca autores por prefijo
     * 
     * @param autores El conjunto de autores
     * @param prefix  El prefijo por el cual queremos buscar
     * @return Conjunto de autores empieza por el "prefix"
     */
    public static ArrayList<Autor> buscar(TreeSet<Autor> autores, String prefix) {
        if (prefix != "") {
            String nextPrefix = computeNextPrefix(prefix);
            return new ArrayList<Autor>(autores.subSet(new Autor(prefix), new Autor(nextPrefix)));
        } else {
            return new ArrayList<Autor>(autores);
        }

    }

    private static String computeNextPrefix(String prefix) {
        int prefixLength = prefix.length() - 1;
        char lastChar = (char) (prefix.charAt(prefixLength) + 1);
        return prefix.substring(0, prefixLength) + lastChar;
    }
}
