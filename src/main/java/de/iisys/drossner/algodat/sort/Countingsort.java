package de.iisys.drossner.algodat.sort;

import java.util.Arrays;
import java.util.function.Function;

public class Countingsort {

    /*
    Implementation note:
    This approach uses functional programming and java streams
    as a demonstration. It will have a performance impact (negative)
     */
    public static <T> void sort(T[] arr, Function<T, Integer> getKey){
        //bestimme Intervall von 0 bis maxKey
        int k = Arrays.stream(arr)
                .map(getKey)
                .max(Integer::compareTo)
                .orElse(0);
        int[] help = new int[k+1]; //automatisch mit 0 initalisiert
        //counting element occurence in arr, save in help
        Arrays.stream(arr)
                .map(getKey)
                .forEach((elem) -> help[elem]++);

        //calc addresses
        for(int i = 1; i < help.length; i++){
            help[i] += help[i-1];
        }
        T[] ret = (T[]) new Object[arr.length];
        for(int j = arr.length - 1; j >= 0; j--){
            ret[--help[getKey.apply(arr[j])]] = arr[j];
        }
        System.arraycopy(ret,0, arr,0, arr.length);
    }


    public static void main(String[] args) {
        //15_000_000
        //1_000
        Mensch[] arr = new Mensch[15_000_000];
        for (int i = 0; i < arr.length; i++){
            arr[i] = new Mensch("Max Muster", (int) (Math.random()*1_000_200_000));
        }
        Mensch[] baseline = new Mensch[arr.length];
        System.arraycopy(arr, 0, baseline, 0, arr.length);

        long start = System.currentTimeMillis();
        sort(arr, mensch -> mensch.age);
        System.out.println("Sort last "+(System.currentTimeMillis()-start)+"ms");

        boolean sorted = true;
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i].age > arr[i+1].age) sorted = false;
        }
        System.out.println("sorted = " + sorted);

        start = System.currentTimeMillis();
        Arrays.sort(baseline);
        System.out.println("Baselinesort last "+(System.currentTimeMillis()-start)+"ms");
    }

    private static class Mensch implements Comparable<Mensch>{
        private String name;
        private int age;
        public Mensch(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(Mensch o) {
            return Integer.compare(this.age, o.age);
        }
    }

}
