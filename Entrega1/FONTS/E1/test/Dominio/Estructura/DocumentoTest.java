package Dominio.Estructura;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DocumentoTest {
    Documento d;
    @Before
    public void setUp() throws Exception {
        d = new Documento("Alberto","Magias","Un texto muy largo");
    }

    @Test
    public void setAutor() {
        d.setAutor("Auto");
        String autor = d.getAutor();
        assertEquals("No se ha modificado bien el nombre del autor","Auto",autor);
    }

    @Test
    public void setTitulo() {
        d.setTitulo("Titu");
        String titulo = d.getTitulo();
        assertEquals("No se ha modificado bien el titulo","Titu",titulo);
    }

    @Test
    public void setContenido() {
        d.setContenido("Contenido");
        String contenido = d.getContenido();
        assertEquals("No se ha modificado bien el contenido","Contenido",contenido);
    }
}