package de.iisys.drossner.algodat.listen;

public class ArrayListTest {

    public static void main(String[] args) {
        ArrayList list = new ArrayList(5);

        list.add("Hund");
        list.add("Kind");
        list.add("Stein");

        list.print();

        list.add("TEST", 2);

        list.print();

        list.add("more");
        list.add("and more");
        list.add("and more more", 0);

        list.print();

        list.remove(3);

        list.print();

        list.remove(0);
        list.remove(4);

        list.print();

        list.add("neuer TEST");

        list.print();
    }

}
