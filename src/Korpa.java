public class Korpa {

    private String naziv;
    private int brojJaja;
    private Jaje[] jaja;
    private int brojPobeda = 0;

    public Korpa(String naziv, int kapacitet) {
        this.naziv = naziv;
        this.brojJaja = 0;
        this.jaja = new Jaje[kapacitet];
    }

    public void dodaj(Jaje jaje) throws GVecPostoji, GKorpaPuna {
        if(postojiLiJajeUKorpi(jaje)){
            throw new GVecPostoji();
        }
        if(jaja.length == brojJaja) {
            throw new GKorpaPuna();
        }
        this.jaja[brojJaja] = jaje;
        brojJaja++;

    }

//    public void jajaUKorpi(){
//        if(korpica.isEmpty()) {
//            return;
//        }
//        for (int i = 0; i < korpica.size(); i++) {
//            System.out.println(korpica.get(i));
//        }
//    }

    private boolean postojiLiJajeUKorpi(Jaje jaje) {
        for (int i = 0; i < brojJaja; i++) {
            try {
                if (jaja[i].jednako(jaje)){
                    return true;
                }
            }
            catch(Exception e){}
        }
        return false;
    }

    public Jaje dohvatiJajeIzKorpice(int i) throws GIndeks {
        if(i < jaja.length){
            return jaja[i];
        }
        throw new GIndeks();
    }

    public int ukupnoJajaUKorpici(){
        return jaja.length;
    }

    public Jaje uzmiNajbolje(Boja boja, Jaje.Velicina velicina) {
        Jaje najbolje = null;
        int najboljaSlicnost = 3 * 255;

        for (int i = 0; i < brojJaja; i++) {
            Jaje t = jaja[i];
            if(t.getVelicina() == velicina){
                if(t.getBoja().slicnost(boja) < najboljaSlicnost){
                    najboljaSlicnost = t.getBoja().slicnost(boja);
                    najbolje = t;
                }
            }
        }
        return najbolje;
    }

    public String toString(){
        return "Korpa:" + this.naziv + " " + jaja.toString();
    }

    public void povecajBrojPobeda() {
        this.brojPobeda++;
    }

    public int getBrojPobeda() {
        return brojPobeda;
    }

    public void setBrojPobeda(int brojPobeda) {
        this.brojPobeda = brojPobeda;
    }
}
