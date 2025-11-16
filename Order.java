import java.util.ArrayList;
import java.util.List;

public class Order {

    public enum OrderStatus { CREATED, ASSIGNED, IN_PROGRESS, COMPLETED, CANCELLED }

    private int orderID;
    private Client client;
    private Driver driver;
    private Car car;
    private Tariff tariff;
    private String pickup;
    private String dropoff;
    private double distance;
    private OrderStatus status;

    private List<Service> services = new ArrayList<>();

    public void addService(Service service) {
        services.add(service);
    }

    public List<Service> getServices() {
        return services;
    }

    public Order(int orderID, Client client, Driver driver, Car car, Tariff tariff,
                 String pickup, String dropoff, double distance) {
        this.orderID = orderID;
        this.client = client;
        this.driver = driver;
        this.car = car;
        this.tariff = tariff;
        this.pickup = pickup;
        this.dropoff = dropoff;
        this.distance = distance;
        this.status = OrderStatus.CREATED;
    }

    public double calculateFinalPrice() {
        double base = tariff.calculateCost(distance);
        double extras = 0;

        for (Service s : services) {
            extras += s.applyEffect(base);
        }

        return base + extras;
    }

    // ======== ГЕТТЕРИ =========

    public int getOrderID() { return orderID; }

    // ======== ДОДАНИЙ СЕТТЕР =========
    public void setOrderID(int id) {
        this.orderID = id;
    }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public Driver getDriver() { return driver; }
    public void setDriver(Driver driver) { this.driver = driver; }

    public Car getCar() { return car; }
    public void setCar(Car car) { this.car = car; }

    public Tariff getTariff() { return tariff; }
    public void setTariff(Tariff tariff) { this.tariff = tariff; }

    public String getPickup() { return pickup; }
    public void setPickup(String pickup) { this.pickup = pickup; }

    public String getDropoff() { return dropoff; }
    public void setDropoff(String dropoff) { this.dropoff = dropoff; }

    public double getDistance() { return distance; }
    public void setDistance(double distance) { this.distance = distance; }

    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }
}
