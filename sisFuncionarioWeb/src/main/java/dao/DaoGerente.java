package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Gerente;
import util.FabricaDeConexoes;



public class DaoGerente {

	
	public boolean salvarNoBanco(Gerente gerente) {

		boolean salvamento = false;

		String comandoSqlInsert = "insert into gerente(cpf,nome,gerencia) values (?,?,?)";

		FabricaDeConexoes fabricaConexoesSisFuncionario = new FabricaDeConexoes();

		Connection conexaoSisFuncionario = null;

		PreparedStatement preparaComando = null;

		try {
			conexaoSisFuncionario = fabricaConexoesSisFuncionario.criarConexaoSis_funcionario();
			preparaComando = conexaoSisFuncionario.prepareStatement(comandoSqlInsert);

			preparaComando.setString(1, gerente.getCpf());
			preparaComando.setString(2, gerente.getNome());
			preparaComando.setString(3, gerente.getGerencia());

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

		public List<Gerente> listarGerenteDoBanco() {
			
			FabricaDeConexoes fabricaConexoesSisFuncionario = new FabricaDeConexoes();
			Connection connection = null; 
			PreparedStatement preparaOcomandoSQL = null; 

			String comandoSqlInsert = "select * from gerente"; 
			
			List<Gerente> listaGerente = new ArrayList<Gerente>();
			
			ResultSet resultadoDaTabelaDoBanco = null;
			
			try {
				
				connection = fabricaConexoesSisFuncionario.criarConexaoSis_funcionario();
				preparaOcomandoSQL = connection.prepareStatement(comandoSqlInsert);
				
				
				resultadoDaTabelaDoBanco = preparaOcomandoSQL.executeQuery();
				
				while(resultadoDaTabelaDoBanco.next()) {
					
					Gerente gerente = new Gerente();
					
					gerente.setCpf(resultadoDaTabelaDoBanco.getString("cpf"));
					
					gerente.setNome(resultadoDaTabelaDoBanco.getString("nome"));
					
					gerente.setGerencia(resultadoDaTabelaDoBanco.getString("gerencia"));
					
					listaGerente.add(gerente);
					
					
				}
				
				
			}catch (Exception e) {
				
			
			} finally { // Esse é obrigatorio
			try {
				if (connection != null) {
					connection.close();// Se objeto connectionBaseExemplo estiver aberto essa linha vai
													// encerrar
				}
				if (preparaOcomandoSQL != null) {// Se objeto preparaOcomandoSQL estiver aberto essa linha vai encerrar
					preparaOcomandoSQL.close();
				}

			} catch (Exception e2) {
				System.out.println("Não foi possivel fechar a conexão!!");
			}

		}

			
			return listaGerente;
		}
		
		public boolean deletarGerente(String cpf) {

			boolean deletar = false;

			String comandoSqlDelete = "DELETE FROM gerente WHERE cpf = ?";

			FabricaDeConexoes fabricaConexoesSisFuncionario = new FabricaDeConexoes();

			Connection conexaoSisFuncionario = null;
			PreparedStatement preparaComando = null;

			try {
				conexaoSisFuncionario = fabricaConexoesSisFuncionario.criarConexaoSis_funcionario();
				preparaComando = conexaoSisFuncionario.prepareStatement(comandoSqlDelete);

				preparaComando.setString(1, cpf);

				int linhasAfetadas = preparaComando.executeUpdate();

				if (linhasAfetadas > 0) {
					deletar = true;
				}

			} catch (SQLException e) {
				System.out.println("erro ao deletar gerente no banco");
				e.printStackTrace();
			} finally {
				try {
					if (preparaComando != null) {
						preparaComando.close();
					}
					if (conexaoSisFuncionario != null) {
						conexaoSisFuncionario.close();
					}
				} catch (SQLException e) {
					System.out.println("erro ao fechar a conexao no banco");
					e.printStackTrace();
				}
			}

			return deletar;
		}
		public boolean atualizarGerente(Gerente gerente) {

			boolean atualizado = false;

			String comandoSqlUpdate =
					"update gerente set nome = ?, gerencia = ? where cpf = ?";

			FabricaDeConexoes fabricaConexoesSisFuncionario = new FabricaDeConexoes();
			Connection conexaoSisFuncionario = null;
			PreparedStatement preparaComando = null;

			try {
				conexaoSisFuncionario = fabricaConexoesSisFuncionario.criarConexaoSis_funcionario();
				preparaComando = conexaoSisFuncionario.prepareStatement(comandoSqlUpdate);

				preparaComando.setString(1, gerente.getNome());
				preparaComando.setString(2, gerente.getGerencia());
				preparaComando.setString(3, gerente.getCpf()); // CPF só no WHERE

				preparaComando.executeUpdate();
				atualizado = true;

			} catch (SQLException e) {
				System.out.println("erro ao atualizar gerente");
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
		
		public Gerente buscarGerentePorCpf(String cpf) {

		    Gerente gerente = null;

		    String comandoSql = "SELECT * FROM gerente WHERE cpf = ?";

		    FabricaDeConexoes fabricaConexoesSisFuncionario = new FabricaDeConexoes();
		    Connection conexaoSisFuncionario = null;
		    PreparedStatement preparaComando = null;
		    ResultSet resultado = null;

		    try {
		        conexaoSisFuncionario = fabricaConexoesSisFuncionario.criarConexaoSis_funcionario();
		        preparaComando = conexaoSisFuncionario.prepareStatement(comandoSql);

		        preparaComando.setString(1, cpf);

		        resultado = preparaComando.executeQuery();

		        if (resultado.next()) {
		            gerente = new Gerente();
		            gerente.setCpf(resultado.getString("cpf"));
		            gerente.setNome(resultado.getString("nome"));
		            gerente.setGerencia(resultado.getString("gerencia"));
		        }

		    } catch (SQLException e) {
		        System.out.println("erro ao buscar gerente por cpf");
		        e.printStackTrace();
		    } finally {
		        try {
		            if (resultado != null) {
		                resultado.close();
		            }
		            if (preparaComando != null) {
		                preparaComando.close();
		            }
		            if (conexaoSisFuncionario != null) {
		                conexaoSisFuncionario.close();
		            }
		        } catch (SQLException e) {
		            System.out.println("erro ao fechar conexao no banco");
		            e.printStackTrace();
		        }
		    }

		    return gerente;
		}

	}