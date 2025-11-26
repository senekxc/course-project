public class Service {

    private int serviceID;
    private String name;
    private String description;
    private String effectType;
    private double effectValue;
    private boolean isPercent;

    public Service(int serviceID, String name, String description,
                   String effectType, double effectValue, boolean isPercent) {
        this.serviceID = serviceID;
        this.name = name;
        this.description = description;
        this.effectType = effectType;
        this.effectValue = effectValue;
        this.isPercent = isPercent;
    }

    public int getServiceID() { return serviceID; }

    public String getName() { return name; }

    public String getDescription() { return description; }

    public String getEffectType() { return effectType; }

    public double getEffectValue() { return effectValue; }

    public boolean isPercent() { return isPercent; }

    public double applyEffect(double amount) {
        if (isPercent) {
            double delta = amount * (effectValue / 100.0);
            return effectType.equals("+") ? amount + delta : amount - delta;
        } else {
            return effectType.equals("+") ? amount + effectValue : amount - effectValue;
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
