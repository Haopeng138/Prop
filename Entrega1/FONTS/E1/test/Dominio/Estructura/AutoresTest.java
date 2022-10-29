package Dominio.Estructura;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


class AutoresTest {


    @Test
    void has() {
        Autores a = new Autores();
        Autor ab = new Autor("Joan");
        a.add(ab);
        assertEquals(a.getAutores().get(0).getName(),"Joagfr");
    }

    @Test
    void add() {
    }

    @Test
    void addTitleToAutor() {
    }

    @Test
    void remove() {
    }

    @Test
    void getAutores() {
    }

    @Test
    void getOrderedAutores() {
    }
}