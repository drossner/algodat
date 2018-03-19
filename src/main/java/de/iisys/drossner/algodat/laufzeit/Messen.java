package de.iisys.drossner.algodat.laufzeit;

import de.iisys.drossner.algodat.sort.MergeSortKt;

/**
 * created at 01.02.18
 *
 * @author drossner
 */
public class Messen {

    public static void main(String[] args) {
        int[] a = new int[10_000];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * (a.length * 10));
        }
        //aktuelle Zeit
        long start = System.currentTimeMillis();
        selectionSort(a); //50k to 100k
        //MergeSortKt.mergesort(a, 0, a.length); //for mergesort 20kk to 10kk
        long duration = System.currentTimeMillis() - start;

        System.out.println(duration/1000.0+"s");
    }


    public static void selectionSort(int[] array){
        for (int i = 0; i < array.length - 1; i++){
            int kleinste = i;
            for (int k = i + 1; k < array.length; k++){
                if(array[k] < array[kleinste]){
                    kleinste = k;
                }
            }
            if(kleinste != i){
                int tmp = array[i];
                array[i] = array[kleinste];
                array[kleinste] = tmp;
            }
        }
    }
}
