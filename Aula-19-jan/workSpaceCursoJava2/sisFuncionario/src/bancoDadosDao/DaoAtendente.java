package bancoDadosDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entidade.Atendente;
public class DaoAtendente {


	public boolean salvarNoBanco(Atendente atendente) {

		boolean salvamento = false;

		String comandoSqlInsert = "insert into atendente(cpf,nome,setor) values (?,?,?)";

		FabricaDeConexoes fabricaConexoesSisFuncionario = new FabricaDeConexoes();

		Connection conexaoSisFuncionario = null;

		PreparedStatement preparaComando = null;

		try {
			conexaoSisFuncionario = fabricaConexoesSisFuncionario.criarConexaoSis_funcionario();
			preparaComando = conexaoSisFuncionario.prepareStatement(comandoSqlInsert);

			preparaComando.setString(1, atendente.getCpf());
			preparaComando.setString(2, atendente.getNome());
			preparaComando.setString(3, atendente.getSetor());

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
