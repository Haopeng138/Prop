package Interficie;

import Dominio.ControladorDominio;
import Interficie.vistas.FramePrincipal;
import java.io.File;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;


public class ControladorInterficie {
    private ControladorDominio ctrl_dominio;
    private FramePrincipal framePrincipal;
    private int doc_size =0;
    public ControladorInterficie() {
        this.ctrl_dominio = new ControladorDominio();
    };


    public void inicial() {
        this.framePrincipal = new FramePrincipal(this);
        ArrayList<String[]> documents = ctrl_dominio.getAllDocuments();
        for(String[] doc:documents){
            if(this.framePrincipal.cargarDocument(doc[0],doc[1])){
                System.out.println(doc[0]);
                doc_size++;
            }
           
        }
        ArrayList<String[]> aliasexpresions = ctrl_dominio.getAllExpresions();
        for(String[] alia:aliasexpresions){
            if (this.framePrincipal.añadirAlia(alia[0], alia[1])){
                System.out.println(alia[0]);
            }
        }
        this.framePrincipal.setVisible(true);
    }
    public void getDocument(){

    }
    
    public int getDocSize(){
        return doc_size;
    }

    private String getExtension(String fileName){
        String extension = "";
        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i+1);
        }
        return extension;
    }

    public void createDocumento(String autor,String titulo,String contenido){
        ctrl_dominio.createDocumento(autor, titulo, contenido);
        doc_size++;

    }
    
    public void createDocumento(File documento) throws Exception {
        System.out.println(getExtension(documento.toString()));
        ctrl_dominio.createDocumento(documento);
        String[] tmp;

        if(getExtension(documento.toString()).equals("txt")){
            tmp = getAutorTituloFromTxt(documento);
        }else {
            tmp = getAutorTituloFromXML(documento);
        }
        this.framePrincipal.cargarDocument(tmp[0],tmp[1]);
        doc_size++;
    }

    public ArrayList<String[]> getAllDocs() {
        return ctrl_dominio.getAllDocuments();

    }

    public ArrayList<String> getTitles(String autor) {
        return ctrl_dominio.getTitles(autor);
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
        }catch (Exception e){
            throw new Exception("Error añadiendo alia");
        }

    }
    public void persit(){
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
    
    private String[] getAutorTituloFromXML(File documento) throws Exception {
        String content = Files.readString(documento.toPath());
        int startAutor = content.indexOf("<Autor>");
        int endAutor = content.indexOf("</Autor>");
        String autor = "";
        if (startAutor != -1 && endAutor != -1) {
            autor = content.substring(startAutor + 8, endAutor).trim();
        }
        int startTitulo = content.indexOf("<Titulo>");
        int endTitulo = content.indexOf("</Titulo>");
        String titulo = "";
        if (startTitulo != -1 && endTitulo != -1) {
            titulo = content.substring(startTitulo + 8, endTitulo).trim();
        }
        if (autor == "" || titulo == "") {
            throw new Exception("There is a missing tag");
        }
       

        return new String[]{autor, titulo};
    }
    
    private String[] getAutorTituloFromTxt(File documento) throws FileNotFoundException {
        try (Scanner file = new Scanner(documento)) {
            String autor = file.nextLine();
            String titulo = file.nextLine();
            return new String[]{autor, titulo};
        }
    }
    
    public void exportTxt(String autor,String titulo,File path){
        ctrl_dominio.exportTxt(autor, titulo, path);
    }
    public void exportXml(String autor,String titulo,File path){
        ctrl_dominio.exportXml(autor, titulo, path);
    }
}
