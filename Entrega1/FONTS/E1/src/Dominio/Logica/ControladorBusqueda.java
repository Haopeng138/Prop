package Dominio.Logica;

import java.util.ArrayList;
import java.util.TreeSet;

import Dominio.Estructura.Autor;

public class ControladorBusqueda {

    public ArrayList<Autor> buscarPorPrefijo(TreeSet<Autor> autores, String prefix) {
        return BusquedaPorPrefijo.buscar(autores, prefix);
    }
}
