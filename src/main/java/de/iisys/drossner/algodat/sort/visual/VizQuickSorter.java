package de.iisys.drossner.algodat.sort.visual;


import java.util.function.BiConsumer;

public class VizQuickSorter implements Sorter {

    private BiConsumer<Long, Long> update;

    public void quicksort(int[] arr, int lo, int hi) throws InterruptedException {
        if(lo < hi - 1){
            Thread.sleep(1);
            int mid = partition(arr, lo, hi);
            quicksort(arr, lo, mid);
            quicksort(arr, mid+1, hi);
            update.accept((long)lo, (long)hi);
        }
    }

    private int partition(int[] arr, int lo, int hi) throws InterruptedException {
        int piv = arr[hi-1];
        for(int i = lo; i <= hi-2; i++){
            Thread.sleep(1);
            if(arr[i] < piv){
                swap(arr, i, lo++);
            }
            update.accept((long)i, (long)hi);
        }
        swap(arr, lo, hi-1);
        return lo;
    }


    private void swap(int[] arr, int i, int lo) throws InterruptedException {
        Thread.sleep(1);
        int tmp = arr[i];
        arr[i] = arr[lo];
        arr[lo] = tmp;
    }

    @Override
    public void sort(int[] arr, BiConsumer<Long, Long> update) throws InterruptedException {
        this.update = update;
        this.quicksort(arr, 0, arr.length);
    }
}
