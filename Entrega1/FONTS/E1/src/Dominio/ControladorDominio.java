package Dominio;

import Dominio.Estructura.*;
import Dominio.Expresion.ControladorExpresiones;
import Dominio.Expresion.Expresion;
import Dominio.Expresion.ExpresionException;
import Dominio.Logica.ControladorBusqueda;
import Dominio.Utils.BinaryTree;
import Dominio.Utils.ParseNode;

import java.util.ArrayList;
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
         System.out.println(ab.get(0).getName()) ;

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

    /**
     * @param e Una expresión
     * @return un conjunto de documentos
     */
    public ArrayList<Documento> busquedaPorExpresion(Expresion e){
        ArrayList<Documento> result = new ArrayList<Documento>();
        return result;
        /*
         * Autor a = new Autor("Joan");
         * System.out.println("expect Joan, its a.getName()");
         * System.out.println(a.getName());
         * Autores b = new Autores();
         * b.add(new Autor("Miquel"));
         * b.add(new Autor("za"));
         * b.add(a);
         * Titulo t = new Titulo("Hei");
         * b.addTitleToAutor(t, a);
         * System.out.println("expect the titles, it's b.getTitles()");
         * System.out.println(b.getTitles(a));
         * System.out.println("expect za, its getAutores, con prefijo z");
         * System.out.println(b.getAutores());
         * ArrayList<Autor> ab = b.getAutores();
         * System.out.println("expect los autores, its b.getAutores()");
         * System.out.println(ab);
         * b.remove(a);
         * System.out.println("expect los autores menos Joan, b.remove(a)");
         * System.out.println(b.getAutores());
         */
        cExpresiones = new ControladorExpresiones();
        cExpresiones.add("prova", "pep");
        cExpresiones.updateExpresion("prova", "{hola bones} | \"bon dia\"");
        cExpresiones.parseFromAlias("prova");
        cExpresiones.remove("prova");
        cExpresiones.parseFromStringExpr("ei & que");
        cExpresiones.updateAlias("prova", "thisWillFail");
        cExpresiones.add("prova", "pep");
        cExpresiones.get("prova");
    }
}
