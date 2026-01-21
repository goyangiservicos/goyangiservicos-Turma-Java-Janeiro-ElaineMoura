package sisPessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoAnimal {

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
