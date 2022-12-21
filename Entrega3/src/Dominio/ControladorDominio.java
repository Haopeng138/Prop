package Dominio;

import Dominio.Expresion.ControladorExpresiones;
import Dominio.Expresion.Expresion;
import Dominio.Expresion.ExpresionException;
import Dominio.Logica.ControladorBusqueda;
import Dominio.Utils.DocumentHeader;
import Dominio.Utils.IOHelper;
import Dominio.Estructura.Autor;
import Dominio.Estructura.Documento;
import Dominio.Estructura.Libreria;
import Dominio.Estructura.Titulo;

import Persistencia.Persistencia;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ControladorDominio {

    Libreria libreria;
    ControladorExpresiones cExpresiones;

    public ControladorDominio() {
        try {
            HashMap<String, String> expresionesAgnostic = Persistencia.recoverExpresiones();
            HashMap<String, Expresion> expresiones = new HashMap<String, Expresion>(
                    expresionesAgnostic.entrySet().stream()
                            .map(t -> {
                                try {
                                    return Map.entry(t.getKey(), new Expresion(t.getValue()));
                                } catch (ExpresionException e) {
                                    // This will never happen, as if an expression is saved it means it was accepted
                                    // before.
                                    throw new RuntimeException();
                                }
                            })
                            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
            if (expresiones.size() > 0) {
                cExpresiones = new ControladorExpresiones(expresiones);
            } else {
                cExpresiones = new ControladorExpresiones();
            }

            String[][] documentosAgnostic = Persistencia.recoverDocumentos();
            Documento[] documentos = Stream.of(documentosAgnostic).map(
                            documento -> new Documento(documento[0], documento[1], documento[2]))
                    .toArray(Documento[]::new);

            if (documentos.length > 0) {
                libreria = new Libreria(documentos);
            } else {
                libreria = new Libreria();
            }

        } catch (Exception e) {
            System.out.println("unable to recover previous state");
            cExpresiones = new ControladorExpresiones();
            libreria = new Libreria();
        }
    }

    public ArrayList<String[]> getAllDocuments(){
        DocumentHeader[] documentHeaders = libreria.getDocumentHeaders();
        ArrayList<DocumentHeader> headers = new ArrayList<> (Arrays.asList(documentHeaders));
        return buildAgnosticHeaders(headers);
    }

    //// PUNTO 1

    /**
     * @param documento El documento a importar
     */
    public void createDocumento(File documento) {
        Documento doc;
        try {
            doc = IOHelper.create(documento);
            createDocumento(doc.getAutor(), doc.getTitulo(), doc.getContenido());
        } catch (Exception e) {
            System.out.println("Error importing Document");
            e.printStackTrace();
        }
    }

    public void createDocumento(String a, String t, String contenido) {
        libreria.createDocumento(a, t, contenido);
    }

    public void modifyDocumento(String a, String t, String contenido) {
        libreria.modifyDocumento(a, t, contenido);
    }

    public void removeDocumento(String a, String t) {
        libreria.removeDocumento(a, t);
    }

    /**
     * @param doc  El documento a exportar
     * @param path El path al que exportarlo
     * @param name El nombre que dar al documento
     */
    public void exportDocumento(Documento doc, File path, String name) {
        try {
            IOHelper.export(doc, path, name);
        } catch (Exception e) {
            System.out.println("Error exporting document");
            e.printStackTrace();
        }
    }
    ////

    //// PUNTO 2
    /**
     * @param a El nombre de un autor
     * @return Listado de titulos del autor
     */
    public ArrayList<String> getTitles(String a) {
        ArrayList<Titulo> titulos = libreria.getTitles(a);
        return new ArrayList<String>(titulos.stream().map(titulo -> titulo.getName()).collect(Collectors.toList()));
    }

    /**
     * @param pre El prefijo de un autor
     * @return Listado de autores que comienza por el pre
     */
    public ArrayList<String> obtenerAutoresPrefijo(String pre) {
        ArrayList<Autor> autores = ControladorBusqueda.buscarPorPrefijo(libreria.getOrderedAutores(), pre);
        return new ArrayList<String>(autores.stream().map(autor -> autor.getName()).collect(Collectors.toList()));
    }

    /**
     * @param autorName  nombre del autor
     * @param tituloName nombre del t
     * @return
     */
    public String getContent(String autorName, String tituloName) {
        return libreria.getContent(autorName, tituloName);
    }

    //// PUNTO 3

    /**
     * @param  a Nombre autor
     * @param t Titulo
     * @param k numero de documentos que quiere
     * @return un conjunto de documentos
     */
    public ArrayList<String[]> busquedaPorSimilitud(String a, String t, int k) {
        ArrayList<DocumentHeader> headers = ControladorBusqueda.buscarPorSimilitud(new DocumentHeader(a, t), k,
                libreria);
        return buildAgnosticHeaders(headers);
    }

    /**
     * @param alias Alias de una expresión
     * @return un conjunto de documentos
     */
    public ArrayList<String[]> busquedaPorExpresion(String alias){
        try {
            ArrayList<DocumentHeader> headers = ControladorBusqueda.buscarPorExpresion(cExpresiones.getAsString(alias),
                    libreria);
            return buildAgnosticHeaders(headers);

        } catch (Exception e) {
            System.out.println("No se ha podido construir el arbol de busqueda de la expresion");
            return null;
        }
    }

    private ArrayList<String[]> buildAgnosticHeaders(ArrayList<DocumentHeader> headers) {
        return new ArrayList<String[]>(headers.stream()
                .map(header -> new String[] { header.getAutor().getName(), header.getTitulo().getName() })
                .collect(Collectors.toList()));
    }

    //// PUNTO 4

    public void addExpresion(String alias, String expresion) throws ExpresionException {
        cExpresiones.add(alias, expresion);
    }

    public Boolean updateExpresion(String alias, String expresion) {
        return cExpresiones.updateExpresion(alias, expresion);
    }

    public Boolean removeExpresion(String alias) {
        return cExpresiones.remove(alias);
    }

    public String getExpresion(String alias) {
        return cExpresiones.getAsString(alias);
    }

    // Persistencia

    public void persist() {
        Documento[] documentos = libreria.getDocumentos();

        String[][] documentosAgnostic = Stream.of(documentos).map(
                        documento -> new String[] { documento.getAutor(), documento.getTitulo(), documento.getContenido() })
                .toArray(String[][]::new);

        HashMap<String, Expresion> expresiones = cExpresiones.getExpresiones();

        HashMap<String, String> expresionesAgnostic = new HashMap<String, String>(expresiones.entrySet().stream()
                .map(t -> Map.entry(t.getKey(), t.getValue().getExpresion()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));

        try {
            Persistencia.persist(documentosAgnostic, expresionesAgnostic);
        } catch (IOException e) {
            System.out.println("Persistence failed!!!");
            throw new RuntimeException();
        }
    }

}