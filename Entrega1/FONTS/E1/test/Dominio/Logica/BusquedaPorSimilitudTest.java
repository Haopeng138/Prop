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
        libreria.createDocumento("Chinua Achebe","Todo se desmorona","La viada de Okonkwo, un líder y campeón local de lucha en Umuofia ...");
        libreria.createDocumento("Hans Christian Andersen", "Cuentos infantiles",  "Muchos cuentos random ningún contenido especial ");
        libreria.createDocumento("Dante Alighieri", "Divina Comedia", " cuentos que se trata de una comedia random pero con contenido especial");
        libreria.createDocumento("Nombre","titulo","Muchos cuentos random ningún contenido especial ");
    }

    @Test
    public void buscar() {
        DocumentHeader header = new DocumentHeader("Hans Christian Andersen", "Cuentos infantiles");
        ArrayList<DocumentHeader> result = BusquedaPorSimilitud.buscar(header,1,libreria);
        assertEquals("No se ha encontrado el más parecido",header,result.get(0));
    }

}