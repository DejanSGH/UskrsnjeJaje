public class Jaje implements Uporediv, Cloneable {

    private Boja boja;
    private static int brojac = 0;
    private  int zasebanID;
    enum Velicina{MALO, SREDNJE, VELIKO};

    private Velicina velicina;


    public Jaje(Jaje jajeOriginal){
        this.boja = new Boja(jajeOriginal.boja.dohvR(),jajeOriginal.boja.dohvG(),jajeOriginal.boja.dohvB());
        this.zasebanID = ++brojac;
        this.velicina = jajeOriginal.velicina;
    }

    public Jaje(Boja boja, Velicina v) {
        this.boja = boja;
        this.velicina = v;
        brojac++;
        this.zasebanID = brojac;
    }

    @Override
    public boolean jednako(Uporediv u) throws GNeuporedivi {

        if(u instanceof Jaje){
            Jaje jaje = (Jaje)u;
            return jaje.velicina == ((Jaje) u).velicina && boja.jednako(jaje.boja);

        }

        throw new GNeuporedivi();
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

    public Jaje clone() {
        return new Jaje(this);
//        Jaje novo = (Jaje)super.clone();
        // duboka kopija ispod
    }

}
