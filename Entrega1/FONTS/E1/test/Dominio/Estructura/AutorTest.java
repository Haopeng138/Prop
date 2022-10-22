package Dominio.Estructura;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AutorTest {
    @Test
    public void creacion(){
        Autor a = new Autor("Luis");
        assertEquals("Luis",a.getName());
    }
}