package dao;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import model.Cargo;
import model.FuncionarioInterno;
import util.FabricaDeConexoes;

public class DaoFuncionarioInterno {

	// ================= INSERT =================
	public boolean salvar(FuncionarioInterno funcionarioInterno) {

		boolean salvamento = false;

		String comandoSqlInsert = "INSERT INTO funcionario_interno "
				+ "(cpf, nome, data_nascimento, matricula, cargo, salario, senha) " + "VALUES (?, ?, ?, ?, ?, ?, ?)";

		FabricaDeConexoes fabricaConexoesSisFuncionario = new FabricaDeConexoes();
		Connection conexaoSisFuncionario = null;
		PreparedStatement preparaComando = null;

		try {
			conexaoSisFuncionario = fabricaConexoesSisFuncionario.criarConexaoSis_funcionario();
			preparaComando = conexaoSisFuncionario.prepareStatement(comandoSqlInsert);

			preparaComando.setString(1, funcionarioInterno.getCpf());
			preparaComando.setString(2, funcionarioInterno.getNome());
			preparaComando.setDate(3,java.sql.Date.valueOf(funcionarioInterno.getDataNascimento()));
			preparaComando.setString(4, funcionarioInterno.getMatricula());
			preparaComando.setString(5, funcionarioInterno.getCargo().name());
			preparaComando.setBigDecimal(6, funcionarioInterno.getSalario());
			preparaComando.setString(7,Base64.getEncoder().encodeToString("123".getBytes(StandardCharsets.UTF_8)));
			salvamento = preparaComando.executeUpdate() > 0;

		} catch (SQLException e) {
			System.out.println("Erro ao salvar funcionario interno");
			e.printStackTrace();
		} finally {
			try {
				if (preparaComando != null)
					preparaComando.close();
				if (conexaoSisFuncionario != null)
					conexaoSisFuncionario.close();
			} catch (SQLException e) {
				System.out.println("Erro ao fechar conexao");
				e.printStackTrace();
			}
		}

		return salvamento;
	}

	// ================= LISTAR =================
	public List<FuncionarioInterno> listar() {

		String comandoSql = "SELECT * FROM funcionario_interno";

		FabricaDeConexoes fabricaConexoesSisFuncionario = new FabricaDeConexoes();
		Connection connection = null;
		PreparedStatement preparaOcomandoSQL = null;
		ResultSet resultadoDaTabelaDoBanco = null;

		List<FuncionarioInterno> listaFuncionarioInterno = new ArrayList<>();

		try {
			connection = fabricaConexoesSisFuncionario.criarConexaoSis_funcionario();
			preparaOcomandoSQL = connection.prepareStatement(comandoSql);
			resultadoDaTabelaDoBanco = preparaOcomandoSQL.executeQuery();

			while (resultadoDaTabelaDoBanco.next()) {
				FuncionarioInterno funcionarioInterno = new FuncionarioInterno();

				funcionarioInterno.setCpf(resultadoDaTabelaDoBanco.getString("cpf"));
				funcionarioInterno.setNome(resultadoDaTabelaDoBanco.getString("nome"));
				funcionarioInterno.setDataNascimento(resultadoDaTabelaDoBanco.getDate("data_nascimento").toLocalDate());
				funcionarioInterno.setMatricula(resultadoDaTabelaDoBanco.getString("matricula"));
				funcionarioInterno.setCargo(Cargo.valueOf(resultadoDaTabelaDoBanco.getString("cargo")));
				funcionarioInterno.setSalario(resultadoDaTabelaDoBanco.getBigDecimal("salario"));

				listaFuncionarioInterno.add(funcionarioInterno);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao listar funcionario interno");
			e.printStackTrace();
		} finally {
			try {
				if (resultadoDaTabelaDoBanco != null)
					resultadoDaTabelaDoBanco.close();
				if (preparaOcomandoSQL != null)
					preparaOcomandoSQL.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				System.out.println("Erro ao fechar conexao");
				e.printStackTrace();
			}
		}

		return listaFuncionarioInterno;
	}

	// ================= BUSCAR POR CPF =================
	public FuncionarioInterno buscarPorCpf(String cpf) {

		String comandoSql = "SELECT * FROM funcionario_interno WHERE cpf = ?";

		FabricaDeConexoes fabricaConexoesSisFuncionario = new FabricaDeConexoes();
		Connection conexaoSisFuncionario = null;
		PreparedStatement preparaComando = null;
		ResultSet resultado = null;

		FuncionarioInterno funcionarioInterno = null;

		try {
			conexaoSisFuncionario = fabricaConexoesSisFuncionario.criarConexaoSis_funcionario();
			preparaComando = conexaoSisFuncionario.prepareStatement(comandoSql);
			preparaComando.setString(1, cpf);

			resultado = preparaComando.executeQuery();

			if (resultado.next()) {
				funcionarioInterno = new FuncionarioInterno();
				funcionarioInterno.setCpf(resultado.getString("cpf"));
				funcionarioInterno.setNome(resultado.getString("nome"));
				funcionarioInterno.setDataNascimento(resultado.getDate("data_nascimento").toLocalDate());
				funcionarioInterno.setMatricula(resultado.getString("matricula"));
				funcionarioInterno.setCargo(Cargo.valueOf(resultado.getString("cargo")));
				funcionarioInterno.setSalario(resultado.getBigDecimal("salario"));
				funcionarioInterno.setSenha(resultado.getString("senha"));
			}

		} catch (SQLException e) {
			System.out.println("Erro ao buscar funcionario interno");
			e.printStackTrace();
		} finally {
			try {
				if (resultado != null)
					resultado.close();
				if (preparaComando != null)
					preparaComando.close();
				if (conexaoSisFuncionario != null)
					conexaoSisFuncionario.close();
			} catch (SQLException e) {
				System.out.println("Erro ao fechar conexao");
				e.printStackTrace();
			}
		}

		return funcionarioInterno;
	}

	// ================= DELETE =================
	public boolean deletar(String cpf) {

		boolean deletado = false;

		String comandoSqlDelete = "DELETE FROM funcionario_interno WHERE cpf = ?";

		FabricaDeConexoes fabricaConexoesSisFuncionario = new FabricaDeConexoes();
		Connection conexaoSisFuncionario = null;
		PreparedStatement preparaComando = null;

		try {
			conexaoSisFuncionario = fabricaConexoesSisFuncionario.criarConexaoSis_funcionario();
			preparaComando = conexaoSisFuncionario.prepareStatement(comandoSqlDelete);
			preparaComando.setString(1, cpf);

			deletado = preparaComando.executeUpdate() > 0;

		} catch (SQLException e) {
			System.out.println("Erro ao deletar funcionario interno");
			e.printStackTrace();
		} finally {
			try {
				if (preparaComando != null)
					preparaComando.close();
				if (conexaoSisFuncionario != null)
					conexaoSisFuncionario.close();
			} catch (SQLException e) {
				System.out.println("Erro ao fechar conexao");
				e.printStackTrace();
			}
		}

		return deletado;
	}

	public boolean atualizarFuncionarioInterno(FuncionarioInterno funcionarioInterno) {

		boolean atualizado = false;

		String comandoSqlUpdate = "UPDATE funcionario_interno SET nome = ?, data_nascimento = ?, matricula = ?, cargo = ?, salario = ? WHERE cpf = ?";

		FabricaDeConexoes fabricaConexoesSisFuncionario = new FabricaDeConexoes();
		Connection conexaoSisFuncionario = null;
		PreparedStatement preparaComando = null;

		try {
			conexaoSisFuncionario = fabricaConexoesSisFuncionario.criarConexaoSis_funcionario();
			preparaComando = conexaoSisFuncionario.prepareStatement(comandoSqlUpdate);

			preparaComando.setString(1, funcionarioInterno.getNome());
			preparaComando.setDate(2,java.sql.Date.valueOf(funcionarioInterno.getDataNascimento()));
			preparaComando.setString(3, funcionarioInterno.getMatricula());
			preparaComando.setString(4, funcionarioInterno.getCargo().name());
			preparaComando.setBigDecimal(5, funcionarioInterno.getSalario());
			preparaComando.setString(6, funcionarioInterno.getCpf()); // WHERE DO UPDATE COM CPF

			atualizado = preparaComando.executeUpdate() > 0;

		} catch (SQLException e) {
			System.out.println("Erro ao atualizar funcionario interno");
			e.printStackTrace();
		} finally {
			try {
				if (preparaComando != null)
					preparaComando.close();
				if (conexaoSisFuncionario != null)
					conexaoSisFuncionario.close();
			} catch (SQLException e) {
				System.out.println("Erro ao fechar conexao");
				e.printStackTrace();
			}
		}

		return atualizado;
	}
}