package Dominio;
import  Dominio.*;
public class ControladorDominio {
    public static void main(String[] args) {
         Autor a = new Autor("Joan");
         System.out.println(a.getName());
         Autores b = new Autores();
         b.Add(a);

    }


}
