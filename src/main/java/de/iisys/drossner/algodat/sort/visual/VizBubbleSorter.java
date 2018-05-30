package de.iisys.drossner.algodat.sort.visual;

import java.util.function.BiConsumer;

public class VizBubbleSorter implements Sorter {

    @Override
    public void sort(int[] arr, BiConsumer<Long, Long> update) throws InterruptedException {
        long step = 0;
        long max = arr.length * arr.length;
        for(int i = arr.length-1; i > 0; i--){
            for(int k = 0; k < i; k++){
                Thread.sleep(1);
                if(arr[k] > arr[k+1]) swap(arr, k, k+1);
                update.accept(step++, max);
            }
        }
    }

    private void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
