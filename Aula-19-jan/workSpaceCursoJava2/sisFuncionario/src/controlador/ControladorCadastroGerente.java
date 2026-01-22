package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.Gerente;
import repositorio.RepositorioGerenteImplementacao;
import validacaoTela.ValidacaoTela;

public class ControladorCadastroGerente implements ActionListener {

	JTextField nome;
	JTextField cpf;
	JTextField email;
	JTextField gerencia;
	RepositorioGerenteImplementacao repositorioGerenteImplementacao = new RepositorioGerenteImplementacao();
	JFrame frameCadastroGerente;
	JFrame frameTelaPrincipal;

	public ControladorCadastroGerente(JTextField nome, JTextField cpf, JTextField email, JTextField gerencia,
			JFrame frameCadastroGerente, JFrame frameTelaPrincipal) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.gerencia = gerencia;
		this.frameCadastroGerente = frameCadastroGerente;
		this.frameTelaPrincipal = frameTelaPrincipal;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("iniciar cadastro");
		System.out.println(nome.getText());
		System.out.println(cpf.getText());
		System.out.println(email.getText());
		System.out.println(gerencia.getText());

		// manipuladorArquivo.registrarGerente(gerente);

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
			Gerente gerente = new Gerente();
			gerente.setNome(nome.getText());

			if (!gerente.isCpfValido(cpf.getText())) {
				JOptionPane.showMessageDialog(null, "CPF invalido!");

			} else {
				gerente.setCpf(cpf.getText());
				gerente.setEmail(email.getText());
				gerente.setGerencia(gerencia.getText());

				if (repositorioGerenteImplementacao.salvarGerente(gerente)) {

					JOptionPane.showMessageDialog(null, "os dados foram salvos no banco");

					nome.setText(null);
					cpf.setText(null);
					email.setText(null);
					gerencia.setText(null);

				} else {
					JOptionPane.showMessageDialog(null, "os dados nao foram salvos no banco");
				}
			}

			break;
		}

		case "menu Inicial": {
			frameCadastroGerente.setVisible(false);
			frameTelaPrincipal.setVisible(true);

			break;
		}
		}

	}

}
