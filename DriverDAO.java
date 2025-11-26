import java.sql.Connection;
import java.sql.SQLException;

public class DriverDAO extends BaseDAO {

    public DriverDAO(Connection conn) {
        super(conn);
    }

    public void insert(Driver d) throws SQLException {
        String sql = "INSERT INTO Driver (name, licenseNo, rating, active) VALUES (?, ?, ?, ?)";
        executeUpdate(sql, d.getName(), d.getLicenseNo(), d.getRating(), d.isActive());
    }
}
