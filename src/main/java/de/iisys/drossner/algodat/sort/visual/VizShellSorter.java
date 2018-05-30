package de.iisys.drossner.algodat.sort.visual;

import java.util.function.BiConsumer;

public class VizShellSorter implements Sorter{

    private BiConsumer<Long, Long> update;

    public void sort(int[] arr, int[] gaps) throws InterruptedException {
        for (int gap : gaps){
            for(int i = gap; i < arr.length; i++){
                Thread.sleep(1);
                int tmp = arr[i];
                int k;
                for(k = i; k >= gap && arr[k-gap] > tmp; k -= gap){
                    Thread.sleep(1);
                    arr[k] = arr[k - gap];
                    update.accept((long)k, (long)arr.length);
                }
                arr[k] = tmp;
                update.accept((long)i,(long)arr.length);
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

    @Override
    public void sort(int[] arr, BiConsumer<Long, Long> update) throws InterruptedException {
        this.update = update;
        this.sort(arr, gapGen(50));
    }
}
