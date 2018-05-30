package de.iisys.drossner.algodat.sort.visual;

import java.util.function.BiConsumer;

public interface Sorter {

    void sort(int[] arr, BiConsumer<Long, Long> update) throws InterruptedException;

}
