package de.iisys.drossner.algodat.sort;

import java.util.Arrays;
import java.util.Random;

public class SimpleQuicksort {


    public static void quicksort(int[] arr, int lo, int hi){
        if(lo < hi - 1){
            int mid = partition(arr, lo, hi);
            quicksort(arr, lo, mid);
            quicksort(arr, mid+1, hi);
        }
    }

    private static int partition(int[] arr, int lo, int hi) {
        int piv = arr[hi-1];
        for(int i = lo; i <= hi-2; i++){
            if(arr[i] < piv){
                swap(arr, i, lo++);
            }
        }
        swap(arr, lo, hi-1);
        return lo;
    }


    public static void main(String[] args) {
        int[] arr = new Random().ints(20, 0, 100).toArray();
        quicksort(arr, 0, arr.length);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void swap(int[] arr, int i, int lo) {
        int tmp = arr[i];
        arr[i] = arr[lo];
        arr[lo] = tmp;
    }


}
