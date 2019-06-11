package de.iisys.drossner.algodat.tree;

import de.iisys.drossner.algodat.uebungen.Pair;

public class BasicTree {

    private Node root;

    public class Node implements Comparable<Node>{
        private String data;
        private Node left;
        private Node right;

        Node(String data){
            this.data = data;
        }

        @Override
        public int compareTo(Node o) {
            return this.data.compareTo(o.data);
        }
    }
    /*
     * Geeignete Methoden zum Einfügen, Löschen, Finden, ...
     */

    public void insert(String dat){
        Node node = new Node(dat);
        Node par = null;
        Node curr = this.root;
        if(curr == null) {
            root = node;
            return;
        }
        while(curr != null){
            par = curr;
            if(node.data.compareTo(curr.data) < 0){
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        if(node.data.compareTo(par.data) < 0){
            par.left = node;
        } else {
            par.right = node;
        }
    }

    public void inorder(Node n){
        if(n == null) return;
        inorder(n.left);
        System.out.println(n.data+" ");
        inorder(n.right);
    }

    public void delete(String key){
        //zunächst finden inkl. parent, ist der gesuchte Knoten root, ist parent null
        //Annahme: key ist im Baum vorhanden, ansonsten muss Implementierung mod. werden
        Node parent = this.root.data.compareTo(key) == 0? null : findParent(this.root, key);
        Node del;
        //aus parent den eigentlich zu löschenden Knoten ableiten
        if(parent == null) del = this.root;
        else del = parent != null
                && parent.left != null
                && parent.left.data.compareTo(key) == 0? parent.left : parent.right;
        if(del == null) return;
        //überprüfen, ob es sich um einen einfachen Fall handelt: 0 oder 1 Nachfolger
        if(del.left == null){
            simpleDelete(parent, del, del.right);
        } else if(del.right == null){
            simpleDelete(parent, del, del.left);
        } else {
            Pair<Node, Node> rparmin = minright(del);
            if(rparmin.get1().data.compareTo(key) != 0){
                simpleDelete(rparmin.get1(), rparmin.get2(), rparmin.get2().right);
                rparmin.get2().right = del.right;
            }
            simpleDelete(parent, del, rparmin.get2());
            rparmin.get2().left = del.left;
        }
    }

    private Pair<Node, Node> minright(Node node) {
        Node parent = node;
        Node min = node.right;
        while (min.left != null){
            parent = min;
            min = min.left;
        }
        return new Pair<>(parent, min);
    }

    private void simpleDelete(Node parent, Node del, Node next) {
        if(parent == null) this.root = next;
        else if(del == parent.left){
            parent.left = next;
        } else {
            parent.right = next;
        }
    }

    private Node findParent(Node start, String key) {
        //Annahme: key ist im Baum vorhanden, ansonsten muss Implementierung mod. werden
        if(start.data.compareTo(key) < 0){
            if(start.right.data.compareTo(key) == 0) return start;
            return findParent(start.right, key);
        } else {
            if(start.left.data.compareTo(key) == 0) return start;
            return findParent(start.left, key);
        }
    }

    public static void main(String[] args) {
        BasicTree tree = new BasicTree();
        tree.insert("Hof");
        tree.insert("Bayreuth");
        tree.insert("München");
        tree.insert("Nürnberg");
        tree.insert("Bamberg");
        tree.insert("Coburg");
        tree.insert("Würzburg");

        tree.inorder(tree.root);

        System.out.println("");

        tree.delete("asdasd");

        tree.inorder(tree.root);
    }
}
