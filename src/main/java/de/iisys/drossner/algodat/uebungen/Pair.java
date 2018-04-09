package de.iisys.drossner.algodat.uebungen;

public class Pair<K, V> {
    private K val1;
    private V val2;

    public Pair(K val1, V val2){
        this.val1 = val1;
        this.val2 = val2;
    }

    public K get1() {
        return val1;
    }

    public V get2() {
        return val2;
    }
}
