package Dominio.Logica;

import Dominio.Estructura.Autor;
import Dominio.Estructura.Autores;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BusquedaPorPrefijoTest {
    Autores a;
    @BeforeEach
    void setUp() {
        a = new Autores();
        Autor autor = new Autor("Abbigail");
        a.add(autor);
        Autor autor1 = new Autor("Abisai");
        a.add(autor1);
        Autor autor2 = new Autor("Abril");
        a.add(autor2);
    }

    @Test
    void buscar() {

        ArrayList<Autor> av = BusquedaPorPrefijo.buscar(a.getOrderedAutores(),"A");
        // Caso 1: Existe los autores con este prefijo
        ArrayList<Autor> expecteda = a.getAutores();
        assertEquals(expecteda,av,"No ha encontrado los autores esperados");

        // Caso 2: No existe los autores con este prefijo  => devuelve una lista vacía
        ArrayList<Autor> avError = BusquedaPorPrefijo.buscar(a.getOrderedAutores(),"B");
        ArrayList<Autor> expectederror = new ArrayList<Autor>();
        assertEquals(expectederror,avError,"Ha encontrado un prefijo que no existe");

        // Caso 3: No introducir ningún prefijo
        ArrayList<Autor> avVacio = BusquedaPorPrefijo.buscar(a.getOrderedAutores(),"");
        assertEquals(a.getAutores(),avVacio,"No se ha devuelto todos los autores");
    }
}