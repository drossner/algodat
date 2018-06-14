package de.iisys.drossner.algodat.sort;

import de.iisys.drossner.algodat.tree.AvlTree;

import java.util.Random;

public class AvlSort {

    public static void main(String[] args) {
        AvlTree<Integer> tree  = new AvlTree<>();
        //care duplicates are ignored by avl tree!!
        new Random()
                .ints(20, 0, 100)
                .boxed()
                .forEach(tree::insert);

        tree.inordertraversal().forEach(System.out::println);

    }

}
