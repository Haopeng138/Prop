package Dominio.Estructura;

import Dominio.Estructura.Documento;

import java.util.ArrayList;

public class Documentos {
    /**
     * Atributos de clase Documento
     */
    private ArrayList<Documento> Documentos;
    public Documentos (){
        this.Documentos = new ArrayList<Documento>();
    }

    /**
     * Metodo para añadir un documento al conjunto de documento
     * @param d Un documento
     */
    public void add(Documento d){
        Documentos.add(d);
    }

    /**
     * Metodo para eliminar un documento del conjunto de documento
     * @param d Un documento
     */
    public void remove(Documento d){
        Documentos.remove(d);
    }

    /**
     * Metodo que devuelve el conjunto de documento
     * @return Documentos
     */
    public ArrayList<Documento> getDocumentos(){
        return Documentos;
    }
}
