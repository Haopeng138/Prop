package Dominio.Estructura;

import java.util.*;

public class Documentos {

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
    //frecuencia de cada palabra en un documento
    private ArrayList<HashMap<String, Double>> tf = new ArrayList<>();
    //número de documentos en qué parece la palabra
    private static HashMap<String, Double> contidf = new HashMap<>();
    public Documentos (){
        this.Documentos = new ArrayList<Documento>();
    }

    /**
     * Metodo para añadir un documento al conjunto de documento
     * @param d Un documento
     */
    public void add(Documento d){
        Documentos.add(d);
    }

    public HashMap<String, Double> getContidf() { return contidf; }
    public ArrayList<HashMap<String, Double>> getTf() { return tf; }
    public ArrayList<HashMap<String, Double>> getDocsPalabra() { return  docsPalabra; }

    /**
     * Metodo para eliminar un documento del conjunto de documento
     * @param d Un documento
     */
    public void remove(Documento d){
        Documentos.remove(d);

    }

    /**
     * Metodo para eliminar un documento según el autor y titulo
     * @param autor Nombre del autor
     * @param title Nombre del título
     */
    public void removeByAutorTitle(String autor,String title){
        Documentos.removeIf(d -> d.getAutor().equals(autor) && d.getTitulo().equals(title) );
    }

    public void modifyContent(String autor,String title, String contenido){
        boolean find = false;
        for (Documento d : Documentos){
            if (d.getAutor()==autor & d.getTitulo()==title){
                d.setContenido(contenido);
                find = true;
                break;
            }
        }
        if (!find){
            System.out.println("No se ha modificado el contenido");
        }
    }

    public String getContentByAutorTitle(String autor, String title){
        for (Documento d : this.Documentos){
            if (d.getAutor()==autor & d.getTitulo()==title){
                return d.getContenido();
            }
        }
        return null;

    }

    /**
     * Metodo que devuelve el conjunto de documento
     * @return Documentos
     */
    public static ArrayList<Documento> getDocumentos(){
        return Documentos;
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

    private static Boolean existe(ArrayList<String> doc, String p) {
        for (String palabra : doc) {
            if (p.equalsIgnoreCase(palabra)) return true;
        }
        return false;
    }

    // una vez, en la hora de input
    private Double tf(ArrayList<String> doc, String p){
        Double cont = 0.0;
        for (int i = 0; i < doc.size(); ++i) {
            String palabra = doc.get(i);
            if (p.equalsIgnoreCase(palabra)) ++cont;
        }
        return cont/doc.size();
    }

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


    public static void actualizarIDF(Documento D, int indexDoc) {
        ArrayList<String> docD = stringToArrayList(Documentos.get(indexDoc).getContenido());
        HashMap<String, Boolean> noVisitat = new HashMap<>();
        for (int i = 0; i < docD.size(); ++i) {
            if (! noVisitat.containsKey(docD.get(i))) noVisitat.put(docD.get(i), false);
        }

        for (int j = 0; j < docD.size(); ++j) {
            if (!existeP(contidf, docD.get(j))) {
                Double b = idf(docD.get(j));
                String palabra = docD.get(j);
                contidf.put(palabra, b);
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

    public void eliminarDocIDF(Documento D, int indexDoc) {
        ArrayList<String> docD = stringToArrayList(Documentos.get(indexDoc).getContenido());
        HashMap<String, Boolean> noVisitat = new HashMap<>();
        for (int i = 0; i < docD.size(); ++i) {
            if (! noVisitat.containsKey(docD.get(i))) noVisitat.put(docD.get(i), false);
        }

        for (int j = 0; j < docD.size(); ++j) {
            if (existeP(contidf, docD.get(j))) {
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
    public void inicializarTF(Documento D) {
        int mida = tf.size();
        ArrayList<String> docD = stringToArrayList(D.getContenido());
        for (int j = 0; j < docD.size(); ++j) {
            if (! existe(docD, docD.get(j))) {
                Double a = tf(docD, docD.get(j));
                tf.get(mida).put(docD.get(j), a);
            }
        }
    }

    //calcula tf-idf de un documento (al principio cuando hace input)
    public void TfIdf(int docIndex) {
        HashMap<String, Double> docD = tf.get(docIndex);
        for (String a : docD.keySet()) {
            Double frecuencia = docD.get(a) * (Math.log(Documentos.size()/contidf.get(a)));
            docsPalabra.get(docIndex).put(a, frecuencia);
        }
    }

    // similitud entre dos docs
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
            s1Res += Math.pow(s1.get(a), 2);
        }
        for (String b : s2.keySet()) {
            s2Res += Math.pow(s2.get(b), 2);
        }
        return result / (Math.sqrt(s1Res) * Math.sqrt(s2Res));
    }

    public static void generarVector(Documento D, int docIndex) {
        HashMap<String,Double> s1 = new HashMap<>();
        s1 = docsPalabra.get(docIndex);

        for (int i = 0; i < docsPalabra.size(); ++i) {
            if (Documentos.get(i) != D) {
                HashMap<String, Double> s2 = new HashMap<>();
                s2 = docsPalabra.get(i);
                double resultat = intersect(s1, s2);
                InfoModificado info = new InfoModificado();
                info.frecuencia = resultat;
                info.modif = false;
                frecResult.get(i).set(docIndex, info);
                frecResult.get(docIndex).set(i, info);
            }
        }
    }
}