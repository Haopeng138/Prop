package Dominio.Estructura;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DocumentosTest {
    Documentos documentos;
    Documento d = new Documento("autor","titulo","contenido");
    @Before
    public void setUp() throws Exception {
        documentos = new Documentos();

    }

    @Test
    public void add() {
        documentos.add(d);
        assertEquals("No se ha añadido bien",1,documentos.getDocumentos().size());

    }

    @Test
    public void remove() {
        documentos.add(d);
        documentos.remove(d);
        assertEquals("No se ha eliminado bien",0,documentos.getDocumentos().size());
    }

    @Test
    public void removeByAutorTitle() {
        documentos.add(d);
        documentos.removeByAutorTitle("autor","titulo");
        assertEquals("No se ha eliminado bien",0,documentos.getDocumentos().size());
    }


    @Test
    public void modifyContent() {
        documentos.add(d);
        documentos.modifyContent("autor","titulo","Contenido nuevo");
        String d = documentos.getContentByAutorTitle("autor","titulo");
        assertEquals("No se ha modificado bien el contenido","Contenido nuevo",d);
    }

    @Test
    public void getContentByAutorTitle() {
        Documento d2 = new Documento("autor2","titulo2","Contenido2");
        documentos.add(d);
        documentos.add(d2);
        String cd = documentos.getContentByAutorTitle("autor","titulo");
        assertEquals("No se ha obtenido bien el contenido","contenido",cd);
        String cd2 = documentos.getContentByAutorTitle("autor2","titulo2");
        assertEquals("No se ha obtenido bien el contenido","Contenido2",cd2);
    }
}