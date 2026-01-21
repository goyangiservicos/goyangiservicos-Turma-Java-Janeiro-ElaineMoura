package sisPessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoPessoa {

	// select para ver se realmente esta dando certo
	public Pessoa buscarPessoaPorCpf(String cpf) {

		Pessoa pessoa = null;

		String sql = "select cpf, nome, email from pessoa where cpf = ?";

		FabricaDeConexoes fabrica = new FabricaDeConexoes();
		Connection conexao = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conexao = fabrica.criarConexaoSisPessoa();
			ps = conexao.prepareStatement(sql);
			ps.setString(1, cpf);

			rs = ps.executeQuery();

			if (rs.next()) {
				pessoa = new Pessoa(rs.getString("cpf"), rs.getString("nome"), rs.getString("email"));
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

		return pessoa;
	}

	public boolean deletarPessoaPorCpf(String cpf) {

		boolean deletado = false;

		String comandoSqlDelete = "delete from pessoa where cpf = ?";

		FabricaDeConexoes fabricaConexoesPessoa = new FabricaDeConexoes();
		Connection conexaoSisPessoa = null;
		PreparedStatement preparaComando = null;

		try {
			conexaoSisPessoa = fabricaConexoesPessoa.criarConexaoSisPessoa();
			preparaComando = conexaoSisPessoa.prepareStatement(comandoSqlDelete);

			preparaComando.setString(1, cpf);

			int linhasAfetadas = preparaComando.executeUpdate();

			if (linhasAfetadas > 0) {
				deletado = true;
			}

		} catch (SQLException e) {
			System.out.println("erro ao deletar pessoa no banco");
			e.printStackTrace();
		} finally {
			try {
				if (preparaComando != null)
					preparaComando.close();
				if (conexaoSisPessoa != null)
					conexaoSisPessoa.close();
			} catch (SQLException e) {
				System.out.println("erro ao fechar a conexao no banco");
				e.printStackTrace();
			}
		}

		return deletado;
	}

	public boolean atualizarNoBanco(Pessoa pessoa) {

		boolean atualizado = false;

		String comandoSqlUpdate = "update pessoa set nome = ?, email = ? where cpf = ?";

		FabricaDeConexoes fabricaConexoesPessoa = new FabricaDeConexoes();
		Connection conexaoSisPessoa = null;
		PreparedStatement preparaComando = null;

		try {
			conexaoSisPessoa = fabricaConexoesPessoa.criarConexaoSisPessoa();
			preparaComando = conexaoSisPessoa.prepareStatement(comandoSqlUpdate);

			preparaComando.setString(1, pessoa.getNome());
			preparaComando.setString(2, pessoa.getEmail());
			preparaComando.setString(3, pessoa.getCpf());

			int linhasAfetadas = preparaComando.executeUpdate();

			if (linhasAfetadas > 0) {
				atualizado = true;
			}

		} catch (SQLException e) {
			System.out.println("erro ao atualizar pessoa no banco");
			e.printStackTrace();
		} finally {
			try {
				if (preparaComando != null)
					preparaComando.close();
				if (conexaoSisPessoa != null)
					conexaoSisPessoa.close();
			} catch (SQLException e) {
				System.out.println("erro ao fechar a conexao no banco");
				e.printStackTrace();
			}
		}

		return atualizado;
	}

	public boolean salvarNoBanco(Pessoa pessoa) {

		boolean salvamento = false;

		String comandoSqlInsert = "insert into pessoa(cpf,nome,email) values (?,?,?)";

		FabricaDeConexoes fabricaConexoesPessoa = new FabricaDeConexoes();

		Connection conexaoSisPessoa = null;

		PreparedStatement preparaComando = null;

		try {
			conexaoSisPessoa = fabricaConexoesPessoa.criarConexaoSisPessoa();
			preparaComando = conexaoSisPessoa.prepareStatement(comandoSqlInsert);

			preparaComando.setString(1, pessoa.getCpf());
			preparaComando.setString(2, pessoa.getNome());
			preparaComando.setString(3, pessoa.getEmail());

			salvamento = true;

			preparaComando.execute();

		} catch (SQLException e) {
			System.out.println("erro ao salvar pessoa no banco");
			e.printStackTrace();
		} finally {

			try {
				if (conexaoSisPessoa != null) {
					conexaoSisPessoa.close();
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
