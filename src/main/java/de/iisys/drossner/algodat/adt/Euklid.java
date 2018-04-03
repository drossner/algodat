package de.iisys.drossner.algodat.adt;

public class Euklid implements Gcd{
    @Override
    public int calcGCD(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return calcGCD(q, r);
    }
}
