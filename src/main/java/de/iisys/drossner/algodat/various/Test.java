package de.iisys.drossner.algodat.various;

public class Test {

     Container t;

    public static void main(String[] args) {
        Test a = new Test();
        a.t = new Container("abc");

        Container b = a.t;
        Container c = new Container("xyz");
        b = c;
        System.out.println(a.t.test);
    }

    private static class Container{
        private String test;
        private Container(String test){
            this.test = test;
        }
    }
}
