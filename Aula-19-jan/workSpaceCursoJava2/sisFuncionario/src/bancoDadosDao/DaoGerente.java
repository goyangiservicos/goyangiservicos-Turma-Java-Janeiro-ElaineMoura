package bancoDadosDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entidade.Gerente;



public class DaoGerente {

	
	public boolean salvarNoBanco(Gerente gerente) {

		boolean salvamento = false;

		String comandoSqlInsert = "insert into gerente(cpf,nome,email) values (?,?,?)";

		FabricaDeConexoes fabricaConexoesSisFuncionario = new FabricaDeConexoes();

		Connection conexaoSisFuncionario = null;

		PreparedStatement preparaComando = null;

		try {
			conexaoSisFuncionario = fabricaConexoesSisFuncionario.criarConexaoSis_funcionario();
			preparaComando = conexaoSisFuncionario.prepareStatement(comandoSqlInsert);

			preparaComando.setString(1, gerente.getCpf());
			preparaComando.setString(2, gerente.getNome());
			preparaComando.setString(3, gerente.getEmail());

			salvamento = true;

			preparaComando.execute();

		} catch (SQLException e) {
			System.out.println("erro ao salvar pessoa no banco");
			e.printStackTrace();
		} finally {

			try {
				if (conexaoSisFuncionario != null) {
					conexaoSisFuncionario.close();
				}
				if (preparaComando != null) {
					preparaComando.close();

				}
			} catch (SQLException e) {
				System.out.println("erro ao fechar a conexao no banco");
				e.printStackTrace();
			}

		}

		return salvamento;
	}
}
