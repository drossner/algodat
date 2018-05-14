package de.iisys.drossner.algodat.sort;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamQuicksort {

    public static <T extends Comparable<? super T>> List<T> sort(List<T> list) {
        if (list.size() < 1) return list;
        T piv = list.get(0);
        return
                Stream.of(
                        sort(list.subList(1, list.size()).stream()
                                .filter(elem -> elem.compareTo(piv) < 0)
                                .collect(Collectors.toList())),
                        Collections.singletonList(piv),
                        sort(list.subList(1, list.size()).stream()
                                .filter(elem -> elem.compareTo(piv) >= 0)
                                .collect(Collectors.toList()))
                )
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> liste =
        new Random()
                .ints(20, 0, 100)
                .boxed()
                .collect(Collectors.toList());

        sort(liste).forEach(System.out::println);
    }

}
