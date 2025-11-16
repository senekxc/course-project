import java.sql.Connection;
import java.sql.SQLException;

public class ServiceDAO extends BaseDAO {

    public ServiceDAO(Connection conn) {
        super(conn);
    }

    public void insert(Service s) throws SQLException {
        String sql = "INSERT INTO Service (name, description, effectType, effectValue, isPercent) VALUES (?, ?, ?, ?, ?)";
        executeUpdate(sql,
                s.getName(),
                s.getDescription(),
                s.getEffectType(),
                s.getEffectValue(),
                s.isPercent()
        );
    }
}
