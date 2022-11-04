package Dominio.Expresion;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExpresionTest {

    @Test
    public void Expresion() throws ExpresionException{
        Expresion e = new Expresion("{p1 p2 p3} & (“hola adéu” | pep) & !joan");
        assertEquals("La expresion no es correcta","{p1 p2 p3} & (“hola adéu” | pep) & !joan",e.getExpresion());
        try{
            Expresion e2 = new Expresion("{p1 p2 p3} & (“hola adéu” | pep) & !joan(");
        }catch (Exception error){
            assertEquals("No se detectado bien una expresion mala","Expresion Invalida",error.getMessage());
        }


    }

    @Test
    public void setExpresion() throws ExpresionException{
        //Caso 1: Una expresion válida
        Expresion e = new Expresion("{p1 p2 p3} & (“hola adéu” | pep) & !joan");
        e.setExpresion("rw & (a b c");
        assertEquals("No se ha detectado bien una expresion mala","{p1 p2 p3} & (“hola adéu” | pep) & !joan",e.getExpresion());
        //Caso 2: Una expresion no válida
        e.setExpresion("{p1 p2 p3} & (“hola adéu” | pep) & !joan");
        assertEquals("La expresion no es correcta","{p1 p2 p3} & (“hola adéu” | pep) & !joan",e.getExpresion());

    }
}