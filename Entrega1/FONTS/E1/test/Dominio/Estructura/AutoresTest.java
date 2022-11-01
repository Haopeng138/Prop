package Dominio.Estructura;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class AutoresTest {

    Autores a ;
    Autor autorg;
    @Before
    public void setUp() throws Exception {
        a = new Autores();
        autorg = new Autor("Alberto");
        a.add(autorg);
    }

    @Test
    public void has() {
        Autor autor = new Autor("Alberto");
        // Caso en que el autor si que está
        assertTrue("No esta el autor", a.has(autor));

        // Caso en que el autor no está
        assertFalse("Esta el autor", a.has(new Autor("Nombre que no existe")));

    }

    @Test
    public void add() {
        Autor autor = new Autor("Joan");
        // Caso inicial (solo hay un autor)
        assertEquals("Debería estar solo un autor",1,a.getNumAutor());

        // Caso 2: se añade un autor => hay dos autores
        a.add(autor);
        assertEquals("Debería haber 2 autores ",2,a.getNumAutor());

        // Caso 3: se añade un autor repetido => no se deberia añadir
        a.add(autor);
        assertEquals("No debería poder añadir el mismo autor dos veces",2,a.getNumAutor());

        // Caso 4: se añade un autor que no tiene nombre => no se deberia añadir
        Autor autortmp = new Autor("");
        a.add(autortmp);
        assertEquals("No debería poder añadir un autor que no tiene nombre",2,a.getNumAutor());

    }

    @Test
    public void addTitleToAutor() {
        Titulo t = new Titulo("Monstruo de las galletas");
        // Caso inicial: (no hay titulo) añadir un titulo =>
        a.addTitleToAutor(t,autorg);
        ArrayList<Titulo> titulos = a.getTitles(autorg);
        String tmp = titulos.get(titulos.size()-1).toString();
        assertEquals("El titulo no se ha introducido bien","Monstruo de las galletas",tmp);
        assertEquals("Solo tendría que haber un titulo",1,titulos.size());

        // Caso 2: Añadir un titulo repetido
        a.addTitleToAutor(t,autorg);
        ArrayList<Titulo> titulos2 = a.getTitles(autorg);
        assertEquals("El mismo titulo no debería poder añadir",1,titulos2.size());

        // Caso 3: Añadir un titulo en blanco
        Titulo t2 = new Titulo("");
        a.addTitleToAutor(t2,autorg);
        ArrayList<Titulo> titulos3 = a.getTitles(autorg);

    }

    @Test
    public void remove() {
        // Caso 1 : eliminar un autor que no existe
        Autor aux = new Autor("Nombre que no esta en la lista");
        int numAutorIni = a.getNumAutor();
        a.remove(aux);
        int numAutorRmv = a.getNumAutor();
        assertEquals("Ha eliminado un autor que no existe",numAutorIni,numAutorRmv);

        // Caso 2: eliminar un autor que existe
        a.remove(autorg);
        numAutorRmv = a.getNumAutor();
        assertEquals("No se ha eliminado el autor correctamente",0,numAutorRmv);

    }

    @Test
    public void getOrderedAutores() {
        for(int i = 10; i>=0; i--){
            String s = Integer.toString(i);
            Autor tmpa = new Autor(s);
            a.add(tmpa);
        }
        TreeSet<Autor> autorTreeSet =  a.getOrderedAutores();
        boolean ordenado = true;
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
        assertTrue("Los autores no están ordenados",ordenado);


    }
}