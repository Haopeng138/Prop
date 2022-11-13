package Dominio.Logica;

import Dominio.Estructura.Libreria;
import Dominio.Utils.DocumentHeader;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BusquedaPorSimilitudTest {

    Libreria libreria = new Libreria();

    @Before
    public void setUp() throws Exception {
        libreria.createDocumento("Chinua Achebe", "Todo se desmorona",
                "La viada de Okonkwo, un líder y campeón local de lucha en Umuofia ...");
        libreria.createDocumento("Hans Christian Andersen", "Cuentos infantiles",
                "Muchos cuentos random ningún contenido especial ");
        libreria.createDocumento("Dante Alighieri", "Divina Comedia",
                " cuentos que se trata de una comedia random pero con contenido especial");
        libreria.createDocumento("Nombre", "titulo", "Muchos cuentos random ningún contenido especial algo ");
    }

    @Test
    public void buscar() {
        DocumentHeader header = new DocumentHeader("Hans Christian Andersen", "Cuentos infantiles");
        DocumentHeader header1 = new DocumentHeader("Nombre", "titulo");
        DocumentHeader header2 = new DocumentHeader("Dante Alighieri", "Divina Comedia");
        DocumentHeader header3 = new DocumentHeader("Chinua Achebe", "Todo se desmorona");
        // header1 és el que más se parece header2 el segundo

        // Deberia obtener el header1
        ArrayList<DocumentHeader> result = BusquedaPorSimilitud.buscar(header, 1, libreria);
        assertEquals("No ha devuelto el numero de documentos indicados", 1, result.size());
        assertEquals("No se ha encontrado el más parecido", header1, result.get(0));

        // Deberia obtener el header1 y header2
        ArrayList<DocumentHeader> result2 = BusquedaPorSimilitud.buscar(header, 2, libreria);
        assertEquals("No ha devuelto el numero de documentos indicados", 2, result2.size());
        assertEquals("No se ha encontrado el más parecido", header1, result2.get(0));
        assertEquals("No se ha encontrado el más parecido", header2, result2.get(1));

        // Todo que pasa si la k supera al numero de documentos que hay:
        // Devolver todos o decir que hay error ?
        ArrayList<DocumentHeader> result3 = BusquedaPorSimilitud.buscar(header, 5, libreria);

        assertEquals("No ha devuelto el numero de documentos indicados", 3, result3.size());
        assertEquals("No se ha devuelto en el orden correcto", header1, result3.get(0));
        assertEquals("No se ha devuelto en el orden correcto", header2, result3.get(1));
        assertEquals("No se ha devuelto en el orden correcto", header3, result3.get(2));
    }

}