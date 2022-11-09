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


    //similitud entre documentos
    private static ArrayList<ArrayList<InfoModificado>> frecResult = new ArrayList<ArrayList<InfoModificado>>();
    //frecuencia de cada palabra en un documento
    private static ArrayList<HashMap<String, Double>> tf = new ArrayList<>();
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
        int mida = Documentos.size();
        frecResult.add(new ArrayList<>(mida));
        tf.add(new HashMap<>());
        inicializarTF(d);
        actualizarIDF(d, mida);

    }

    public HashMap<String, Double> getContidf() { return contidf; }
    public ArrayList<HashMap<String, Double>> getTf() { return tf; }

    /**
     * Metodo para eliminar un documento del conjunto de documento
     * @param d Un documento
     */
    public void remove(Documento d){
        boolean trobat = false;
        for (int i = 0; ! trobat && i < Documentos.size(); ++i) {
            if (Documentos.get(i) == d) {
                trobat = true;
                eliminarDocIDF(d, i);
            }
        }
        Documentos.remove(d);
    }

    /**
     * Metodo para eliminar un documento según el autor y titulo
     * @param autor Nombre del autor
     * @param title Nombre del título
     */
    public void removeByAutorTitle(String autor,String title){
        boolean trobat = false;
        for (int i = 0; ! trobat && i < Documentos.size(); ++i) {
            if (Documentos.get(i).getAutor() == autor && Documentos.get(i).getTitulo() == title) {
                trobat = true;
                eliminarDocIDF(Documentos.get(i), i);
            }
        }
        Documentos.removeIf(d -> d.getAutor().equals(autor) && d.getTitulo().equals(title) );
    }

    public void modifyContent(String autor,String title, String contenido){
        boolean find = false;
        for (int i = 0; i < Documentos.size(); ++i){
            Documento d = Documentos.get(i);
            if (d.getAutor()==autor & d.getTitulo()==title){
                d.setContenido(contenido);
                find = true;
                modificarTF(d);
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

    // Si una palabra ya está en el arrayList, es decir, ya tiene su frecuencia
    private static Boolean existeP(HashMap<String, Double> doc, String p) {
        return doc.containsKey(p);
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

    //no hace falta ????
    private static Double idf(String p) {
        Double cont = 0.0;
        for (int j = 0; j < Documentos.size(); ++j) {
            String a = Documentos.get(j).getContenido();
            ArrayList<String> docA = Documento.stringToArrayList(a);
            if (Documento.existe(docA, p)) {
                ++cont;
                break;
            }
        }
        return cont;
    }

    public static void actualizarIDF(Documento D, int indexDoc) {
        ArrayList<String> docD = Documento.stringToArrayList(Documentos.get(indexDoc).getContenido());
        HashMap<String, Boolean> noVisitat = new HashMap<>();
        for (int i = 0; i < docD.size(); ++i) {
            if (! noVisitat.containsKey(docD.get(i))) noVisitat.put(docD.get(i), false);
        }

        for (int j = 0; j < docD.size(); ++j) {
            if (!existeP(contidf, docD.get(j))) {
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

    public void eliminarDocIDF(Documento D, int indexDoc) {
        ArrayList<String> docD = Documento.stringToArrayList(Documentos.get(indexDoc).getContenido());
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


    public void modificarTF (Documento D) {
        int mida = -1;
        boolean trobat = false;
        for (int i = 0; ! trobat && i < Documentos.size(); ++i) {
            if (Documentos.get(i) == D) {
                trobat = true;
                mida = i;
            }
        }
        tf.get(mida).clear();
        ArrayList<String> docD = Documento.stringToArrayList(D.getContenido());
        for (int j = 0; j < docD.size(); ++j) {
            if (! Documento.existe(docD, docD.get(j))) {
                Double a = tf(docD, docD.get(j));
                tf.get(mida).put(docD.get(j), a);
            }
        }
        actualizarIDF(D, mida);
    }

    public void inicializarTF(Documento D) {
        int mida = tf.size();
        ArrayList<String> docD = Documento.stringToArrayList(D.getContenido());
        for (int j = 0; j < docD.size(); ++j) {
            if (! Documento.existe(docD, docD.get(j))) {
                Double a = tf(docD, docD.get(j));
                tf.get(mida).put(docD.get(j), a);
            }
        }
    }

    //calcula tf-idf de un documento (al principio cuando hace input)


    // similitud entre dos docs
    public static Double intersect(HashMap<String, Double> s1, HashMap<String, Double> s2) {

        double result = 0.0;
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

    public static void generarVector(int docIndex, int docSim) {
        HashMap<String,Double> s1 = new HashMap<>();
        s1 = tf.get(docIndex);
        HashMap<String, Double> s2 = new HashMap<>();
        s2 = tf.get(docSim);

        double resultat = intersect(s1, s2);
        InfoModificado info = new InfoModificado();
        info.frecuencia = resultat;
        info.modif = true;
        frecResult.get(docIndex).set(docSim, info);
    }
}

