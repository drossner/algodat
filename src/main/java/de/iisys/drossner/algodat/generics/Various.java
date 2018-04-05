package de.iisys.drossner.algodat.generics;

import java.util.ArrayList;
import java.util.List;

public class Various {

    public static void main(String[] args) {

        Number[] numbera = new Double[1]; //geht (Arrays sind kovariant>
        //List<Number> numberl = new ArrayList<Double>(); //geht nicht (invariant)

        List<? extends Number> extendsl = new ArrayList<Double>(); //(kovariant)
        //extendsl.add(1.0);          //geht nicht
        //extendsl.add(2);            //geht nicht
        //Double a = extendsl.get(0); //geht nicht
        Number b = extendsl.get(0); //geht


        List<? super Double> superl = new ArrayList<Number>(); //(kontravariant)
        superl.add(1.0);            //geht
        //superl.add(2);              //geht nicht
        //a = superl.get(0);          //geht nicht
        //b = superl.get(0);          //geht nicht
        Object c = superl.get(0);   //geht
    }
}
