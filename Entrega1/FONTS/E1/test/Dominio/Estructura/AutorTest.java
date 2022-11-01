package Dominio.Estructura;

import org.junit.Test;

import static org.junit.Assert.*;

public class AutorTest {

    @Test
    public void testToString() {
        Autor a = new Autor("Joan");
        //Con el mismo nombre
        assertEquals( "Debe tener el mismo nombre","Joan",a.toString());
        //Con un nombre diferente
        assertNotEquals("random",a.toString());

    }

    @Test
    public void compareTo() {
        Autor a = new Autor("Joan");
        Autor b = new Autor("Luis");
        assertEquals("Deben ser lo mismo",0,a.compareTo(a));
        assertNotEquals("No deben ser lo mismo",0,a.compareTo(b));
    }
}