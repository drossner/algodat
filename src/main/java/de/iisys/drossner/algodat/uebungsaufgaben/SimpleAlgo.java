package de.iisys.drossner.algodat.uebungsaufgaben;

public class SimpleAlgo {

    public static String doSomething(int i){
        int k = i;
        String s = "";
        for (; k > 0 ; k--) {
            s = s + (k*k)+", ";
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(doSomething(10));
    }


}
