public class Jaje implements Uporediv, Cloneable {

    private Boja boja;
    private static int id = 0; //ne radi ID
    enum Velicina{MALO, SREDNJE, VELIKO};

    private Velicina velicina;


    public Jaje(Jaje jaje){
        this.boja = jaje.boja;
        id = id;
        this.velicina = jaje.velicina;
    }

    public Jaje(Boja boja, Velicina v) {
        this.boja = boja;
        this.velicina = v;
        id++;
    }

    @Override
    public int slicnost(Object o1) throws GNeuporedivi {
        Jaje j = (Jaje)o1;
        if(!jelUporedivo(j)) throw new GNeuporedivi();

        if(this.boja.slicnost(j.boja) == 0 && this.velicina == j.velicina){
            System.out.println("Jaja su slicna");
            return 1;
        }
        System.out.println("Jaja nisu slicna");
        return 0;
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

    public int getId() {
        return id;
    }

    public Velicina getVelicina() {
        return velicina;
    }

    public String toString(){
        //Jaje_ид:боја-величина
        return "Jaje_" + this.id + ":" + this.boja + "-" + this.velicina;
    }

    public Jaje clone(){
        return new Jaje(this);
    }
}
