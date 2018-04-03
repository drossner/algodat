package de.iisys.drossner.algodat.adt;

public class Test {

    public static void main(String[] args) {
        Gcd gcd1 = new Euklid();
        Gcd gcd2 = new EuklidIter();

        System.out.print(gcd1.calcGCD(28, 66) == gcd2.calcGCD(28, 66));
    }

}
