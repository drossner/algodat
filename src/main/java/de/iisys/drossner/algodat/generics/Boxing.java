package de.iisys.drossner.algodat.generics;

public class Boxing {

    static void boxing(Integer aint){
        System.out.println("aint = " + aint);
    }

    static Integer unboxing(){
        return 3; // int 3 wird als Integer 'boxed'
    }

    public static void main(String[] args) {
        boxing(4); //wird automatisch 'boxed'
        int a = unboxing(); //Integer wird 'unboxed'

        Integer test = 4; //autoboxing
        int test2 = test; //autounboxing
    }

}
