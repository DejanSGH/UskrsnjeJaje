public class Boja implements Uporediv {

    // RGB
    private int r;
    private int g;
    private int b;
    private int[] vrednostiBoja;

    public Boja(){

        this.r = 0;
        this.g = 0;
        this.b = 0;

        this.vrednostiBoja = new int[]{r,b,g};

    }

    public Boja(int r, int g, int b) {

        this.vrednostiBoja = new int[]{r,b,g};

        for (int i = 0; i < this.vrednostiBoja.length; i++) {
            if(this.vrednostiBoja[i] > 255){
                this.vrednostiBoja[i] = 255;
            }
            else if (this.vrednostiBoja[i] < 0) {
                this.vrednostiBoja[i] = 0;
            }
            this.r = vrednostiBoja[0];
            this.g = vrednostiBoja[1];
            this.b = vrednostiBoja[2];
        }

    }

    @Override
    public int slicnost(Object o1) throws GNeuporedivi {

        Boja b1 = (Boja)o1;

        if(!jelUporedivo(b1)) throw new GNeuporedivi();

        int rezultat = 0;

        for (int i = 0; i < b1.vrednostiBoja.length; i++) {
            rezultat += Math.abs((this.vrednostiBoja[i] - b1.vrednostiBoja[i]));
        }
        return rezultat;
    }

    @Override
    public boolean jelUporedivo(Object o1){
        if(Boja.this.getClass().equals(o1.getClass())){
            return true;
        }
        return false;
    }

    public int dohvR() {
        return r;
    }

    public int dohvG() {
        return g;
    }

    public int dohvB() {
        return b;
    }

    public String toString(){
        return "RGB(" + this.r + ", " + this.g + ", " + this.b + ")";
    }
}
