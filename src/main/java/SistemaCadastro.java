import java.util.List;

public class SistemaCadastro {
    public static void main(String[] args) {
        FabricaConexao.conectar();
        CadastroRepository cadastroRepository = new CadastroRepository();

        //        Cadastro cadastro = cadastrar(cadastroRepository);
        //        alterar(cadastro, cadastroRepository);
        //        excluir(cadastroRepository, cadastro);

        listar(cadastroRepository);
        buscar(cadastroRepository);
    }

    private static void excluir(CadastroRepository cadastroRepository, Cadastro cadastro) {
        cadastroRepository.excluir(cadastro.getId());
    }

    private static void alterar(Cadastro cadastro, CadastroRepository cadastroRepository) {
        cadastro.setId(1);
        cadastro.setNome("Maria Julia da Silva");
        cadastro.setIdade(18);

        cadastroRepository.alterar(cadastro);
    }

    private static Cadastro cadastrar(CadastroRepository cadastroRepository) {
        Cadastro cadastro = new Cadastro();
        cadastro.setNome("Maria Julia");
        cadastro.setIdade(17);

        cadastroRepository.incluir(cadastro);
        return cadastro;
    }

    private static void listar(CadastroRepository cadastroRepository) {
        List<Cadastro> cadastros = cadastroRepository.listar();
        for (Cadastro cadastro : cadastros) {
            System.out.println(cadastro);
            System.out.println("==============================================");
        }
    }

    private static void buscar(CadastroRepository cadastroRepository) {
        Cadastro cadastro = cadastroRepository.buscar(1);
        if (cadastro != null) {
            System.out.println(cadastro);
        } else {
            System.out.println("Cadastro não encontrado!");
        }
    }
}
