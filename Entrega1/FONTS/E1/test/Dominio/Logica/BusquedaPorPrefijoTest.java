package Dominio.Logica;

import Dominio.Estructura.Autor;
import Dominio.Estructura.Autores;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BusquedaPorPrefijoTest {
    Autores a;
    Autor autor3;
    @Before
    public void setUp() throws Exception {
        a = new Autores();
        Autor autor = new Autor("Abbigail");
        a.add(autor);
        Autor autor1 = new Autor("Abisai");
        a.add(autor1);
        Autor autor2 = new Autor("Abril");
        a.add(autor2);
        autor3 = new Autor("Zeping");
        a.add(autor3);


    }

    @Test
    public void buscar() {
        ArrayList<Autor> av = BusquedaPorPrefijo.buscar(a.getOrderedAutores(),"A");
        // Caso 1: Existe los autores con este prefijo
        ArrayList<Autor> expecteda = a.getAutores();
        expecteda.remove(autor3);
        assertEquals("No se ha buscado bien",expecteda,av);

        // Caso 2: No existe los autores con este prefijo  => devuelve una lista vacía
        ArrayList<Autor> avError = BusquedaPorPrefijo.buscar(a.getOrderedAutores(),"B");
        ArrayList<Autor> expectederror = new ArrayList<Autor>();
        assertEquals("Ha encontrado un prefijo que no existe",expectederror,avError);

        // Caso 3: No introducir ningún prefijo
        ArrayList<Autor> avTodos = BusquedaPorPrefijo.buscar(a.getOrderedAutores(),"");
        assertEquals("No se ha devuelto todos los autores",a.getAutores(),avTodos);
    }
}