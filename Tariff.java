public class Tariff {
    private int tariffID;
    private String name;
    private double basePrice;
    private double pricePerKm;
    private boolean active;

    public Tariff(int tariffID, String name, double basePrice, double pricePerKm, boolean active) {
        this.tariffID = tariffID;
        this.name = name;
        this.basePrice = basePrice;
        this.pricePerKm = pricePerKm;
        this.active = active;
    }
    public double calculateCost(double distance) {
        return basePrice + distance * pricePerKm;
    }
    public int getTariffID() { return tariffID; }
    public String getName() { return name; }
    public double getBasePrice() { return basePrice; }
    public double getPricePerKm() { return pricePerKm; }
    public boolean isActive() { return active; }

    public double calculateBaseCost(double distance) { return basePrice + distance * pricePerKm; }
}
