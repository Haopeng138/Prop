package Dominio.Estructura;

import java.util.*;

public class Documentos {

    private class InfoModificado {
        private Double frecuencia;
        private Boolean modif;
    }

    /**
     * Atributos de clase Documento
     */
    private static ArrayList<Documento> Documentos;
    private ArrayList<HashMap<String,Double>> docsPalabra = new ArrayList<HashMap<String,Double>>();

    private ArrayList<ArrayList<InfoModificado>> frecResult = new ArrayList<ArrayList<InfoModificado>>();
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

    private ArrayList<String> stringToArrayList(String contenido) {
        //ArrayList<String> separator = new ArrayList<>(Arrays.asList(".", ";", ",", " ", "(", ")", "{", "}", "!", "?", ":"));
        String contenidoMinusculas = contenido.toLowerCase();
        ArrayList<String> doc = new ArrayList<String>(Arrays.asList(contenidoMinusculas.split("[,. ?;:()!{}]+")));
        return doc;
    }

    // Si una palabra ya está en el arrayList, es decir, ya tiene su frecuencia
    private Boolean existeP(HashMap<String,Double> doc, String p) {
        return doc.containsKey(p);
    }

    private Boolean existe(ArrayList<String> doc, String p) {
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

    // cada vez que anadimos o eliminamos un elemento
    public Double idf(String p) {
        int cont = 0;
        for (int j = 0; j < Documentos.size(); ++j) {
            String a = Documentos.get(j).getContenido();
            ArrayList<String> docA = stringToArrayList(a);
            if (existe(docA, p)) {
                ++cont;
                break;
            }
        }
        return Math.log(Documentos.size() / cont);
    }

    // donde contiene el frecuencia de cada palabra de cada doc
    public void Set() {
        for (int i = 0; i < Documentos.size(); ++i) {
            ArrayList<String> docD = stringToArrayList(Documentos.get(i).getContenido());
            for (int j = 0; j < docD.size(); ++j) {
                if (! existeP(docsPalabra.get(i), docD.get(j))) {
                    Double a = tf(docD, docD.get(j));
                    Double b = idf(docD.get(j));
                    Double frecuencia = a * b;
                    String palabra = docD.get(j);
                    docsPalabra.get(i).put(palabra, frecuencia);
                }
            }
        }
    }
    public Double intersect(HashMap<String,Double> s1, HashMap<String,Double> s2) {
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

    public void generarVector() {
        HashMap<String,Double> s1 = new HashMap<>();
        s1 = docsPalabra.get(docsPalabra.size() - 1);

        for (int i = 0; i < docsPalabra.size() - 1 ; ++i) {
            HashMap<String,Double> s2 = new HashMap<>();
            s2 = docsPalabra.get(i);
            double resultat = intersect(s1, s2);
            InfoModificado info = new InfoModificado();
            info.frecuencia = resultat;
            info.modif = true;
            frecResult.get(i).set(docsPalabra.size()-1, info);
            frecResult.get(docsPalabra.size()-1).set(i, info);
        }
    }
}