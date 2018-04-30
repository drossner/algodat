package de.iisys.drossner.algodat.uebungen;

public class Foo {
    static int fubar = 42;

    Foo getFoo() {
        return null;
    }

    public static void main(String args[]) {
        Foo foo = new Foo();
        System.out.println(foo.getFoo().fubar);

        for (int i = 0; i < 20; i++){
            System.out.println((i & (7)));
        }
    }
}
