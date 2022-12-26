import java.util.ArrayList;

public class Korpa {

    private String naziv;
    private int brojJaja;
    private ArrayList<Jaje> korpica;
    private int brojPobeda = 0;

    public Korpa(String naziv, int brojJaja) {
        this.naziv = naziv;
        this.brojJaja = brojJaja;
        this.korpica = new ArrayList<>();
    }

    public void dodaj(Jaje jaje){
        if(postojiLiJajeUKorpi(jaje)){
            return;
        }
        if(korpica.size() < brojJaja) {
            korpica.add(jaje);
        }

    }

    public void jajaUKorpi(){
        if(korpica.isEmpty()) {
            return;
        }
        for (int i = 0; i < korpica.size(); i++) {
            System.out.println(korpica.get(i));
        }
    }

    private boolean postojiLiJajeUKorpi(Jaje jaje){
        if(korpica.isEmpty()){
            return false;
        }
        for (int i = 0; i < korpica.size(); i++) {
            if(korpica.get(i).equals(jaje)){
                return true;
            }
        }
        return false;
    }

    public Jaje dohvatiJajeIzKorpice(int i){
        if(i < korpica.size()){
            return korpica.get(i);
        }
        return null;
    }

    public int ukupnoJajaUKorpici(){
        return korpica.size();
    }

    public Jaje uzmiNajbolje(Boja boja, Jaje.Velicina velicina) throws GNeuporedivi {
        Boja kriterijum = boja;
        int indeksSlicnogJajeta = 0;
        int slicnostJajeta = 765; // maksimalna razlika u odnosi izmedju crne i bele boje
        for (int i = 0; i < korpica.size(); i++) {
            if(velicina == korpica.get(i).getVelicina()){
                if(kriterijum.slicnost(korpica.get(i).getBoja()) < slicnostJajeta){
                    slicnostJajeta = kriterijum.slicnost(korpica.get(i).getBoja());
                    indeksSlicnogJajeta = i;
                }
            }
        }
        return dohvatiJajeIzKorpice(indeksSlicnogJajeta);
    }

    public String toString(){
        return "Korpa:" + this.naziv + " " + korpica.toString();
    }

    public ArrayList<Jaje> getKorpica() {
        return korpica;
    }

    public void setBrojPobeda(int brojPobeda) {
        this.brojPobeda++;
    }

    public int getBrojPobeda() {
        return brojPobeda;
    }
}
