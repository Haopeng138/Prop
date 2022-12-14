package Dominio;

import Dominio.Expresion.ControladorExpresiones;
import Dominio.Expresion.ExpresionException;
import Dominio.Logica.ControladorBusqueda;
import Dominio.Utils.BinaryTree;
import Dominio.Utils.DocumentHeader;
import Dominio.Utils.IOHelper;
import Dominio.Utils.ParseNode;
import Dominio.Estructura.Autor;
import Dominio.Estructura.Documento;
import Dominio.Estructura.Libreria;
import Dominio.Estructura.Titulo;

import java.io.File;

import java.util.ArrayList;

public class ControladorDominio {

    Libreria libreria;
    ControladorExpresiones cExpresiones;

    public ControladorDominio() {
        libreria = new Libreria();
        cExpresiones = new ControladorExpresiones();
    }

    //// PUNTO 1

    /**
     * @param documento El documento a importar
     */
    public void createDocumento(File documento) {
        Documento doc;
        try {
            doc = IOHelper.create(documento);
            createDocumento(doc.getAutor(), doc.getTitulo(), doc.getContenido());
        } catch (Exception e) {
            System.out.println("Error importing Document");
            e.printStackTrace();
        }
    }

    public void createDocumento(String a, String t, String contenido) {
        libreria.createDocumento(a, t, contenido);
    }

    public void modifyDocumento(String a, String t, String contenido) {
        libreria.modifyDocumento(a, t, contenido);
    }

    public void removeDocumento(String a, String t) {
        libreria.removeDocumento(a, t);
    }

    /**
     * @param doc  El documento a exportar
     * @param path El path al que exportarlo
     * @param name El nombre que dar al documento
     */
    public void exportDocumento(Documento doc, File path, String name) {
        try {
            IOHelper.export(doc, path, name);
        } catch (Exception e) {
            System.out.println("Error exporting document");
            e.printStackTrace();
        }
    }
    ////

    //// PUNTO 2
    /**
     * @param a El nombre de un autor
     * @return Listado de titulos del autor
     */
    public ArrayList<Titulo> getTitles(String a) {
        return libreria.getTitles(a);
    }

    /**
     * @param pre El prefijo de un autor
     * @return Listado de autores que comienza por el pre
     */
    public ArrayList<Autor> obtenerAutoresPrefijo(String pre) {
        return ControladorBusqueda.buscarPorPrefijo(libreria.getOrderedAutores(), pre);
    }

    /**
     * @param autorName  nombre del autor
     * @param tituloName nombre del t
     * @return
     */
    public String getContent(String a, String t) {
        return libreria.getContent(a, t);
    }

    //// PUNTO 3

    /**
     * @param e Una expresión
     * @return un conjunto de documentos
     */
    public ArrayList<DocumentHeader> busquedaPorSimilitud(String a, String t, int k) {
        return ControladorBusqueda.buscarPorSimilitud(new DocumentHeader(a, t), k, libreria);
    }

    /**
     * @param e Una expresión
     * @return un conjunto de documentos
     */
    public ArrayList<DocumentHeader> busquedaPorExpresion(String alias) {

        BinaryTree<ParseNode> bTree;
        try {
            bTree = cExpresiones.parseFromAlias(alias);
            return ControladorBusqueda.buscarPorExpresion(bTree, libreria);
        } catch (Exception e) {
            System.out.println("No se ha podido construir el arbol de busqueda de la expresion");
            return null;
        }
    }

    //// PUNTO 4

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

    public String getExpresion(String alias) {
        return cExpresiones.getAsString(alias);
    }
}