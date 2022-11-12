package Dominio.Estructura;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

import Dominio.Utils.DocumentHeader;

public class Libreria {

    Autores autores;
    Documentos documentos;

    public Libreria() {
        autores = new Autores();
        documentos = new Documentos();
    }

    public void createDocumento(String a, String t, String contenido) {
        if (a == "") {
            System.out.println("El autor no puede ser vacio");
        }
        if (t == "") {
            System.out.println("El titulo no puede ser vacio");
        }

        Autor autor = new Autor(a);
        Titulo titulo = new Titulo(t);
        if (autores.has(autor)) {
            autores.addTitleToAutor(new DocumentHeader(autor, titulo));
        } else {
            autores.add(autor);
            autores.addTitleToAutor(new DocumentHeader(autor, titulo));
        }

        Documento documento = new Documento(a, t, contenido);
        documentos.add(documento);
    }

    public Documento getDocumento(String a, String t) {
        DocumentHeader header = new DocumentHeader(a, t);
        try {
            int idx = autores.getDocumentIdx(header);
            return documentos.getDocumento(idx);
        } catch (Exception e) {
            System.out.println("No existe el documento");
            return null;
        }
    }

    public Documento getDocumento(DocumentHeader header) {
        try {
            int idx = autores.getDocumentIdx(header);
            return documentos.getDocumento(idx);
        } catch (Exception e) {
            System.out.println("No existe el documento");
            return null;
        }
    }

    public void removeDocumento(String a, String t) {
        DocumentHeader header = new DocumentHeader(a, t);
        try {
            int idx = autores.getDocumentIdx(header);
            autores.removeTitle(a, t);
            documentos.remove(idx);
        } catch (Exception e) {
            System.out.println("No existe el documento");
        }
    }

    public void modifyDocumento(String a, String t, String contenido) {
        DocumentHeader header = new DocumentHeader(a, t);
        try {
            int idx = autores.getDocumentIdx(header);
            documentos.modifyContent(idx, contenido);
            // Documentos needs to modify from idx!
        } catch (Exception e) {
            System.out.println("No existe el documento");
        }
    }

    public String getContent(String a, String t) {
        try {
            DocumentHeader header = new DocumentHeader(a, t);
            int idx = autores.getDocumentIdx(header);
            return documentos.getContent(idx);
        } catch (Exception e) {
            System.out.println("No existe el documento");
            return null;
        }
    }

    public ArrayList<Autor> getAutores() {
        return autores.getAutores();
    }

    public TreeSet<Autor> getOrderedAutores() {
        return autores.getOrderedAutores();
    }

    public ArrayList<Titulo> getTitles(String a) {
        return autores.getTitles(a);
    }

    public TreeMap<Autor, HashSet<Titulo>> getIdx() {
        return autores.getIdx();
    }

    public Boolean tienePalabra(DocumentHeader documentHeader, String word) {
        try {
            int idx = autores.getDocumentIdx(documentHeader);
            return documentos.tienePalabra(idx, word);
        } catch (Exception e) {
            System.out.format("No existe el autor: %s, con el titulo: %s", documentHeader.getAutor(),
                    documentHeader.getTitulo());
            return false;
        }
    }

    public Boolean tieneString(DocumentHeader documentHeader, String toMatch) {
        try {
            int idx = autores.getDocumentIdx(documentHeader);
            return documentos.tieneString(idx, toMatch);
        } catch (Exception e) {
            System.out.format("No existe el autor: %s, con el titulo: %s", documentHeader.getAutor(),
                    documentHeader.getTitulo());
            return false;
        }
    }

    public double computeSimilarity(DocumentHeader header, DocumentHeader toCompare) {
        try {
            int idx1 = autores.getDocumentIdx(header);
            int idx2 = autores.getDocumentIdx(toCompare);
            // we should get a method that checks if it has been computed, or it computes it
            // by indexs
            return documentos.generarSimilitudEntreDocs(idx1, idx2);
        } catch (Exception e) {
            System.out.println("No existen los documentos que se quieren comparar!");
            return -1;
        }
    }
}
