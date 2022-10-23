package Dominio;

import Dominio.Estructura.Autor;
import Dominio.Estructura.Titulo;
import Dominio.Estructura.Autores;

import java.util.ArrayList;

public class ControladorDominio {
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
        System.out.println(b.getAutores("z"));
        ArrayList<Autor> ab = b.getAutores();
        System.out.println("expect los autores, its b.getAutores()");
        System.out.println(ab);
        b.remove(a);
        System.out.println("expect los autores menos Joan, b.remove(a)");
        System.out.println(b.getAutores());

    }
}
