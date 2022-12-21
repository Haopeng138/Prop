package Interficie;

import Dominio.ControladorDominio;
import Dominio.Expresion.ExpresionException;
import Interficie.vistas.FramePrincipal;
import java.util.ArrayList;


public class ControladorInterficie {
    private ControladorDominio ctrl_dominio;
    private FramePrincipal framePrincipal;
    public ControladorInterficie() {
        this.ctrl_dominio = new ControladorDominio();
    };


    public void inicial() {
        this.framePrincipal = new FramePrincipal(this);
        ArrayList<String[]> documents = ctrl_dominio.getAllDocuments();
        for(String[] doc:documents){
            this.framePrincipal.cargarDocumento(doc[0], doc[1]);
        }
        this.framePrincipal.setVisible(true);
    }
    public void getDocument(){

    }


    public void updateExpresion(String alias, String expresion) {

    }

    public void createDocumento(String autor,String titulo,String contenido){
        ctrl_dominio.createDocumento(autor, titulo, contenido);
    }
    
    public ArrayList<String[]> busquedaPorExpresion(String alia){
        return ctrl_dominio.busquedaPorExpresion(alia);
    }    
    public ArrayList<String[]> busquedaPorSimilitud(String autor,String titulo,int k){
        return ctrl_dominio.busquedaPorSimilitud(autor,titulo,k);
    }
    
    public String busquedaPorAutorTitulo(String autor, String titulo){
        return ctrl_dominio.getContent(autor, titulo);
    }
    
    public void removeDocument(String autor,String titulo){
        ctrl_dominio.removeDocumento(autor, titulo);
    }
    
    public void modifyDocument(String autor,String titulo,String contenido){
        ctrl_dominio.modifyDocumento(autor, titulo, contenido);
    }

    public void addExpresion(String alia,String expresion) throws Exception {
        try {
            ctrl_dominio.addExpresion(alia,expresion);
        }catch (ExpresionException e){
            throw new Exception("Error añadiendo alia");
        }

    }
    public void persit(){
        ctrl_dominio.persist();
    }
}
