package de.iisys.drossner.algodat.ggt;

/**
 * created at 26.01.18
 *
 * @author drossner
 */
public class Test {

    /**
     * Calculates the gcd.
     * @param p positive integer
     * @param q positive integer
     * @return the greatest common divisor of p and q
     */
    public static int gcd(int p, int q){
        //TODO: place your code here

        return 0;
    }

    public static void main(String[] args) {
        // test gcd
        boolean failed = false;
        for (int i = 0; i < 30; i++){
            int p = (int) (Math.random()*100);
            int q = (int) (Math.random()*60);
            if(Euklid.gcd(p, q) != gcd(p, q)){
                failed = true;
                System.out.println("failed for "+p+" and "+q+".");
            }
        }
        System.out.println("Test "+(failed? "failed" : "succeeded"));
    }

}
