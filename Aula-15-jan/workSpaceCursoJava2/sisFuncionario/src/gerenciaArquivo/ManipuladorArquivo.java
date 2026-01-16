package gerenciaArquivo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import entidade.Gerente;

public class ManipuladorArquivo {
	public boolean registrarGerente(Gerente gerente) {

		String enderecoArquivo = "C:\\IMPACTA JAVA\\goyangiservicos-Turma-Java-Janeiro-ElaineMoura\\Aula-15-jan\\workSpaceCursoJava2\\sisFuncionario\\registroGerente.txt";
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(enderecoArquivo));
			bufferedWriter.append("o NOME do gerente é:" + gerente.getNome());
			bufferedWriter.newLine();
			bufferedWriter.append("o CPF do gerente é:" + gerente.getCpf());
			bufferedWriter.append("o EMAIL do gerente é:" + gerente.getEmail());
			bufferedWriter.append("A GERENCIA é:" + gerente.getGerencia());
			
			bufferedWriter.close(); //PRECISA FECHAR!!!!

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return true;
	}
}
