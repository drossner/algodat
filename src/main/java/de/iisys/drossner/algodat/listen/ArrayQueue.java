package de.iisys.drossner.algodat.listen;

public class ArrayQueue<E> implements Queue<E>{

    private E[] basis;
    private int head;
    private int tail;
    private int elements;

    public ArrayQueue(int cap){
        basis = (E[]) new Object[cap];
        tail = 0;
        head = 0;
        elements = 0;
    }

    @Override
    public boolean enqueue(E e) {
        if(tail == head && !isEmpty()){
            return false;
        }
        elements++;
        basis[tail] = e;
        tail = (tail + 1) % basis.length;
        return true;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            return null;
        }
        elements--;
        E tmp = basis[head];
        basis[head] = null;
        head = (head + 1) % basis.length;
        return tmp;
    }

    @Override
    public E peek() {
        return isEmpty()? null : basis[head];
    }

    private boolean isEmpty(){
        return elements == 0;
    }
}
