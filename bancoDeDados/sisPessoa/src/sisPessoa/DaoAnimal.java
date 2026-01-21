package sisPessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoAnimal {

	public Animal buscarAnimalPorMatricula(String matricula) {

		Animal animal = null;

		String sql = "select matricula, nome, nometutor from animal where matricula = ?";

		FabricaDeConexoes fabrica = new FabricaDeConexoes();
		Connection conexao = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conexao = fabrica.criarConexaoSisPessoa();
			ps = conexao.prepareStatement(sql);
			ps.setString(1, matricula);

			rs = ps.executeQuery();

			if (rs.next()) {
				animal = new Animal(rs.getString("matricula"), rs.getString("nome"), rs.getString("nometutor"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (conexao != null)
					conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return animal;
	}

	public boolean deletarAnimalPorMatricula(String matricula) {

		boolean deletado = false;

		String comandoSqlDelete = "delete from animal where matricula = ?";

		FabricaDeConexoes fabricaConexoesAnimal = new FabricaDeConexoes();
		Connection conexaoSisAnimal = null;
		PreparedStatement preparaComando = null;

		try {
			conexaoSisAnimal = fabricaConexoesAnimal.criarConexaoSisPessoa();
			preparaComando = conexaoSisAnimal.prepareStatement(comandoSqlDelete);

			preparaComando.setString(1, matricula);

			int linhasAfetadas = preparaComando.executeUpdate();

			if (linhasAfetadas > 0) {
				deletado = true;
			}

		} catch (SQLException e) {
			System.out.println("erro ao deletar animal no banco");
			e.printStackTrace();
		} finally {
			try {
				if (preparaComando != null)
					preparaComando.close();
				if (conexaoSisAnimal != null)
					conexaoSisAnimal.close();
			} catch (SQLException e) {
				System.out.println("erro ao fechar a conexao no banco");
				e.printStackTrace();
			}
		}

		return deletado;
	}

	public boolean atualizarNoBanco(Animal animal) {

		boolean atualizado = false;

		String comandoSqlUpdate = "update animal set nome = ?, nometutor = ? where matricula = ?";

		FabricaDeConexoes fabricaConexoesAnimal = new FabricaDeConexoes();
		Connection conexaoSisAnimal = null;
		PreparedStatement preparaComando = null;

		try {
			conexaoSisAnimal = fabricaConexoesAnimal.criarConexaoSisPessoa();
			preparaComando = conexaoSisAnimal.prepareStatement(comandoSqlUpdate);

			preparaComando.setString(1, animal.getNome());
			preparaComando.setString(2, animal.getNomeTutor());
			preparaComando.setString(3, animal.getMatricula());

			int linhasAfetadas = preparaComando.executeUpdate();

			if (linhasAfetadas > 0) {
				atualizado = true;
			}

		} catch (SQLException e) {
			System.out.println("erro ao atualizar animal no banco");
			e.printStackTrace();
		} finally {
			try {
				if (preparaComando != null)
					preparaComando.close();
				if (conexaoSisAnimal != null)
					conexaoSisAnimal.close();
			} catch (SQLException e) {
				System.out.println("erro ao fechar a conexao no banco");
				e.printStackTrace();
			}
		}

		return atualizado;
	}

	public boolean salvarNoBanco(Animal animal) {

		boolean salvamento = false;

		String comandoSqlInsert = "insert into animal(matricula,nome,nometutor) values (?,?,?)";

		FabricaDeConexoes fabricaConexoesAnimal = new FabricaDeConexoes();

		Connection conexaoSisAnimal = null;

		PreparedStatement preparaComando = null;

		try {
			conexaoSisAnimal = fabricaConexoesAnimal.criarConexaoSisPessoa();
			preparaComando = conexaoSisAnimal.prepareStatement(comandoSqlInsert);

			preparaComando.setString(1, animal.getMatricula());
			preparaComando.setString(2, animal.getNome());
			preparaComando.setString(3, animal.getNomeTutor());

			salvamento = true;

			preparaComando.execute();

		} catch (SQLException e) {
			System.out.println("erro ao salvar animal  no banco");
			e.printStackTrace();
		} finally {

			try {
				if (conexaoSisAnimal != null) {
					conexaoSisAnimal.close();
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
