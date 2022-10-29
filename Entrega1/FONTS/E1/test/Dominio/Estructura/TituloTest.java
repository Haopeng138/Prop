package Dominio.Estructura;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TituloTest {

    @Test
    void testToString() {
        Titulo a = new Titulo("El monstruo de las galletas");
        //Con el mismo nombre
        assertEquals("El monstruo de las galletas",a.toString(),"Debe tener el mismo nombre");
        //Con un nombre diferente
        assertNotEquals("random",a.toString());

    }
}