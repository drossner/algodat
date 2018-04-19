package de.iisys.drossner.algodat.tree;

public class BasicTree {

    private Node root;

    public class Node{
        private String data;
        private Node left;
        private Node right;

        Node(String data){
            this.data = data;
        }
    }
    /*
     * Geeignete Methoden zum Einfügen, Löschen, Finden, ...
     */
}
