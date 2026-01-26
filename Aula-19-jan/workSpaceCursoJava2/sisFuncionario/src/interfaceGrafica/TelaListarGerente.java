package interfaceGrafica;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controlador.ControladorTelaListarGerente;
import entidade.Gerente;

public class TelaListarGerente {
	
	
	public void listarGerente(List<Gerente> listaGerentes) {
		
		
		int quantidadeLinhas = listaGerentes.size();
		
		String [][] tabelaString = new String [quantidadeLinhas][3];
		
		int posicaoColuna = 0;
		int posicaoLinha = 0;
		
		
		for(Gerente gerente: listaGerentes) {
			
			tabelaString[posicaoLinha][posicaoColuna] = gerente.getCpf();
			posicaoColuna ++;
			tabelaString[posicaoLinha][posicaoColuna] = gerente.getNome();
			posicaoColuna++;
			tabelaString[posicaoLinha][posicaoColuna] = gerente.getEmail();
			
			posicaoColuna = 0;
			posicaoLinha ++;
		}
		
		String [] nomeColunas = {"CPF", "NOME", "EMAIL"};
		
		JFrame frameListarGerentes = new JFrame();
		frameListarGerentes.setSize(600, 600);
		
		JTable tabelaGerentes = new JTable(tabelaString, nomeColunas);
		tabelaGerentes.setSize(1000,1000);
		tabelaGerentes.setBounds(30,40,300,300);
		
		JScrollPane scrollPaneListarGerente = new JScrollPane(tabelaGerentes);
		
		JPanel panelListarGerente = new JPanel();
		panelListarGerente.add(scrollPaneListarGerente);
		
		
	
		JLabel labelcpf = new JLabel("digite o cpf");
		panelListarGerente.add(labelcpf);
		JTextField textCpf = new JTextField(10);
		panelListarGerente.add(textCpf);
		
	
		
		JButton botaoDetalhar = new JButton("Detalhar");// Cria o botão detalhes 
		panelListarGerente.add(botaoDetalhar);
		frameListarGerentes.setLocationRelativeTo(frameListarGerentes);
		frameListarGerentes.add(panelListarGerente);
			
		frameListarGerentes.setVisible(true);
		
		ControladorTelaListarGerente controladorTelaListarGerente = new ControladorTelaListarGerente(textCpf , listaGerentes);
		botaoDetalhar.addActionListener(controladorTelaListarGerente);
		
	
	}

}