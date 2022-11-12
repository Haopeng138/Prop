package Dominio.Estructura;

import java.util.*;

public class Documentos {

    /**
     * Atributos de clase Documento
     */
    public class InfoModificado {
        public Double frecuencia;
        public Boolean modif = false;

    }

    /**
     * Atributos de clase Documento
     */
    private ArrayList<Documento> documentos;

    // similitud entre documentos
    private ArrayList<ArrayList<InfoModificado>> frecResult = new ArrayList<ArrayList<InfoModificado>>();
    // frecuencia de cada palabra de un documento
    private ArrayList<HashMap<String, Double>> tf = new ArrayList<>();
    // número de documentos en qué parece la palabra
    private HashMap<String, Double> contidf = new HashMap<>();

    /**
     * Métode de creación por defecto de documentos
     */
    public Documentos() {
        this.documentos = new ArrayList<Documento>();
    }

    /**
     * Metodo para añadir un documento al conjunto de documento
     * 
     * @param d Un documento
     */
    public void add(Documento d) {
        documentos.add(d);
        int mida = documentos.size();
        frecResult.add(new ArrayList<>(mida));
        tf.add(new HashMap<>());
        /*
         * inicializarTF(d);
         * actualizarIDF(d);
         */
    }

    /**
     * Metodo para eliminar un documento del conjunto de documento
     * 
     * @param d Un documento
     */
    public void remove(int idx) {
        eliminarDocIDF(documentos.get(idx));
        documentos.remove(documentos.get(idx));

    }

    // TODO: FIXME: mirar esto
    public void modifyContent(int idx, String contenido) {

        Documento d = documentos.get(idx);

        d.setContenido(contenido);
        modificarTF(idx);
        actualizarIDF(d);
        for (int j = 0; j < frecResult.get(idx).size(); ++j) {
            if (frecResult.get(idx).get(j).modif)
                frecResult.get(idx).get(j).modif = false;
        }
        for (int j = idx + 1; j < frecResult.size(); ++j) {
            if (frecResult.get(idx).get(j).modif)
                frecResult.get(idx).get(j).modif = false;
        }
    }

    /**
     * Método para obtener el contenido de un documento dado el autor y el título
     * 
     * @param autor Nombre del autor
     * @param title Nombre del título
     * @return Contenido del documento con el título "title" y del autor "autor", si
     *         existe este documento
     *         Null, en el caso contrario
     */
    public String getContent(int idx) {
        return documentos.get(idx).getContenido();
    }

    /**
     * Método para verificar la existencia de una key en el contidf
     * 
     * @param p Una palabra
     * @return True, si la palabra "p" es una key del contidf (ya tiene asignada una
     *         frecuencia)
     *         false, en el caso contrario
     */
    private Boolean existeEnContidf(String p) {
        return contidf.containsKey(p);
    }

    /**
     * Método para calcular la frecuencia de una palabra en un determinado documento
     * (TF)
     * 
     * @param doc Contenido del documento en forma de ArrayList
     * @param p   Una palabra
     * @return Frecuencia de la palabra "p" en el documento "doc"
     */
    private Double tf(ArrayList<String> doc, String p) {
        Double cont = 0.0;
        for (int i = 0; i < doc.size(); ++i) {
            String palabra = doc.get(i);
            if (p.equalsIgnoreCase(palabra))
                ++cont;
        }
        return cont / doc.size();
    }

    /**
     * Método para inicializar el tf de un documento
     * 
     * @param d Un documento
     */
    private void inicializarTF(Documento d) {
        int mida = tf.size();
        ArrayList<String> docD = d.stringToArrayList(d.getContenido());
        for (int j = 0; j < docD.size(); ++j) {
            if (!tf.get(mida).containsKey(docD.get(j))) {
                Double a = tf(docD, docD.get(j));
                tf.get(mida).put(docD.get(j), a);
            }
        }
    }

    /*
     * Método para actualizar el contidf cada vez que haya una modificación del
     * contenido de un documento o cuando añade un nuevo documento
     * 
     * @param d Un documento
     */
    private void actualizarIDF(Documento d) {
        ArrayList<String> docD = d.stringToArrayList(d.getContenido());
        HashMap<String, Boolean> noVisitat = new HashMap<>();
        for (int i = 0; i < docD.size(); ++i) {
            if (!noVisitat.containsKey(docD.get(i)))
                noVisitat.put(docD.get(i), false);
        }

        for (int j = 0; j < docD.size(); ++j) {
            if (!existeEnContidf(docD.get(j))) {
                String palabra = docD.get(j);
                contidf.put(palabra, 1.0);
                noVisitat.put(palabra, true);
            } else {
                String palabra = docD.get(j);
                if (!noVisitat.get(palabra)) {
                    Double b = contidf.get(palabra);
                    ++b;
                    contidf.put(palabra, b);
                    noVisitat.put(palabra, true);
                }
            }
        }
    }

    /**
     * Método para actualizar el contidf cuando elimina un documento
     * 
     * @param d Un documento
     */
    private void eliminarDocIDF(Documento d) {
        ArrayList<String> docD = d.stringToArrayList(d.getContenido());
        HashMap<String, Boolean> noVisitat = new HashMap<>();
        for (int i = 0; i < docD.size(); ++i) {
            if (!noVisitat.containsKey(docD.get(i)))
                noVisitat.put(docD.get(i), false);
        }

        for (int j = 0; j < docD.size(); ++j) {
            if (existeEnContidf(docD.get(j))) {
                String palabra = docD.get(j);
                if (!noVisitat.get(palabra)) {
                    Double b = contidf.get(palabra);
                    --b;
                    contidf.put(palabra, b);
                    noVisitat.put(palabra, true);
                }
            }
        }
    }

    /**
     * Método para actualizar el tf cuando haya una modificación del contenido de un
     * documento
     * 
     * @param d Un documento
     */
    private void modificarTF(int idx) {

        Documento d = documentos.get(idx);
        tf.get(idx).clear();
        ArrayList<String> docD = d.stringToArrayList(d.getContenido());
        for (int j = 0; j < docD.size(); ++j) {
            if (!tf.get(idx).containsKey(docD.get(j))) {
                Double a = tf(docD, docD.get(j));
                tf.get(idx).put(docD.get(j), a);
            }
        }
    }

    /**
     * Método para calcular la similitud entre dos documentos a partir de sus TFs y
     * IDFs
     * 
     * @param s1 tf de un documento
     * @param s2 tf de otro documento
     * @return Similitud entre los documentos "s1" y "s2"
     */
    private Double intersect(HashMap<String, Double> s1, HashMap<String, Double> s2) {
        double result = 0.0;
        double s1Res = 0.0;
        double s2Res = 0.0;

        for (String a : s1.keySet()) {
            double idf = contidf.get(a);
            s1Res += Math.pow(s1.get(a) * (Math.log(documentos.size() / idf)), 2);
        }

        for (String a : s2.keySet()) {
            double idf = contidf.get(a);
            s2Res += Math.pow(s2.get(a) * (Math.log(documentos.size() / idf)), 2);
        }

        for (String a : s1.keySet()) {
            if (s2.containsKey(a)) {
                double idf = contidf.get(a);
                result = result + (s1.get(a) * (Math.log(documentos.size() / idf)))
                        * (s2.get(a) * (Math.log(documentos.size() / idf)));
            }
        }
        return result / (Math.sqrt(s1Res) * Math.sqrt(s2Res));
    }

    /**
     * Método para generar el "ángulo" entre dos documentos, la similitud del sus
     * contenidos
     * 
     * @param docIndice Índice de un documento
     * @param docSim    Índice de otro documento
     */
    public double generarSimilitudEntreDocs(int docIndice, int docSim) {
        HashMap<String, Double> s1 = new HashMap<>();
        s1 = tf.get(docIndice);
        HashMap<String, Double> s2 = new HashMap<>();
        s2 = tf.get(docSim);

        int pequeno = docIndice < docSim ? docIndice : docSim;
        int grande = docIndice < docSim ? docSim : docIndice;

        if (frecResult.get(grande).get(pequeno).modif) {
            return frecResult.get(grande).get(pequeno).frecuencia;
        }

        double resultat = intersect(s1, s2);
        InfoModificado info = new InfoModificado();
        info.frecuencia = resultat;
        info.modif = true;
        frecResult.get(grande).set(pequeno, info);
        return resultat;
    }

    public Boolean tieneString(int idx, String texto) {
        return documentos.get(idx).existeString(texto);
    }

    public boolean tienePalabra(int idx, String palabra) {
        return tf.get(idx).get(palabra) != null;
    }

    public Documento getDocumento(int idx) {
        return documentos.get(idx);
    }

    public ArrayList<Documento> getDocumentos() {
        return documentos;
    }
}