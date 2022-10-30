package Dominio.Estructura;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class AutoresTest {
    Autores a;
    Autor autorg;
    @BeforeEach
    void setUp() {
        a = new Autores();
        autorg = new Autor("Alberto");
        a.add(autorg);
    }

    @Test
    void has() {
        Autor autor = new Autor("Alberto");
        // Caso en que el autor si que está
        assertTrue(a.has(autor),"No esta el autor");

        // Caso en que el autor no está
        assertFalse(a.has(new Autor("Nombre que no existe")),"Esta el autor");
    }

    @Test
    void add() {
        Autor autor = new Autor("Joan");
        // Caso inicial (solo hay un autor)
        assertEquals(1,a.getNumAutor(),"Debería estar solo un autor");

        // Caso 2: se añade un autor => hay dos autores
        a.add(autor);
        assertEquals(2,a.getNumAutor(),"Debería haber 2 autores ");

        // Caso 3: se añade un autor repetido => no se deberia añadir
        a.add(autor);
        assertEquals(2,a.getNumAutor(),"No debería poder añadir el mismo autor dos veces");

        // Caso 4: se añade un autor que no tiene nombre => no se deberia añadir
        Autor autortmp = new Autor("");
        a.add(autortmp);
        assertEquals(2,a.getNumAutor(),"No debería poder añadir un autor que no tiene nombre");
    }

    @Test
    void addTitleToAutor() {
        Titulo t = new Titulo("Monstruo de las galletas");
        // Caso inicial: (no hay titulo) añadir un titulo =>
        a.addTitleToAutor(t,autorg);
        ArrayList<Titulo> titulos = a.getTitles(autorg);
        String tmp = titulos.get(titulos.size()-1).toString();
        assertEquals("Monstruo de las galletas",tmp,"El titulo no se ha introducido bien");
        assertEquals(1,titulos.size(),"Solo tendría que haber un titulo");

        // Caso 2: Añadir un titulo repetido
        a.addTitleToAutor(t,autorg);
        ArrayList<Titulo> titulos2 = a.getTitles(autorg);
        assertEquals(1,titulos2.size(),"El mismo titulo no debería poder añadir");

        // Caso 3: Añadir un titulo en blanco
        Titulo t2 = new Titulo("");
        a.addTitleToAutor(t2,autorg);
        ArrayList<Titulo> titulos3 = a.getTitles(autorg);

    }

    @Test
    void remove() {
        // Caso 1 : eliminar un autor que no existe
        Autor aux = new Autor("Nombre que no esta en la lista");
        int numAutorIni = a.getNumAutor();
        a.remove(aux);
        int numAutorRmv = a.getNumAutor();
        assertEquals(numAutorIni,numAutorRmv,"Ha eliminado un autor que no existe");

        // Caso 2: eliminar un autor que existe
        a.remove(autorg);
        numAutorRmv = a.getNumAutor();
        assertEquals(0,numAutorRmv,"No se ha eliminado el autor correctamente");
    }

    @Test
    void getOrderedAutores() {
        for(int i = 10; i>=0; i--){
            String s = Integer.toString(i);
            Autor tmpa = new Autor(s);
            a.add(tmpa);
        }
        TreeSet<Autor> autorTreeSet =  a.getOrderedAutores();
/*        boolean ordenado = true;
        String tmp="";
        for (Autor s:autorTreeSet){
            if (tmp ==""){
                tmp = s.getName();
            }else{
                if(tmp.compareTo(s.getName()) > 0){
                    ordenado = false;
                    break;
                }else {
                    tmp = s.getName();
                }
            }

        }
        assertTrue(ordenado,"Los autores están ordenados");*/

    }


}