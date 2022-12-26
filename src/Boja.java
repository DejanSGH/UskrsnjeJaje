public class Boja implements Uporediv {

    // RGB
    private int r;
    private int g;
    private int b;


    public Boja(){

        this.r = 0;
        this.g = 0;
        this.b = 0;


    }

    public Boja(int r, int g, int b) {

        int[] vrednostiBoja = new int[]{r,b,g};

        for (int i = 0; i < vrednostiBoja.length; i++) {
            if(vrednostiBoja[i] > 255){
                vrednostiBoja[i] = 255;
            }
            else if (vrednostiBoja[i] < 0) {
                vrednostiBoja[i] = 0;
            }
            this.r = vrednostiBoja[0];
            this.g = vrednostiBoja[1];
            this.b = vrednostiBoja[2];
        }

    }

    @Override
    public boolean jednako(Uporediv u) throws GNeuporedivi {

        if(u instanceof Boja){
            Boja boja = (Boja)u;
            return (r == boja.r && g == boja.g && b == boja.b );
        }
        throw new GNeuporedivi();
    }

    public int slicnost(Boja b){

        return Math.abs(this.b - b.b) + Math.abs(this.r - b.r) + Math.abs(this.g - b.g);
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
