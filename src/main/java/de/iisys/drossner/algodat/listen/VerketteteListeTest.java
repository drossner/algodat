package de.iisys.drossner.algodat.listen;

public class VerketteteListeTest {

    public static void main(String[] args) {
        CoolList<String> liste = new VerketteteListe<>();

        liste.insert("Hans");
        liste.insert("Meyer");
        liste.insert("Hubert");

        liste.print();

        System.out.println(
                liste.find((data) -> data.startsWith("H"))
        );

        System.out.println(
                liste.delete(data -> data.equals("Meyer"))
        );

        liste.print();

        System.out.println(
                liste.delete(data -> data.equals("Hans"))
        );

        liste.print();

        System.out.println(
                liste.delete(data -> data.equals("Hubert"))
        );

        liste.print();
    }

}
