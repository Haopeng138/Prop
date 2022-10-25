package Dominio.Logica;

import Dominio.Estructura.Autor;
import Dominio.Estructura.Documento;
import Dominio.Estructura.Titulo;
import Dominio.Expresion.Expresion;

import java.util.ArrayList;

public class ControladorBusqueda {
    /**
     * @param autorName Nombre del autor
     * @return Listado de títulos de un autor
     */
    public ArrayList<Titulo> obtenerTítulosDeAutor(String autorName){
        ArrayList<Titulo> result = new ArrayList<Titulo>();
        return result;
    }

    /**
     * @param pre El prefijo de un autor
     * @return Listado de autores que comienza por el pre
     */
    public ArrayList<Autor> obtenerAutoresPrefijo(String pre){
        ArrayList<Autor> result = new ArrayList<Autor>();
        return result;
    }

    /**
     * @param autorName nombre del autor
     * @param tituloName nombre del t
     * @return
     */
    public String obtenerContenido(String autorName,String tituloName){
        String result = "resultado";
        return result;
    }

    /**
     * @param D documento seleccionado
     * @param K un número natural
     * @return un conjunto de K documentos más similares a D
     */
    public ArrayList<Documento> similares(Documento D, int K){
        ArrayList<Documento> result = new ArrayList<Documento>();
        return result;
    }

    /**
     * @param e Una expresión
     * @return un conjunto de documentos
     */
    public ArrayList<Documento> busquedaPorExpresion(Expresion e){
        ArrayList<Documento> result = new ArrayList<Documento>();
        return result;
    }
}
