package Dominio.Estructura;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

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

    public void add(Autor a) {
        if (!this.has(a)) {
            autores.put(a, new HashMap<Titulo, Integer>());
        } else
            System.out.println("El autor ya existe!");
        // eso puede que se tenga que convertir a excepcion
    }

    public void addTitleToAutor(Titulo t, Autor a) {
        HashMap<Titulo, Integer> titulos = autores.get(a);
        currentIdx++;
        titulos.put(t, currentIdx);
        autores.replace(a, titulos);
    }

    /**
     * Metodo que devuelve todos los titulos que tiene un autor
     * 
     * @param a Un autor
     * @return un conjunto de autor
     */
    public ArrayList<Titulo> getTitles(Autor a) {
        return new ArrayList<Titulo>(autores.get(a).keySet());
    }

    /**
     * Metodo que elimina un autor de nuestro conjunto de autores
     * 
     * @param a Autor
     */
    public void remove(Autor a) {
        autores.remove(a);
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
     * Metodo que devuelve el indice del documento
     * 
     * @param a Autor
     * @param t Title
     * @return Posicion en la que se indexa el documento
     * @throws Exception
     */
    public Integer getIndex(Autor a, Titulo t) throws Exception {
        if (!this.has(a)) {
            throw new Exception("Autor no encontrado");
        }
        HashMap<Titulo, Integer> titulos = autores.get(a);
        Integer idx = titulos.get(t);
        if (t == null) {
            throw new Exception("El autor no tiene este titulo");
        }
        return idx;
    }

}
