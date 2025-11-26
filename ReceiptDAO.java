import java.sql.*;

public class ReceiptDAO extends BaseDAO {

    public ReceiptDAO(Connection conn) {
        super(conn);
    }

    public void insert(Receipt r) throws SQLException {
        String sql =
                "INSERT INTO Receipt (orderID, basePrice, extrasPrice, discount, finalPrice, generatedAt) VALUES (?, ?, ?, ?, ?, ?)";

        executeUpdate(sql, r.getOrder().getOrderID(), r.getBasePrice(), r.getExtrasPrice(), r.getDiscount(), r.getFinalPrice(), Timestamp.valueOf(r.getGeneratedAt()));
    }
}
