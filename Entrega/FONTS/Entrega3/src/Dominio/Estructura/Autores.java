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
     * Metodo que nos indica si el autor existe en nuestro conjunto de autores
     * 
     * @param a Un autor
     * @return True si existe , False en caso contrario
     */
    public Boolean has(Autor a) {
        return autores.get(a) != null;
    }

    public Boolean has(String a) {
        return autores.get(new Autor(a)) != null;
    }

    /**
     * Metodo que añade un autor al conjunto de autores
     * 
     * @param a autor
     */
    public void add(Autor a) {
        if (!this.has(a)) {
            autores.put(a, new HashMap<Titulo, Integer>());
        } else
            System.out.format("El autor: %s, ya existe!\n", a);
    }

    /**
     * Metodo que añade un autor al conjunto de autores
     * 
     * @param a nombre del autor
     */
    public void add(String a) {
        if (!this.has(a)) {
            autores.put(new Autor(a), new HashMap<Titulo, Integer>());
        } else
            System.out.format("El autor: %s, ya existe!\n", a);
    }

    /**
     * Metodo que añade un titulo al conjunto de titulos de un autor
     * 
     * @param header El header de un documento autor y titulo
     *
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
     * Metodo que devuelve todos los titulos que tiene un autor
     *
     * @param a Un autor
     * @return un conjunto de autor
     */
    public ArrayList<Titulo> getTitles(String a) {
        return new ArrayList<Titulo>(autores.get(new Autor(a)).keySet());
    }

    /**
     * Metodo que elimina un autor de nuestro conjunto de autores
     *
     * @param a Autor
     */
    public void remove(Autor a) {
        autores.remove(a);
    }

    public void remove(String a) {
        autores.remove(new Autor(a));
    }

    /**
     * Metodo que devuelve el conjunto de autores
     *
     * @return Un conjunto de autores
     */
    public ArrayList<Autor> getAutores() {
        return new ArrayList<Autor>(autores.keySet());
    }

    /**
     * Metodo que devuelve el conjunto de autores ordenados
     *
     * @return Un conjunto de autores ordenados
     */
    public TreeSet<Autor> getOrderedAutores() {
        return new TreeSet<Autor>(autores.keySet());
    }

    /**
     * Metodo que devuelve el numero de autores en el sistema
     *
     * @return El numero de autores en el sistema
     */
    public int getNumAutor() {
        return autores.size();
    }

    /**
     * @param autor El autor al que consultar
     * @return El numero de documentos que tiene el autor
     */
    public int getNumDocumentos(Autor autor) {
        return autores.get(autor).size();
    }

    /**
     * Metodo que devuelve el indice del documento
     *
     * @param header El header del documento
     * @return Posicion en la que se indexa el documento
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
     * Metodo que devuelve el indice del documento
     *
     * @return La lista de autores y titulos
     */
    public TreeMap<Autor, HashSet<Titulo>> getIdx() {
        TreeMap<Autor, HashSet<Titulo>> entries = new TreeMap<Autor, HashSet<Titulo>>();
        autores.forEach((a, hmT) -> entries.put(a, new HashSet<Titulo>(hmT.keySet())));
        return entries;
    }

    /**
     * Metodo que borra un documento
     *
     * @param a Autor
     * @param t Titulo
     */
    public void removeTitle(String a, String t) {
        Autor autor = new Autor(a);
        HashMap<Titulo, Integer> titulos = autores.get(autor);
        titulos.remove(new Titulo(t));
        if (!titulos.isEmpty()) {
            autores.put(autor, titulos);
        } else {
            autores.remove(autor);
        }
    }

    /**
     * Metodo que borra un documento
     *
     * @param header pareja autor titulo
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
