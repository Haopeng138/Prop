package Dominio.Estructura;

import Dominio.Estructura.Documento;

import java.util.ArrayList;
import java.util.Arrays;

public class Documentos {
    /**
     * Atributos de clase Documento
     */
    private ArrayList<Documento> Documentos;
    private ArrayList<ArrayList<PalabraFrec>> docsPalabra = new ArrayList<ArrayList<PalabraFrec>>();

    private ArrayList<ArrayList<Double>> frecResult = new ArrayList<ArrayList<Double>>();
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
            if (d.getAutor()==autor && d.getTitulo()==title){
                return d.getContenido();
            }
        }
        return null;

    }

    /**
     * Metodo que devuelve el conjunto de documento
     * @return Documentos
     */
    public ArrayList<Documento> getDocumentos(){
        return Documentos;
    }

    private class PalabraFrec {
        private String palabra;
        private Double frecuencia;
    }

    private ArrayList<String> stringToArrayList(String contenido) {
        //ArrayList<String> separator = new ArrayList<>(Arrays.asList(".", ";", ",", " ", "(", ")", "{", "}", "!", "?", ":"));
        ArrayList<String> doc = new ArrayList<String>(Arrays.asList(contenido.split("[,. ?;:()!{}]+")));
        return doc;
    }
    private Double tf(ArrayList<String> doc, String p){
        Double cont = 0.0;
        for (int i = 0; i < doc.size(); ++i) {
            String palabra = doc.get(i);
            if (p.equalsIgnoreCase(palabra)) ++cont;
        }
        return cont/doc.size();
    }

    public Double idf(String p) {
        int cont = 0;
        for (int j = 0; j < Documentos.size(); ++j) {
            String a = Documentos.get(j).getContenido();
            ArrayList<String> docA = stringToArrayList(a);
            if (existe(docA, p)) ++cont;
        }
        return Math.log(Documentos.size() / cont);
    }

    private Boolean existeP(ArrayList<PalabraFrec> doc, String p) {
        for (PalabraFrec palabrafreq : doc) {
            if (p.equalsIgnoreCase(palabrafreq.palabra)) return true;
        }
        return false;
    }

    // donde contiene el frecuencia de cada palabra de cada doc
    public void Set() {
        for (int i = 0; i < Documentos.size(); ++i) {
            ArrayList<String> docD = stringToArrayList(Documentos.get(i).getContenido());
            for (int j = 0; j < docD.size(); ++j) {
                if (! existeP(docsPalabra.get(i), docD.get(j))) {
                    Double a = tf(docD, docD.get(j));
                    Double b = idf(docD.get(j));
                    PalabraFrec c = new PalabraFrec();
                    c.frecuencia = a * b;
                    c.palabra = docD.get(j);
                    docsPalabra.get(i).add(c);
                }
            }
        }
    }
    public Double intersect(ArrayList<PalabraFrec> s1, ArrayList<PalabraFrec> s2) {
        double result = 0;
        for (int i = 0; i < s1.size(); ++i) {
            boolean trobat = false;
            for (int j = 0; !trobat && j < s2.size(); ++j) {
                if (s1.get(i).palabra == s2.get(j).palabra)
                    result = result + s1.get(i).frecuencia * s2.get(j).frecuencia;
                trobat = true;
            }
        }
        double s1Res = 0;
        double s2Res = 0;
        double sRes;
        for (int i = 0; i < s1.size(); ++i) {
            s1Res += s1.get(i).frecuencia * s1.get(i).frecuencia;
        }

        for (int i = 0; i < s2.size(); ++i) {
            s2Res += s1.get(i).frecuencia * s1.get(i).frecuencia;
        }

        return (Math.sqrt(s1Res) * Math.sqrt(s2Res)) / result;
    }
    public void generarVector() {

        ArrayList<PalabraFrec> s1 = new ArrayList<PalabraFrec>();
        s1 = docsPalabra.get(docsPalabra.size() - 1);

        for (int i = 0; i < docsPalabra.size() - 1 ; ++i) {
            ArrayList<PalabraFrec> s2 = new ArrayList<PalabraFrec> ();
            s2 = docsPalabra.get(i);
            double resultat = intersect(s1, s2);
            frecResult.get(i).set(docsPalabra.size()-1, resultat);
            frecResult.get(docsPalabra.size()-1).set(i, resultat);
        }

    }
    private Boolean visitado(ArrayList<PalabraFrec>frecuencia, String p) {
        for(PalabraFrec f : frecuencia) {
            if(f.palabra == p) return true;
        }
        return false;
    }

    private Boolean existe(ArrayList<String> doc, String p) {
        for (String palabra : doc) {
            if (p.equalsIgnoreCase(palabra)) return true;
        }
        return false;
    }
}
