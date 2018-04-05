package de.iisys.drossner.algodat.listen;

import java.util.Date;

public class VerketteteListeTest2 {

    public static void main(String[] args){
        CoolList<Kunde> liste = new VerketteteListe<>();
        //new Date(int,int,int) is deprecated!!!!!! (just to keep this example simple)
        liste.insert(new Kunde(12345, "asd@hs.de", new Date(1990,1,1)));
        liste.insert(new Kunde(98745, "wda@hs.de", new Date(1995,8,5)));

        System.out.println(
             liste.find(data -> data.birthday.after(new Date(1991,1,1))).kundennummer
        );

        liste.print();
    }


    private static class Kunde{
        Kunde(int kn, String email, Date bd){
            this.kundennummer = kn;
            this.email = email;
            this.birthday = bd;
        }
        int kundennummer;
        String email;
        Date birthday;

        @Override
        public String toString() {
            return "Kunde{" +
                    "kundennummer=" + kundennummer +
                    '}';
        }
    }

}
