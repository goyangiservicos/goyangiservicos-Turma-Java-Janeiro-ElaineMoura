package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.Atendente;
import repositorio.RepositorioAtendenteImplementacao;
import validacaoTela.ValidacaoTela;

public class ControladorCadastroAtendente implements ActionListener {

	JTextField nome;
	JTextField cpf;
	JTextField email;
	JTextField setor;
	RepositorioAtendenteImplementacao repositorioAtendenteImplementacao = new RepositorioAtendenteImplementacao();
	JFrame frameCadastroAtendente;
	JFrame frameTelaPrincipal;

	public ControladorCadastroAtendente(JTextField nome, JTextField cpf, JTextField email, JTextField setor,
			JFrame frameCadastroAtendente, JFrame frameTelaPrincipal) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.setor = setor;
		this.frameCadastroAtendente = frameCadastroAtendente;
		this.frameTelaPrincipal = frameTelaPrincipal;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("iniciar cadastro");
		System.out.println(nome.getText());
		System.out.println(cpf.getText());
		System.out.println(email.getText());
		System.out.println(setor.getText());

		switch (e.getActionCommand()) {
		case "cadastrar": {

			ValidacaoTela validacaoTela = new ValidacaoTela();
			validacaoTela.setCpf(cpf.getText());
			// validacoes de cpf vazio, se tem 11 caracteres e se eh valido
			if (cpf.getText() == null || cpf.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "CPF vazio, informe o CPF.");
				return;
			}

			if (!validacaoTela.validaCampoCpf()) {
				JOptionPane.showMessageDialog(null, "CPF invalido. CPF deve conter 11 números.");
				return;
			}
			Atendente atendente = new Atendente();
			atendente.setNome(nome.getText());

			if (!atendente.isCpfValido(cpf.getText())) {
				JOptionPane.showMessageDialog(null, "CPF invalido!");

			} else {
				atendente.setCpf(cpf.getText());
				atendente.setEmail(email.getText());
				atendente.setSetor(setor.getText());

				if (repositorioAtendenteImplementacao.salvarAtendente(atendente)) {


					JOptionPane.showMessageDialog(null, "O atennddente  foi salvo");

					nome.setText(null);
					cpf.setText(null);
					email.setText(null);
					setor.setText(null);

				} else {
					JOptionPane.showMessageDialog(null, "O atendente  não salvo");
				}
			}

			break;
		}

		case "menu Inicial": {
			frameCadastroAtendente.setVisible(false);
			frameTelaPrincipal.setVisible(true);

			break;
		}
		}

	}

}
