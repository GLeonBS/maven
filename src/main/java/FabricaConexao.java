import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FabricaConexao {

    private static Connection conexao;

    public static void conectar(){
        try {
            if(conexao==null) {
                // PreparedStatement realizar todos os comandos de alteração/manipulação de banco de dados
                // ResultSet buscar os dados do banco de dados
                String url = "jdbc:postgresql://localhost:5435/maven";
                Properties props = new Properties();
                props.setProperty("user", "postgres");
                props.setProperty("password", "postgres");
                conexao = DriverManager.getConnection(url, props);
                System.out.println("Conexão realizada com sucesso!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConexao() {
        return conexao;
    }


}
