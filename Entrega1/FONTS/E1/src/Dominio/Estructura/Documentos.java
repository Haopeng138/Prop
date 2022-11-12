package Dominio.Estructura;

import java.util.*;


public class Documentos {

    /**
     * Atributos de clase Documento
     */
    public static class InfoModificado {
        public Double frecuencia;
        public Boolean modif = false;

    }

    /**
     * Atributos de clase Documento
     */
    private static ArrayList<Documento> Documentos;

    //tf * idf
    private static ArrayList<HashMap<String,Double>> docsPalabra = new ArrayList<HashMap<String,Double>>();

    //similitud entre documentos
    private static ArrayList<ArrayList<InfoModificado>> frecResult = new ArrayList<ArrayList<InfoModificado>>();
    //frecuencia de cada palabra de un documento
    private static ArrayList<HashMap<String, Double>> tf = new ArrayList<>();
    //número de documentos en qué parece la palabra
    private static HashMap<String, Double> contidf = new HashMap<>();


    /**
     * Métode de creación por defecto de documentos
     */
    public Documentos (){
        this.Documentos = new ArrayList<Documento>();
    }

    /**
     * Método que devuelve el conjunto de documento
     * @return Documentos
     */
    public static ArrayList<Documento> getDocumentos (){
        return Documentos;
    }


    /**
     * Método que devuelve la matriz de similitud entre los documentos
     * @return frecResult
     */
    public  static  ArrayList<ArrayList<InfoModificado>> getFrecResult() { return frecResult; }

    /**
     * Método para añadir un documento al conjunto de documento
     * @param d Un documento
     */
    public void add(Documento d){
        Documentos.add(d);
        int mida = Documentos.size();
        frecResult.add(new ArrayList<>(mida));
        tf.add(new HashMap<>());
        inicializarTF(d);
        actualizarIDF(d);
    }



    /**
     * Método que devuelve el conjunto de documento
     * @return Documentos
     */

    public HashMap<String, Double> getContidf() { return contidf; }
    public ArrayList<HashMap<String, Double>> getTf() { return tf; }
    public ArrayList<HashMap<String, Double>> getDocsPalabra() { return  docsPalabra; }

    /**
     * Método para eliminar un documento del conjunto de documento
     * @param d Un documento
     */
    public void remove(Documento d){
        boolean trobat = false;
        for (int i = 0; ! trobat && i < Documentos.size(); ++i) {
            if (Documentos.get(i) == d) {
                trobat = true;
                eliminarDocIDF(d);
            }
        }
        Documentos.remove(d);

    }

    /**
     * Metodo para eliminar un documento dado el autor y el título
     * @param autor Nombre del autor
     * @param title Nombre del título
     */
    public void removeByAutorTitle(String autor, String title){
        boolean trobat = false;
        for (int i = 0; ! trobat && i < Documentos.size(); ++i) {
            if (Documentos.get(i).getAutor() == autor && Documentos.get(i).getTitulo() == title) {
                trobat = true;
                eliminarDocIDF(Documentos.get(i));
            }
        }
        Documentos.removeIf(d -> d.getAutor().equals(autor) && d.getTitulo().equals(title) );
    }

    /**
     * Método para modificar el contenido de un documento dado el autor y el título
     * @param autor Nombre del autor
     * @param title Nombre del título
     * @param contenido Contenido del documento con el título "title" y del autor "autor"
     */
    public void modifyContent(String autor,String title, String contenido){
        boolean find = false;
        for (int i = 0; i < Documentos.size(); ++i){
            Documento d = Documentos.get(i);
            if (d.getAutor()==autor & d.getTitulo()==title){
                d.setContenido(contenido);
                find = true;
                modificarTF(d);
                actualizarIDF(d);
                for (int j = 0; j < frecResult.get(i).size()-1; ++i) {
                    if (frecResult.get(i).get(j).modif) frecResult.get(i).get(j).modif = false;
                }
                for (int j = 1; i+j < frecResult.size()+1; ++i) {
                    if (frecResult.get(i).get(i+j).modif) frecResult.get(i).get(i+j).modif = false;
                }
                break;
            }
        }
        if (!find){
            System.out.println("No se ha modificado el contenido");
        }
    }

    /**
     * Método para obtener el contenido de un documento dado el autor y el título
     * @param autor Nombre del autor
     * @param title Nombre del título
     * @return Contenido del documento con el título "title" y del autor "autor", si existe este documento
     *         Null, en el caso contrario
     */
    public String getContentByAutorTitle(String autor, String title){
        for (Documento d : this.Documentos){
            if (d.getAutor()==autor & d.getTitulo()==title){
                return d.getContenido();
            }
        }
        return null;

    }


    private static ArrayList<String> stringToArrayList(String contenido) {
        //ArrayList<String> separator = new ArrayList<>(Arrays.asList(".", ";", ",", " ", "(", ")", "{", "}", "!", "?", ":"));
        String contenidoMinusculas = contenido.toLowerCase();
        ArrayList<String> doc = new ArrayList<String>(Arrays.asList(contenidoMinusculas.split("[,. ¿?;:()¡!{}...]+")));
        return doc;
    }

    // Si una palabra ya está en el arrayList, es decir, ya tiene su frecuencia
    private static Boolean existeP(HashMap<String, Double> doc, String p) {
        return doc.containsKey(p);
    }

    /**
     * Método para verificar la existencia de una key en el contidf
     * @param p Una palabra
     * @return True, si la palabra "p" es una key del contidf (ya tiene asignada una frecuencia)
     *         false, en el caso contrario
     */
    private static Boolean existeEnContidf(String p) {
        return contidf.containsKey(p);
    }

    /**
     *
     * @param d
     */
    public void altabajaDoc(Documento d) {
        if (d.getEstado()) actualizarIDF(d);
        else eliminarDocIDF(d);
    }

    /**
     * Método para calcular la frecuencia de una palabra en un determinado documento (TF)
     * @param doc Contenido del documento en forma de ArrayList
     * @param p Una palabra
     * @return Frecuencia de la palabra "p" en el documento "doc"
     */
    // una vez, en la hora de input
    private Double tf(ArrayList<String> doc, String p){
        Double cont = 0.0;
        for (int i = 0; i < doc.size(); ++i) {
            String palabra = doc.get(i);
            if (p.equalsIgnoreCase(palabra)) ++cont;
        }
        return cont/doc.size();
    }

    /**
     * Método para inicializar el tf de un documento
     * @param d Un documento
     */
    public void inicializarTF(Documento d) {
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
    //no hace falta ????
    private static Double idf(String p) {
        Double cont = 0.0;
        for (int j = 0; j < Documentos.size(); ++j) {
            String a = Documentos.get(j).getContenido();
            ArrayList<String> docA = stringToArrayList(a);
            if (existe(docA, p)) {
                ++cont;
                break;
            }
        }
        return cont;
    }

    /**
     * Método para actualizar el contidf cada vez que haya una modificación del contenido de un documento o cuando añade un nuevo documento
     * @param d Un documento
     */
    public static void actualizarIDF(Documento d) {
        ArrayList<String> docD = d.stringToArrayList(d.getContenido());
        HashMap<String, Boolean> noVisitat = new HashMap<>();
        for (int i = 0; i < docD.size(); ++i) {
            if (! noVisitat.containsKey(docD.get(i))) noVisitat.put(docD.get(i), false);
        }

        for (int j = 0; j < docD.size(); ++j) {
            if (!existeEnContidf(docD.get(j))) {
                String palabra = docD.get(j);
                contidf.put(palabra, 1.0);
                noVisitat.put(palabra, true);
            }
            else {
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
     * @param d Un documento
     */
    public void eliminarDocIDF(Documento d) {
        ArrayList<String> docD = d.stringToArrayList(d.getContenido());
        HashMap<String, Boolean> noVisitat = new HashMap<>();
        for (int i = 0; i < docD.size(); ++i) {
            if (! noVisitat.containsKey(docD.get(i))) noVisitat.put(docD.get(i), false);
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
     * Método para actualizar el tf cuando haya una modificación del contenido de un documento
     * @param d Un documento
     */
    public void modificarTF (Documento d) {
        int mida = -1;
        boolean trobat = false;
        for (int i = 0; ! trobat && i < Documentos.size(); ++i) {
            if (Documentos.get(i) == d) {
                trobat = true;
                mida = i;
            }
        }
        tf.get(mida).clear();
        ArrayList<String> docD = d.stringToArrayList(d.getContenido());
        for (int j = 0; j < docD.size(); ++j) {
            if (! tf.get(mida).containsKey(docD.get(j))) {
                Double a = tf(docD, docD.get(j));
                tf.get(mida).put(docD.get(j), a);
            }
        }
    }

    /**
     * Método para calcular la similitud entre dos documentos a partir de sus TFs y IDFs
     * @param s1 tf de un documento
     * @param s2 tf de otro documento
     * @return Similitud entre los documentos "s1" y "s2"
     */
    public static Double intersect(HashMap<String, Double> s1, HashMap<String, Double> s2) {
        double result = 0.0;
        for (String a : s1.keySet()) {
            boolean trobat = false;
            while (!trobat) {
                for (String b : s2.keySet()) {
                    if (a == b) {
                        result = result + s1.get(a) * s2.get(b);
                        trobat = true;
                    }
                }
            }
        }
        double s1Res = 0.0;
        double s2Res = 0.0;

        for (String a : s1.keySet()) {
            double idf = contidf.get(a);
            s1Res += Math.pow(s1.get(a) * (Math.log(Documentos.size()/idf)), 2);
        }

        for (String a : s2.keySet()) {
            double idf = contidf.get(a);
            s2Res += Math.pow(s2.get(a) * (Math.log(Documentos.size()/idf)), 2);
        }

        for (String a : s1.keySet()) {
            if (s2.containsKey(a)) {
                double idf = contidf.get(a);
                result = result + (s1.get(a) * (Math.log(Documentos.size()/idf))) * (s2.get(a) * (Math.log(Documentos.size()/idf)));
            }
        }
        return result / (Math.sqrt(s1Res) * Math.sqrt(s2Res));
    }

    /**
     * Método para generar el "ángulo" entre dos documentos, la similitud del sus contenidos
     * @param docIndice Índice de un documento
     * @param docSim Índice de otro documento
     */
    public static void generarSimilitudEntreDocs(int docIndice, int docSim) {
        HashMap<String,Double> s1 = new HashMap<>();
        s1 = tf.get(docIndice);
        HashMap<String, Double> s2 = new HashMap<>();
        s2 = tf.get(docSim);

        double resultat = intersect(s1, s2);
        InfoModificado info = new InfoModificado();
        info.frecuencia = resultat;
        info.modif = true;
        frecResult.get(docIndice).set(docSim, info);
    }
}

