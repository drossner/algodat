package de.iisys.drossner.algodat.uebungen;

public class GenericsTest {

    public static void main(String[] args) {
        String[] strarr = {"Max", "Bernd", "Buch", "Auto", "Bahn", "Haus"};

        Pair<String, String> strpair = GetRandPair.getRandPair(strarr);

        System.out.println(
                "val1 = "+strpair.get1()+" / val2 = "+strpair.get2()
        );

        Fahrzeug[] fzgarr = {new Auto(4, false), new Auto(3, true),
                new Motorrad(2, "Kette")};

        ComparablePair<Fahrzeug> fzgpair = new ComparablePair<>(fzgarr[0], fzgarr[2]);

        System.out.println(
                "val1 = "+fzgpair.get1()+" / val2 = "+fzgpair.get2()
        );

        System.out.println(fzgpair.getMax());

    }


    private static class Fahrzeug implements Comparable<Fahrzeug>{
        int raeder;
        Fahrzeug(int raeder){
            this.raeder = raeder;
        }

        @Override
        public int compareTo(Fahrzeug o) {
            return this.raeder - o.raeder;
        }
    }

    private static class Auto extends Fahrzeug{
        boolean caprio;
        Auto(int raeder, boolean caprio){
            super(raeder);
            this.caprio = caprio;
        }

        @Override
        public String toString() {
            return "Auto{" +
                    "raeder=" + raeder +
                    ", caprio=" + caprio +
                    '}';
        }
    }

    private static class Motorrad extends Fahrzeug {
        String antrieb;
        Motorrad(int raeder, String antrieb) {
            super(raeder);
            this.antrieb = antrieb;
        }

        @Override
        public String toString() {
            return "Motorrad{" +
                    "raeder=" + raeder +
                    ", antrieb='" + antrieb + '\'' +
                    '}';
        }
    }

}
