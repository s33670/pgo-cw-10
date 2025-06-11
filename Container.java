public abstract class Container {
    protected static int c = 1;
    protected String numerSeryjny;
    protected double masaLadunku;
    protected final double wagaWlasna;
    protected final double ladownosc;
    protected final int wysokosc;
    protected final int glebokosc;

    public Container(String type, double wagaWlasna, double ladownosc, int wysokosc, int glebokosc) {
        this.numerSeryjny = "KON-" + type + "-" + c++;
        this.wagaWlasna = wagaWlasna;
        this.ladownosc = ladownosc;
        this.wysokosc = wysokosc;
        this.glebokosc = glebokosc;
        this.masaLadunku = 0;
    }

    public abstract void load(double weight) throws OverfillException;
    public abstract void unload();

    public String getSerialNumber() {
        return numerSeryjny;
    }

    public double getTotalWeight() {
        return  wagaWlasna + masaLadunku;
    }

    public String toString() {
        return numerSeryjny + " [load=" + masaLadunku + "kg, max=" +ladownosc + "kg]";
    }
}
