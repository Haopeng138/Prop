package Dominio.Logica;

import java.util.HashSet;
import java.util.Set;

import Dominio.Estructura.Documento;
import Dominio.Utils.BinaryTree;
import Dominio.Utils.ParseNode;
import Dominio.Utils.ParseNode.OPERATOR;

public class BusquedaPorExpresion {

    /**
     * Metodo que buscar documentos que cumple la expresión
     * @param bTree La expresion parseada a un BinaryTree
     * @param documentos Documentos en la cual queremos buscar
     * @return Conjunto de documentos que cumple la expresión
     */
    public static Set<Documento> buscar(BinaryTree<ParseNode> bTree, Set<Documento> documentos) {
        if (bTree == null) {
            return null;
        }
        ParseNode nodeVal = bTree.val;
        switch (nodeVal.label) {
            case OPERATOR:
                OPERATOR op = (OPERATOR) nodeVal.val;
                switch (op) {
                    case AND: {
                        Set<Documento> set1 = buscar(bTree.left, documentos);
                        return buscar(bTree.right, set1);
                    }
                    case OR: {
                        Set<Documento> set1 = buscar(bTree.left, documentos);
                        Set<Documento> copy = new HashSet<Documento>(documentos);
                        copy.removeAll(set1);
                        Set<Documento> set2 = buscar(bTree.right, copy);
                        set1.addAll(set2);
                        return set1;
                    }
                    case NOT: {
                        Set<Documento> unwanted = buscar(bTree.left, documentos);
                        Set<Documento> copy = new HashSet<Documento>(documentos);
                        copy.removeAll(unwanted);
                        return copy;
                    }
                }
                break;
            case CONTAIN:
                // TODO: what's missing is the documents implementation...
                String[] words = (String[]) nodeVal.val;
                /*
                 * return findDocumentsThatContain(words)
                 * which could be handled by document controller ?
                 * Or shall we get the library and operate it from here... don't think so.
                 * it should be sth like...
                 * for (String word : words) {
                 * library.getDocumentsThatHave(word)
                 * }
                 * ...etc
                 */
                break;
            case MATCH:
                // TODO: what's missing is the documents implementation...
                String toMatch = (String) nodeVal.val;
                // String[] toContain = toMatch.split(" ");
                // Set<Documento> set1 = findDocumentsThatContain(toContain);
                // return busquedaPorString(set1);

                /*
                 * return findDocumentsThatMatch(sth)
                 * Not sure if this should also be handled by document Controller
                 */
                break;
        }

        // Resultado temporal para test
        return new HashSet<Documento>(documentos);
    }
}
