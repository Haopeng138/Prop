package Dominio.Estructura;

import Dominio.Estructura.Documento;

import java.util.ArrayList;

public class Documentos {
    /**
     * Atributos de clase Documento
     */
    private ArrayList<Documento> Documentos;
    private ArrayList<PalabraFrec> docsPalabra [] = new ArrayList<PalabraFrec> [];
    private ArrayList<PalabraFrec> interseccioDoc [] = new ArrayList<PalabraFrec> [];
    private Double[][] frecResult = new Double[][];
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
    public ArrayList<Documento> getDocumentos(){
        return Documentos;
    }

    private class PalabraFrec {
        private String palabra;
        private Double frecuencia;
    }

    private Double tf(String[] doc, String p){
        int cont  = 0;
        for (int i = 0; i < doc.size(); ++i) {
            String palabra = doc[i];
            if (p.equalsIgnoreCase(palabra)) ++cont;
        }
        return cont/doc.size();
    }

    public Double idf(String p) {
        int cont = 0;
        for (int j = 0; j < Documentos.size(); ++j) {
            String a = Documentos.get(j).contenido;
            String[] docA = stringToArrayList(a);
            if (existe ? (docA,p))++cont;
        }
        return Math.log(Documentos.size() / cont);
    }

    private Boolean existeP(ArrayList<PalabraFrec> doc, String p) {
        for (PalabraFrec palabrafreq : doc) {
            if (p.equalsIgnoreCase(palabrafreq.palabra)) return true;
        }
        return false;
    }
    public void Set() {
        for (int i = 0; i < Documentos.size(); ++i) {
            String[] docD = stringToArrayList(D.contenido);
            for (int j = 0; j < docD.size(); ++j) {
                if (! existeP(docsPalabra[i], docD[j])) {
                    Double a = tf(docD, docD[j]);
                    Double b = idf(docD[j]);
                    PalabraFrec c = new PalabraFrec();
                    c.frecuencia = a * b;
                    c.palabra = docD[j];
                    docsPalabra[i].Add(c);
                }
            }
        }
    }
    public void intersect(ArrayList<PalabraFrec> s1, ArrayList<PalabraFrec> s2) {
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

        return (sqrt(s1Res) * sqrt(s2Res)) / result;
    }

    public void generarVector() {

        ArrayList<PalabraFrec> s1 = new ArrayList<string> ();
        s1 = docsPalabra[docsPalabra.size() - 1];

        for (int i = 0; i < docsPalabra.size() - 1 ; ++i) {
            ArrayList<PalabraFrec> s2 = new ArrayList<string> ()
            double resultat = intersect(s1, s2);
            frecResult[docsPalabra.size()-1][i] = resultat;
            frecResult[i][docsPalabra.size()-1] = resultat;
        }

    }


    private ArrayList<String> stringToArrayList(String contenido) {
        ArrayList<String> doc = new ArrayList<String>;
        //ArrayList<String> separator = new ArrayList<>(Arrays.asList(".", ";", ",", " ", "(", ")", "{", "}", "!", "?", ":"));
        doc = contenido.split("[,. ?;:()!{}]+");
        return doc;
    }

    private Boolean visitado?(ArrayList<PalabraFrec> frecuencia, String p) {
        for(PalabraFrec f : frecuencia) {
            if(f.palabra == p) return true;
        }
        return false;
    }


    private PalabraFrec frecPalabrasD(ArrayList<String> docD, string p){
        ArrayList<PalabraFrec> resultado = new ArrayList<PalabraFrec>();
        for(int i = 0; i < docD.size(); ++i) {
            String palabra1 = docD.get(i);
            int cont = 1;
            if (!visitado?(resultado, palabra1)){
                for (int j = i + 1; j < docD.size(); ++j) {
                    String palabra2 = docD.get(j);
                    if (palabra1.equalsIgnoreCase(palabra2)) ++cont;
                }
                PalabraFrec a = new PalabraFrec();
                a.palabra = palabra1;
                a.frecuencia = cont / docD.size();
                resultado.Add(a);
            }
        }
        return resultado;
    }


    private Boolean existe?(ArrayList<String> doc, String p) {
        for (String palabra : doc) {
            if (p.equalsIgnoreCase(palabra)) return true;
        }
        return false;
    }

    /**
     * @param D documento seleccionado
     * @param K un número natural
     * @return un conjunto de K documentos más similares a D
     */
    public ArrayList<Documento> similares(Documento D, int K){
        Autor autorD = D.autor;
        Titulo tituloD = D.titulo;

        ArrayList<Documento> result = new ArrayList<Documento>();

        ArrayList<String> docD = stringToArrayList(D.contenido);
        ArrayList<PalabraFrec> frecuenciasD = frecPalabrasD(docD);

        PalabraFrec todasFrecDocs [][] = new PalabraFrec[][];

        ArrayList<Double> idf = new ArrayList<Double>(frecuenciasD.size());

        for(int i = 0; i < frecuenciasD.size(); ++i) {
            int cont = 0;
            for (int j = 0; j < Documentos.size(); ++j) {
                String a = Documentos.get(j).contenido;
                ArrayList<String> docA = stringToArrayList(a);
                if (existe? (docA,frecuenciasD.get(i).palabra))++cont;
            }
            idf.set(i, Math.log(Documentos.size()/cont));
        }

        for (int i = 0; i < Documentos.size(); ++i) {

            ArrayList<PalabraFrec> f = new ArrayList<PalabraFrec>();
            ArrayList<String> doc = stringToArrayList(Documentos.get(i).contenido);
            for (int j = 0; j < frecuenciasD.size(); ++j) {
                string p = frecuenciasD.get(j).palabra;
                double frec = tf(doc, p);
                PalabraFrec a = new PalabraFrec();
                a.palabra = p;
                a.frecuencia = frec*idf.get(j);
                f.Add(a);
            }
            todasFrecDocs.Add(f);
        }

        for (int i = 0; i < todasFrecDocs.size(); ++i) {

        }

        for (int i = 0; i < K; ++i) {
            result.Add()
        }
        return result;
    }


}
