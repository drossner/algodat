package de.iisys.drossner.algodat.sprachbeispiel;

import java.util.stream.IntStream;

/**
 * created at 11.01.18
 *
 * @author drossner
 */
public class Beispiel {
    public static void main(String[] args){
        final int n = 3;
        int ergebnis = 0;
        for(int i = n; i > 0; i--){
            ergebnis += i;
        }
        System.out.println(ergebnis);
    }

    //für Fortgeschrittene:
    public static void kuerzer(){
        final int n = 3;
        System.out.println( IntStream.range(n, 0).sum() );
    }
}