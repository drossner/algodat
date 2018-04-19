package de.iisys.drossner.algodat.uebungen;

import java.util.*;

public class IteratorTest {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>(
                Arrays.asList("Huber", "Meyer", "Müller", "Günther", "Gerda"));
        sort2(list);
        foreach(list);
    }

    public static <E> void forloop(List<E> list){
        for(E e: list){
            System.out.println(e);
        }
    }

    public static <E> void foreach(List<E> list){
        list.forEach(System.out::println);
    }

    public static <E> void iterator(List<E> list){
        Iterator<E> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it);
        }
    }

    public static void sort0(List<String> list){
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });
    }

    public static void sort1(List<String> list){
        list.sort((o1, o2) -> o1.length() - o2.length());
    }

    public static void sort2(List<String> list){
        list.sort(null);
    }

    public static void sort3(List<String> list){
        Collections.sort(list, (o1, o2) -> o1.compareToIgnoreCase(o2));
        Collections.sort(list);
    }

}
