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
     * @param header     Documento del cual queremos
     * @param K          Número de documentos que queremos obtener
     * @param libreria   Resultado de similitud de cada documento con los otros
     * @return Los K documentos más similares a D del conjunto de documentos
     */
    public static ArrayList<DocumentHeader> buscar(DocumentHeader header, int K, Libreria libreria) {

        TreeMap<Autor, HashSet<Titulo>> index = libreria.getIdx();
        ArrayList<Similitud> res = new ArrayList<Similitud>();
        index.forEach((a, sT) -> sT.forEach(t -> {
            if (!a.getName().equals(header.getAutor().getName()) 
                    && !(t.getName().equals(header.getTitulo().getName()))) {
                DocumentHeader toCompare = new DocumentHeader(a, t);
                double similitud = libreria.computeSimilarity(header, toCompare);
                res.add(new Similitud(toCompare, similitud));
            }
        }));

        Collections.sort(res, (h1, h2) -> -Double.compare(h1.similitud, h2.similitud));
        ArrayList<DocumentHeader> resultado = new ArrayList<DocumentHeader>();
        for (int i = 0; i < K && i < res.size(); i++) {
            resultado.add(res.get(i).header);
        }
        return resultado;
    }

    private static class Similitud {
        DocumentHeader header;
        double similitud;

        public Similitud(DocumentHeader header, double similitud) {
            this.header = header;
            this.similitud = similitud;
        }
    }
}
