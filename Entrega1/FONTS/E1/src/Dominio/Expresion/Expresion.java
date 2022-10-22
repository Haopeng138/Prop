package Dominio.Expresion;

public class Expresion {

    private String alias;
    private String expresion;

    public Expresion(String expresion,String alias) {
        this.expresion = expresion;
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }

    public String getExpresion() {
        return expresion;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setExpresion(String expresion) {
        this.expresion = expresion;
    }
}
