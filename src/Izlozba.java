import java.util.ArrayList;

public class Izlozba {

    private ArrayList<Korpa> izlozba;
    private int brojPobeda;
    private boolean jelZapocetoTakmicenje = false;

    public Izlozba() {
        this.izlozba = new ArrayList<>();
    }

    public void dodaj(Korpa korpa){

        if(this.jelZapocetoTakmicenje){
            return;
        }

        if(postojiLiKorpaUIzlozbi(korpa)){
            return;
        }
        else{
            izlozba.add(korpa);
        }

    }
    private boolean postojiLiKorpaUIzlozbi(Korpa korpa){
        if(izlozba.isEmpty()){
            return false;
        }
        for (int i = 0; i < izlozba.size(); i++) {
            if(izlozba.get(i).equals(korpa)){
                return true;
            }
        }
        return false;
    }

    private int brojKorpiNaIzlozbi(){
        return izlozba.size();
    }

    public void zapocni(){
        this.jelZapocetoTakmicenje = true;
    }

    public Jaje odrziKrug(Boja boja, Jaje.Velicina velicina) throws GNeuporedivi {
        Korpa korpa = new Korpa("Pobednik iz svake korpe", izlozba.size());
        for (int i = 0; i < izlozba.size(); i++) {
            for (int j = 0; j < izlozba.get(i).getKorpica().size(); j++) {
                korpa.dodaj(izlozba.get(i).uzmiNajbolje(boja, velicina));
            }
        }
        Jaje pobednik = new Jaje(korpa.uzmiNajbolje(boja, velicina));
        for (int i = 0; i < izlozba.size(); i++) {
            for (int j = 0; j < izlozba.get(i).getKorpica().size(); j++) {
                if(izlozba.get(i).getKorpica().get(j).slicnost(pobednik) == 0){
                    izlozba.get(i).setBrojPobeda(1);
                }
            }
        }
        return new Jaje(korpa.uzmiNajbolje(boja, velicina));
    }

    public String toString(){
        //Korpa:Uskrsnja radost[Jaje_1:RGB(255,0,0)-MALO]-Broj_pobeda:0
        String str = "";
        for (int i = 0; i < izlozba.size(); i++) {
            if(izlozba.get(i).getBrojPobeda() > 0){
                str = "V:";
            }
            System.out.println(str + izlozba.get(i).toString() + "-Broj_pobeda:" + izlozba.get(i).getBrojPobeda() );
        }
        return "";
    }

}
