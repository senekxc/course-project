import java.sql.*;

public class OrderDAO extends BaseDAO {

    public OrderDAO(Connection conn) {
        super(conn);
    }

    public int insert(Order o) throws SQLException {
        String sql = "INSERT INTO `Order` (clientID, driverID, carID, tariffID, pickup, dropoff, distance) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, o.getClient().getClientID());
            ps.setInt(2, o.getDriver().getDriverID());
            ps.setInt(3, o.getCar().getCarID());
            ps.setInt(4, o.getTariff().getTariffID());
            ps.setString(5, o.getPickup());
            ps.setString(6, o.getDropoff());
            ps.setDouble(7, o.getDistance());

            ps.executeUpdate();

            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) return keys.getInt(1);
        }

        throw new SQLException("Order insert failed");
    }
}
