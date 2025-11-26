import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dispatcher extends User {
    private String workShift;

    public Dispatcher(int userID, String name, String phoneNum, String email, String workShift) {
        super(userID, name, phoneNum, email);
        this.workShift = workShift;
    }

    public String getWorkShift() { return workShift; }

    public Order createOrder(int orderID, Client client, Car car, Tariff tariff, String pickup, String dropoff, double distance) {
        Order order = new Order(orderID, client, null, car, tariff, pickup, dropoff, distance);
        System.out.println("Dispatcher created order " + orderID + " for client " + client.getName());
        return order;
    }

    public void assignDriver(Order order, Driver driver, Connection conn) throws SQLException {
        order.setDriver(driver);
        order.setStatus(Order.OrderStatus.ASSIGNED);
        System.out.println("Dispatcher assigned driver " + driver.getName() + " to order " + order.getOrderID());
        String sql = "UPDATE `Order` SET driverID = ?, status = ? WHERE orderID = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, driver.getUserID());
            ps.setString(2, order.getStatus().name());
            ps.setInt(3, order.getOrderID());
            ps.executeUpdate();
        }
        driver.receiveOrder(order);
    }

    public void cancelOrder(Order order) { order.setStatus(Order.OrderStatus.CANCELLED); }
}
