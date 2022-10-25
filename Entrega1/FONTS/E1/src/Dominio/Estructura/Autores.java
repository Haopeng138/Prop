package Dominio.Estructura;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class Autores {
    SortedMap<Autor, ArrayList<Titulo>> autores;

    public Autores() {
        this.autores = new TreeMap<>();
    }

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

    public void remove(Autor a) {
        this.autores.remove(a);
    }

    public ArrayList<Autor> getAutores() {
        return new ArrayList<Autor>(autores.keySet());
    }

    public TreeSet<Autor> getOrderedAutores() {
        return (TreeSet<Autor>) autores.keySet();
    }

    public ArrayList<Titulo> getTitles(Autor a) {
        return autores.get(a);
    }
}
