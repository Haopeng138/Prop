package Dominio.Logica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import Dominio.Utils.BinaryTree;
import Dominio.Utils.DocumentHeader;
import Dominio.Utils.ParseNode;
import Dominio.Utils.ParseNode.OPERATOR;

import Dominio.Estructura.Autor;
import Dominio.Estructura.Titulo;
import Dominio.Estructura.Libreria;

public class BusquedaPorExpresion {

    private TreeMap<Autor, HashSet<Titulo>> indice;
    private static Libreria libreria;

    public ArrayList<DocumentHeader> buscar(BinaryTree<ParseNode> bTree, Libreria libreria) throws Exception {
        TreeMap<Autor, HashSet<Titulo>> indice = libreria.getIdx();
        TreeMap<Autor, HashSet<Titulo>> indiceResuelto = buscarRec(bTree, indice);
        ArrayList<DocumentHeader> documentHeaders = new ArrayList<DocumentHeader>();
        indiceResuelto.forEach((a, sT) -> sT.forEach((t) -> documentHeaders.add(new DocumentHeader(a, t))));
        return documentHeaders;
    }

    /**
     * Metodo que buscar documentos que cumple la expresión
     * 
     * @param bTree  La expresion parseada a un BinaryTree
     * @param indice Indice por el que buscar documentos
     * @return Conjunto de documentos que cumple la expresión
     * @throws Exception
     */
    public static TreeMap<Autor, HashSet<Titulo>> buscarRec(BinaryTree<ParseNode> bTree,
            TreeMap<Autor, HashSet<Titulo>> indice) throws Exception {
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
                        TreeMap<Autor, HashSet<Titulo>> hm1 = buscarRec(bTree.left, indice);
                        return buscarRec(bTree.right, hm1);
                    }
                    case OR: {
                        // We return the documents that fulfill one of the conditions
                        TreeMap<Autor, HashSet<Titulo>> copy = new TreeMap<Autor, HashSet<Titulo>>(indice);
                        TreeMap<Autor, HashSet<Titulo>> hm1 = buscarRec(bTree.left, indice);
                        // We remove the author title pairs that have already been found
                        hm1.forEach((a, sT) -> copy.merge(a, sT, (sT1, sT2) -> sT1.removeAll(sT2) ? sT1 : sT1));
                        // We remove the authors that have no documents that we are keeping
                        copy.entrySet().removeIf(e -> e.getValue().isEmpty());
                        TreeMap<Autor, HashSet<Titulo>> hm2 = buscarRec(bTree.right, copy);
                        // We add both searches
                        hm2.forEach((k, v) -> hm1.merge(k, v, (v1, v2) -> v1.addAll(v2) ? v1 : v1));
                        return hm1;
                    }
                    case NOT: {
                        // We return the documents that do not fulfill the condition
                        TreeMap<Autor, HashSet<Titulo>> unwanted = buscarRec(bTree.left, indice);
                        TreeMap<Autor, HashSet<Titulo>> copy = new TreeMap<Autor, HashSet<Titulo>>(indice);
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
                String[] wordArray = (String[]) nodeVal.val;
                ArrayList<String> words = new ArrayList<String>(Arrays.asList(wordArray));
                // we filter out the documents that don't contain the words specified
                return new TreeMap<Autor, HashSet<Titulo>>(indice.entrySet().stream()
                        .filter(a -> !a.getValue().stream()
                                .filter(t -> words.stream()
                                        .allMatch(
                                                word -> libreria.tienePalabra(new DocumentHeader(a.getKey(), t), word)))
                                .collect(Collectors.toSet()).isEmpty())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
            }
            case MATCH: {
                String toMatch = (String) nodeVal.val;
                // we filter out the documents that don't contain the string specified
                return new TreeMap<Autor, HashSet<Titulo>>(indice.entrySet().stream()
                        .filter(a_sT -> !a_sT.getValue().stream()
                                .filter(t -> libreria.tieneString(new DocumentHeader(a_sT.getKey(), t), toMatch))
                                .collect(Collectors.toSet()).isEmpty())
                        .collect(Collectors.toMap(newI -> newI.getKey(), newI -> newI.getValue())));
            }
            default: {
                throw new Exception("Couldn't make it work");
            }
        }
    }
}
