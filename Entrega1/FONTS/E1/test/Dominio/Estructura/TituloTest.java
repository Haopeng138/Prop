package Dominio.Estructura;

import org.junit.Test;

import static org.junit.Assert.*;

public class TituloTest {

    @Test
    public void testToString() {
        Titulo a = new Titulo("El monstruo de las galletas");
        // Con el mismo nombre
        assertEquals("Debe tener el mismo nombre", "El monstruo de las galletas", a.toString());
        // Con un nombre diferente
        assertNotEquals("No debe tener el mismo nombre", "random", a.toString());
    }

    @Test
    public void compareTo() {
        Titulo a = new Titulo("Joan");
        Titulo b = new Titulo("Luis");
        assertTrue("Deben ser lo mismo", a.equals(a));
        assertFalse("No deben ser lo mismo", a.equals(b));
    }
}