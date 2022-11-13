package Dominio.Expresion;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExpresionTest {

    @Test
    public void Expresion() throws ExpresionException {
        Expresion e = new Expresion("{p1 p2 p3} & (\"hola adéu\" | pep) & !joan");
        assertEquals("La expresion no es correcta", "{p1 p2 p3} & (\"hola adéu\" | pep) & !joan", e.getExpresion());
        try {
            Expresion e2 = new Expresion("{p1 p2 p3} & (\"hola adéu\" | pep) & !joan(");
        } catch (Exception error) {
            assertEquals("No se detectado bien una expresion mala", "Expresion Invalida", error.getMessage());
        }

    }

    @Test
    public void setExpresion() throws ExpresionException {
        Expresion e = new Expresion("{p1 p2 p3} & ( \"hola adéu\" | pep) & !joan");
        // Caso 1: Modificar a una expresion invalida
        try {
            e.setExpresion("rw & (a b c");
        } catch (Exception error) {
            assertEquals("No se ha detectado bien una expresion mala", "Expresion Invalida", error.getMessage());
        }

        // Caso 2: Modificar a una expresion valida
        e.setExpresion("{p1 p2 p3} & (“hola adéu” | pep) & !joan");
        assertEquals("La expresion no es correcta", "{p1 p2 p3} & (“hola adéu” | pep) & !joan", e.getExpresion());

    }
}