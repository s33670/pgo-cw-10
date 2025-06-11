public class LiquidContainer extends Container implements IHazardNotifier {

    private boolean czyNiebezpieczny;

    public LiquidContainer(double ownWeight, double maxLoad, int height, int depth, boolean czyNiebezpieczny) {
        super("L", ownWeight, maxLoad, height, depth);
        this.czyNiebezpieczny = czyNiebezpieczny;
    }

    @Override
    public void load(double weight) throws OverfillException {
        double limit = czyNiebezpieczny ? ladownosc*  0.5 : ladownosc * 0.9;
        if (weight > limit) {
            notifyHazard("Próba przeładowania niebezpiecznego kontenera: " + numerSeryjny);
            throw new OverfillException("Ładunek przekracza dopuszczalną granicę!");
        }
        this.masaLadunku = weight;
    }

    @Override
    public void unload() {
        this.masaLadunku = 0;
    }

    @Override
    public void notifyHazard(String message) {
        System.out.println("ZAGROŻENIE: " + message);
    }
}
