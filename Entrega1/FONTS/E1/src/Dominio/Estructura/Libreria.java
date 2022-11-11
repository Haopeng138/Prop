package Dominio.Estructura;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

import Dominio.Utils.DocumentHeader;

public class Libreria {

    Autores autores;
    Documentos documentos;

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
            return documentos.getDocumentos().get(idx);
        } catch (Exception e) {
            System.out.println("No existe el documento");
            return null;
        }
    }

    public Documento getDocumento(DocumentHeader header) {
        try {
            int idx = autores.getDocumentIdx(header);
            return documentos.getDocumentos().get(idx);
        } catch (Exception e) {
            System.out.println("No existe el documento");
            return null;
        }
    }

    // TODO:
    public void removeDocumento(String a, String t) {
        DocumentHeader header = new DocumentHeader(a, t);
        try {
            int idx = autores.getDocumentIdx(header);
            autores.removeTitle(a, t);
            // documentos.remove(idx); Documentos needs to remove from idx!
        } catch (Exception e) {
            System.out.println("No existe el documento");
        }
    }

    // TODO:
    public void modifyDocumento(String a, String t, String contenido) {
        DocumentHeader header = new DocumentHeader(a, t);
        try {
            int idx = autores.getDocumentIdx(header);
            // documentos.modifyContent(idx, contenido);
            // Documentos needs to modify from idx!
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

    // Maybe this method shouldn't exist
    public ArrayList<Documento> getDocumentos() {
        return this.documentos.getDocumentos(); // This can't work!
        // We need to at least check if it's been removed...
        // best way to return "documentos" might be to return autores...
    }

    public TreeMap<Autor, HashSet<Titulo>> getIdx() {
        return autores.getIdx();
    }

    // TODO:
    public Boolean tienePalabra(DocumentHeader documentHeader, String word) {
        try {
            int idx = autores.getDocumentIdx(documentHeader);
            // return documentos.tienePalabra(idx, word);
            return true;
        } catch (Exception e) {
            System.out.format("No existe el autor: %s, con el titulo: %s", documentHeader.getAutor(),
                    documentHeader.getTitulo());
            e.printStackTrace();
            return false;
        }
    }

    // TODO:
    public Boolean tieneString(DocumentHeader documentHeader, String toMatch) {
        try {
            int idx = autores.getDocumentIdx(documentHeader);
            // return documentos.tieneContenido(idx, toMatch);
            return true;
        } catch (Exception e) {
            System.out.format("No existe el autor: %s, con el titulo: %s", documentHeader.getAutor(),
                    documentHeader.getTitulo());
            e.printStackTrace();
            return false;
        }
    }

    public float computeSimilarity(DocumentHeader header, DocumentHeader toCompare) {
        try {
            int idx1 = autores.getDocumentIdx(header);
            int idx2 = autores.getDocumentIdx(toCompare);
            // we should get a method that checks if it has been computed, or it computes it
            // by indexs
            // return documentos.intersect(idx1, idx2);
            return 1;
        } catch (Exception e) {
            System.out.println("No existen los documentos que se quieren comparar!");
            return -1;
        }
    }
}
