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

    /**
     *  Método constructor de la clase ControladorDominio
     *
     */
    public ControladorDominio() {
        try {
            HashMap<String, String> expresionesAgnostic = Persistencia.recoverExpresiones();
            HashMap<String, Expresion> expresiones = new HashMap<String, Expresion>(
                    expresionesAgnostic.entrySet().stream()
                            .map(t -> {
                                try {
                                    return Map.entry(t.getKey(), new Expresion(t.getValue()));
                                } catch (ExpresionException e) {
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
            cExpresiones = new ControladorExpresiones();
            libreria = new Libreria();
        }
    }

    /**
     * Método que devuelve todos los documentos existentes del sistema
     *
     * @return Los documentos con su autor y título, String[0] es el autor y String[1] es el título
     */
    public ArrayList<String[]> getAllDocuments() {
        DocumentHeader[] documentHeaders = libreria.getDocumentHeaders();
        ArrayList<DocumentHeader> headers = new ArrayList<>(Arrays.asList(documentHeaders));
        return buildAgnosticHeaders(headers);
    }

    /**
     * Método que devuelve todas las expresiones existentes del sistema
     *
     * @return El conjunto de alia y su expresión booleana correspondient, String[0] es la alia y String[1] es la expresión
     */
    public ArrayList<String[]> getAllExpresions() {
        HashMap<String, Expresion> expresiones = cExpresiones.getExpresiones();
        ArrayList<String[]> expresions = new ArrayList<>();
        for (String i : expresiones.keySet()) {
            String alia = i;
            String expresion = expresiones.get(i).getExpresion();
            String[] aliaexp = { alia, expresion };
            expresions.add(aliaexp);
        }
        return expresions;
    }

    /**
     * Método para importar el documento a la base de datos
     *
     * @param documento el documento en formato xml o txt
     * @return El documento que hemos importado, String[0] es el autor y String[1] es el título
     */
    public void createDocumento(File documento) throws Exception {

        Documento doc;

        boolean error = false;

        try {

            doc = IOHelper.create(documento);

            if(!createDocumento(doc.getAutor(), doc.getTitulo(), doc.getContenido())){

                error = true;

            }

            
        } catch (Exception e) {

            System.out.println("Error importing Document");

            e.printStackTrace();

        }
        if(error){
            throw new Exception("Error creating document");
        }
    }


    /**
     * Método para crear un nuevo documennto
     *
     * @param aut         El autor del documento
     * @param tit         El titulo del documento
     * @param contenido   El contenido del documento
     * @return True si se ha creado, False si ya existía un documento con el mismo
     *         autor y titulo
     */
    public boolean createDocumento(String aut, String tit, String contenido) {
        return libreria.createDocumento(aut, tit, contenido);
    }

    /**
     * Método para modificar el contenido de un documento
     *
     * @param aut         El autor del documento
     * @param tit         El titulo del documento
     * @param contenido El contenido del documento
     */
    public void modifyDocumento(String aut, String tit, String contenido) {
        libreria.modifyDocumento(aut, tit, contenido);
    }

    /**
     * Método para elimininar un documento
     *
     * @param aut El autor del documento
     * @param tit El título del documento
     */
    public void removeDocumento(String aut, String tit) {
        libreria.removeDocumento(aut, tit);
    }

    /**
     * Método para exportar el documento en el formato de txt
     *
     * @param autor     El autor del documento
     * @param titulo    El título del documento
     * @param path      El directorio donde tiene que exportar el documento
     */
    public void exportTxt(String autor, String titulo, File path) {
        Documento doc = libreria.getDocumento(autor, titulo);
        exportDocumento(doc, path, titulo + ".txt");
    }

    /**
     * Método para exportar el documento en el formato de xml
     *
     * @param autor     El autor del documento
     * @param titulo    El título del documento
     * @param path      El directorio donde tiene que exportar el documento
     */
    public void exportXml(String autor, String titulo, File path) {
        Documento doc = libreria.getDocumento(autor, titulo);
        exportDocumento(doc, path, titulo + ".xml");
    }

    /**
     * Método de exportar el documento
     *
     * @param doc  El documento a exportar
     * @param path El path donde exportarlo
     * @param name El nombre que dar al documento
     */
    private void exportDocumento(Documento doc, File path, String name) {
        try {
            IOHelper.export(doc, path, name);
        } catch (Exception e) {
            System.out.println("Error exporting document");
            e.printStackTrace();
        }
    }

    /**
     * Método para obtener el conjunto de títulos de un autor
     *
     * @param aut El nombre de un autor
     * @return Listado de titulos del autor aut
     */
    public ArrayList<String> getTitles(String aut) {
        ArrayList<Titulo> titulos = libreria.getTitles(aut);
        return new ArrayList<String>(titulos.stream().map(titulo -> titulo.getName()).collect(Collectors.toList()));
    }

    /**
     * Método de obtener el conjunto de autores con el mismo prefijo
     *
     * @param pre El prefijo de un autor
     * @return Listado de autores que comienza por el mismo prefijo pre
     */
    public ArrayList<String> obtenerAutoresPrefijo(String pre) {
        ArrayList<Autor> autores = ControladorBusqueda.buscarPorPrefijo(libreria.getOrderedAutores(), pre);
        return new ArrayList<String>(autores.stream().map(autor -> autor.getName()).collect(Collectors.toList()));
    }

    /**
     * Método de obtener el contenido de un documento
     *
     * @param autorName  El nombre del autor
     * @param tituloName El nombre del título
     * @return El contenido del documento con el nombre de autor autorName y el título tituloName
     */
    public String getContent(String autorName, String tituloName) {
        return libreria.getContent(autorName, tituloName);
    }

    /**
     * Método para buscar los k documentos más similares a un documento existente
     *
     * @param aut   El autor del documento
     * @param tit   El título del documento
     * @param k     El número de documentos
     * @return un conjunto de documentos con el contenido más similares al documento con el autor aut y título tit
     */
    public ArrayList<String[]> busquedaPorSimilitud(String aut, String tit, int k) {
        if (libreria.getDocumento(aut, tit) == null) {
            return null;
        }
        ArrayList<DocumentHeader> headers = ControladorBusqueda.buscarPorSimilitud(new DocumentHeader(aut, tit), k,
                libreria);
        return buildAgnosticHeaders(headers);
    }

    /**
     * Método de buscar un conjunto de documentos con la misma expresión booleana
     *
     * @param alias Alias de una expresión booleana
     * @return un conjunto de documentos con la misma expresión booleana, String[0] es el autor y String[1] es el título
     */
    public ArrayList<String[]> busquedaPorExpresion(String alias) {
        try {
            ArrayList<DocumentHeader> headers = ControladorBusqueda.buscarPorExpresion(cExpresiones.getAsString(alias),
                    libreria);
            return buildAgnosticHeaders(headers);

        } catch (Exception e) {
            System.out.println("No se ha podido construir el arbol de busqueda de la expresion");
            return null;
        }
    }

    /**
     * Método de parser el DocumentHeader a un String[] para la comunicación entre capas
     *
     * @param headers   El conjunto de documentos que tienen que parsear
     * @return un conjunto de documentos
     */
    private ArrayList<String[]> buildAgnosticHeaders(ArrayList<DocumentHeader> headers) {
        return new ArrayList<String[]>(headers.stream()
                .map(header -> new String[] { header.getAutor().getName(), header.getTitulo().getName() })
                .collect(Collectors.toList()));
    }

    /**
     * Método para añadir una expresión booleana con su alia
     *
     * @param alias     La nueva alia
     * @param expresion La nueva expresión booleana
     * @throws ExpresionException falla si ya existe la alia
     */
    public void addExpresion(String alias, String expresion) throws ExpresionException {
        cExpresiones.add(alias, expresion);
    }

    /**
     * Método para modificar una expresión booleana
     *
     * @param alias     La alia que contiene la expresión que queremos modificar
     * @param expresion La nueva expresión a modificar
     * @return true si se puede modificar, y false en otros casos
     */
    public Boolean updateExpresion(String alias, String expresion) {
        return cExpresiones.updateExpresion(alias, expresion);
    }

    /**
     * Método para eliminar una expresión booleana
     *
     * @param alias La alia de la expresión booleana
     * @return true si se puede eliminar, false en otros casos
     */
    public Boolean removeExpresion(String alias) {
        return cExpresiones.remove(alias);
    }

    /**
     * Método para obtener la expresión booleana con su alia
     *
     * @param alias La alia de la expresión booleana
     * @return la expresión booleana con alia alias
     */
    public String getExpresion(String alias) {
        return cExpresiones.getAsString(alias);
    }

    /**
     * Método de hacer la persistencia
     *
     */
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
