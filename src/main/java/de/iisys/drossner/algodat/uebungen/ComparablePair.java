package de.iisys.drossner.algodat.uebungen;

public class ComparablePair<T extends Comparable<? super T>> extends Pair<T, T> {
    public ComparablePair(T val1, T val2) {
        super(val1, val2);
    }
    public T getMax(){
        int i = get1().compareTo(get2());
        if(i >= 0) return get1();
        return get2();
    }
}
