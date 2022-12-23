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
     * Método de devuelve la lista de documentos que cumplen la expresión booleana
     *
     * @param expresion La expresión con la que buscar
     * @param libreria  La librería de documentos
     * @return Los documentos que cumplen la expresión
     * @throws Exception
     */
    public ArrayList<DocumentHeader> buscar(String expresion, Libreria libreria) throws Exception {
        this.libreria = libreria;
        TreeMap<Autor, HashSet<Titulo>> indice = libreria.getIdx();
        BinaryTree<ParseNode> bTree = parse(expresion);
        TreeMap<Autor, HashSet<Titulo>> indiceResuelto = buscarRec(bTree, indice);
        ArrayList<DocumentHeader> documentHeaders = new ArrayList<DocumentHeader>();
        indiceResuelto.forEach((aut, sTit) -> sTit.forEach((tit) -> documentHeaders.add(new DocumentHeader(aut, tit))));
        return documentHeaders;
    }

    /**
     * Método que convierte la expresión booleana en un árbol de búsqueda
     *
     * @param expr La expresión con la que hacer la búsqueda
     * @return Un árbol de búsqueda
     * @throws Exception Si la expresión está sintácticamente incorrecta
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

    /**
     * Método que convierte un String en un String[]
     *
     * @param words El String a convertir
     * @return Un String[] donde ha separado la words por " "
     */
    private String[] getWords(String words) {
        return words.split(" ");
    }

    /**
     * Método que encuentra la posición del símbolo que cierra
     *
     * @param expr La expresión booleana
     * @param c El símbolo
     * @return La posición del símbolo de la expresión que cierra
     * @throws Exception Si la expresión está sintácticamente incorrecta
     */
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

    /**
     * Método que encuentra la posición del símbolo que cierra
     *
     * @param expr La expresión booleana
     * @param c El símbolo
     * @return La posición del símbolo de la expresión que cierra
     */
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
     * Método que buscar documentos que cumple la expresión
     * 
     * @param bTree    La expresión parseada a un BinaryTree
     * @param indice   Índice por el que buscar documentos
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
                        TreeMap<Autor, HashSet<Titulo>> hm1 = buscarRec(bTree.left, indice);
                        return buscarRec(bTree.right, hm1);
                    }
                    case OR: {
                        TreeMap<Autor, HashSet<Titulo>> copy = new TreeMap<Autor, HashSet<Titulo>>(indice);
                        TreeMap<Autor, HashSet<Titulo>> hm1 = buscarRec(bTree.left, indice);

                        hm1.forEach((a, sT) -> copy.merge(a, sT, (sT1, sT2) -> sT1.removeAll(sT2) ? sT1 : sT1));

                        copy.entrySet().removeIf(e -> e.getValue().isEmpty());
                        TreeMap<Autor, HashSet<Titulo>> hm2 = buscarRec(bTree.right, copy);

                        hm2.forEach((k, v) -> hm1.merge(k, v, (v1, v2) -> v1.addAll(v2) ? v1 : v1));
                        return hm1;
                    }
                    case NOT: {
                        TreeMap<Autor, HashSet<Titulo>> unwanted = buscarRec(bTree.left, indice);
                        TreeMap<Autor, HashSet<Titulo>> copy = new TreeMap<Autor, HashSet<Titulo>>(indice);

                        unwanted.forEach((a, sT) -> copy.merge(a, sT, (sT1, sT2) -> sT1.removeAll(sT2) ? sT1 : sT1));

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
