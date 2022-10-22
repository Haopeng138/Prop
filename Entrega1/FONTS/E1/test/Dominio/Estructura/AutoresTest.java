package Dominio.Estructura;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AutoresTest {
    @Test
    public void CreacionBorrado(){
        Autores a = new Autores();
        Autor autor = new Autor("Carlos");
        a.add(autor);
        a.remove(autor);
        ArrayList<Autor> b = a.getAutores();
        assertEquals(b.isEmpty(),true);
    }
}