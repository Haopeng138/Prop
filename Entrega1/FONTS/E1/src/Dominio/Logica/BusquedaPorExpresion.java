package Dominio.Logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import Dominio.Estructura.Documento;
import Dominio.Utils.BinaryTree;
import Dominio.Utils.ParseNode;
import Dominio.Utils.ParseNode.OPERATOR;

public class BusquedaPorExpresion {

    // FIXME: how do we get the documents in here?
    static Set<Documento> documentos;

    public static Set<Documento> buscar(BinaryTree<ParseNode> bTree) {
        if (bTree == null) {
            return null;
        }
        ParseNode nodeVal = bTree.val;
        switch (nodeVal.label) {
            case OPERATOR:
                OPERATOR op = (OPERATOR) nodeVal.val;
                switch (op) {
                    case AND: {
                        Set<Documento> set1 = buscar(bTree.left);
                        Set<Documento> set2 = buscar(bTree.right);
                        set1.retainAll(set2);
                        return set1;
                    }
                    case OR: {
                        Set<Documento> set1 = buscar(bTree.left);
                        Set<Documento> set2 = buscar(bTree.right);
                        set1.retainAll(set2);
                        return set1;
                    }
                    case NOT: {
                        Set<Documento> unwanted = buscar(bTree.left);
                        documentos.removeAll(unwanted);
                        return documentos;
                    }
                }
                break;
            case CONTAIN:
                ArrayList<String> words = (ArrayList<String>) nodeVal.val;
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
                String toMatch = (String) nodeVal.val;
                /*
                 * return findDocumentsThatMatch(sth)
                 * Not sure if this should also be handled by document Controller
                 */
                break;
        }
        return new HashSet<Documento>();
    }
}
