package Interficie;

import Dominio.ControladorDominio;
import Utils.DocumentHeader;
import Interficie.vistas.FramePrincipal;


public class ControladorInterficie {
    private ControladorDominio ctrl_domini;
    private FramePrincipal framePrincipal;
    public ControladorInterficie() {
        this.ctrl_domini = new ControladorDominio();
    };


    public void inicial() {
         this.framePrincipal = new FramePrincipal(this);
         this.framePrincipal.setVisible(true);
         this.framePrincipal.añadirDocumento("ctrlintr");
    }
    public void getDocument(){

        DocumentHeader[] documentHeaders = ctrl_domini.getDocumentHeaders();
        for (DocumentHeader documentHeader : documentHeaders) {
            this.framePrincipal.añadirDocumento(documentHeader.getTitulo().getName());
        }


    }
}
