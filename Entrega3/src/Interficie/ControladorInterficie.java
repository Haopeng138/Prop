package Interficie;

import Dominio.ControladorDominio;
import Interficie.vistas.FramePrincipal;
import java.io.File;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ControladorInterficie {
    private ControladorDominio ctrl_dominio;
    private FramePrincipal framePrincipal;

    public ControladorInterficie() {
        this.ctrl_dominio = new ControladorDominio();
    };

    public void inicial() {
        this.framePrincipal = new FramePrincipal(this);
        ArrayList<String[]> documents = ctrl_dominio.getAllDocuments();
        for (String[] doc : documents) {
            if (this.framePrincipal.cargarDocument(doc[0], doc[1])) {
                System.out.println(doc[0]);
            }

        }
        ArrayList<String[]> aliasexpresions = ctrl_dominio.getAllExpresions();
        for (String[] alia : aliasexpresions) {
            if (this.framePrincipal.añadirAlia(alia[0], alia[1])) {
                System.out.println(alia[0]);
            }
        }
        this.framePrincipal.setVisible(true);
    }

    public void getDocument() {

    }

    private String getExtension(String fileName) {
        String extension = "";
        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i + 1);
        }
        return extension;
    }

    public void createDocumento(String autor, String titulo, String contenido) {
        ctrl_dominio.createDocumento(autor, titulo, contenido);

    }

    public void createDocumento(File documento) throws Exception {
        System.out.println(getExtension(documento.toString()));
        String[] tmp = ctrl_dominio.createDocumento(documento);
        if (tmp != null) {
            this.framePrincipal.cargarDocument(tmp[0], tmp[1]);
        } else {
            JOptionPane.showMessageDialog(null, "Formato incorrecto, deberia ser \n Titulo \n Autor \n Contenido");
        }
    }

    public ArrayList<String[]> getAllDocs() {
        return ctrl_dominio.getAllDocuments();

    }

    public ArrayList<String> getTitles(String autor) {
        return ctrl_dominio.getTitles(autor);
    }

    public ArrayList<String[]> busquedaPorExpresion(String alia) {
        return ctrl_dominio.busquedaPorExpresion(alia);
    }

    public ArrayList<String[]> busquedaPorSimilitud(String autor, String titulo, int k) {
        return ctrl_dominio.busquedaPorSimilitud(autor, titulo, k);
    }

    public String busquedaPorAutorTitulo(String autor, String titulo) {
        return ctrl_dominio.getContent(autor, titulo);
    }

    public void removeDocument(String autor, String titulo) {
        ctrl_dominio.removeDocumento(autor, titulo);
    }

    public void modifyDocument(String autor, String titulo, String contenido) {
        ctrl_dominio.modifyDocumento(autor, titulo, contenido);
    }

    public void addExpresion(String alia, String expresion) throws Exception {
        try {
            ctrl_dominio.addExpresion(alia, expresion);
        } catch (Exception e) {
            throw new Exception("Error añadiendo alia");
        }

    }

    public void persit() {
        ctrl_dominio.persist();
    }

    public void removeExpresion(String alia) {
        ctrl_dominio.removeExpresion(alia);
    }

    public void updateExpresion(String alia, String expresion) {
        ctrl_dominio.updateExpresion(alia, expresion);
    }

    public String getExpresion(String alia) {
        return ctrl_dominio.getExpresion(alia);
    }

    public ArrayList<String> busquedaPorPrefijo(String prefijo) {
        return ctrl_dominio.obtenerAutoresPrefijo(prefijo);
    }

    public void exportTxt(String autor, String titulo, File path) {
        ctrl_dominio.exportTxt(autor, titulo, path);
    }

    public void exportXml(String autor, String titulo, File path) {
        ctrl_dominio.exportXml(autor, titulo, path);
    }
}
