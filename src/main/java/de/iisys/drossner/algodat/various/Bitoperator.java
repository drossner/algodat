package de.iisys.drossner.algodat.various;

public class Bitoperator {

    public static void print(Object o){
        System.out.println(o);
    }


    public static void main(String[] args) {
        int x = 26;
        int z = 0b0001_1010;
        print(x == z);  //true

        int res = x << 3;
        print(res);     //208
        print(Integer.toBinaryString(res)); //1101 0000

        print(2 << 1);      //4   -> *2
        print(3 << 2);      //12  -> *2*2
        print(33 << 1);     //66  -> *2
        print(-14 << 1);    //-28 -> *2

        x = -26;
        z = (~z)+1; //11111....00110
        print(x == z);  //true

        res = x >> 2;
        print(res); //-7
        print(Integer.toBinaryString(res)); //111....001

        print(2 >> 1);      //1
        print(3 >> 2);      //0
        print(33 >> 1);     //16
        print(-14 >> 1);    //-7

        res = x >>> 3;
        print(Integer.toBinaryString(res)); //11111111111111111111111111100
        print(res); //536870908

    }

}
