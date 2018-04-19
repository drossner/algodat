package de.iisys.drossner.algodat.listen;

public interface Queue<E> {

    boolean enqueue(E e);
    E dequeue();
    E peek();

}
