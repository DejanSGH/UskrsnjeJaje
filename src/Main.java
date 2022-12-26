public class Main {

    public static void main(String[] args) throws GNeuporedivi {

//        Boja crna = new Boja();
//        Boja crvena = new Boja(255,0,0);
//        Boja zelena = new Boja(0,255,0);
//        Boja plava = new Boja(0,0,255);
//        Boja bela = new Boja(crvena.dohvR(), zelena.dohvG(), plava.dohvB());

//        Boja b1 = new Boja(100,200,0);
//        Boja b2 = new Boja(150,100,20);
//
//        System.out.println(b1.slicnost(b2));

//        Jaje j1 = new Jaje(crvena, Jaje.Velicina.MALO);
//        Jaje j2 = new Jaje(zelena, Jaje.Velicina.SREDNJE);
//        Jaje j3 = new Jaje(plava, Jaje.Velicina.SREDNJE);
//        Jaje j4 = new Jaje(zelena, Jaje.Velicina.VELIKO);
//        Jaje j5 = new Jaje(zelena, Jaje.Velicina.VELIKO);

//        Jaje kriterijum = new Jaje(plava, Jaje.Velicina.VELIKO);
//
//        Korpa korpa = new Korpa("Test", 10);
//        korpa.dodaj(j1);
//        korpa.dodaj(j2);
//        korpa.dodaj(j3);
//        korpa.dodaj(j4);
//        korpa.dodaj(j5);
//        korpa.jajaUKorpi();
//        System.out.println(korpa.dohvatiJajeIzKorpice(1));
//        System.out.println(korpa.ukupnoJajaUKorpici());
//
//        System.out.println(korpa);
//
//        Jaje naj = korpa.uzmiNajbolje(new Boja(0, 100, 200), Jaje.Velicina.SREDNJE);
//        System.out.println("Jaje koje najbolje odgovara kriterijumima: " + naj);




//        try{
//            System.out.println(korpa.najslicnijeJaje(kriterijum));
//        }
//        catch(GNeuporedivi g) {
//        }
//        catch(Exception g) {
//            System.out.println(g);
//        }


        Boja crna = new Boja(); Boja crvena = new Boja(255, 0, 0); // R, G, B
        Boja zelena = new Boja(0, 255, 0); Boja plava = new Boja(0, 0, 255);
// dohvatanje pojedinacnih delova boje
        Boja bela = new Boja(crvena.dohvR(), zelena.dohvG(), plava.dohvB());
        Jaje j1 = new Jaje(crvena, Jaje.Velicina.MALO);
        Jaje j2 = new Jaje(zelena, Jaje.Velicina.SREDNJE);
        Jaje j3 = new Jaje(plava, Jaje.Velicina.SREDNJE);
        Korpa k1 = new Korpa("Uskrsnja radost", 3);
            k1.dodaj(j1); k1.dodaj(j2); k1.dodaj(j3);
// Neuspesno dodavanje jajeta - korpa je popunjena
            k1.dodaj(new Jaje(crvena, Jaje.Velicina.VELIKO));
// Uzimanje jajeta iz korpe koje najbolje odgovara zadatim kriterijumima
        Jaje naj = k1.uzmiNajbolje(new Boja(0, 100, 200), Jaje.Velicina.SREDNJE);
        System.out.println("Jaje koje najbolje odgovara kriterijumima: " + naj);
        Jaje j4 = new Jaje(bela, Jaje.Velicina.MALO);
        Jaje j5 = new Jaje(crna, Jaje.Velicina.SREDNJE);
        Korpa k2 = new Korpa("Minimalisticka korpa", 2);
            k2.dodaj(j4); k2.dodaj(j5);
// Neuspesno dodavanje jajeta - jaje vec postoji u korpi
            k2.dodaj(j4.clone());
        Izlozba i = new Izlozba();
        i.dodaj(k1); i.dodaj(k2);
        i.zapocni();
        System.out.println("*** Ispis korpi u izlozbi pre prvog kruga ***");
        System.out.print(i);
        Jaje pobednik1 = i.odrziKrug(crvena, Jaje.Velicina.SREDNJE);
        System.out.println("*** Ispis pobednickog jajeta i korpi u izlozbi nakon prvog kruga ***");
        System.out.println("Pobednik: " + pobednik1);
        System.out.print(i);
    }
}
