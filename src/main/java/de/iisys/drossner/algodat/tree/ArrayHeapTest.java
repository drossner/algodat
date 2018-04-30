package de.iisys.drossner.algodat.tree;

public class ArrayHeapTest {

    public static void main(String[] args) {
        Heap<String> heap = new ArrayHeap<>(5);
        heap.insert("Marta");
        heap.insert("Alfons");
        heap.insert("Zeppelin");
        heap.insert("Peter");
        heap.insert("Markus");

        System.out.println(heap.extractMax());
        System.out.println(heap.extractMax());
        System.out.println(heap.extractMax());
        System.out.println(heap.extractMax());
        System.out.println(heap.extractMax());
        System.out.println(heap.extractMax());

        heap.insert("Marta");
        heap.insert("Alfons");
        heap.insert("Zeppelin");
        heap.insert("Peter");
        heap.insert("Markus");

        System.out.println(heap.remove(2));
        System.out.println(heap.remove(1));
        heap.insert("Test");
        heap.insert("Qualle");

        System.out.println(heap.extractMax());
        System.out.println(heap.extractMax());
        System.out.println(heap.extractMax());
        System.out.println(heap.extractMax());
        System.out.println(heap.extractMax());
        System.out.println(heap.extractMax());
        System.out.println(heap.extractMax());

        Heap<String> testHeap = new ArrayHeap<>(
                new String[]{"Opa", "Mutter", "Vater", "Kind", "Schwester"}
                );
        System.out.println(testHeap.extractMax());
        System.out.println(testHeap.extractMax());
        System.out.println(testHeap.extractMax());
        System.out.println(testHeap.extractMax());
        System.out.println(testHeap.extractMax());
        System.out.println(testHeap.extractMax());
    }
}
