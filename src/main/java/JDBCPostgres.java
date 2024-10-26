import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCPostgres {
    String url = "jdbc:postgresql://localhost/test";
    Properties props = new Properties();
    props.setProperty("user", "fred");
    props.setProperty("password", "secret");
    props.setProperty("ssl", "true");
    Connection conn = DriverManager.getConnection(url, props);
}
