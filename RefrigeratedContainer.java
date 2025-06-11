public class RefrigeratedContainer extends Container {

    private String productType;
    private double temperatura;

    public RefrigeratedContainer(double ownWeight, double maxLoad, int height, int depth, String productType, double temperatura) {
        super("C", ownWeight, maxLoad, height, depth);
        this.productType = productType;
        this.temperatura = temperatura;
    }

    @Override
    public void load(double weight) throws OverfillException {
        if (weight > ladownosc) {
            throw new OverfillException("Zbyt duży ładunek dla kontenera chłodzącego: " + numerSeryjny);
        }
        this.masaLadunku = weight;
    }

    @Override
    public void unload() {
        this.masaLadunku = 0;
    }
}
