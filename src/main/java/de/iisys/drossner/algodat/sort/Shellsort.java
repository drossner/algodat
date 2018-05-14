package de.iisys.drossner.algodat.sort;

import java.util.Arrays;
import java.util.Random;

public class Shellsort {


    public void sort(int[] arr, int[] gaps){
        for (int gap : gaps){
            for(int i = gap; i < arr.length; i++){

                int tmp = arr[i];
                int k;
                for(k = i; k >= gap && arr[k-gap] > tmp; k -= gap){
                    arr[k] = arr[k - gap];
                }
                arr[k] = tmp;

            }
        }
    }

    public int[] gapGen(int count){
        int[] gaps = new int[count];
        gaps[count-1] = 1;

        for (int i = count - 1; i >= 1; i--){
            //Sedgewick '86 -> https://oeis.org/A036569
            gaps[i-1] = (int) (Math.pow(4, 1) + 3 * Math.pow(2, i-1) + 1);
        }

        return gaps;
    }

    public static void main(String[] args) {
        int[] arr = new Random()
                .ints(50, 0, 100).toArray();
        Shellsort shells = new Shellsort();
        shells.sort(arr, shells.gapGen(10));

        Arrays.stream(arr).forEach(System.out::println);
    }

}
