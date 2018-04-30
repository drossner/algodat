package de.iisys.drossner.algodat.jcf;

import java.util.HashMap;
import java.util.Map;

public class MapExample {

    public static void main(String[] args) {
        Map<Integer, String> wm16 = new HashMap<>(10, 0.5f);

        wm16.put(4, "Brasilien");
        wm16.put(1, "Deutschland");
        wm16.put(2, "Argentinien");
        wm16.put(5, "Kolumbien");
        wm16.put(3, "Niederlande");

        wm16.values().forEach(System.out::println);
        wm16.keySet().forEach(System.out::println);
        wm16.forEach((key, value) ->
                System.out.println(key + " -> " + value));
    }

}
