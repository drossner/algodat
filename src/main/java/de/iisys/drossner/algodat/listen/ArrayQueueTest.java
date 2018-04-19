package de.iisys.drossner.algodat.listen;

public class ArrayQueueTest {

    public static void main(String[] args) {
        Queue<String> qu = new ArrayQueue<>(4);
        qu.enqueue("Albrecht");
        qu.enqueue("Bertram");
        qu.enqueue("Cesar");
        qu.enqueue("Detlev");

        System.out.println("Should be false: "+qu.enqueue("overflow"));

        System.out.println(qu.dequeue());
        System.out.println(qu.dequeue());
        System.out.println(qu.dequeue());

        qu.enqueue("TEST");

        System.out.println(qu.dequeue());
        System.out.println(qu.dequeue());
        System.out.println("Should be null: "+qu.dequeue());


    }

}
