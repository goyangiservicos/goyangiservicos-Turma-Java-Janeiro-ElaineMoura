package bancoDadosDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entidade.SupervisorAuxiliar;

public class DaoSupervisorAuxiliar {

	public boolean salvarNoBanco(SupervisorAuxiliar supervisorAuxiliar) {

		boolean salvamento = false;

		String comandoSqlInsert = "insert into Supervisor_Auxiliar(cpf,nome,email) values (?,?,?)";

		FabricaDeConexoes fabricaConexoesSisFuncionario = new FabricaDeConexoes();

		Connection conexaoSisFuncionario = null;

		PreparedStatement preparaComando = null;

		try {
			conexaoSisFuncionario = fabricaConexoesSisFuncionario.criarConexaoSis_funcionario();
			preparaComando = conexaoSisFuncionario.prepareStatement(comandoSqlInsert);

			preparaComando.setString(1, supervisorAuxiliar.getCpf());
			preparaComando.setString(2, supervisorAuxiliar.getNome());
			preparaComando.setString(3, supervisorAuxiliar.getEmail());

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
