package Dominio.Logica;

import java.util.HashSet;
import java.util.Map;
import java.util.function.Function;
import java.util.HashMap;
import java.util.stream.Collectors;

import Dominio.Utils.BinaryTree;
import Dominio.Utils.ParseNode;
import Dominio.Utils.ParseNode.OPERATOR;

import Dominio.Estructura.Autor;
import Dominio.Estructura.Titulo;

public class BusquedaPorExpresion {

    /**
     * Metodo que buscar documentos que cumple la expresión
     * 
     * @param bTree  La expresion parseada a un BinaryTree
     * @param indice Indice por el que buscar documentos
     * @return Conjunto de documentos que cumple la expresión
     * @throws Exception
     */
    public static HashMap<Autor, HashSet<Titulo>> buscar(BinaryTree<ParseNode> bTree,
            HashMap<Autor, HashSet<Titulo>> indice) throws Exception {
        if (bTree == null) {
            return null;
        }
        ParseNode nodeVal = bTree.val;
        switch (nodeVal.label) {
            case OPERATOR:
                OPERATOR op = (OPERATOR) nodeVal.val;
                switch (op) {
                    case AND: {
                        // We return the documents that fulfill both conditions
                        HashMap<Autor, HashSet<Titulo>> hm1 = buscar(bTree.left, indice);
                        return buscar(bTree.right, hm1);
                    }
                    case OR: {
                        // We return the documents that fulfill one of the conditions
                        HashMap<Autor, HashSet<Titulo>> copy = new HashMap<Autor, HashSet<Titulo>>(indice);
                        HashMap<Autor, HashSet<Titulo>> hm1 = buscar(bTree.left, indice);
                        // We remove the author title pairs that have already been found
                        hm1.forEach((a, sT) -> copy.merge(a, sT, (sT1, sT2) -> sT1.removeAll(sT2) ? sT1 : sT1));
                        // We remove the authors that have no documents that we are keeping
                        copy.entrySet().removeIf(e -> e.getValue().isEmpty());
                        HashMap<Autor, HashSet<Titulo>> hm2 = buscar(bTree.right, copy);
                        // We add both searches
                        hm2.forEach((k, v) -> hm1.merge(k, v, (v1, v2) -> v1.addAll(v2) ? v1 : v1));
                        return hm1;
                    }
                    case NOT: {
                        // We return the documents that do not fulfill the condition
                        HashMap<Autor, HashSet<Titulo>> unwanted = buscar(bTree.left, indice);
                        HashMap<Autor, HashSet<Titulo>> copy = new HashMap<Autor, HashSet<Titulo>>(indice);
                        // We remove the author title pairs that have already been found
                        unwanted.forEach((a, sT) -> copy.merge(a, sT, (sT1, sT2) -> sT1.removeAll(sT2) ? sT1 : sT1));
                        // We remove the authors that have no documents that we are keeping
                        copy.entrySet().removeIf(e -> e.getValue().isEmpty());
                        return copy;
                    }
                    default: {
                        throw new Exception();
                    }
                }
            case CONTAIN: {
                String[] words = (String[]) nodeVal.val;
                // we filter out the documents that don't contain the words specified
                return new HashMap<Autor, HashSet<Titulo>>(indice.entrySet().stream()
                        .filter(a -> !a.getValue().stream().filter(t -> cDocumento.tienePalabras(a.getKey(), t, words))
                                .collect(Collectors.toSet()).isEmpty())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
            }
            case MATCH: {
                String toMatch = (String) nodeVal.val;
                // we filter out the documents that don't contain the string specified
                return new HashMap<Autor, HashSet<Titulo>>(indice.entrySet().stream()
                        .filter(a_sT -> !a_sT.getValue().stream()
                                .filter(t -> cDocumento.tieneString(a_sT.getKey(), t, toMatch))
                                .collect(Collectors.toSet()).isEmpty())
                        .collect(Collectors.toMap(newI -> newI.getKey(), newI -> newI.getValue())));
            }
            default: {
                throw new Exception("Couldn't make it work");
            }
        }
    }

    private static class cDocumento {
        // TODO: implement this in library

        public static Boolean tienePalabras(Autor key, Titulo t, String[] words) {
            return true;
        }

        public static Boolean tieneString(Autor key, Titulo t, String toMatch) {
            return true;
        }
    }
}
