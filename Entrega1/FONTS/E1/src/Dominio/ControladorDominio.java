package Dominio;

import Dominio.Expresion.ControladorExpresiones;
import Dominio.Expresion.ExpresionException;
import Dominio.Logica.ControladorBusqueda;
import Dominio.Utils.DocumentHeader;
import Dominio.Expresion.Expresion;
import Dominio.Estructura.Autor;
import Dominio.Estructura.Libreria;
import Dominio.Estructura.Titulo;

import java.util.ArrayList;

public class ControladorDominio {

    ControladorBusqueda cBusqueda;
    Libreria libreria;
    static ControladorExpresiones cExpresiones;

    public ControladorDominio() {
        cBusqueda = new ControladorBusqueda();
        libreria = new Libreria();
        cExpresiones = new ControladorExpresiones();
    }

    //// PUNTO 1
    public void createDocumento(String a, String t, String contenido) {
        libreria.createDocumento(a, t, contenido);
    }

    public void modifyDocumento(String a, String t, String contenido) {
        libreria.modifyDocumento(a, t, contenido);
    }

    public void removeDocumento(String a, String t) {
        libreria.removeDocumento(a, t);
    }
    ////

    //// PUNTO 2
    public ArrayList<Titulo> getTitles(String a) {
        return libreria.getTitles(a);
    }

    /**
     * @param pre El prefijo de un autor
     * @return Listado de autores que comienza por el pre
     */
    public ArrayList<Autor> obtenerAutoresPrefijo(String pre) {
        return cBusqueda.buscarPorPrefijo(libreria.getOrderedAutores(), pre);
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
        return cBusqueda.buscarPorSimilitud(new DocumentHeader(a, t), k, libreria);
    }

    /**
     * @param e Una expresión
     * @return un conjunto de documentos
     */
    public ArrayList<DocumentHeader> busquedaPorExpresion(String alias) {

        Expresion expresion = cExpresiones.get(alias);
        return cBusqueda.buscarPorExpresion(expresion, libreria);
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