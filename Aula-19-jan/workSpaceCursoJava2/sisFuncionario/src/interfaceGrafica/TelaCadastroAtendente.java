package interfaceGrafica;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.ControladorCadastroAtendente;

public class TelaCadastroAtendente {

	public void formularioAtendente(JFrame frameTelaPrincipal) {
		String nomeAtendente = "Digite o nome do Atendente";
		String cpf = "Digite o cpf do Atendente";
		String email = "Digite o email do Atendente";
		String setor = "Digite o setor";

		JFrame frameCadastroAtendente = new JFrame();
		frameCadastroAtendente.setSize(300, 300);

		JPanel panelAtendente = new JPanel();

		JLabel labelNome = new JLabel(nomeAtendente);
		panelAtendente.add(labelNome);
		JTextField textNome = new JTextField(10);
		panelAtendente.add(textNome);

		JLabel labelCpf = new JLabel(cpf);
		panelAtendente.add(labelCpf);

		JTextField textCpf = new JTextField(10);
		panelAtendente.add(textCpf);

		JLabel labelEmail = new JLabel(email);
		panelAtendente.add(labelEmail);

		JTextField textEmail = new JTextField(10);
		panelAtendente.add(textEmail);

		JLabel labelSetor = new JLabel(setor);
		panelAtendente.add(labelSetor);
		
		JTextField textSetor = new JTextField(10);
		panelAtendente.add(textSetor);

		JButton botaoCadastrarAtendente = new JButton("cadastrar");
		panelAtendente.add(botaoCadastrarAtendente);

		JButton botaoMenuInicial = new JButton("menu Inicial");
		panelAtendente.add(botaoMenuInicial);

		frameCadastroAtendente.add(panelAtendente);
		frameCadastroAtendente.setLocationRelativeTo(frameCadastroAtendente);
		frameCadastroAtendente.setVisible(true);

		ControladorCadastroAtendente controladorCadastroAtendente = new ControladorCadastroAtendente(textNome, textCpf,
				textEmail, textSetor, frameCadastroAtendente, frameTelaPrincipal);
		botaoCadastrarAtendente.addActionListener(controladorCadastroAtendente);
		botaoMenuInicial.addActionListener(controladorCadastroAtendente);
	}
}
