package Interficie;
import Dominio.ControladorDominio;
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
    }
}
