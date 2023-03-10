package Interficie;

import Dominio.ControladorDominio;
import Utils.DocumentHeader;
import com.mycompany.prueba1.FramePrincipal;


public class ControladorInterficie {
    private ControladorDominio ctrl_domini;
    private FramePrincipal framePrincipal;
    public ControladorInterficie() {
        this.ctrl_domini = new ControladorDominio();
    };


    public void inicial() {
         this.framePrincipal = new FramePrincipal();
         this.framePrincipal.setVisible(true);
         this.framePrincipal.añadirDocumento("ctrlintr");
    }
    public void getDocument(){

        DocumentHeader[] documentHeaders = ctrl_domini.getDocumentHeaders();
        for( int i = 0; i < documentHeaders.length; i++){
            this.framePrincipal.añadirDocumento(documentHeaders[i].getTitulo().getName());
        }


    }
}
