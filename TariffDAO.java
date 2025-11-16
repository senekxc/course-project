import java.sql.Connection;
import java.sql.SQLException;

public class TariffDAO extends BaseDAO {

    public TariffDAO(Connection conn) {
        super(conn);
    }

    public void insert(Tariff t) throws SQLException {
        String sql = "INSERT INTO Tariff (name, basePrice, pricePerKm, active) VALUES (?, ?, ?, ?)";
        executeUpdate(sql,
                t.getName(),
                t.getBasePrice(),
                t.getPricePerKm(),
                t.isActive()
        );
    }
}
