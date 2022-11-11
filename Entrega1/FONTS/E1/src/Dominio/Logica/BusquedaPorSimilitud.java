package Dominio.Logica;

import Dominio.Estructura.Autor;
import Dominio.Estructura.Libreria;
import Dominio.Estructura.Titulo;
import Dominio.Utils.DocumentHeader;

import java.util.*;

public class BusquedaPorSimilitud {

    /**
     * Método que devuelve los K documentos más similares al documento D según Tfidf
     *
     * @param header   Documento del cual queremos
     * @param K        Número de documentos que queremos obtener
     * @param libreria Libreria con todos los documentos
     * @return Los K documentos más similares al documento header del conjunto de
     *         documentos
     */

    public static ArrayList<DocumentHeader> buscar(DocumentHeader header, int K, Libreria libreria) {

        TreeMap<Autor, HashSet<Titulo>> index = libreria.getIdx();
        // We should get indexs!!!! :)
        // getFrecResult for a document means getting all comparisons!
        // We need to go through index, as we need to also check for those who have been
        // deleted and such
        ArrayList<Similitud> res = new ArrayList<Similitud>();
        index.forEach((a, sT) -> sT.forEach(t -> {
            DocumentHeader toCompare = new DocumentHeader(a, t);
            float similitud = libreria.computeSimilarity(header, toCompare);
            res.add(new Similitud(toCompare, similitud));
        }));

        Comparator<Similitud> comparador = Collections.reverseOrder();
        Collections.sort(res, comparador);

        ArrayList<DocumentHeader> resultado = new ArrayList<DocumentHeader>();

        // Start at 1, cuz comparison with itself will be at index 0
        for (int i = 1; i < K; i++) {
            resultado.add(res.get(i).header);
        }

        return resultado;
    }

    private static class Similitud implements Comparator<Similitud> {
        DocumentHeader header;
        float similitud;

        public Similitud(DocumentHeader header, float similitud) {
            this.header = header;
            this.similitud = similitud;
        }

        @Override
        public int compare(Similitud o1, Similitud o2) {
            Similitud s1 = (Similitud) o1;
            Similitud s2 = (Similitud) o2;
            return Float.compare(s1.similitud, s2.similitud);
        }
    }
}
