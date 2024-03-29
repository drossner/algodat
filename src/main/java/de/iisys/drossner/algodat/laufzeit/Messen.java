package de.iisys.drossner.algodat.laufzeit;

import de.iisys.drossner.algodat.sort.MergeSortKt;

import java.util.Arrays;

/**
 * created at 01.02.18
 *
 * @author drossner
 */
public class Messen {

    public static void main(String[] args) {
        int[] a = new int[160_000];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * (a.length * 10));
        }
        //aktuelle Zeit
        long start = System.currentTimeMillis();
        //selectionSort(a); //50k to
        Arrays.sort(a);
        //MergeSortKt.mergesort(a, 0, a.length); //for mergesort 20kk to 10kk
        long duration = System.currentTimeMillis() - start;

        System.out.println(duration/1000.0+"s");
    }


    public static void selectionSort(int[] array){
        for (int i = 0; i < array.length - 1; i++){
            int lo = i;
            for (int k = i + 1; k < array.length; k++){
                if(array[k] < array[lo]){
                    lo = k;
                }
            }
            if(lo != i){
                int tmp = array[i];
                array[i] = array[lo];
                array[lo] = tmp;
            }
        }
    }
}
