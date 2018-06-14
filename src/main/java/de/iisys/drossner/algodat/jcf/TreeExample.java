package de.iisys.drossner.algodat.jcf;

import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeExample {

    public static void main(String[] args) {
        Map<Integer, String> map = new TreeMap<>();
        NavigableMap<Integer, String> navmap = new TreeMap<>();
        SortedMap<Integer, String> sortedmap = new TreeMap<>();

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(4, "Südkorea");
        treeMap.put(1, "Brasilien");
        treeMap.put(5, "Spanien");
        treeMap.put(2, "Deutschland");
        treeMap.put(3, "Türkei");

        System.out.println(treeMap.lowerEntry(3).getValue());
        treeMap.tailMap(3).values().forEach(System.out::println);
    }

}
