package de.iisys.drossner.algodat.sort;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class HeapSort {

    public static <T extends Comparable<? super T>> void sortBU(List<T> list){
        //copy in array
        Comparable[] arr = list.toArray(new Comparable[list.size()]);
        //build heap
        buildHeap(arr);

        //now sort
        for(int i = arr.length-1; i > 0; --i){
            //swap largest to end
            Comparable tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            //reheap
            bottomUp(arr, 0, i);
        }

        //copy back to list
        ListIterator<T> listit = list.listIterator();
        for(Object e : arr){
            listit.next();
            listit.set((T) e);
        }
    }

    public static <T extends Comparable<? super T>> void sort(List<T> list){
        //copy in array
        Comparable[] arr = list.toArray(new Comparable[list.size()]);
        //build heap
        buildHeap(arr);

        //now sort
        for(int i = arr.length-1; i > 0; --i){
            //swap largest to end
            Comparable tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            //reheap
            heapify(arr, 0, i);
        }

        //copy back to list
        ListIterator<T> listit = list.listIterator();
        for(Object e : arr){
            listit.next();
            listit.set((T) e);
        }
    }

    private static void bottomUp(Comparable[] arr, int root, int heapsize){
        //follow path down to leaf
        int next = root;
        do{
            int l = left(next);
            int r = right(next);
            if(l >= heapsize) break;
            else if(r >= heapsize){
                next = l;
            } else {
                next = arr[l].compareTo(arr[r]) > 0? l : r;
            }
        } while (true);

        //index next = leaf;
        increase(arr, next, arr[root]);
    }

    private static void heapify(Comparable[] arr, int root, int heapsize){
        int l = left(root);
        int r = right(root);
        int largest = root;
        if(l < heapsize && arr[l].compareTo(arr[largest]) > 0){
            largest = l;
        }
        if(r < heapsize && arr[r].compareTo(arr[largest]) > 0){
            largest = r;
        }
        if(largest != root){
            Comparable tmp = arr[root];
            arr[root] = arr[largest];
            arr[largest] = tmp;
            heapify(arr, largest, heapsize);
        }
    }

    private static void increase(Comparable[] arr, int start, Comparable val){
        int parent = parent(start);
        while(start > 0 && arr[start].compareTo(val) < 0){
            start = parent;
            parent = parent(start);
        }
        //start is position for value -> push path up to root, val on index start
        int current = start; //memorize start, use current in following while
        Comparable tmp1 = arr[current];
        Comparable tmp2;
        while(current > 0){
            tmp2 = arr[parent];
            arr[parent] = tmp1;
            tmp1 = tmp2;
            current = parent;
            parent = parent(current);
        }
        arr[start] = val;
    }

    private static void buildHeap(Comparable[] arr){
        for(int i = arr.length / 2 - 1; i >= 0; --i){
            heapify(arr, i, arr.length);
        }
    }

    private static int left(int root){
        return root * 2 + 1;
    }

    private static int right(int root){
        return left(root) + 1;
    }

    private static int parent(int node){
        return (node - 1) / 2;
    }
}
