import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DBConnector.connect()) {

            // DAO
            ClientDAO clientDAO = new ClientDAO(conn);
            DriverDAO driverDAO = new DriverDAO(conn);
            CarDAO carDAO = new CarDAO(conn);
            TariffDAO tariffDAO = new TariffDAO(conn);
            ServiceDAO serviceDAO = new ServiceDAO(conn);
            OrderDAO orderDAO = new OrderDAO(conn);
            ReceiptDAO receiptDAO = new ReceiptDAO(conn);

            System.out.println("Connected.");

            // 1. Create objects
            Client client = new Client(1, "Ivan", "380631234567", "ivan@example.com", 0.05);
            Driver driver = new Driver(1, "Petro", "380501112233", "petro@example.com", "AB12345", 4.8, true);
            Car car = new Car(1, "AA1234BB", "Sedan", "Black", 4, 1);
            Tariff tariff = new Tariff(1, "Comfort", 40, 12, true);
            Service baggage = new Service(1, "Baggage", "Extra bag", "+", 30.0, false);

            // 2. Insert into DB
            clientDAO.insert(client);
            driverDAO.insert(driver);
            carDAO.insert(car);
            tariffDAO.insert(tariff);
            serviceDAO.insert(baggage);

            // 3. Create order
            Order order = new Order(0, client, driver, car, tariff,
                    "Odessa Center", "Shevchenko 92A", 8.5);
            order.addService(baggage);

            int orderId = orderDAO.insert(order);
            order.setOrderID(orderId);

            // 4. Generate receipt
            double finalPrice = order.calculateFinalPrice();
            Receipt receipt = new Receipt(0, order,
                    tariff.calculateCost(order.getDistance()),
                    finalPrice - tariff.calculateCost(order.getDistance()),
                    client.getDiscount(),
                    finalPrice);

            receiptDAO.insert(receipt);

            receipt.printReceipt();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
