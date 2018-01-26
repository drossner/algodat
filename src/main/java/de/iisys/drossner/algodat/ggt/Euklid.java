package de.iisys.drossner.algodat.ggt;

/**
 * created at 25.01.18
 *
 * @author drossner
 */
public class Euklid {

    public static void main(String[] args){
        final int a = 1337;
        final int b = 42;
        System.out.println(gcd(a, b));
        System.out.println(gcd2(a, b));
    }

    static int gcd(int p, int q){
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

    static int gcd2(int p, int q){
        return (q == 0)? p : gcd2(q, p % q);
    }

}
