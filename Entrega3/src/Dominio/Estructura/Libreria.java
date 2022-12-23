package Dominio.Estructura;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

import Dominio.Utils.DocumentHeader;

public class Libreria {

    Autores autores;
    Documentos documentos;

    /**
     * Constructora
     */
    public Libreria() {
        autores = new Autores();
        documentos = new Documentos();
    }

    /**
     * @param documentos Los documentos que añadir a la libreria
     */
    public Libreria(Documento[] documentos) {
        autores = new Autores();
        this.documentos = new Documentos();
        for (Documento documento : documentos) {

            String autor = documento.getAutor();
            System.out.println(autor);
            if (!autores.has(autor)) {
                autores.add(autor);
            }
            System.out.println(documento.getTitulo());
            this.autores.addTitleToAutor(new DocumentHeader(autor, documento.getTitulo()));
            this.documentos.add(documento);

        }
    }

    /**
     * @return Los documentos que estan en la libreria
     */
    public Documento[] getDocumentos() {
        ArrayList<Documento> documentos = new ArrayList<>();
        autores.getIdx().forEach((autor, setTitulos) -> {
            setTitulos.forEach(titulo -> {
                DocumentHeader header = new DocumentHeader(autor, titulo);
                try {
                    int docIdx = autores.getDocumentIdx(header);
                    documentos.add(this.documentos.getDocumento(docIdx));
                } catch (Exception e) {
                    // This can never happen, as indices are directly from the index.
                }
            });
        });
        Documento[] docs = new Documento[documentos.size()];
        docs = documentos.toArray(docs);
        return docs;
    }

    /**
     * @return Los documentHeaders de los documentos que estan en la libreria
     */
    public DocumentHeader[] getDocumentHeaders() {
        ArrayList<DocumentHeader> documentHeaders = new ArrayList<>();
        autores.getIdx().forEach((autor, setTitulos) -> {
            setTitulos.forEach(titulo -> {
                documentHeaders.add(new DocumentHeader(autor, titulo));
            });
        });
        DocumentHeader[] headers = new DocumentHeader[documentHeaders.size()];
        headers = documentHeaders.toArray(headers);
        return headers;
    }

    /**
     * @param autor El autor al que consultar su numero de documentos
     * @return El numero de documentos del autor
     */
    public int getNumDocumentos(Autor autor) {
        return autores.getNumDocumentos(autor);
    }

    /**
     * @param a         El nombre del autor del que crear el documento
     * @param t         El titulo del documento a crear
     * @param contenido El contenido del documento a crear
     */
    public boolean createDocumento(String a, String t, String contenido) {
        if (a == "") {
            System.out.println("El autor no puede ser vacio");
        }
        if (t == "") {
            System.out.println("El titulo no puede ser vacio");
        }

        Autor autor = new Autor(a);
        Titulo titulo = new Titulo(t);
        if (!autores.has(autor)) {
            autores.add(autor);
        }
        if (autores.addTitleToAutor(new DocumentHeader(autor, titulo))) {
            Documento documento = new Documento(a, t, contenido);
            documentos.add(documento);
            return true;
        } else {
            return false;
        }

    }

    /**
     * @param a El nombre del autor del documento que recuperar
     * @param t El titulo del documento que recuperar
     * @return El documento
     */
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

    /**
     * @param header El header del documento a recupear
     * @return El documento
     */
    public Documento getDocumento(DocumentHeader header) {
        try {
            int idx = autores.getDocumentIdx(header);
            return documentos.getDocumento(idx);
        } catch (Exception e) {
            System.out.println("No existe el documento");
            return null;
        }
    }

    /**
     * @param a El autor del documento a borrar
     * @param t El titulo del documento a borrar
     */
    public void removeDocumento(String a, String t) {
        try {
            autores.removeTitle(a, t);
            // documentos.remove(idx); NO!!! esto descuadraria los indices.
            // Se elimina porque no hay modo de encontrarlo, y cuando se cierra
            // la aplicacion, no será persistido
        } catch (Exception e) {
            System.out.println("No existe el documento");
        }
    }

    /**
     * @param a         El autor del documento a modificar
     * @param t         El titulo del documento a modificar
     * @param contenido El nuevo contenido
     */
    public void modifyDocumento(String a, String t, String contenido) {
        DocumentHeader header = new DocumentHeader(a, t);
        try {
            int idx = autores.getDocumentIdx(header);
            documentos.modifyContent(idx, contenido);
        } catch (Exception e) {
            System.out.println("No existe el documento");
        }
    }

    /**
     * @param a El nombre del autor del documento que recuperar el contenido
     * @param t El titulo del documento que recuperar el contenido
     * @return El contenido del documento
     */
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

    /**
     * @return Los autores que hay en la libreria
     */
    public ArrayList<Autor> getAutores() {
        return autores.getAutores();
    }

    /**
     * @return Un set ordenado de los autores que hay en la libreria
     */
    public TreeSet<Autor> getOrderedAutores() {
        return autores.getOrderedAutores();
    }

    /**
     * @param a El autor a consultar sus titulo
     * @return Los titulos del autor
     */
    public ArrayList<Titulo> getTitles(String a) {
        return autores.getTitles(a);
    }

    /**
     * @return Un indice de autor, [titulos]
     */
    public TreeMap<Autor, HashSet<Titulo>> getIdx() {
        return autores.getIdx();
    }

    /**
     * @param documentHeader El header de un documento
     * @param word           Una palabra
     * @return Si el documento tiene la palabra
     */
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

    /**
     * @param documentHeader El header del documento
     * @param toMatch        Una String
     * @return Si el documento contiene esta string
     */
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

    /**
     * @param header    El header del documento
     * @param toCompare El header de otro documento
     * @return La similitud entre ambos documentos
     */
    public double computeSimilarity(DocumentHeader header, DocumentHeader toCompare) {
        try {
            int idx1 = autores.getDocumentIdx(header);
            int idx2 = autores.getDocumentIdx(toCompare);
            if (idx1 == idx2) {
                return 1;
            }
            return documentos.generarSimilitudEntreDocs(idx1, idx2);
        } catch (Exception e) {
            System.out.println("No existen los documentos que se quieren comparar!");
            return -1;
        }
    }

}
