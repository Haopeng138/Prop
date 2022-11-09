package Dominio;

import Dominio.Estructura.*;
import Dominio.Expresion.ControladorExpresiones;
import Dominio.Expresion.ExpresionException;
import Dominio.Logica.ControladorBusqueda;
import Dominio.Utils.BinaryTree;
import Dominio.Utils.ParseNode;
import Dominio.Expresion.Expresion;
import Dominio.Estructura.Autor;
import Dominio.Estructura.ControladorDocumento;
import Dominio.Estructura.Titulo;
import Dominio.Estructura.Autores;
import Dominio.Estructura.Documento;
import Dominio.Expresion.Expresion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class ControladorDominio {

    ControladorBusqueda cBusqueda;
    ControladorDocumento cDocumento;
    static ControladorExpresiones cExpresiones;

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

    public void addExpresion(String alias, String expresion) throws ExpresionException {
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

    public BinaryTree<ParseNode> parse(String expr) throws ExpresionException {
        return cExpresiones.parseFromStringExpr(expr);
    }

    public BinaryTree<ParseNode> parseFromAlias(String alias) throws Exception {
        return cExpresiones.parseFromAlias(alias);
    }

    /**
     * @param pre El prefijo de un autor
     * @return Listado de autores que comienza por el pre
     */
    public ArrayList<Autor> obtenerAutoresPrefijo(String pre) {
        ArrayList<Autor> result = new ArrayList<Autor>();
        return result;

    }

    /**
     * @param autorName  nombre del autor
     * @param tituloName nombre del t
     * @return
     */
    public String obtenerContenido(String autorName, String tituloName) {
        String result = "resultado";
        return result;
    }

    //////////////////////////////////////////////////////////////
    private class PalabraFrec {
        private String palabra;
        private Double frecuencia;
    }

    private ArrayList<String> stringToArrayList(String contenido) {
        ArrayList<String> doc = new ArrayList<String>(Arrays.asList(contenido.split("[,. ?;:()!{}]+")));
        // ArrayList<String> separator = new ArrayList<>(Arrays.asList(".", ";", ",", "
        // ", "(", ")", "{", "}", "!", "?", ":"));
        return doc;
    }

    private Boolean visitado(ArrayList<PalabraFrec> frecuencia, String p) {
        for (PalabraFrec f : frecuencia) {
            if (f.palabra == p)
                return true;
        }
        return false;
    }

    private ArrayList<PalabraFrec> frecPalabrasD(ArrayList<String> docD) {
        ArrayList<PalabraFrec> resultado = new ArrayList<PalabraFrec>();
        for (int i = 0; i < docD.size(); ++i) {
            String palabra1 = docD.get(i);
            int cont = 1;
            if (!visitado(resultado, palabra1)) {
                for (int j = i + 1; j < docD.size(); ++j) {
                    String palabra2 = docD.get(j);
                    if (palabra1.equalsIgnoreCase(palabra2))
                        ++cont;
                }
                PalabraFrec a = new PalabraFrec();
                a.palabra = palabra1;
                a.frecuencia = Double.valueOf(cont / docD.size());
                resultado.add(a);
            }
        }
        return resultado;
    }

    private Double tf(ArrayList<String> doc, String p) {
        int cont = 0;
        for (int i = 0; i < doc.size(); ++i) {
            String palabra = doc.get(i);
            if (p.equalsIgnoreCase(palabra))
                ++cont;
        }
        return Double.valueOf(cont / doc.size());
    }

    private Boolean existe(ArrayList<String> doc, String p) {
        for (String palabra : doc) {
            if (p.equalsIgnoreCase(palabra))
                return true;
        }
        return false;
    }

    /**
     * @param D documento seleccionado
     * @param K un número natural
     * @return un conjunto de K documentos más similares a D
     */
    public ArrayList<Documento> similares(Documento D, int K) {
        String autorD = D.getAutor();
        String tituloD = D.getTitulo();

        ArrayList<Documento> result = new ArrayList<Documento>();

        ArrayList<String> docD = stringToArrayList(D.getContenido());
        ArrayList<PalabraFrec> frecuenciasD = frecPalabrasD(docD);

        ArrayList<ArrayList<PalabraFrec>> todasFrecDocs = new ArrayList<ArrayList<PalabraFrec>>();

        ArrayList<Double> idf = new ArrayList<Double>(frecuenciasD.size());
        ArrayList<Documento> documentos = cDocumento.getDocumentos();
        for (int i = 0; i < frecuenciasD.size(); ++i) {
            int cont = 0;
            for (int j = 0; j < documentos.size(); ++j) {
                String a = documentos.get(j).getContenido();
                ArrayList<String> docA = stringToArrayList(a);
                if (existe(docA, frecuenciasD.get(i).palabra))
                    ++cont;
            }
            idf.set(i, Math.log(documentos.size() / cont));
        }

        for (int i = 0; i < documentos.size(); ++i) {

            ArrayList<PalabraFrec> f = new ArrayList<PalabraFrec>();
            ArrayList<String> doc = stringToArrayList(documentos.get(i).getContenido());
            for (int j = 0; j < frecuenciasD.size(); ++j) {
                String p = frecuenciasD.get(j).palabra;
                double frec = tf(doc, p);
                PalabraFrec a = new PalabraFrec();
                a.palabra = p;
                a.frecuencia = frec * idf.get(j);
                f.add(a);
            }
            todasFrecDocs.add(f);
        }

        for (int i = 0; i < todasFrecDocs.size(); ++i) {

        }

        for (int i = 0; i < K; ++i) {
            // todo

        }
        return result;
    }

    ////////////////////////////////////////////////////////////////

    /**
     * @param e Una expresión
     * @return un conjunto de documentos
     */
    public ArrayList<Documento> busquedaPorExpresion(Expresion e) {
        ArrayList<Documento> result = new ArrayList<Documento>();
        return result;
    }

}
