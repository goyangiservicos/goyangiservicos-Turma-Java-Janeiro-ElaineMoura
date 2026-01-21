package sisPessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoAnimal {

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
