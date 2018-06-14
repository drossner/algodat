package de.iisys.drossner.algodat.tree;

public class AvlTreeTest {

    public static void main(String[] args) {
        AvlTree<Integer> tree = new AvlTree<>();

        tree.insert(44);
        tree.insert(29);
        tree.insert(10);
        tree.insert(58);
        tree.insert(19);
        tree.insert(88);
        tree.insert(2);
        tree.insert(76);
        tree.insert(3);
        tree.insert(44);
        tree.insert(96);
        tree.insert(28);
        tree.insert(18);
        tree.insert(29);

        tree.leveltraversal().forEach(System.out::println);
    }

}
