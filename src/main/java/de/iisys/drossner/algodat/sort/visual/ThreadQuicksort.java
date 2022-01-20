package de.iisys.drossner.algodat.sort.visual;


import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;

public class ThreadQuicksort implements Sorter {

    private BiConsumer<Long, Long> update;
    private ExecutorService executor;
    private AtomicInteger count = new AtomicInteger(1);
    private BlockingQueue lock = new ArrayBlockingQueue(1);

    {
        executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    public void quicksort(int[] arr) {

        try {
            quicksort(arr, 0, arr.length);
            lock.take();
            executor.shutdown();
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) System.out.println("FEHLER");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void quicksort(int[] arr, int lo, int hi) throws InterruptedException {
        if (lo < hi - 1) {
            Thread.sleep(1);
            count.addAndGet(1);
            int mid = partition(arr, lo, hi);
            Runnable first = () -> {
                try {
                    quicksort(arr, lo, mid);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            Runnable second = () -> {
                try {
                    quicksort(arr, mid + 1, hi);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };

            if (mid - lo > 10) executor.submit(first);
            else first.run();
            if (hi - mid + 1 > 10) executor.submit(second);
            else second.run();
        } else {
            if (count.decrementAndGet() == 0) {
                try {
                    lock.put(count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        update.accept((long)lo, (long)hi);
    }

    private int partition(int[] arr, int lo, int hi) throws InterruptedException {
        int piv = arr[hi - 1];
        for (int i = lo; i <= hi - 2; i++) {
            Thread.sleep(1);
            if (arr[i] < piv) {
                swap(arr, i, lo++);
            }
            update.accept((long)i, (long)hi);
        }
        swap(arr, lo, hi - 1);
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
        this.quicksort(arr);
    }
}
