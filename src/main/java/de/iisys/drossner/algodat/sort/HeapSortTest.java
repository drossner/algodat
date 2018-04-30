package de.iisys.drossner.algodat.sort;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.UUID;

public class HeapSortTest {

    public static void main(String[] args) {
        List<String> liste = Arrays.asList(
          "Atzenbeck", "Ashauer", "Stöhr", "Roßner", "Scheidt", "Peinl", "Heym"
        );

        HeapSort.sort(liste);

        liste.forEach(System.out::println);

        //1000 -> 1
        //3_000_000 -> 0
        System.out.println("Init Array...");
        Comparable[] arr = new Comparable[1_000];
        for(int i = 0; i < arr.length; i++){
            arr[i] = new DifficultToCompare(UUID.randomUUID().toString());
            if((i*1.0/arr.length * 100) % 5 == 0) System.out.println((i*1.0/arr.length * 100)+"%");
        }
        Comparable arr2[] = new Comparable[arr.length];
        System.arraycopy(arr, 0, arr2, 0, arr.length);

        System.out.println("Generate Lists");
        List<? extends Comparable> benchNorm = Arrays.asList(arr);
        List<? extends Comparable> benchBott = Arrays.asList(arr2);

        System.out.println("Start warmup...");

        //warmup
        for(int i = 0; i < 1_000_000; i++){
            HeapSort.sort(liste);
            HeapSort.sortBU(liste);
        }
        System.out.println("Finished warmup");
        System.out.println("Start norm");
        long start = System.currentTimeMillis();
        HeapSort.sort(benchNorm);
        System.out.println("Normal lasts: "+ ((System.currentTimeMillis()-start)/1000.0)+"s");
        System.out.println("Start bott");
        start = System.currentTimeMillis();
        HeapSort.sortBU(benchBott);
        System.out.println("BottomUp lasts: "+ ((System.currentTimeMillis()-start)/1000.0)+"s");

        System.out.println("Check if norm is correct:");
        ListIterator<? extends Comparable> listit = benchNorm.listIterator();
        boolean correct = true;
        while(listit.hasNext()){
            Comparable a = listit.next();
            if(!listit.hasNext()) break;
            Comparable b = listit.next();
            if(a.compareTo(b) > 0){
                correct = false;
                break;
            }
            listit.previous();
        }
        System.out.println(correct);

        System.out.println("Check if bott is correct:");
        listit = benchBott.listIterator();
        correct = true;
        while(listit.hasNext()){
            Comparable a = listit.next();
            if(!listit.hasNext()) break;
            Comparable b = listit.next();
            if(a.compareTo(b) > 0){
                correct = false;
                break;
            }
            listit.previous();
        }
        System.out.println(correct);
    }


    public static class DifficultToCompare implements Comparable<DifficultToCompare>{

        String s;

        public DifficultToCompare(String s){
            this.s = s;
        }

        @Override
        public int compareTo(DifficultToCompare o) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return s.compareTo(o.s);
        }
    }
}
