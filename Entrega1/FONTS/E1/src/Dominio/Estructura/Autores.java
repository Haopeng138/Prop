package Dominio.Estructura;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class Autores {
    /**
     * Atributos de clase Autores
     */
    private SortedMap<Autor, ArrayList<Titulo>> autores;

    /**
     * Constructor por defecto
     */
    public Autores() {
        this.autores = new TreeMap<>();
    }

    /**
     * Metodo que nos indica si el autor existe en nuestro conjunto de autores
     * @param a Un autor
     * @return True si existe , False en caso contrario
     */
    public Boolean has(Autor a) {
        return autores.get(a) != null;
    }

    public void add(Autor a) {
        this.autores.put(a, new ArrayList<Titulo>());
    }

    public void addTitleToAutor(Titulo t, Autor a) {
        ArrayList<Titulo> titulos = autores.get(a);
        titulos.add(t);
        autores.replace(a, titulos);
    }


    /**
     * Metodo que devuelve todos los titulos que tiene un autor
     * @param a Un autor
     * @return un conjunto de autor
     */
    public ArrayList<Titulo> getTitles(Autor a ){
        return autores.get(a);
    }


    /**
     * Metodo que elimina un autor de nuestro conjunto de autores
     * @param a Autor
     */
    public void remove(Autor a) {
        this.autores.remove(a);
    }

    /**
     * Metodo que devuelve el conjunto de autores
     * @return Un conjunto de autores
     */
    public ArrayList<Autor> getAutores() {
        return new ArrayList<Autor>(autores.keySet());
    }

    /**
     * Metodo que devuelve el conjunto de autores ordenados
     * @return Un conjunto de autores ordenados
     */
    public TreeSet<Autor> getOrderedAutores() {
        return new TreeSet<Autor>(autores.keySet());
    }

    public ArrayList<Titulo> getTitles(Autor a) {
        return autores.get(a);
    }
}
