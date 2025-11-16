public class Test {
    public static void main(String[] args) {
        Client client = new Client(1, "Test", "0", "test@gmail.com", 0.1);
        Driver driver = new Driver(1, "Petro", "1", "petro@gmail.com", "123", 5.0, true);
        Car car = new Car(1, "AB1234AA", "Sedan", "Black", 4, 1);
        Tariff tariff = new Tariff(1, "Comfort", 40.0, 12.0, true);

        Order order = new Order(1, client, driver, car, tariff, "Odessa Center", "Shevchenko 92", 10.0);

        Service baggage = new Service(1, "Baggage", "large baggage", "+", 30.0, false);
        Service promo = new Service(2, "Promocode", "−10%", "-", 10.0, true);
        order.addService(baggage);
        order.addService(promo);

        double result = order.calculateFinalPrice();
        System.out.println("final price: " + result);
    }
}
