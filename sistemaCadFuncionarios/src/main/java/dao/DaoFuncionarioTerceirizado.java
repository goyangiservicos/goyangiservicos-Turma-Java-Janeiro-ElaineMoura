package dao;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import model.Funcao;
import model.FuncionarioTerceirizado;
import util.FabricaDeConexoes;

public class DaoFuncionarioTerceirizado {

    // ================= INSERT =================
    public boolean salvarNoBanco(FuncionarioTerceirizado funcionarioTerceirizado) {

        boolean salvamento = false;

        String comandoSqlInsert =
            "INSERT INTO funcionario_terceirizado " +
            "(cpf, nome, data_nascimento, funcao, empresa, horas_trabalhadas, senha) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?)";

        FabricaDeConexoes fabricaConexoesSisFuncionario = new FabricaDeConexoes();
        Connection conexaoSisFuncionario = null;
        PreparedStatement preparaComando = null;

        try {
            conexaoSisFuncionario = fabricaConexoesSisFuncionario.criarConexaoSis_funcionario();
            preparaComando = conexaoSisFuncionario.prepareStatement(comandoSqlInsert);

            preparaComando.setString(1, funcionarioTerceirizado.getCpf());
            preparaComando.setString(2, funcionarioTerceirizado.getNome());
            preparaComando.setDate(
                3,
                java.sql.Date.valueOf(funcionarioTerceirizado.getDataNascimento())
            );
            preparaComando.setString(4, funcionarioTerceirizado.getFuncao().name());
            preparaComando.setString(5, funcionarioTerceirizado.getEmpresa());
            preparaComando.setBigDecimal(6, funcionarioTerceirizado.getHorasTrabalhadas());
            preparaComando.setString(7,Base64.getEncoder().encodeToString("123".getBytes(StandardCharsets.UTF_8))
            );

            salvamento = preparaComando.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao salvar funcionario terceirizado");
            e.printStackTrace();
        } finally {
            try {
                if (preparaComando != null) preparaComando.close();
                if (conexaoSisFuncionario != null) conexaoSisFuncionario.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexao");
                e.printStackTrace();
            }
        }

        return salvamento;
    }
 // ================= BUSCAR POR CPF =================
    public FuncionarioTerceirizado buscarPorCpf(String cpf) {

        String comandoSql = "SELECT * FROM funcionario_terceirizado WHERE cpf = ?";

        FabricaDeConexoes fabricaConexoesSisFuncionario = new FabricaDeConexoes();
        Connection conexaoSisFuncionario = null;
        PreparedStatement preparaComando = null;
        ResultSet resultado = null;

        FuncionarioTerceirizado funcionarioTerceirizado = null;

        try {
            conexaoSisFuncionario = fabricaConexoesSisFuncionario.criarConexaoSis_funcionario();
            preparaComando = conexaoSisFuncionario.prepareStatement(comandoSql);
            preparaComando.setString(1, cpf);

            resultado = preparaComando.executeQuery();

            if (resultado.next()) {
                funcionarioTerceirizado = new FuncionarioTerceirizado();
                funcionarioTerceirizado.setCpf(resultado.getString("cpf"));
                funcionarioTerceirizado.setNome(resultado.getString("nome"));
                funcionarioTerceirizado.setDataNascimento(
                    resultado.getDate("data_nascimento").toLocalDate()
                );
                funcionarioTerceirizado.setFuncao(
                    Funcao.valueOf(resultado.getString("funcao"))
                );
                funcionarioTerceirizado.setEmpresa(resultado.getString("empresa"));
                funcionarioTerceirizado.setHorasTrabalhadas(
                    resultado.getBigDecimal("horas_trabalhadas")
                );
                funcionarioTerceirizado.setSenha(resultado.getString("senha"));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar funcionario terceirizado");
            e.printStackTrace();
        } finally {
            try {
                if (resultado != null) resultado.close();
                if (preparaComando != null) preparaComando.close();
                if (conexaoSisFuncionario != null) conexaoSisFuncionario.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexao");
                e.printStackTrace();
            }
        }

        return funcionarioTerceirizado;
    }
    // ================= LISTAR =================
    public List<FuncionarioTerceirizado> listarFuncionarioTerceirizado() {

        String comandoSql = "SELECT * FROM funcionario_terceirizado";

        FabricaDeConexoes fabricaConexoesSisFuncionario = new FabricaDeConexoes();
        Connection connection = null;
        PreparedStatement preparaOcomandoSQL = null;
        ResultSet resultadoDaTabelaDoBanco = null;

        List<FuncionarioTerceirizado> lista = new ArrayList<>();

        try {
            connection = fabricaConexoesSisFuncionario.criarConexaoSis_funcionario();
            preparaOcomandoSQL = connection.prepareStatement(comandoSql);
            resultadoDaTabelaDoBanco = preparaOcomandoSQL.executeQuery();

            while (resultadoDaTabelaDoBanco.next()) {

                FuncionarioTerceirizado funcionarioTerceirizado =
                        new FuncionarioTerceirizado();

                funcionarioTerceirizado.setCpf(
                        resultadoDaTabelaDoBanco.getString("cpf"));
                funcionarioTerceirizado.setNome(
                        resultadoDaTabelaDoBanco.getString("nome"));
                funcionarioTerceirizado.setFuncao(
                        Funcao.valueOf(resultadoDaTabelaDoBanco.getString("funcao")));
                funcionarioTerceirizado.setEmpresa(
                        resultadoDaTabelaDoBanco.getString("empresa"));
                funcionarioTerceirizado.setHorasTrabalhadas(
                        resultadoDaTabelaDoBanco.getBigDecimal("horas_trabalhadas"));
                funcionarioTerceirizado.setDataNascimento(
                        resultadoDaTabelaDoBanco
                            .getDate("data_nascimento")
                            .toLocalDate());

                lista.add(funcionarioTerceirizado);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar funcionario terceirizado");
            e.printStackTrace();
        } finally {
            try {
                if (resultadoDaTabelaDoBanco != null) resultadoDaTabelaDoBanco.close();
                if (preparaOcomandoSQL != null) preparaOcomandoSQL.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexao");
            }
        }

        return lista;
    }

    // ================= DELETE =================
    public boolean deletarFuncionarioTerceirizado(String cpf) {

        boolean deletado = false;

        String comandoSqlDelete =
                "DELETE FROM funcionario_terceirizado WHERE cpf = ?";

        FabricaDeConexoes fabricaConexoesSisFuncionario = new FabricaDeConexoes();
        Connection conexaoSisFuncionario = null;
        PreparedStatement preparaComando = null;

        try {
            conexaoSisFuncionario = fabricaConexoesSisFuncionario.criarConexaoSis_funcionario();
            preparaComando = conexaoSisFuncionario.prepareStatement(comandoSqlDelete);
            preparaComando.setString(1, cpf);

            deletado = preparaComando.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao deletar funcionario terceirizado");
            e.printStackTrace();
        } finally {
            try {
                if (preparaComando != null) preparaComando.close();
                if (conexaoSisFuncionario != null) conexaoSisFuncionario.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexao");
            }
        }

        return deletado;
    }
    public boolean atualizarFuncionarioTerceirizado(FuncionarioTerceirizado funcionarioTerceirizado) {

        boolean atualizado = false;

        String comandoSqlUpdate =
            "UPDATE funcionario_terceirizado " +
            "SET nome = ?, data_nascimento = ?, funcao = ?, empresa = ?, horas_trabalhadas = ?, senha = ? " +
            "WHERE cpf = ?";

        FabricaDeConexoes fabricaConexoesSisFuncionario = new FabricaDeConexoes();
        Connection conexaoSisFuncionario = null;
        PreparedStatement preparaComando = null;

        try {
            conexaoSisFuncionario = fabricaConexoesSisFuncionario.criarConexaoSis_funcionario();
            preparaComando = conexaoSisFuncionario.prepareStatement(comandoSqlUpdate);

            preparaComando.setString(1, funcionarioTerceirizado.getNome());
            preparaComando.setDate(
                2,
                java.sql.Date.valueOf(funcionarioTerceirizado.getDataNascimento())
            );
            preparaComando.setString(3, funcionarioTerceirizado.getFuncao().name());
            preparaComando.setString(4, funcionarioTerceirizado.getEmpresa());
            preparaComando.setBigDecimal(5, funcionarioTerceirizado.getHorasTrabalhadas());
            preparaComando.setString(
                6,
                Base64.getEncoder()
                      .encodeToString("123".getBytes(StandardCharsets.UTF_8))
            );
            preparaComando.setString(7, funcionarioTerceirizado.getCpf()); // WHERE

            atualizado = preparaComando.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar funcionario terceirizado");
            e.printStackTrace();
        } finally {
            try {
                if (preparaComando != null) preparaComando.close();
                if (conexaoSisFuncionario != null) conexaoSisFuncionario.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexao");
            }
        }

        return atualizado;
    }
}