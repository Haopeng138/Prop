package Dominio.Expresion;

public class BinaryTree<T> {
    BinaryTree<T> left;
    BinaryTree<T> right;
    T val;

    BinaryTree() {
    };

    BinaryTree(T val) {
        this.val = val;
    }

}
