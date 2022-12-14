package Interficie;
import Dominio.ControladorDominio;
import com.mycompany.prueba1.FramePrincipal;

public class ControladorInterficie {
    ControladorDominio ctrl_domini;
    public ControladorInterficie() {
        ctrl_domini = new ControladorDominio();
    };

    FramePrincipal framePrincipal;
    public void inicial() {
        framePrincipal = new FramePrincipal();
    }
}
