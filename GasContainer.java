public class GasContainer extends Container implements IHazardNotifier {

    private double pressure;

    public GasContainer(double ownWeight, double maxLoad, int height, int depth, double pressure) {
        super("G", ownWeight, maxLoad, height, depth);
        this.pressure = pressure;
    }

    @Override
    public void load(double weight) throws OverfillException {
        if (weight > ladownosc) {
            notifyHazard("Próba przeładowania gazu: " + numerSeryjny);
            throw new OverfillException("Przekroczono pojemność konteneru z gazem");
        }
        this.masaLadunku = weight;
    }

    @Override
    public void unload() {
        this.masaLadunku *= 0.05;
    }

    @Override
    public void notifyHazard(String message) {
        System.out.println("ZAGROŻENIE: " + message);
    }
}
