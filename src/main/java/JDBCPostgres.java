import java.sql.*;
import java.util.Properties;

public class JDBCPostgres {
    public static void main(String[] args) {
        try {
            // PreparedStatement realizar todos os comandos de alteração/manipulação de banco de dados
            // ResultSet buscar os dados do banco de dados
            String url = "jdbc:postgresql://localhost:5435/maven";
            Properties props = new Properties();
            props.setProperty("user", "postgres");
            props.setProperty("password", "postgres");
            //props.setProperty("ssl", "true");
            Connection conn = DriverManager.getConnection(url, props);

            String isert = "INSERT INTO tab_cadastros(nome, idade) VALUES(?, ?)";
            String nome = "Izabelly";
            Integer idade = 20;

            PreparedStatement pst = conn.prepareStatement(isert);
            pst.setString(1, nome);
            pst.setInt(2, idade);

            pst.execute();
            System.out.println("Cadastro realizado com sucesso!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
