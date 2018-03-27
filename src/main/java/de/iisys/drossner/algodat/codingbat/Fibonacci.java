package de.iisys.drossner.algodat.codingbat;

public class Fibonacci {

    public int fib(int n){
        if(n < 1) return -1;
        if(n == 1) return 0;
        if(n == 2) return 1;
        return fib(n-2) + fib(n-1);
    }

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        System.out.println("4: "+fib.fib(4));
        System.out.println("9: "+fib.fib(9));
        System.out.println("10: "+fib.fib(10));
        System.out.println("15: "+fib.fib(15));
    }

}
