package Dominio.Logica;

import Dominio.Estructura.Libreria;
import Dominio.Expresion.Expresion;
import Dominio.Utils.BinaryTree;
import Utils.DocumentHeader;
import Dominio.Utils.ParseNode;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static Dominio.Expresion.Parser.parse;
import static org.junit.Assert.*;

public class BusquedaPorExpresionTest {

        Libreria libreria = new Libreria();
        BusquedaPorExpresion bpe = new BusquedaPorExpresion();

        @Before
        public void setUp() throws Exception {
                libreria.createDocumento("Chinua Achebe", "Todo se desmorona",
                                "La viada de Okonkwo, un líder y campeón local de lucha en Umuofia ...");
                libreria.createDocumento("Hans Christian Andersen", "Cuentos infantiles",
                                "Muchos cuentos random ningún contenido especial ");
                libreria.createDocumento("Dante Alighieri", "Divina Comedia",
                                " cuentos que se trata de una comedia random pero con contenido especial");

        }

        @Test
        public void buscar() throws Exception {

                Expresion e = new Expresion("(viada , líder) & !cuentos");
                BinaryTree<ParseNode> eparser = parse(e.getExpresion());
                ArrayList<DocumentHeader> result = bpe.buscar(eparser, libreria);
                ArrayList<DocumentHeader> expected = new ArrayList<DocumentHeader>();
                expected.add(new DocumentHeader("Chinua Achebe", "Todo se desmorona"));

                // Caso 1: Solo cumple la condición uno de los
                assertEquals("No se ha devuelto documentos que se esperaba", expected.get(0), result.get(0));

                Expresion e2 = new Expresion("(viada , líder) | cuentos");
                BinaryTree<ParseNode> eparser2 = parse(e2.getExpresion());
                ArrayList<DocumentHeader> result2 = bpe.buscar(eparser2, libreria);
                ArrayList<DocumentHeader> expected2 = new ArrayList<DocumentHeader>();
                expected2.add(new DocumentHeader("Hans Christian Andersen", "Cuentos infantiles"));
                expected2.add(new DocumentHeader("Dante Alighieri", "Divina Comedia"));

                // Caso 2: Cada documento cumple una de las dos condiciones y devuelve la lista
                // entera de documentos
                // Todo: cambiar el orden dependiendo de la función
                Collections.sort(expected2, ((h1, h2) -> h1.getAutor().compareTo(h2.getAutor())));
                Collections.sort(result2, ((h1, h2) -> h1.getAutor().compareTo(h2.getAutor())));
                for (int i = 0; i < expected.size(); i++) {
                        assertEquals("No se ha devuelto documentos que se esperaba", expected2.get(i), result2.get(i));
                }
        }
}