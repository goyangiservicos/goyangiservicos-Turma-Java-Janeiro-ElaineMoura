package sisPessoa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexoes {
	private static String USUARIO = "root";
	private static String SENHA = "123456";
	private static String BANCO_URL = "jdbc:mysql://localhost:3306/sisPessoa";

	public Connection criarConexaoSisPessoa() {
		Connection conexaoBaseDadosSisPessoa = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				conexaoBaseDadosSisPessoa = DriverManager.getConnection(BANCO_URL, USUARIO, SENHA);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Erro na linha do Classe.forName");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conexaoBaseDadosSisPessoa;
	}
}
