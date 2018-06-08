package de.iisys.drossner.algodat.tree;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AvlTree<T extends Comparable<? super T>> {

    private class Node implements Comparable<Node>{
        private T data;
        private byte bf;

        private Node left;
        private Node right;

        private Node(T data){
            this.data = data;
            this.bf = 0;
        }

        @Override
        public int compareTo(@NotNull Node o) {
            return this.data.compareTo(o.data);
        }
    }

    private Node root;

    public void insert(T data){
        //encapsulate in new node
        Node toinsert = new Node(data);
        if(root == null){
            root = toinsert;
        } else {
            insert(null, root, toinsert);
        }
    }

    private byte insert(Node parent, Node node, Node toinsert) {
        //care about duplicate keys..
        if(toinsert.compareTo(node) == 0){
            if(parent.left == node) parent.left = toinsert;
            else parent.right = toinsert;
            return 0;
        }
        Node left = node.left;
        Node right = node.right;
        boolean smth = toinsert.compareTo(node) < 0;
        if(left != null && smth){
            byte change = insert(node, left, toinsert); //gets smaller or stays
             if(change == 0) return  0;
             node.bf-=change;
        } else if(right != null && !smth){
            byte change = insert(node, right, toinsert); //gets bigger or stays
            if(change == 0) return 0;
            node.bf+=change;
        } else {
            if(smth){
                node.left = toinsert;
                node.bf--;
            }
            else{
                node.right = toinsert;
                node.bf++;
            }
            return (byte) Math.abs(node.bf); //subtree of "node" got bigger, hence return 1
        }

        //basic case returns 1 or 0
        //for recursion case: check bf, do actions if needed, propagate bf changes
        if(node.bf == 0) return 0; //inserted in (before) smaller subtree
        if(Math.abs(node.bf) == 1){ //subtree got bigger (right or left subtree increased, bf from 0 to +-1)
            return 1;
        } else { //-2 or +2 -> rotation(s) needed
            //check case, fix bf
            if(node.bf < 0) { //we are in a L situation
                if(node.left.bf < 0){ //LL situation -> rot_r(node)
                    node.left.bf = 0;
                    node.bf = 0;
                    rotRight(parent, node);
                } else {              //LR situation -> rot_l(node.left) + rot_r(node)
                    if(node.left.right.bf > 0){
                        node.bf = 0;
                        node.left.bf = -1;
                    } else if(node.left.right.bf < 0){
                        node.bf = 1;
                        node.left.bf = 0;
                    } else {
                        node.bf = 0;
                        node.left.bf = 0;
                    }
                    node.left.right.bf = 0;
                    rotLeft(node, node.left);
                    rotRight(parent, node);
                }
            } else {          //we are in a R situation
                if(node.right.bf < 0){ //RL situation -> rot_r(node.right) + rot_l(node)
                    if(node.right.left.bf > 0){ //RL -> insertion in which subtree?
                        node.bf = -1;
                        node.right.bf = 0;
                    } else if(node.right.left.bf < 0){
                        node.bf = 0;
                        node.right.bf = 1;
                    } else {
                        node.bf = 0;
                        node.right.bf = 0;
                    }
                    node.right.left.bf = 0;
                    rotRight(node, node.right);
                    rotLeft(parent, node);
                } else {               //RR situation -> rot_l(node)
                    node.right.bf = 0;
                    node.bf = 0;
                    rotLeft(parent, node);
                }
            }
            return 0; //subtree is the same as before insertion
        }
    }

    private void rotLeft(Node parent, Node node){
        //save right child of node
        Node rchild = node.right;
        //check if node is left or right child of parent
        if(parent == null){
            root = rchild;
        } else if(node == parent.left){
            parent.left = rchild;
        } else {
            parent.right = rchild;
        }
        node.right = rchild.left;
        rchild.left = node;
    }

    private void rotRight(Node parent, Node node){
        //save left child of node
        Node lchild = node.left;
        //check if node is left or right child of parent
        if(parent == null){
          root = lchild;
        } else if(node == parent.left){
            parent.left = lchild;
        } else {
            parent.right = lchild;
        }
        node.left = lchild.right;
        lchild.right = node;
    }

    public List<T> leveltraversal(){
        List<T> ret = new LinkedList<>();
        Queue<Node> lvl = new LinkedList<>();
        lvl.add(root);
        for(Node curr; (curr = lvl.poll()) != null;){
            ret.add(curr.data);
            if(curr.left != null) lvl.add(curr.left);
            if(curr.right != null) lvl.add(curr.right);
        }
        return ret;
    }
}
