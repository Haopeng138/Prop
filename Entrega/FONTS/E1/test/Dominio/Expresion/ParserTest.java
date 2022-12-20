package Dominio.Expresion;

import Dominio.Utils.BinaryTree;
import Dominio.Utils.ParseNode;
import Dominio.Utils.ParseNode.NODE_TYPE;
import Dominio.Utils.ParseNode.OPERATOR;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void parse() throws Exception {
        String expresion = "{p1 p2 p3} & (\"hola adéu\" | (!pep))";

        BinaryTree<ParseNode> root = new BinaryTree<ParseNode>();
        ParseNode node = new ParseNode(NODE_TYPE.OPERATOR, OPERATOR.AND);
        root.val = node;

        ParseNode lnode = new ParseNode(NODE_TYPE.CONTAIN, new ArrayList<String>(Arrays.asList("p1", "p2", "p3")));
        root.left = new BinaryTree<ParseNode>();
        root.left.val = lnode;

        ParseNode rnode = new ParseNode(NODE_TYPE.OPERATOR, OPERATOR.OR);
        root.right = new BinaryTree<ParseNode>();
        root.right.val = rnode;

        ParseNode rlnode = new ParseNode(NODE_TYPE.MATCH, "hola adéu");
        root.right.left = new BinaryTree<ParseNode>();
        root.right.left.val = rlnode;

        ParseNode rrnode = new ParseNode(NODE_TYPE.OPERATOR, OPERATOR.NOT);
        root.right.right = new BinaryTree<ParseNode>();
        root.right.right.val = rrnode;

        ParseNode rrlnode = new ParseNode(NODE_TYPE.CONTAIN, new ArrayList<String>(Arrays.asList("pep")));
        root.right.right.left = new BinaryTree<ParseNode>();
        root.right.right.left.val = rrlnode;

        BinaryTree<ParseNode> bTree = Parser.parse(expresion);

        assertTrue(assertRecursively(root, bTree));
    }

    private boolean assertRecursively(BinaryTree<ParseNode> a, BinaryTree<ParseNode> b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }

        assertEquals("no coincide el tipo de nodo", a.val.label.toString(), b.val.label.toString());
        return (assertRecursively(a.left, b.left) && assertRecursively(a.right, b.right));
    }
}