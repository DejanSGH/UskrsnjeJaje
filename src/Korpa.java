import java.util.ArrayList;

public class Korpa {

    private String naziv;
    private int brojJaja;
    private ArrayList<Jaje> korpica;

    public Korpa(String naziv, int brojJaja) {
        this.naziv = naziv;
        this.brojJaja = brojJaja;
        this.korpica = new ArrayList<>();
    }

    public void dodaj(Jaje jaje){
        if(postojiLiJajeUKorpi(jaje)){
            System.out.println("Jaje vec postoji u korpi");
            return;
        }
        if(korpica.size() < brojJaja) {
            System.out.println("Dodato je jaje");
            korpica.add(jaje);
        }
        else{
            System.out.println("Korpica je puna");
        }

    }

    public void jajaUKorpi(){
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
        System.out.println("Pogresan indeks");
        return null;
    }

}
