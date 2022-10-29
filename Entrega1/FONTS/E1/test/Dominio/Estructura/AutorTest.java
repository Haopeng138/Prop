package Dominio.Estructura;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AutorTest {

    @Test
    void testToString() {
        Autor a = new Autor("Joan");
        //Con el mismo nombre
        assertEquals("Joan",a.toString(),"Debe tener el mismo nombre");
        //Con un nombre diferente
        assertNotEquals("random",a.toString());

    }

    @Test
    void compareTo() {
        Autor a = new Autor("Joan");
        Autor b = new Autor("Luis");
        assertEquals(0,a.compareTo(a),"Deben ser lo mismo");
        assertNotEquals(0,a.compareTo(b),"No deben ser lo mismo");

    }
}