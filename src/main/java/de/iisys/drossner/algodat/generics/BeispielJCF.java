package de.iisys.drossner.algodat.generics;

import java.util.ArrayList;

public class BeispielJCF {
    private static class Auto{
        public Auto(String marke, int ps) {
            this.marke = marke;
            this.ps = ps;
        }
        String marke;
        int ps;
    }
    
    public static void main(String[] args) {
        //set generic type to 'Auto'
        ArrayList<Auto> autolist = new ArrayList<>();
        Auto aauto = new Auto("Audi", 68);
        Auto bauto = new Auto("Opel", 55);
        
        autolist.add(aauto);
        autolist.add(bauto);
        //no cast
        Auto tmp = autolist.get(1);
        System.out.println("tmp.marke = " + tmp.marke);
    }
}
