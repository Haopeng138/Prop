package Dominio.Estructura;

import Dominio.Utils.DocumentHeader;
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


    }

    @Test
    public void addTitleToAutor() {

        Titulo t = new Titulo("Monstruo de las galletas");
        // Caso inicial: (no hay titulo) añadir un titulo =>
        DocumentHeader header = new DocumentHeader(autorg,t);
        a.addTitleToAutor(header);
        ArrayList<Titulo> titulos = a.getTitles(autorg.getName());
        String tmp = titulos.get(titulos.size()-1).toString();
        assertEquals("El titulo no se ha introducido bien","Monstruo de las galletas",tmp);
        assertEquals("Solo tendría que haber un titulo",1,titulos.size());

        // Caso 2: Añadir un titulo repetido
        a.addTitleToAutor(header);
        ArrayList<Titulo> titulos2 = a.getTitles(autorg.getName());
        assertEquals("El mismo titulo no debería poder añadir",1,titulos2.size());

        // Caso 3: Añadir un titulo en blanco
        Titulo t2 = new Titulo("");
        DocumentHeader header1 = new DocumentHeader(autorg,t2);
        a.addTitleToAutor(header1);
        ArrayList<Titulo> titulos3 = a.getTitles(autorg.getName());
        // Todo decidir si un titulo nullo se puede añadir
        assertEquals("El mismo titulo no debería poder añadir",1,titulos3.size());
        assertEquals("El titulo aunque esté vacío puede añadir",2,titulos3.size());

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

    @Test
    public void getDocumentIdx() throws Exception {
        Titulo t = new Titulo("Monstruo de las galletas");
        // Caso inicial: (no hay titulo) añadir un titulo =>
        DocumentHeader header = new DocumentHeader(autorg,t);
        a.addTitleToAutor(header);
        Titulo t2 = new Titulo("No te deja dormir");
        DocumentHeader header2 = new DocumentHeader(autorg,t2);
        a.addTitleToAutor(header2);
        Integer i = 1;
        assertEquals("No se ha devuelto el index esperado",i,a.getDocumentIdx(header));
        i = 2;
        assertEquals("No se ha devuelto el index esperado",i,a.getDocumentIdx(header2));
        try {
            DocumentHeader headererror = new DocumentHeader("janfkga","gksjdfnlgkjsdf");
            a.getDocumentIdx(headererror);
        }catch (Exception e){
            assertEquals("No se ha detectado el error","Autor no encontrado",e.getMessage());
        }

        try{
            DocumentHeader headererrort = new DocumentHeader(autorg,new Titulo("HOla"));
            a.getDocumentIdx(headererrort);
        }catch (Exception e){
            assertEquals("No se ha detecatado que no tiene el titulo","El autor no tiene este titulo",e.getMessage());
        }
    }

    @Test
    public void getIdx() {
    }

    @Test
    public void removeTitle() {
        Titulo t = new Titulo("Hola");
        DocumentHeader header = new DocumentHeader(autorg,t);
        a.add(autorg);
        a.addTitleToAutor(header);
        Titulo t2 = new Titulo("Hola2");
        DocumentHeader header1 = new DocumentHeader(autorg,t2);
        a.addTitleToAutor(header1);
        a.removeTitle(autorg.getName(),t.getName());
        assertEquals("Solo deberia tener un titulo:",t2.getName(),a.getTitles(autorg.getName()).get(0).getName());
    }


}