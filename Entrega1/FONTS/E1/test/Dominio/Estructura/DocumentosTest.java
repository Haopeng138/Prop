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
        // Caso añadir un documento
        assertEquals("Deberia estar vacio ",0,documentos.getDocumentos().size());
        documentos.add(d);
        assertEquals("No se ha añadido bien", 1, documentos.getDocumentos().size());
    }

    @Test
    public void remove() {
        // Eliminar un documento
        documentos.add(d);
        documentos.remove(0);
        assertEquals("No se ha eliminado bien", 0, documentos.getDocumentos().size());
    }

    @Test
    public void modifyContent() {
        // Caso en que se modifica un documento ya creado
        documentos.add(d);
        documentos.modifyContent(0, "Contenido nuevo");
        String d = documentos.getDocumentos().get(0).getContenido();
        assertEquals("No se ha modificado bien el contenido", "Contenido nuevo", d);
    }

    @Test
    public void getContent() {
        // Obtener un contenido
        documentos.add(d);
        String contentlocal = documentos.getContent(0);
        assertEquals("No se ha obtenido bien el contenido", content, contentlocal);

    }

    @Test
    public void generarSimilitudEntreDocs() {

        Documento local = new Documento("autorlocal", "titullocal", content);
        Documento local2 = new Documento("autorloca2", "titu2", "Mut thekl fdjgj");
        Documento local3 = new Documento("atuor ","tit","contenido test Mut");
        documentos.add(d);
        documentos.add(local);
        documentos.add(local2);
        documentos.add(local3);


        // Caso 1: Comparar dos documentos iguales
        double angle = documentos.generarSimilitudEntreDocs(0, 1);
        int data = (int) angle;
        assertEquals("Son iguales deberia devolver 1 ", 1, data);

        // Caso 2: Comparar dos documentos completamente diferentes
        double angle2 = documentos.generarSimilitudEntreDocs(1, 2);
        int data2 = (int) angle2;
        assertEquals("Son diferentes deberia devolver 0 ", 0, data2);

        // Caso 3: Tienen algo similar
        double angle3 = documentos.generarSimilitudEntreDocs(0, 3);
        int data3 = (int) angle3;
        assertTrue("No ha devuelto dentro del rango",0 <= data3 && data3 <=1);
    }

    @Test
    public void tieneString() {
        String s = "contenido corto";
        documentos.add(d);
        // Caso 1: buscar un string que si tiene
        boolean b = documentos.tieneString(0, s);
        assertTrue("Tiene el contenido pero no lo ha encontrado ", b);

        // Caso 2: buscar un string que no tiene
        String s2 = "radno ajldfhgksfdjgkla";
        boolean b2 = documentos.tieneString(0, s2);
        assertFalse("No tiene ese contendio y ha encontrado", b2);

        // Casa 3: buscar un string parcial
        String s3 = "suficiente pa";
        boolean b3 = documentos.tieneString(0, s3);
        assertTrue("No tiene ese contendio y ha encontrado", b3);
    }

    @Test
    public void tienePalabra() {
        documentos.add(d);
        //Caso 1: busca una palabra existente
        boolean b = documentos.tienePalabra(0, "test");
        assertTrue("Tiene el contenido pero no lo ha encontrado ", b);
        //Caso 2: busca una palabra inexistente
        boolean b2 = documentos.tienePalabra(0, "unaparalgkf");
        assertFalse("No tiene ese contendio y ha encontrado", b2);

        //Caso 3: buscar una palabra parcial
        boolean b3 = documentos.tienePalabra(0, "te");
        assertFalse("No tiene esa palabra ", b3);
    }

}