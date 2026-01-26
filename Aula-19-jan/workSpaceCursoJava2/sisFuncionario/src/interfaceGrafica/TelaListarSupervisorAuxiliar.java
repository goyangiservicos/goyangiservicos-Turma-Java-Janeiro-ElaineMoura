package interfaceGrafica;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controlador.ControladorTelaListarSupervisorAuxiliar;
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
		frameListarSupervisor.setSize(600, 600);
		
		JTable tabelaSupervisor = new JTable(tabelaString, nomeColunas);
		tabelaSupervisor.setSize(1000,1000);
		tabelaSupervisor.setBounds(30,40,300,300);
		
		JScrollPane scrollPaneListarSupervisor = new JScrollPane(tabelaSupervisor);
		
		
		JPanel panelListarSupervisor = new JPanel();
		panelListarSupervisor.add(scrollPaneListarSupervisor);
		
		
		
		JLabel labelcpf = new JLabel("digite o cpf");
		panelListarSupervisor.add(labelcpf);
		JTextField textCpf = new JTextField(10);
		panelListarSupervisor.add(textCpf);
		
		
		JButton botaoDetalhar = new JButton("Detalhar");// Cria o botão detalhes 
		panelListarSupervisor.add(botaoDetalhar);
		frameListarSupervisor.setLocationRelativeTo(frameListarSupervisor);
		frameListarSupervisor.add(panelListarSupervisor);
			
		frameListarSupervisor.setVisible(true);
		
		ControladorTelaListarSupervisorAuxiliar controladorTelaListarSupervisorAuxiliar = new ControladorTelaListarSupervisorAuxiliar(textCpf, listaSupervisores);
		botaoDetalhar.addActionListener(controladorTelaListarSupervisorAuxiliar);
		
	}

}
