package Dominio.Estructura;

import Dominio.Estructura.Autor;

import java.util.ArrayList;

public class Autores {
    ArrayList<Autor> Autores;
    public Autores (){
        this.Autores = new ArrayList<Autor>();
    }

    public void add(Autor a){
        Autores.add(a);
    }

    public void remove(Autor a){
        Autores.remove(a);
    }
    public ArrayList<Autor> getAutores(){
        return Autores;
    }

}
