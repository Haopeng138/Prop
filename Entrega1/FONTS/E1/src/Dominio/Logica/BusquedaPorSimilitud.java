package Dominio.Logica;

import Dominio.Estructura.Documento;
import Dominio.Estructura.Documentos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

public class BusquedaPorSimilitud {

    private static Integer buscarIndice(Documento doc, ArrayList<Documento> docs) {
        for (int i = 0; i < docs.size(); ++i) {
            if (doc == docs.get(i)) return i;
        }
        return -1;
    }

    /**
     * Metodo que devuelve los K documentos más similares al documento D según Tfidf
     *
     * @param D          Documento del cual queremos
     * @param K          Numero de documentos que queremos obtener
     * @param frecResult Resultado de similitud de cada documento con los otros
     * @return Los K documentos más similares a D del conjunto de documentos
     */
    public static ArrayList<Documento> buscar(Documento D, int K, ArrayList<ArrayList<Double>> frecResult) {
        ArrayList<Documento> resultado = new ArrayList<>();
        ArrayList<Documento> docs = new ArrayList<Documento>();
        docs = Documentos.getDocumentos();

        int indice = buscarIndice(D, docs);
        ArrayList<Double> res = new ArrayList<Double>();
        for (int i = 0; i < frecResult.get(indice).size(); ++i) {
            Double a = frecResult.get(indice).get(i);
            res.add(a);
        }
        Collections.sort(res);

        int cont = 0;
        for (int i = 0; i < frecResult.get(indice).size(); ++i) {
            Double b = res.get(i);
            if (cont < K) {
                if (indice != i) {
                    if (b == frecResult.get(indice).get(i)) {
                        Documento c = docs.get(i);
                        resultado.add(c);
                        ++cont;
                    }
                }
            }
        }
        return resultado;
    }
}
