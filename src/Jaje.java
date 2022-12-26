public class Jaje implements Uporediv, Cloneable {

    private Boja boja;
    private static int brojac = 0;
    private  int zasebanID;
    enum Velicina{MALO, SREDNJE, VELIKO};

    private Velicina velicina;


    public Jaje(Jaje jaje){
        this.boja = jaje.boja;
        this.zasebanID = jaje.zasebanID;
        this.velicina = jaje.velicina;
    }

    public Jaje(Boja boja, Velicina v) {
        this.boja = boja;
        this.velicina = v;
        brojac++;
        this.zasebanID = brojac;
    }

    @Override
    public int slicnost(Object o1) throws GNeuporedivi {
        Jaje j = (Jaje)o1;
        if(!jelUporedivo(j)) throw new GNeuporedivi();
        int rezultat = this.boja.slicnost(j.boja);
        if(this.boja.slicnost(j.boja) == 0 && this.velicina == j.velicina){
            return rezultat;
        }
        return rezultat;
    }

    @Override
    public boolean jelUporedivo(Object o1) {
        if(Jaje.this.getClass().equals(o1.getClass())){
            return true;
        }
        return false;
    }


    public Boja getBoja() {
        return boja;
    }

    public int getZasebanID() {
        return zasebanID;
    }

    public Velicina getVelicina() {
        return velicina;
    }

    public String toString(){
        //Jaje_ид:боја-величина
        return "Jaje_" + zasebanID + ":" + this.boja + "-" + this.velicina;
    }

    public Jaje clone(){
        return new Jaje(this);
    }

}
