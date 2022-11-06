package Dominio;

import Dominio.Estructura.*;
import Dominio.Expresion.ControladorExpresiones;
import Dominio.Expresion.ExpresionException;
import Dominio.Logica.ControladorBusqueda;
import Dominio.Utils.BinaryTree;
import Dominio.Utils.ParseNode;
import Dominio.Expresion.Expresion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class ControladorDominio {

    ControladorBusqueda cBusqueda;
    ControladorDocumento cDocumento;
    ControladorExpresiones cExpresiones;

    public ArrayList<Autor> getAutores() {
        return cDocumento.getAutores();
    }

    public TreeSet<Autor> getOrderedAutores() {
        return cDocumento.getOrderedAutores();
    }

    public ArrayList<Titulo> getTitles(Autor a) {
        return cDocumento.getTitles(a);
    }

    public String getExpresion(String alias) {
        return cExpresiones.get(alias);
    }

    public void addExpresion(String alias, String expresion)throws ExpresionException {
        cExpresiones.add(alias, expresion);
    }

    public Boolean updateAlias(String oldAlias, String newAlias) {
        return cExpresiones.updateAlias(oldAlias, newAlias);
    }

    public Boolean updateExpresion(String alias, String expresion) {
        return cExpresiones.updateExpresion(alias, expresion);
    }

    public Boolean removeExpresion(String alias) {
        return cExpresiones.remove(alias);
    }

    public BinaryTree<ParseNode> parse(String expr) throws ExpresionException{
        return cExpresiones.parseFromStringExpr(expr);
    }

    public BinaryTree<ParseNode> parseFromAlias(String alias) {
        return cExpresiones.parseFromAlias(alias);
    }

    public static void main(String[] args) {
        Autor a = new Autor("Joan");
        System.out.println(a.getName());
        Autores b = new Autores();
        b.add(a);
        ArrayList<Autor> ab = b.getAutores();
        System.out.println(ab.get(0).getName());
    }

    /**
     * @param pre El prefijo de un autor
     * @return Listado de autores que comienza por el pre
     */
    public ArrayList<Autor> obtenerAutoresPrefijo(String pre){
        ArrayList<Autor> result = new ArrayList<Autor>();
        return result;
    }

    /**
     * @param autorName nombre del autor
     * @param tituloName nombre del t
     * @return
     */
    public String obtenerContenido(String autorName,String tituloName){
        String result = "resultado";
        return result;
    }

//////////////////////////////////////////////////////////////
    private class PalabraFrec {
        private String palabra;
        private Double frecuencia;
    }

    private ArrayList<String> stringToArrayList(String contenido) {
        ArrayList<String> doc = new ArrayList<String>;
        //ArrayList<String> separator = new ArrayList<>(Arrays.asList(".", ";", ",", " ", "(", ")", "{", "}", "!", "?", ":"));
        doc = new ArrayList<String>(Arrays.asList(contenido.split("[,. ?;:()!{}]+")));

        return doc;
    }

    private Boolean visitado(ArrayList<PalabraFrec> frecuencia, String p) {
        for(PalabraFrec f : frecuencia) {
            if(f.palabra == p) return true;
        }
        return false;
    }

    private ArrayList<PalabraFrec> frecPalabrasD(ArrayList<String> docD){
        ArrayList<PalabraFrec> resultado = new ArrayList<PalabraFrec>();
        for(int i = 0; i < docD.size(); ++i) {
            String palabra1 = docD.get(i);
            int cont = 1;
            if (!visitado(resultado, palabra1)){
                for (int j = i + 1; j < docD.size(); ++j) {
                    String palabra2 = docD.get(j);
                    if (palabra1.equalsIgnoreCase(palabra2)) ++cont;
                }
                PalabraFrec a = new PalabraFrec();
                a.palabra = palabra1;
                a.frecuencia = Double.valueOf(cont / docD.size());
                resultado.add(a);
            }
        }
        return resultado;
    }

    private Double tf(ArrayList<String> doc, Documento D, String p){
        int cont  = 0;
        for (int i = 0; i < doc.size(); ++i) {
            String palabra = doc.get(i);
            if (p.equalsIgnoreCase(palabra)) ++cont;
        }
        return Double.valueOf(cont/doc.size());
    }

    private Boolean existe(ArrayList<String> doc, String p) {
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
        String autorD = D.getAutor();
        String tituloD = D.setTitulo();

        ArrayList<Documento> result = new ArrayList<Documento>();

        ArrayList<String> docD = stringToArrayList(D.getContenido());
        ArrayList<PalabraFrec> frecuenciasD = frecPalabrasD(docD);

        PalabraFrec todasFrecDocs [][] = new PalabraFrec[][];

        ArrayList<Double> idf = new ArrayList<Double>(frecuenciasD.size());

        for(int i = 0; i < frecuenciasD.size(); ++i) {
            int cont = 0;
            for (int j = 0; j < Documentos.size(); ++j) {
                String a = Documentos.get(j).contenido;
                ArrayList<String> docA = stringToArrayList(a);
                if (existe (docA,frecuenciasD.get(i).palabra))++cont;
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

    ////////////////////////////////////////////////////////////////

    /**
     * @param e Una expresión
     * @return un conjunto de documentos
     */
    public ArrayList<Documento> busquedaPorExpresion(Expresion e){
        ArrayList<Documento> result = new ArrayList<Documento>();
        return result;
    }



}
