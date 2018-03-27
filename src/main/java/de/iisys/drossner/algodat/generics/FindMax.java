package de.iisys.drossner.algodat.generics;

public class FindMax<T extends Comparable<? super T>> {
    public T findMax(T o1, T o2){
        T max = o1;

        if(o1.compareTo(o2) < 0){
            max = o2;
        }

        return max;
    }


    public static void main(String[] args) {
        FindMax<Book> maxtester = new FindMax<>();
        EBook b1 = new EBook("Die Blechtrommel", 602);
        EBook b2 = new EBook("Die Leiden des jungen Werther", 227);

        System.out.println(maxtester.findMax(b1, b2).title);
    }
}
