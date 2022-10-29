package Dominio.Expresion;

public class Expresion {

    private String expresion;

    public Expresion(String expresion) {
        // if (isValid)
        // else maybe create a new type of Exception and throw that. Invalid Expresion
        // exception.
        this.expresion = expresion;
    }

    public String getExpresion() {
        return expresion;
    }

    public void setExpresion(String expresion) {
        this.expresion = expresion;
    }
}
