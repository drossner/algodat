package de.iisys.drossner.algodat.sort;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = new Random().ints(100, 0, 1000).toArray();
        Arrays.stream(array).forEach(System.out::println);
        mergesort(array);
        System.out.println("============ Sortiert ===========");
        Arrays.stream(array).forEach(System.out::println);
    }

    public static void mergesort(int[] array){
        mergesort(array, 0, array.length);
    }

    private static void mergesort(int[] array, int start, int end) {
        int mid = (start + end) / 2;

        if(start < end - 1) {
            mergesort(array, start, mid);
            mergesort(array, mid, end);
            merge(array, start, mid, end);
        }
    }



    private static void merge(int[] array, int start, int mid, int end){
        int[] left = Arrays.copyOfRange(array, start, mid);
        int[] right = Arrays.copyOfRange(array, mid, end);

        int leftCursor = 0;
        int rightCursor = 0;

        for(int i = start; i < end ; i++) {
            int lowLeft = (leftCursor < left.length)? left[leftCursor] : Integer.MAX_VALUE;
            int lowRight = (rightCursor < right.length)? right[rightCursor] : Integer.MAX_VALUE;
            if(lowLeft <= lowRight) {
                array[i] = lowLeft;
                leftCursor++;
            } else {
                array[i] = lowRight;
                rightCursor++;
            }
        }
    }
}
