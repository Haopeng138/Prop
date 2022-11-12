package Dominio.Logica;

import Dominio.Estructura.Documento;
import Dominio.Expresion.Expresion;
import Dominio.Expresion.ExpresionException;
import Dominio.Utils.BinaryTree;
import Dominio.Utils.ParseNode;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static Dominio.Expresion.Parser.parse;
import static org.junit.Assert.*;

public class BusquedaPorExpresionTest {
    Set<Documento> documentoSet;
    @Before
    public void setUp() throws Exception {
        documentoSet = new HashSet<>();
        Documento d1 = new Documento("Chinua Achebe","Todo se desmorona","La viada de Okonkwo, un líder y campeón local de lucha en Umuofia ...");
        Documento d2 = new Documento("Hans Christian Andersen", "Cuentos infantiles",  "Muchos cuentos random ningún contenido especial ");
        Documento d3 = new Documento("Dante Alighieri", "Divina Comedia", " cuentos que se trata de una comedia random pero con contenido especial");
        documentoSet.add(d1);
        documentoSet.add(d2);
        documentoSet.add(d3);
    }

    @Test
    public void buscar() throws ExpresionException {
        // Caso 1: Cada documento cumple una de las dos condiciones y devuelve la lista entera de documentos
        /*Expresion e = new Expresion("(viada , líder) | cuentos");
        BinaryTree<ParseNode> eparser = parse(e.getExpresion());
        Set<Documento> result = BusquedaPorExpresion.buscar(eparser,documentoSet);
        assertEquals("No lo mirado en todos los documentos",documentoSet,result);

        // Caso 2: Solo un documento cumple la condición

        Expresion e2 = new Expresion("(viada , líder) | !cuentos");
        BinaryTree<ParseNode> eparser2 = parse(e2.getExpresion());
        Set<Documento> result2 = BusquedaPorExpresion.buscar(eparser2,documentoSet);

        assertEquals("Ha devuelto documentos que se esperaba",documentoSet.stream().findFirst(),result2.stream().findFirst());
*/
    }
}