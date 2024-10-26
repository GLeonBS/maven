import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CadastroRepository {
    private Connection conexao;

    public CadastroRepository() {
        conexao = FabricaConexao.getConexao();
    }

    public void incluir(Cadastro cadastro){
        try{
            String sql = "INSERT INTO tab_cadastros(nome, idade) VALUES(?, ?)";

            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, cadastro.getNome());
            pst.setInt(2, cadastro.getIdade());

            pst.execute();
            System.out.println("Cadastro realizado com sucesso!");
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void alterar(Cadastro cadastro){
        try{
            String sql = "UPDATE public.tab_cadastros SET nome=?, idade=? WHERE id=?;";

            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setString(1, cadastro.getNome());
            pst.setInt(2, cadastro.getIdade());
            pst.setInt(3, cadastro.getId());

            pst.execute();
            System.out.println("Cadastro alterado com sucesso!");
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void excluir(Integer id){
        try{
            String sql = "DELETE FROM public.tab_cadastros WHERE id=?;";

            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);

            pst.execute();
            System.out.println("Cadastro excluído com sucesso!");
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Cadastro> listar(){
        List<Cadastro> cadastros = new ArrayList<>();
        try {
            String sql = "SELECT id, nome, idade FROM public.tab_cadastros;";
            PreparedStatement statement = conexao.prepareStatement(sql);

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Integer id = result.getInt("id");
                String nome = result.getString("nome");
                Integer idade = result.getInt("idade");

                Cadastro cadastro = new Cadastro();
                cadastro.setId(id);
                cadastro.setNome(nome);
                cadastro.setIdade(idade);

                cadastros.add(cadastro);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cadastros;
    }

    public Cadastro buscar(Integer id){

        Cadastro cadastro = null;

        try {
            String sql = "SELECT id, nome, idade FROM public.tab_cadastros WHERE id=?;";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                String nome = result.getString("nome");
                Integer idade = result.getInt("idade");

                cadastro = new Cadastro();
                cadastro.setId(id);
                cadastro.setNome(nome);
                cadastro.setIdade(idade);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cadastro;
    }
}
