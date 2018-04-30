package de.iisys.drossner.algodat.tree;

public class ArrayHeap<T extends Comparable<? super T>> implements Heap<T> {

    private int heapsize;
    private T[] basis;

    public ArrayHeap(int cap){
        heapsize = 0;
        basis = (T[]) new Comparable[cap];
    }

    public ArrayHeap(T[] initArr){
        heapsize = initArr.length;
        basis = initArr;
        buildHeap();
    }

    private void buildHeap() {
        for(int i = heapsize / 2 - 1; i >= 0; --i){
            heapify(i);
        }
    }

    private void increase(int node){
        int parent = parent(node);
        while(node > 0 && basis[node].compareTo(basis[parent]) > 0){
            //swap
            T tmp = basis[parent];
            basis[parent] = basis[node];
            basis[node] = tmp;
            node = parent;
            parent = parent(node);
        }
    }

    @Override
    public boolean insert(T t) {
        if(heapsize == basis.length) return false;
        basis[heapsize] = t;
        heapsize++;
        increase(heapsize - 1);
        return true;
    }

    @Override
    public T remove(int pos) {
        if(isEmpty() || pos < 0 || pos > heapsize) return null;
        T ret = basis[pos];
        //swap with last
        basis[pos] = basis[heapsize-1];
        basis[heapsize-1] = null;
        heapsize--;
        //compare with parent
        if(pos > 0 && basis[pos].compareTo(basis[parent(pos)]) > 0){
            increase(pos);
        } else {
            heapify(pos);
        }
        return ret;
    }

    @Override
    public T extractMax() {
        T ret = null;
        if(!isEmpty()){
            ret = basis[0];
            basis[0] = basis[heapsize-1];
            basis[heapsize-1] = null;
            heapsize--;
            heapify(0);
        }
        return ret;
    }

    private void heapify(int root) {
        int l = left(root);
        int r = right(root);
        int largest = root;
        if(l < heapsize && basis[l].compareTo(basis[largest]) > 0){
            largest = l;
        }
        if(r < heapsize && basis[r].compareTo(basis[largest]) > 0){
            largest = r;
        }
        if(largest != root){
            T tmp = basis[root];
            basis[root] = basis[largest];
            basis[largest] = tmp;
            heapify(largest);
        }
    }

    private int left(int root){
        return root * 2 + 1;
    }

    private int right(int root){
        return left(root) + 1;
    }

    private int parent(int node){
        return (node - 1) / 2;
    }

    public boolean isEmpty(){
        return heapsize == 0;
    }
}
