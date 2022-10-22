package Dominio;
import Dominio.Estructura.Autor;
import Dominio.Estructura.Autores;

import java.util.ArrayList;

public class ControladorDominio {
    public static void main(String[] args) {
         Autor a = new Autor("Joan");
         System.out.println(a.getName());
         Autores b = new Autores();
         b.Add(a);
         ArrayList<Autor> ab = b.getAutores();
         System.out.println(ab.get(0).getName()) ;

    }
}
