import java.util.ArrayList;

public class Izlozba {

    private ArrayList<Korpa> korpe;
    private int brojPobeda;
    private boolean jelZapocetoTakmicenje = false;

    public Izlozba() {
        this.korpe = new ArrayList<>();
    }

    public void dodaj(Korpa korpa){

        if(this.jelZapocetoTakmicenje){
            return;
        }

        if(postojiLiKorpaUIzlozbi(korpa)){
            return;
        }
        else{
            korpe.add(korpa);
        }

    }
    private boolean postojiLiKorpaUIzlozbi(Korpa korpa){
        if(korpe.isEmpty()){
            return false;
        }
        for (int i = 0; i < korpe.size(); i++) {
            if(korpe.get(i).equals(korpa)){
                return true;
            }
        }
        return false;
    }

    private int brojKorpiNaIzlozbi(){
        return korpe.size();
    }

    public void zapocni(){
        this.jelZapocetoTakmicenje = true;
        for (Korpa k: korpe) {
            k.setBrojPobeda(0);
        }
    }

    public Jaje odrziKrug(Boja boja, Jaje.Velicina velicina)  {
        Korpa najboljaKorpa = korpe.get(0);
        Jaje najboljeJaje = najboljaKorpa.uzmiNajbolje(boja, velicina);
        for (Korpa k: korpe) {
            Jaje t = k.uzmiNajbolje(boja, velicina);
            if(t != null){
                if(najboljeJaje == null || t.getBoja().slicnost(boja) < najboljeJaje.getBoja().slicnost(boja)){
                    najboljeJaje = t;
                    najboljaKorpa = k;
                }
            }
        }
        najboljaKorpa.povecajBrojPobeda();
        return najboljeJaje;
    }

    public String toString(){
        //Korpa:Uskrsnja radost[Jaje_1:RGB(255,0,0)-MALO]-Broj_pobeda:0
        String str = "";
        for (int i = 0; i < korpe.size(); i++) {
            if(korpe.get(i).getBrojPobeda() > 0){
                str = "V:";
            }
            System.out.println(str + korpe.get(i).toString() + "-Broj_pobeda:" + korpe.get(i).getBrojPobeda() );
        }
        return "";
    }

}
