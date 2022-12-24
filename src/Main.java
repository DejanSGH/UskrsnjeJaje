public class Main {

    public static void main(String[] args) {

        Boja crna = new Boja();
        Boja crvena = new Boja(255,0,0);
        Boja zelena = new Boja(0,255,0);
        Boja plava = new Boja(0,0,255);
        Boja bela = new Boja(crvena.dohvR(), zelena.dohvG(), plava.dohvB());

//        Boja b1 = new Boja(100,200,0);
//        Boja b2 = new Boja(150,100,20);
//
//        System.out.println(b1.slicnost(b2));

        Jaje j1 = new Jaje(crvena, Jaje.Velicina.VELIKO);
        Jaje j2 = new Jaje(plava, Jaje.Velicina.VELIKO);
        Jaje j4 = new Jaje(zelena, Jaje.Velicina.VELIKO);
        Jaje j5 = new Jaje(zelena, Jaje.Velicina.VELIKO);
        Jaje j3 = new Jaje(j1.clone());

        Korpa korpa = new Korpa("Test", 3);
        korpa.dodaj(j1);
        korpa.dodaj(j2);
        korpa.dodaj(j1);
        korpa.jajaUKorpi();
        System.out.println(korpa.dohvatiJajeIzKorpice(1));



//        try{
//            j3.slicnost(b2);
//        }
//        catch(GNeuporedivi g) {
//        }
//        catch(Exception g) {
//            System.out.println(g);
//        }

    }
}
