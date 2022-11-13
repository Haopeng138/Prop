package Dominio.Estructura;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DocumentosTest {
    Documentos documentos;
    String content = "contenido corto pero suficiente para los test";
    Documento d = new Documento("autor", "titulo", content);

    @Before
    public void setUp() throws Exception {
        documentos = new Documentos();

    }

    @Test
    public void add() {
        documentos.add(d);
        assertEquals("No se ha añadido bien", 1, documentos.getDocumentos().size());
    }

    @Test
    public void remove() {
        documentos.add(d);
        documentos.remove(0);
        assertEquals("No se ha eliminado bien", 0, documentos.getDocumentos().size());
    }

    @Test
    public void modifyContent() {
        documentos.add(d);
        documentos.modifyContent(0, "Contenido nuevo");
        String d = documentos.getDocumentos().get(0).getContenido();
        assertEquals("No se ha modificado bien el contenido", "Contenido nuevo", d);
    }

    @Test
    public void getContent() {
        documentos.add(d);
        String contentlocal = documentos.getContent(0);
        assertEquals("No se ha obtenido bien el contenido", content, contentlocal);

    }

    @Test
    public void generarSimilitudEntreDocs() {

        Documento local = new Documento("autorlocal", "titullocal", content);
        Documento local2 = new Documento("autorloca2", "titu2", "Mut thekl fdjgj");
        documentos.add(d);
        documentos.add(local);
        documentos.add(local2);
        System.out.println(documentos.getDocumentos().size());
        double angle = documentos.generarSimilitudEntreDocs(0, 1);
        int data = (int) angle;
        assertEquals("Son iguales deberia devolver 1 ", 1, data);
        double angle2 = documentos.generarSimilitudEntreDocs(1, 2);
        int data2 = (int) angle2;
        assertEquals("Son diferentes deberia devolver 0 ", 0, data2);

    }

    @Test
    public void tieneString() {
        String s = "contenido corto";
        documentos.add(d);
        boolean b = documentos.tieneString(0, s);
        assertTrue("Tiene el contenido pero no lo ha encontrado ", b);
        String s2 = "radno ajldfhgksfdjgkla";
        boolean b2 = documentos.tieneString(0, s2);
        assertFalse("No tiene ese contendio y ha encontrado", b2);
    }

    @Test
    public void tienePalabra() {
        documentos.add(d);
        boolean b = documentos.tienePalabra(0, "test");
        assertTrue("Tiene el contenido pero no lo ha encontrado ", b);
        boolean b2 = documentos.tienePalabra(0, "unaparalgkf");
        assertFalse("No tiene ese contendio y ha encontrado", b2);
    }

}