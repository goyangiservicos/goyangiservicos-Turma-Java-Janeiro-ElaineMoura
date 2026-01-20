package gerenciaArquivo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import entidade.AssistenteAdministrativo;
import entidade.Atendente;
import entidade.Gerente;
import entidade.SupervisorAuxiliar;

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

			bufferedWriter.close(); // PRECISA FECHAR!!!!

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	public boolean registrarAssistenteAdministrativo(AssistenteAdministrativo assistenteAdministrativo) {
		String enderecoArquivo = "C:\\IMPACTA JAVA\\goyangiservicos-Turma-Java-Janeiro-ElaineMoura\\Aula-15-jan\\workSpaceCursoJava2\\sisFuncionario\\registroAssistenteAdministrativo.txt";
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(enderecoArquivo));
			bufferedWriter.append("o NOME do gerente é:" + assistenteAdministrativo.getNome());
			bufferedWriter.newLine();
			bufferedWriter.append("o CPF do gerente é:" + assistenteAdministrativo.getCpf());
			bufferedWriter.append("o EMAIL do gerente é:" + assistenteAdministrativo.getEmail());
			bufferedWriter.append("A GERENCIA é:" + assistenteAdministrativo.getEscritorio());

			bufferedWriter.close(); 

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}
	public boolean registrarSupervisorAuxiliar(SupervisorAuxiliar supervisorAuxiliar) {
		String enderecoArquivo = "C:\\IMPACTA JAVA\\goyangiservicos-Turma-Java-Janeiro-ElaineMoura\\Aula-15-jan\\workSpaceCursoJava2\\sisFuncionario\\registroSupervisorAuxiliar.txt";
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(enderecoArquivo));
			bufferedWriter.append("o NOME do gerente é:" + supervisorAuxiliar.getNome());
			bufferedWriter.newLine();
			bufferedWriter.append("o CPF do gerente é:" + supervisorAuxiliar.getCpf());
			bufferedWriter.append("o EMAIL do gerente é:" + supervisorAuxiliar.getEmail());
			bufferedWriter.append("A GERENCIA é:" + supervisorAuxiliar.getPatio());

			bufferedWriter.close(); 

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}
	public boolean registrarAtendente(Atendente Atendente) {
		String enderecoArquivo = "C:\\IMPACTA JAVA\\goyangiservicos-Turma-Java-Janeiro-ElaineMoura\\Aula-15-jan\\workSpaceCursoJava2\\sisFuncionario\\registroAtendente.txt";
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(enderecoArquivo));
			bufferedWriter.append("o NOME do Atendente é:" + Atendente.getNome());
			bufferedWriter.newLine();
			bufferedWriter.append("o CPF do Atendente é:" + Atendente.getCpf());
			bufferedWriter.append("o EMAIL do Atendente é:" + Atendente.getEmail());
			bufferedWriter.append("o setor é:" + Atendente.getSetor());

			bufferedWriter.close(); 

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

}



