package de.iisys.drossner.algodat.listen;

public class VerketteteListeTest {

    public static void main(String[] args) {
        CoolList<String> liste = new VerketteteListe<>();

        liste.insert("Hans");
        liste.insert("Meyer");
        liste.insert("Hubert");
        liste.insert("Test", 2);
        liste.insert("Anfang", 0);

        liste.print();

        System.out.println("find starts with H: "+
                liste.find((data) -> data.startsWith("H"))
        );

        System.out.println("delete equals Meyer: "+
                liste.delete(data -> data.equals("Meyer"))
        );

        liste.print();

        System.out.println("delete equals Hans: "+
                liste.delete(data -> data.equals("Hans"))
        );

        liste.print();

        System.out.println("delete equals Hubert: "+
                liste.delete(data -> data.equals("Hubert"))
        );

        liste.print();
    }

}
