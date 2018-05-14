package de.iisys.drossner.algodat.sort;

import java.util.Arrays;
import java.util.Random;

public class RadixTest {

    public static void test(int[] arr){

        int[] bucket0 = new int[arr.length];
        int[] bucket1 = new int[arr.length];
        int index0, index1;

        for (int i = 0; i < 32; i++){
            index0 = 0;
            index1 = 0;

            for(int elem : arr){
                int z = (elem >> i) & 1;
                if(z == 0){
                    bucket0[index0++] = elem;
                } else {
                    bucket1[index1++] = elem;
                }
            }

            System.arraycopy(bucket0, 0, arr, 0, index0);
            System.arraycopy(bucket1, 0, arr, index0, index1);

        }

    }

    public static void main(String[] args) {

        int[] arr = new Random()
                .ints(40, 0, 100).toArray();

        test(arr);

        Arrays.stream(arr).forEach(System.out::println);
    }

}
