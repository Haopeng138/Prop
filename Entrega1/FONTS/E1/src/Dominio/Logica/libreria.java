package Dominio.Logica;

import java.util.HashSet;
import java.util.TreeMap;

import Dominio.Estructura.Autor;
import Dominio.Estructura.Titulo;

public class Libreria {

    public static Boolean tienePalabra(Autor key, Titulo t, String word) {
        return true;
    }

    public static Boolean tieneString(Autor key, Titulo t, String toMatch) {
        return true;
    }

    public TreeMap<Autor, HashSet<Titulo>> getIdx() {
        return null;
    }

}