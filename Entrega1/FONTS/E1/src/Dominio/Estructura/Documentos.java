package Dominio.Estructura;

import Dominio.Estructura.Documento;

import java.util.ArrayList;

public class Documentos {
    private ArrayList<Documento> Documentos;
    public Documentos (){
        this.Documentos = new ArrayList<Documento>();
    }

    public void add(Documento d){
        Documentos.add(d);
    }

    public void remove(Documento d){
        Documentos.remove(d);
    }

    public ArrayList<Documento> getDocumentos(){
        return Documentos;
    }
}
