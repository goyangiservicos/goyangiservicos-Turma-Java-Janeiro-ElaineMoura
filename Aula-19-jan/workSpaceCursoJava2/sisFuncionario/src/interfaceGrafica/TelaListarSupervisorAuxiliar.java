package interfaceGrafica;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entidade.SupervisorAuxiliar;
public class TelaListarSupervisorAuxiliar {

	
	public void listarSupervisorAuxiliar(List<SupervisorAuxiliar> listaSupervisores) {
		
		
		int quantidadeLinhas = listaSupervisores.size();
		
		String [][] tabelaString = new String [quantidadeLinhas][3];
		
		int posicaoColuna = 0;
		int posicaoLinha = 0;
		
		
		for(SupervisorAuxiliar supervisorAuxiliar: listaSupervisores) {
			
			tabelaString[posicaoLinha][posicaoColuna] = supervisorAuxiliar.getCpf();
			posicaoColuna ++;
			tabelaString[posicaoLinha][posicaoColuna] = supervisorAuxiliar.getNome();
			posicaoColuna++;
			tabelaString[posicaoLinha][posicaoColuna] = supervisorAuxiliar.getPatio();
			
			posicaoColuna = 0;
			posicaoLinha ++;
		}
		
		String [] nomeColunas = {"CPF", "NOME", "PATIO"};
		
		JFrame frameListarSupervisor = new JFrame();
		frameListarSupervisor.setSize(475, 450);
		
		JTable tabelaSupervisor = new JTable(tabelaString, nomeColunas);
		tabelaSupervisor.setSize(1000,1000);
		tabelaSupervisor.setBounds(30,40,300,300);
		
		JScrollPane scrollPaneListarSupervisor = new JScrollPane(tabelaSupervisor);
		
		JPanel panelListarSupervisor = new JPanel();
		panelListarSupervisor.add(scrollPaneListarSupervisor);
		
		frameListarSupervisor.add(panelListarSupervisor);
		
	
		frameListarSupervisor.setVisible(true);
		
		
	}

}
