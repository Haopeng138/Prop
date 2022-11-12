package Dominio.Logica;

import Dominio.Estructura.Documento;
import Dominio.Estructura.Libreria;
import Dominio.Expresion.Expresion;
import Dominio.Expresion.ExpresionException;
import Dominio.Utils.BinaryTree;
import Dominio.Utils.DocumentHeader;
import Dominio.Utils.ParseNode;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static Dominio.Expresion.Parser.parse;
import static org.junit.Assert.*;

public class BusquedaPorExpresionTest {

    Libreria libreria = new Libreria();
    BusquedaPorExpresion bpe = new BusquedaPorExpresion();
    @Before
    public void setUp() throws Exception {
        libreria.createDocumento("Chinua Achebe","Todo se desmorona","La viada de Okonkwo, un líder y campeón local de lucha en Umuofia ...");
        libreria.createDocumento("Hans Christian Andersen", "Cuentos infantiles",  "Muchos cuentos random ningún contenido especial ");
        libreria.createDocumento("Dante Alighieri", "Divina Comedia", " cuentos que se trata de una comedia random pero con contenido especial");

    }

    @Test
    public void buscar() throws Exception {

        Expresion e = new Expresion("(viada , líder) & !cuentos");
        BinaryTree<ParseNode> eparser = parse(e.getExpresion());
        ArrayList<DocumentHeader> result = bpe.buscar(eparser,libreria);
        ArrayList<DocumentHeader> expeted = new ArrayList<DocumentHeader>();
        expeted.add(new DocumentHeader("Chinua Achebe","Todo se desmorona"));

        // Caso 1: Solo cumple la condición uno de los
        //assertEquals("No se ha devuelto documentos que se esperaba autor",expeted.get(0).getAutor().getName(),result.get(0).getAutor().getName());
        //assertEquals("No se ha devuelto documentos que se esperaba titulo",expeted.get(0).getTitulo().getName(),result.get(0).getTitulo().getName());

        Expresion e2 = new Expresion("(viada , líder) | cuentos");
        BinaryTree<ParseNode> eparser2 = parse(e2.getExpresion());
        ArrayList<DocumentHeader> result2 = bpe.buscar(eparser2,libreria);
        expeted.add(new DocumentHeader("Hans Christian Andersen", "Cuentos infantiles"));
        expeted.add(new DocumentHeader("Dante Alighieri", "Divina Comedia"));

        // Caso 2: Cada documento cumple una de las dos condiciones y devuelve la lista entera de documentos
        assertEquals("No se ha devuelto documentos que se esperaba autor 0",expeted.get(0).getAutor().getName(),result2.get(0).getAutor().getName());
        assertEquals("No se ha devuelto documentos que se esperaba titulo 0",expeted.get(0).getTitulo().getName(),result2.get(0).getTitulo().getName());
        assertEquals("No se ha devuelto documentos que se esperaba autor 1",expeted.get(1).getAutor().getName(),result2.get(1).getAutor().getName());
        assertEquals("No se ha devuelto documentos que se esperaba titulo 1",expeted.get(1).getTitulo().getName(),result2.get(1).getTitulo().getName());
        assertEquals("No se ha devuelto documentos que se esperaba autor 2",expeted.get(2).getAutor().getName(),result2.get(2).getAutor().getName());
        assertEquals("No se ha devuelto documentos que se esperaba titulo 2",expeted.get(2).getTitulo().getName(),result2.get(2).getTitulo().getName());

    }
}