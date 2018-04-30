package de.iisys.drossner.algodat.jcf;

import java.util.PriorityQueue;

public class HeapExample {

    public static void main(String[] args) {
        PriorityQueue<String> prio = new PriorityQueue<>();
        prio.add("Hans");
        prio.add("Peter");
        prio.add("Ziege");
        prio.add("Albrecht");

        System.out.println(prio.poll());
        System.out.println(prio.poll());
        System.out.println(prio.poll());
        System.out.println(prio.poll());
    }

}
