package Dominio.Estructura;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

import Dominio.Utils.DocumentHeader;

public class Autores {
    /**
     * Atributos de clase Autores
     */
    private TreeMap<Autor, HashMap<Titulo, Integer>> autores;
    private Integer currentIdx;

    /**
     * Constructor por defecto
     */
    public Autores() {
        autores = new TreeMap<>();
        currentIdx = 0;
    }

    /**
     * Método que nos indica si el autor existe en nuestro conjunto de autores
     *
     * @param aut Un Autor
     * @return True si existe, False en caso contrario
     */
    public Boolean has(Autor aut) {
        return autores.get(aut) != null;
    }

    /**
     * Método que nos indica si el autor existe en nuestro conjunto de autores dado su nombre
     *
     * @param aut Un nombre de autor
     * @return True si existe, False en caso contrario
     */
    public Boolean has(String aut) {
        return autores.get(new Autor(aut)) != null;
    }

    /**
     * Método que añade un autor al conjunto de autores
     *
     * @param aut Un Autor
     */
    public void add(Autor aut) {
        if (!this.has(aut)) {
            autores.put(aut, new HashMap<Titulo, Integer>());
        } else
            System.out.format("El autor: %s, ya existe!\n", aut);
    }

    /**
     * Método que añade un autor al conjunto de autores
     *
     * @param aut Un nombre del autor
     */
    public void add(String aut) {
        if (!this.has(aut)) {
            autores.put(new Autor(aut), new HashMap<Titulo, Integer>());
        } else
            System.out.format("El autor: %s, ya existe!\n", aut);
    }

    /**
     * Método que añade un título al conjunto de títulos de un autor
     *
     * @param header El header de un documento, autor y título
     * @return True si se ha añadido correctamente el título, false en el caso contrario
     */
    public boolean addTitleToAutor(DocumentHeader header) {
        HashMap<Titulo, Integer> titulos = autores.get(header.getAutor());
        if (titulos.get(header.getTitulo()) != null) {
            System.out.format("Ya existe el documento con titulo: %s para el autor %s", header.getTitulo().getName(),
                    header.getAutor().getName());
            return false;
        }
        titulos.put(header.getTitulo(), currentIdx);
        autores.replace(header.getAutor(), titulos);
        currentIdx++;
        return true;
    }

    /**
     * Método que devuelve todos los títulos que tiene un autor
     *
     * @param aut Un nombre de autor
     * @return Un conjunto de autor
     */
    public ArrayList<Titulo> getTitles(String aut) {
        return new ArrayList<Titulo>(autores.get(new Autor(aut)).keySet());
    }

    /**
     * Método que elimina un autor de nuestro conjunto de autores
     *
     * @param aut Autor
     */
    public void remove(Autor aut) {
        autores.remove(aut);
    }

    /**
     * Método que elimina un autor de nuestro conjunto de autores dado su nombre
     *
     * @param aut Un nombre de autor
     */
    public void remove(String aut) {
        autores.remove(new Autor(aut));
    }

    /**
     * Método que devuelve el conjunto de autores
     *
     * @return Un conjunto de autores
     */
    public ArrayList<Autor> getAutores() {
        return new ArrayList<Autor>(autores.keySet());
    }

    /**
     * Método que devuelve el conjunto de autores ordenados alfabéticamente
     *
     * @return Un conjunto de autores ordenados
     */
    public TreeSet<Autor> getOrderedAutores() {
        return new TreeSet<Autor>(autores.keySet());
    }

    /**
     * Método que devuelve el número de autores en el sistema
     *
     * @return El número de autores en el sistema
     */
    public int getNumAutor() {
        return autores.size();
    }

    /**
     * Método que devuelve el número de documentos de un autor
     *
     * @param aut El autor al que consultar
     * @return El número de documentos que tiene el autor
     */
    public int getNumDocumentos(Autor aut) {
        return autores.get(aut).size();
    }

    /**
     * Método que devuelve el índice del documento
     *
     * @param header El header del documento
     * @return Posición en la que se indexa el documento
     * @throws Exception Si no se encuentra el documento
     */
    public Integer getDocumentIdx(DocumentHeader header) throws Exception {
        if (!this.has(header.getAutor())) {
            throw new Exception("Autor no encontrado");
        }
        HashMap<Titulo, Integer> titulos = autores.get(header.getAutor());
        Integer idx = titulos.get(header.getTitulo());
        if (idx == null) {
            throw new Exception("Titulo no encontrado");
        }
        return idx;
    }

    /**
     * Método que devuelve el índice del documento
     *
     * @return La lista de autores y títulos
     */
    public TreeMap<Autor, HashSet<Titulo>> getIdx() {
        TreeMap<Autor, HashSet<Titulo>> entries = new TreeMap<Autor, HashSet<Titulo>>();
        autores.forEach((a, hmT) -> entries.put(a, new HashSet<Titulo>(hmT.keySet())));
        return entries;
    }

    /**
     * Método que borra un documento
     *
     * @param aut Un nombre de autor
     * @param tit Titulo
     */
    public void removeTitle(String aut, String tit) {
        Autor autor = new Autor(aut);
        HashMap<Titulo, Integer> titulos = autores.get(autor);
        titulos.remove(new Titulo(tit));
        if (!titulos.isEmpty()) {
            autores.put(autor, titulos);
        } else {
            autores.remove(autor);
        }
    }

    /**
     * Método que borra un documento
     *
     * @param header La pareja de autor y título
     */
    public void removeTitle(DocumentHeader header) {
        HashMap<Titulo, Integer> titulos = autores.get(header.getAutor());
        titulos.remove(header.getTitulo());
        if (!titulos.isEmpty()) {
            autores.put(header.getAutor(), titulos);
        } else {
            autores.remove(header.getAutor());
        }
    }
}
