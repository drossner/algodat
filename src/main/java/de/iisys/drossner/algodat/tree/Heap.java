package de.iisys.drossner.algodat.tree;

/**
 * A binary max heap
 * @param <T>
 */
public interface Heap<T extends Comparable<? super T>> {

    boolean insert(T t);
    /**
     * Removes element at specified position based on level-order traversal
     * @param pos
     * @return the element or null if there is no element at pos
     */
    T remove(int pos);

    T extractMax();

}
