import java.sql.Connection;
import java.sql.SQLException;

public class CarDAO extends BaseDAO {

    public CarDAO(Connection conn) {
        super(conn);
    }

    public void insert(Car c) throws SQLException {
        String sql = "INSERT INTO Car (plate, carType, color, seats, driverID) VALUES (?, ?, ?, ?, ?)";
        executeUpdate(sql, c.getPlate(), c.getCarType(), c.getColor(), c.getSeats(), c.getDriverID());
    }
}
