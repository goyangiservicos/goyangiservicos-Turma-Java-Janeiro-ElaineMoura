package interfaceGrafica;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.ControladorCadastroGerente;

public class TelaCadastroGerente {
	public void formularioGerente() {
		String nomeGerente = "Digite o nome do gerente";
		String cpf = "Digite o cpf do gerente";
		String email = "Digite o email do gerente";
		String gerencia = "Digite a gerencia";
		
		JFrame frameCadastroGerente = new JFrame();
		frameCadastroGerente.setSize(300, 300);
		
		JPanel panelGerente = new JPanel();
		
		JLabel labelNome = new JLabel(nomeGerente);
		panelGerente.add(labelNome);
		
		JLabel labelCpf = new JLabel(cpf);
		panelGerente.add(labelCpf);
		
		
		JLabel labelEmail = new JLabel(email);
		panelGerente.add(labelEmail);
		
		JLabel labelGerencia = new JLabel(gerencia);
		panelGerente.add(labelGerencia);
		
	
		
		JTextField textNome = new JTextField(10);
		panelGerente.add(textNome);
		
		JTextField textCpf = new JTextField(10);
		panelGerente.add(textCpf);
		

		JTextField textEmail = new JTextField(10);
		panelGerente.add(textEmail);
	
		
		JTextField textGerencia = new JTextField(10);
		panelGerente.add(textGerencia);
		
		JButton botaoCadastrarGerente = new JButton("cadastrar");
		panelGerente.add(botaoCadastrarGerente);
		frameCadastroGerente.add(panelGerente);
		frameCadastroGerente.setLocationRelativeTo(frameCadastroGerente);
		frameCadastroGerente.setVisible(true);
		
		ControladorCadastroGerente controladorCadastroGerente = new ControladorCadastroGerente(textNome, textCpf, textEmail, textGerencia );
		botaoCadastrarGerente.addActionListener(controladorCadastroGerente);
		
	}
}
