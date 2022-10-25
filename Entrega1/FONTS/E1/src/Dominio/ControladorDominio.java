package Dominio;

import Dominio.Estructura.Autor;
import Dominio.Estructura.Titulo;
import Dominio.Expresion.ControladorExpresiones;
import Dominio.Logica.ControladorBusqueda;
import Dominio.Estructura.Autores;
import Dominio.Estructura.ControladorDocumento;

import java.util.ArrayList;
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

    public static void main(String[] args) {
        Autor a = new Autor("Joan");
        System.out.println("expect Joan, its a.getName()");
        System.out.println(a.getName());
        Autores b = new Autores();
        b.add(new Autor("Miquel"));
        b.add(new Autor("za"));
        b.add(a);
        Titulo t = new Titulo("Hei");
        b.addTitleToAutor(t, a);
        System.out.println("expect the titles, it's b.getTitles()");
        System.out.println(b.getTitles(a));
        System.out.println("expect za, its getAutores, con prefijo z");
        System.out.println(b.getAutores());
        ArrayList<Autor> ab = b.getAutores();
        System.out.println("expect los autores, its b.getAutores()");
        System.out.println(ab);
        b.remove(a);
        System.out.println("expect los autores menos Joan, b.remove(a)");
        System.out.println(b.getAutores());

    }
}
