package de.iisys.drossner.algodat.uebungen;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GetRandPair {

    public static <T> Pair<T, T> getRandPair(T[] arr){
        //Es gibt verschiedene Möglichkeiten zwei verschiedene Zufallszahlen zu generieren -> google!
        List<Integer> randoms = IntStream.range(0, arr.length).boxed().collect(Collectors.toList());
        int index1, index2;
        index1 = randoms.remove((int) (Math.random() * randoms.size()));
        index2 = randoms.remove((int) (Math.random() * randoms.size()));

        return new Pair<>(arr[index1], arr[index2]);
    }

}
