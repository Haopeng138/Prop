package Dominio;
import Dominio.Estructura.Autor;
import Dominio.Estructura.Autores;

public class ControladorDominio {
    public static void main(String[] args) {
         Autor a = new Autor("Joan");
         System.out.println(a.getName());
         Autores b = new Autores();
         b.Add(a);

    }
}
