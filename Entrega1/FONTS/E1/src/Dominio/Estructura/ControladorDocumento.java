package Dominio.Estructura;

import java.util.ArrayList;
import java.util.TreeSet;

public class ControladorDocumento {

    Autores autores;
    Documentos documentos;

    public void createDocumento(String a, String t, String contenido) throws Exception {
        if (a == "") {
            throw new Exception("El autor no puede ser vacio");
        }
        if (t == "") {
            throw new Exception("El titulo no puede ser vacio");
        }

        Autor autor = new Autor(a);
        Titulo titulo = new Titulo(t);
        if (autores.has(autor)) {
            autores.addTitleToAutor(titulo, autor);
        } else {
            autores.add(autor);
            autores.addTitleToAutor(titulo, autor);
        }

        Documento documento = new Documento(a, t, contenido);
        documentos.add(documento);
    }

    public Documento getDocumento(String a, String t) {
        Autor autor = new Autor(a);
        Titulo titulo = new Titulo(t);
        try {
            int idx = autores.getDocumentIdx(autor, titulo);
            return documentos.getDocumentos().get(idx);
        } catch (Exception e) {
            System.out.println("No existe el documento");
            return null;
        }
    }

    public void removeDocumento(String a, String t) {
        Autor autor = new Autor(a);
        Titulo titulo = new Titulo(t);
        try {
            int idx = autores.getDocumentIdx(autor, titulo);
            autores.remove(autor);
            // documentos.remove(idx); Documentos needs to remove from idx!
        } catch (Exception e) {
            System.out.println("No existe el documento");
        }
    }

    public void modifyDocumento(String a, String t, String contenido) {
        Autor autor = new Autor(a);
        Titulo titulo = new Titulo(t);
        try {
            int idx = autores.getDocumentIdx(autor, titulo);
            // documentos.modifyContent(idx, contenido); Documentos needs to modify from
            // idx!
        } catch (Exception e) {
            System.out.println("No existe el documento");
        }
    }

    public ArrayList<Autor> getAutores() {
        return autores.getAutores();
    }

    public TreeSet<Autor> getOrderedAutores() {
        return autores.getOrderedAutores();
    }

    public ArrayList<Titulo> getTitles(Autor a) {
        return autores.getTitles(a);
    }

    public ArrayList<Documento> getDocumentos() {
        return this.documentos.getDocumentos(); // This can't work!
        // We need to at least check if it's been removed...
        // best way to return "documentos" might be to return autores...
    }
}
