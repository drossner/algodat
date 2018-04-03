package de.iisys.drossner.algodat.adt;

public class EuklidIter implements Gcd{
    @Override
    public int calcGCD(int a, int b) {
        int temp = 0;
        int i = 0;

        while(a != b){
            if(a < b){
                temp = a;
                a = b;
                b = temp;
            }
            a = a - b;
        }
        return b;
    }
}
