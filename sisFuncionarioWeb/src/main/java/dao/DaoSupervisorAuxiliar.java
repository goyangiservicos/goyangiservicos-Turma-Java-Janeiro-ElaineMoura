package dao;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import model.SupervisorAuxiliar;
import util.FabricaDeConexoes;


public class DaoSupervisorAuxiliar {

	public boolean salvarNoBanco(SupervisorAuxiliar supervisorAuxiliar) {

		boolean salvamento = false;

		String comandoSqlInsert = "insert into Supervisor_Auxiliar(cpf,nome,patio,senha) values (?,?,?,?)";

		FabricaDeConexoes fabricaConexoesSisFuncionario = new FabricaDeConexoes();

		Connection conexaoSisFuncionario = null;

		PreparedStatement preparaComando = null;

		try {
			conexaoSisFuncionario = fabricaConexoesSisFuncionario.criarConexaoSis_funcionario();
			preparaComando = conexaoSisFuncionario.prepareStatement(comandoSqlInsert);

			preparaComando.setString(1, supervisorAuxiliar.getCpf());
			preparaComando.setString(2, supervisorAuxiliar.getNome());
			preparaComando.setString(3, supervisorAuxiliar.getPatio());
			preparaComando.setString(4,
				    Base64.getEncoder()
				          .encodeToString("123".getBytes(StandardCharsets.UTF_8))
				);
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
	
	public boolean atualizarSupervisorAuxiliar(SupervisorAuxiliar supervisorAuxiliar) {

		boolean atualizado = false;

		String comandoSqlUpdate =
				"update supervisor_auxiliar set nome = ?, email = ? where cpf = ?";

		FabricaDeConexoes fabricaConexoesSisFuncionario = new FabricaDeConexoes();
		Connection conexaoSisFuncionario = null;
		PreparedStatement preparaComando = null;

		try {
			conexaoSisFuncionario = fabricaConexoesSisFuncionario.criarConexaoSis_funcionario();
			preparaComando = conexaoSisFuncionario.prepareStatement(comandoSqlUpdate);

			preparaComando.setString(1, supervisorAuxiliar.getNome());
			preparaComando.setString(2, supervisorAuxiliar.getPatio());
			preparaComando.setString(3, supervisorAuxiliar.getCpf()); // CPF só no WHERE

			preparaComando.executeUpdate();
			atualizado = true;

		} catch (SQLException e) {
			System.out.println("erro ao atualizar supervisor auxiliar");
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

		return atualizado;
	}

	public boolean deletarSupervisorAuxiliar(String cpf) {

		boolean deletado = false;

		String comandoSqlDelete = "delete from supervisor_auxiliar where cpf = ?";

		FabricaDeConexoes fabricaConexoesSisFuncionario = new FabricaDeConexoes();
		Connection conexaoSisFuncionario = null;
		PreparedStatement preparaComando = null;

		try {
			conexaoSisFuncionario = fabricaConexoesSisFuncionario.criarConexaoSis_funcionario();
			preparaComando = conexaoSisFuncionario.prepareStatement(comandoSqlDelete);

			preparaComando.setString(1, cpf);

			int linhasAfetadas = preparaComando.executeUpdate();

			if (linhasAfetadas > 0) {
				deletado = true;
			} else {
				deletado = false;
			}

			
			

		} catch (SQLException e) {
			System.out.println("erro ao deletar supervisor auxiliar");
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

		return deletado;
	}

}
