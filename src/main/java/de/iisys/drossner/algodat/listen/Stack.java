package de.iisys.drossner.algodat.listen;

public interface Stack<T> {
    void push(T e);
    T pop();
    boolean isFull();
    boolean isEmpty();
}
