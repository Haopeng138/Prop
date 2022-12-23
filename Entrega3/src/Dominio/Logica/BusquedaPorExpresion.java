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
import Dominio.Utils.ParseNode.NODE_TYPE;
import Dominio.Utils.ParseNode.OPERATOR;

import Dominio.Estructura.Autor;
import Dominio.Estructura.Titulo;
import Dominio.Estructura.Libreria;

public class BusquedaPorExpresion {
    private Libreria libreria;

    /**
     * @param expresion La expresion con la que buscar
     * @param libreria  La libreria de documentos
     * @return Los documentos que cumplen la expresion
     * @throws Exception
     */
    public ArrayList<DocumentHeader> buscar(String expresion, Libreria libreria) throws Exception {
        this.libreria = libreria;
        TreeMap<Autor, HashSet<Titulo>> indice = libreria.getIdx();
        BinaryTree<ParseNode> bTree = parse(expresion);
        TreeMap<Autor, HashSet<Titulo>> indiceResuelto = buscarRec(bTree, indice);
        ArrayList<DocumentHeader> documentHeaders = new ArrayList<DocumentHeader>();
        indiceResuelto.forEach((a, sT) -> sT.forEach((t) -> documentHeaders.add(new DocumentHeader(a, t))));
        return documentHeaders;
    }

    /**
     * @param expr La expresion con la que hacer la busqueda
     * @return Un arbol de busqueda
     * @throws Exception
     */
    private BinaryTree<ParseNode> parse(String expr) throws Exception {
        int ptr = 0;
        BinaryTree<ParseNode> root = new BinaryTree<ParseNode>();
        BinaryTree<ParseNode> currNode = root;
        while (ptr < expr.length()) {
            char c = expr.charAt(ptr);
            switch (c) {
                case '|': {
                    BinaryTree<ParseNode> newRoot = new BinaryTree<ParseNode>();
                    newRoot.val = new ParseNode(NODE_TYPE.OPERATOR, OPERATOR.OR);
                    newRoot.left = root;
                    newRoot.right = parse(expr.substring(ptr + 1));
                    return newRoot;
                }
                case '&': {
                    BinaryTree<ParseNode> newRoot = new BinaryTree<ParseNode>();
                    newRoot.val = new ParseNode(NODE_TYPE.OPERATOR, OPERATOR.AND);
                    newRoot.left = root;
                    newRoot.right = parse(expr.substring(ptr + 1));
                    return newRoot;
                }
                case '!': {
                    currNode.val = new ParseNode(NODE_TYPE.OPERATOR, OPERATOR.NOT);
                    currNode.right = null;
                    currNode.left = new BinaryTree<ParseNode>();
                    currNode = currNode.left;
                    break;
                }
                case '(': {
                    int nextPtr = ptr + 1 + findNext(expr.substring(ptr + 1), ')');
                    BinaryTree<ParseNode> toCopyBecauseJavaSucks = parse(expr.substring(ptr + 1, nextPtr));
                    currNode.val = toCopyBecauseJavaSucks.val;
                    currNode.left = toCopyBecauseJavaSucks.left;
                    currNode.right = toCopyBecauseJavaSucks.right;
                    ptr = nextPtr;
                    break;
                }
                case '{': {
                    int nextPtr = ptr + 1 + findNext(expr.substring(ptr + 1), '}');
                    currNode.val = new ParseNode(NODE_TYPE.CONTAIN, getWords(expr.substring(ptr + 1, nextPtr)));
                    currNode.left = null;
                    currNode.right = null;
                    ptr = nextPtr;
                    break;
                }
                case '"': {
                    int nextPtr = ptr + 1 + findNext(expr.substring(ptr + 1), '"');
                    currNode.val = new ParseNode(NODE_TYPE.MATCH, expr.substring(ptr + 1, nextPtr));
                    currNode.left = null;
                    currNode.right = null;
                    ptr = nextPtr;
                    break;
                }
                case ' ': {
                    break;
                }
                default: {
                    int nextPtr = ptr + 1 + findNextOrEnd(expr.substring(ptr + 1), ' ');
                    currNode.val = new ParseNode(NODE_TYPE.CONTAIN, getWords(expr.substring(ptr, nextPtr)));
                    currNode.left = null;
                    currNode.right = null;
                    ptr = nextPtr;
                    break;
                }
            }
            ptr++;
        }
        return root;
    }

    private String[] getWords(String words) {
        return words.split(" ");
    }

    private int findNext(String expr, char c) throws Exception {
        int nextPtr = 0;
        char match = Matches.match(c);
        int count = 0;
        while (nextPtr < expr.length()) {
            if (expr.charAt(nextPtr) == c) {
                if (count == 0) {
                    return nextPtr;
                } else {
                    count--;
                }
            }
            if (expr.charAt(nextPtr) == match) {
                count++;
            }
            nextPtr++;
        }
        if (nextPtr == 0) {
            throw new Exception("No closing token found: " + c);
        }
        return nextPtr;
    }

    private int findNextOrEnd(String expr, char c) {
        try {
            int nextPtr = findNext(expr, c);
            return nextPtr;
        } catch (Exception e) {
            return expr.length();
        }
    }

    protected static class Matches {
        protected static char match(char c) {
            switch (c) {
                case ')': {
                    return '(';
                }
                case '}': {
                    return '{';
                }
                case '"': {
                    return '"';
                }
                default: {
                    return ' ';
                }
            }
        }
    }

    /**
     * Metodo que buscar documentos que cumple la expresión
     * 
     * @param bTree  La expresion parseada a un BinaryTree
     * @param indice Indice por el que buscar documentos
     * @return Conjunto de documentos que cumple la expresión
     * @throws Exception
     */
    public TreeMap<Autor, HashSet<Titulo>> buscarRec(BinaryTree<ParseNode> bTree,
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
