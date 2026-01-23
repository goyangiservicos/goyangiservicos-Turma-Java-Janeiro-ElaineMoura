package interfaceGrafica;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.ControladorCadastroGerente;

public class TelaCadastroGerente {
	public void formularioGerente(JFrame frameTelaPrincipal) {
		String nomeGerente = "Digite o nome do gerente";
		String cpf = "Digite o cpf do gerente";
		String email = "Digite o email do gerente";
		String gerencia = "Digite a gerencia";

		JFrame frameCadastroGerente = new JFrame();
		frameCadastroGerente.setSize(300, 300);

		JPanel panelGerente = new JPanel();

		JLabel labelNome = new JLabel(nomeGerente);
		panelGerente.add(labelNome);
		JTextField textNome = new JTextField(10);
		panelGerente.add(textNome);

		JLabel labelCpf = new JLabel(cpf);
		panelGerente.add(labelCpf);

		JTextField textCpf = new JTextField(10);
		panelGerente.add(textCpf);

		JLabel labelEmail = new JLabel(email);
		panelGerente.add(labelEmail);

		JTextField textEmail = new JTextField(10);
		panelGerente.add(textEmail);

		JLabel labelGerencia = new JLabel(gerencia);
		panelGerente.add(labelGerencia);
		JTextField textGerencia = new JTextField(10);
		panelGerente.add(textGerencia);

		JButton botaoCadastrarGerente = new JButton("cadastrar");
		panelGerente.add(botaoCadastrarGerente);

		JButton botaoMenuInicial = new JButton("menu Inicial");
		panelGerente.add(botaoMenuInicial);

		frameCadastroGerente.add(panelGerente);
		frameCadastroGerente.setLocationRelativeTo(frameCadastroGerente);
		frameCadastroGerente.setVisible(true);
		
		JButton botaoListar = new JButton("Listar");
		panelGerente.add(botaoListar);

		ControladorCadastroGerente controladorCadastroGerente = new ControladorCadastroGerente(textNome, textCpf,
				textEmail, textGerencia, frameCadastroGerente, frameTelaPrincipal);
		botaoCadastrarGerente.addActionListener(controladorCadastroGerente);
		botaoMenuInicial.addActionListener(controladorCadastroGerente);
		botaoListar.addActionListener(controladorCadastroGerente);
	}
}
