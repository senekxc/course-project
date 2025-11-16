import java.sql.Connection;
import java.sql.SQLException;

public class ClientDAO extends BaseDAO {

    public ClientDAO(Connection conn) {
        super(conn);
    }

    public void insert(Client c) throws SQLException {
        String sql = "INSERT INTO Client (name, phone, email) VALUES (?, ?, ?)";
        executeUpdate(sql,
                c.getName(),
                c.getPhoneNum(),
                c.getEmail()
        );
    }
}
