package de.iisys.drossner.algodat.sort;


import java.util.Arrays;

/**
 * Seite „Radixsort“. In: Wikipedia, Die freie Enzyklopädie.
 * Bearbeitungsstand: 2. Mai 2018, 20:45 UTC.
 * URL: https://de.wikipedia.org/w/index.php?title=Radixsort&oldid=177093499 (Abgerufen: 7. Mai 2018, 10:40 UTC)
 */
public class Radixsort {

    // Achtung: Integer ist in Java immer vorzeichenbehaftet (=signed).
    // Der folgende Code sortiert jedoch so, als ob der Datentyp int kein Vorzeichen hätte (=unsigned)
    // und funktioniert daher in Java nur bei positiven Zahlen.
    public static void radixSort(int[] a) {
        int     n;                             // Fachnummer
        int[]   nPart = new int[2];            // Anzahl der Elemente in den beiden Faechern
        int[][] part  = new int[2][a.length];  // die beiden Faecher haben die Groesse des Arrays a

        // Schleife ueber alle Bits der Schluessel (bei int: 32 Bit)
        for (int i=0; i<32; i++) {
            nPart[0] = 0;
            nPart[1] = 0;

            // Partitionierungsphase: teilt "a" auf die Faecher auf
            for (int j=0; j<a.length; j++) {
                n = (a[j]>>i)&1;              // ermittelt die Fachnummer: 0 oder 1
                part[n][nPart[n]++] = a[j];   // kopiert j-tes Element ins richtige Fach
            }

            // Sammelphase: kopiert die beiden Faecher wieder nach "a" zusammen
            System.arraycopy(part[0], 0, a, 0,        nPart[0]);
            System.arraycopy(part[1], 0, a, nPart[0], nPart[1]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1000, 998, 3, 12158, 65};
        radixSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

}
