package de.iisys.drossner.algodat.listen;

import java.util.function.Function;

public class VerketteteListe<T> implements CoolList<T> {

    private Node<T> head;

    @Override
    public void insert(T data) {
        //Sonderfall List leer
        if(head == null) head = new Node<>(data);
        else{
            Node<T> temp = head;
            head = new Node<>(data);
            head.next = temp;
        }
    }

    @Override
    public T delete(Function<T, Boolean> func) {
        Node<T> current = head;
        //Sonderfall delete head
        if(func.apply(current.data)){
            head = current.next;
            return current.data;
        }
        Node<T> prev = current;
        current = current.next;
        while(current != null){
            if(func.apply(current.data)){
                prev.next = current.next;
                return current.data;
            }
            prev = current;
            current = current.next;
        }
        return null;
    }

    @Override
    public T find(Function<T, Boolean> func) {
        Node<T> current = head;
        while(current != null){
            if(func.apply(current.data)){
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public void print() {
        Node<T> current = head;
        if(current == null) System.out.print("Liste ist leer :(");
        while (current != null){
            System.out.print(current.data.toString() + " ---> ");
            current = current.next;
        }
        System.out.println();
    }

    private class Node<T>{

        Node(T data){
            this.data = data;
        }
        private T data;
        private Node<T> next;
    }
}
