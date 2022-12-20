package Interficie;

import Dominio.ControladorDominio;
import Dominio.Utils.DocumentHeader;
import Interficie.vistas.FramePrincipal;


public class ControladorInterficie {
    private ControladorDominio ctrl_dominio;
    private FramePrincipal framePrincipal;
    public ControladorInterficie() {
        this.ctrl_dominio = new ControladorDominio();
    };


    public void inicial() {
         this.framePrincipal = new FramePrincipal(this);
         this.framePrincipal.setVisible(true);
         this.framePrincipal.añadirDocumento("ctrlintr");
    }
    public void getDocument(){

        DocumentHeader[] documentHeaders = ctrl_dominio.getDocumentHeaders();
        for (DocumentHeader documentHeader : documentHeaders) {
            this.framePrincipal.añadirDocumento(documentHeader.getTitulo().getName());
        }
    }

    public void updateExpresion(String alias, String expresion) {

    }

    public void createDocumento(String autor,String titulo,String contenido){
        ctrl_dominio.createDocumento(autor, titulo, contenido);
    }
}
