package de.iisys.drossner.algodat.tree;

public class AvlTreeTest {

    public static void main(String[] args) {
        AvlTree<Integer> tree = new AvlTree<>();

        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        tree.insert(35);
        tree.insert(25);

        tree.leveltraversal().forEach(System.out::println);
    }

}
