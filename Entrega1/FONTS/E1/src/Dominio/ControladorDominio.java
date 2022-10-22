package Dominio;
import Dominio.Estructura.Autor;
import Dominio.Estructura.Autores;

import java.util.ArrayList;

public class ControladorDominio {
    public static void main(String[] args) {
         Autor a = new Autor("Joan");

         Autores b = new Autores();
         b.add(a);
         ArrayList<Autor> ab = b.getAutores();


    }
}
