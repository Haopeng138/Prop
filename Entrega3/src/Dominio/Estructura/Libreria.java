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
     * Constructora por defecto de la clase
     */
    public Libreria() {
        autores = new Autores();
        documentos = new Documentos();
    }

    /**
     * Método constructor de la clase dado un array de documentos
     *
     * @param documentos Los documentos que añade a la librería
     */
    public Libreria(Documento[] documentos) {
        autores = new Autores();
        this.documentos = new Documentos();
        for (Documento documento : documentos) {
            String autor = documento.getAutor();
            if (!autores.has(autor)) {
                autores.add(autor);
            }
            this.autores.addTitleToAutor(new DocumentHeader(autor, documento.getTitulo()));
            this.documentos.add(documento);
        }
    }

    /**
     * Método que devuelve todos los documentos de la librería
     *
     * @return Los documentos que estan en la librería
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
     * Método que devuelve la pareja de autor y título de los documentos de la librería
     *
     * @return Los documentHeaders de los documentos que estan en la librería
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
     * Método que devuelve el número de documentos de un autor
     *
     * @param aut El autor al que consultar su numero de documentos
     * @return El número de documentos del autor
     */
    public int getNumDocumentos(Autor aut) {
        return autores.getNumDocumentos(aut);
    }

    /**
     * Método que crea un documento dado un nombre de autor, un título y un contenido
     *
     * @param aut El nombre del autor del que crear el documento
     * @param tit El título del documento a crear
     * @param contenido El contenido del documento a crear
     * @return True si ha creado correctamente el documento, false en el caso contrario
     */
    public boolean createDocumento(String aut, String tit, String contenido) {
        if (aut == "") {
            System.out.println("El autor no puede ser vacio");
        }
        if (tit == "") {
            System.out.println("El titulo no puede ser vacio");
        }

        Autor autor = new Autor(aut);
        Titulo titulo = new Titulo(tit);
        if (!autores.has(autor)) {
            autores.add(autor);
        }
        if (autores.addTitleToAutor(new DocumentHeader(autor, titulo))) {
            Documento documento = new Documento(aut, tit, contenido);
            documentos.add(documento);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método que devuelve el documento dado un nombre de autor y un título
     *
     * @param aut El nombre del autor del documento que recuperar
     * @param tit El título del documento que recuperar
     * @return El documento
     */
    public Documento getDocumento(String aut, String tit) {
        DocumentHeader header = new DocumentHeader(aut, tit);
        try {
            int idx = autores.getDocumentIdx(header);
            return documentos.getDocumento(idx);
        } catch (Exception e) {
            System.out.println("No existe el documento");
            return null;
        }
    }

    /**
     * Método que devuele el documento dado el header del dicho documento
     *
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
     * Método que borra un documento dado un nombre de autor y un título
     *
     * @param aut El autor del documento a borrar
     * @param tit El título del documento a borrar
     */
    public void removeDocumento(String aut, String tit) {
        DocumentHeader header = new DocumentHeader(aut, tit);
        try {
            int idx = autores.getDocumentIdx(header);
            autores.removeTitle(aut, tit);
            documentos.remove(idx);
        } catch (Exception e) {
            System.out.println("No existe el documento");
        }
    }

    /**
     * Método que modifica el contenido de un documento
     *
     * @param aut El autor del documento a modificar
     * @param tit El título del documento a modificar
     * @param contenido El nuevo contenido
     */
    public void modifyDocumento(String aut, String tit, String contenido) {
        DocumentHeader header = new DocumentHeader(aut, tit);
        try {
            int idx = autores.getDocumentIdx(header);
            documentos.modifyContent(idx, contenido);
        } catch (Exception e) {
            System.out.println("No existe el documento");
        }
    }

    /**
     * Método que devuelve el contenido de un documento dado un nombre de autor y un título
     *
     * @param aut El nombre del autor del documento
     * @param tit El titulo del documento
     * @return El contenido del documento
     */
    public String getContent(String aut, String tit) {
        try {
            DocumentHeader header = new DocumentHeader(aut, tit);
            int idx = autores.getDocumentIdx(header);
            return documentos.getContent(idx);
        } catch (Exception e) {
            System.out.println("No existe el documento");
            return null;
        }
    }

    /**
     * Método que devuelve todos los autores que hay en la librería
     *
     * @return El conjunto de autores que hay en la librería
     */
    public ArrayList<Autor> getAutores() {
        return autores.getAutores();
    }

    /**
     * Método que devuelve todos los autores que hay en la librería ordenados alfabéticamente
     *
     * @return Un set ordenado de los autores que hay en la libreria
     */
    public TreeSet<Autor> getOrderedAutores() {
        return autores.getOrderedAutores();
    }

    /**
     * Método que devuelve los títulos de los documento de un autor
     *
     * @param aut El autor a consultar sus títulos
     * @return Los titulos del autor
     */
    public ArrayList<Titulo> getTitles(String aut) {
        return autores.getTitles(aut);
    }

    /**
     * Método que devuelve para cada autor los índices de los títulos de sus documentos
     *
     * @return Un indice de autor, [titulos]
     */
    public TreeMap<Autor, HashSet<Titulo>> getIdx() {
        return autores.getIdx();
    }

    /**
     * Método que verifica la existencia de una palabra en un documento dado su header
     *
     * @param documentHeader El header de un documento
     * @param word Una palabra
     * @return True si el documento contiene la palabra, false en el caso contrario
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
     * Método que verifica la existencia de una String en un documento dado su header
     *
     * @param documentHeader El header del documento
     * @param toMatch Una String
     * @return True si el documento contiene la String, false en el caso contrario
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
     * Método que devuelve la similitud de dos documetos
     *
     * @param header El header del documento
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
