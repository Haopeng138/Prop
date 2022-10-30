package Dominio.Expresion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpresionTest {

    @Test
    void Expresion(){
        //Caso 1: Crear una expresion válida:
        Expresion e = new Expresion("{p1 p2 p3} & (“hola adéu” | pep) & !joan");
        assertEquals("{p1 p2 p3} & (“hola adéu” | pep) & !joan",e.getExpresion(),"La expresion no es correcta");

        //Caso 2: Crear una expresion no válida: devuelve null
        Expresion e2 = new Expresion("{p1 p2 p3} & (“hola adéu” | pep) & !joan(");
        assertEquals(null,e2.getExpresion(),"No se detectado bien una expresion mala");
    }

    @Test
    void setExpresion() {
        //Caso 1: Una expresion válida
        Expresion e = new Expresion("{p1 p2 p3} & (“hola adéu” | pep) & !joan");
        e.setExpresion("rw & (a b c");
        assertEquals("{p1 p2 p3} & (“hola adéu” | pep) & !joan",e.getExpresion(),"No se ha detectado bien una expresion mala");
        //Caso 2: Una expresion no válida
        e.setExpresion("{p1 p2 p3} & (“hola adéu” | pep) & !joan");
        assertEquals("{p1 p2 p3} & (“hola adéu” | pep) & !joan",e.getExpresion(),"La expresion no es correcta");
    }
}