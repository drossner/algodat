package de.iisys.drossner.algodat.listen;

public class ArrayStack<T> implements Stack<T>{

    private T[] basis;
    private int top = -1;

    public ArrayStack(int cap){
        //unchecked Cast!
        basis = (T[]) new Object[cap];
    }

    @Override
    public void push(T e) {
        if(!isFull()) {
            basis[++top] = e;
        }
    }

    @Override
    public T pop() {
        if( isEmpty() ) return null;
        T ret = basis[top];
        basis[top] = null;
        top--;
        return ret;
    }

    @Override
    public boolean isFull() {
        return top >= basis.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return top < 0;
    }
}
