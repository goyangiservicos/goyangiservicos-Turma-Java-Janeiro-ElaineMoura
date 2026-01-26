package bancoDadosDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.SupervisorAuxiliar;

public class DaoSupervisorAuxiliar {

	public boolean salvarNoBanco(SupervisorAuxiliar supervisorAuxiliar) {

		boolean salvamento = false;

		String comandoSqlInsert = "insert into Supervisor_Auxiliar(cpf,nome,patio) values (?,?,?)";

		FabricaDeConexoes fabricaConexoesSisFuncionario = new FabricaDeConexoes();

		Connection conexaoSisFuncionario = null;

		PreparedStatement preparaComando = null;

		try {
			conexaoSisFuncionario = fabricaConexoesSisFuncionario.criarConexaoSis_funcionario();
			preparaComando = conexaoSisFuncionario.prepareStatement(comandoSqlInsert);

			preparaComando.setString(1, supervisorAuxiliar.getCpf());
			preparaComando.setString(2, supervisorAuxiliar.getNome());
			preparaComando.setString(3, supervisorAuxiliar.getPatio());

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

	public List<SupervisorAuxiliar> listarSupervisorAuxiliar() {

		FabricaDeConexoes fabricaConexoesSisFuncionario = new FabricaDeConexoes();
		Connection connection = null;
		PreparedStatement preparaOcomandoSQL = null;

		String comandoSqlInsert = "select * from supervisor_auxiliar";

		List<SupervisorAuxiliar> listaSupervisorAuxiliar = new ArrayList<SupervisorAuxiliar>();

		ResultSet resultadoDaTabelaDoBanco = null;

		try {

			connection = fabricaConexoesSisFuncionario.criarConexaoSis_funcionario();
			preparaOcomandoSQL = connection.prepareStatement(comandoSqlInsert);

			resultadoDaTabelaDoBanco = preparaOcomandoSQL.executeQuery();

			while (resultadoDaTabelaDoBanco.next()) {

				SupervisorAuxiliar supervisorAuxiliar = new SupervisorAuxiliar();

				supervisorAuxiliar.setCpf(resultadoDaTabelaDoBanco.getString("cpf"));
				supervisorAuxiliar.setNome(resultadoDaTabelaDoBanco.getString("nome"));
				supervisorAuxiliar.setPatio(resultadoDaTabelaDoBanco.getString("patio"));

				listaSupervisorAuxiliar.add(supervisorAuxiliar);

			}

		} catch (Exception e) {

		} finally { // obrigatorio
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparaOcomandoSQL != null) {
					preparaOcomandoSQL.close();
				}

			} catch (Exception e2) {
				System.out.println("Não foi possivel fechar a conexao");
			}

		}

		return listaSupervisorAuxiliar;
	}

}
