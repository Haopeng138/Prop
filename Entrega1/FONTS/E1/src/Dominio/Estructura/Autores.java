package Dominio.Estructura;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.HashSet;

public class Autores {
    SortedMap<Autor, HashSet<Titulo>> autores;

    public Autores() {
        this.autores = new TreeMap<>();
    }

    public void add(Autor a) {
        this.autores.put(a, new HashSet<Titulo>());
    }

    public void addTitleToAutor(Titulo t, Autor a) {
        HashSet<Titulo> titulos = autores.get(a);
        titulos.add(t);
        autores.replace(a, titulos);
    }

    public void remove(Autor a) {
        this.autores.remove(a);
    }

    public ArrayList<Autor> getAutores() {
        return new ArrayList<Autor>(autores.keySet());
    }

    public HashSet<Titulo> getTitles(Autor a) {
        return autores.get(a);
    }

    public ArrayList<Autor> getAutores(String prefix) {
        if (prefix == "") {
            return new ArrayList<Autor>(autores.keySet());
        }

        String nextPrefix = getNextPrefix(prefix);
        if (nextPrefix != null) {
            return new ArrayList<Autor>(
                    autores.subMap(new Autor(prefix), new Autor(nextPrefix)).keySet());
        }
        return new ArrayList<Autor>(autores.tailMap(new Autor(prefix)).keySet());
    }

    private String getNextPrefix(String prefix) {
        for (int charIdx = prefix.length() - 1; charIdx >= 0; charIdx--) {
            if (prefix.charAt(charIdx) != 'z') {
                return replaceChar(prefix, charIdx);
            }
        }
        return null;
    }

    private String replaceChar(String prefix, int idx) {
        char nextChar = (char) (prefix.charAt(idx) + 1);
        StringBuilder nextPrefix = new StringBuilder(prefix);
        nextPrefix.setCharAt(idx, nextChar);
        return nextPrefix.toString();
    }
}
