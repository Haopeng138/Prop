package Dominio.Estructura;

import Dominio.Estructura.Autor;

import java.util.ArrayList;

public class Autores {
    ArrayList<Autor> Autores = new ArrayList<Autor>();
    public Autores (){
        this.Autores = new ArrayList<Autor>();
    }

    public void Add(Autor a){
        this.Autores.add(a);
    }

    public ArrayList<Autor> getAutores(){
        return this.Autores;
    }

}
