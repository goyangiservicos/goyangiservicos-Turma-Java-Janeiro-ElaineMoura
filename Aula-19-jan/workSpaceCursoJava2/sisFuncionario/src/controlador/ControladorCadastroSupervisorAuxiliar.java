package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.SupervisorAuxiliar;
import repositorio.RepositorioSupervisorAuxiliarImplementacao;
import validacaoTela.ValidacaoTela;

public class ControladorCadastroSupervisorAuxiliar implements ActionListener {

	JTextField nome;
	JTextField cpf;
	JTextField email;
	JTextField patio;
	RepositorioSupervisorAuxiliarImplementacao repositorioSupervisorAuxiliarImplementacao = new RepositorioSupervisorAuxiliarImplementacao();
	JFrame frameCadastroSupervisorAuxiliar;
	JFrame frameTelaPrincipal;

	public ControladorCadastroSupervisorAuxiliar(JTextField nome, JTextField cpf, JTextField email, JTextField patio,
			JFrame frameCadastroSupervisorAuxiliar, JFrame frameTelaPrincipal) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.patio = patio;
		this.frameCadastroSupervisorAuxiliar = frameCadastroSupervisorAuxiliar;
		this.frameTelaPrincipal = frameTelaPrincipal;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("iniciar cadastro");
		System.out.println(nome.getText());
		System.out.println(cpf.getText());
		System.out.println(email.getText());
		System.out.println(patio.getText());

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
			SupervisorAuxiliar supervisorAuxiliar = new SupervisorAuxiliar();
			supervisorAuxiliar.setNome(nome.getText());

			if (!supervisorAuxiliar.isCpfValido(cpf.getText())) {
				JOptionPane.showMessageDialog(null, "CPF invalido!");

			} else {
				supervisorAuxiliar.setCpf(cpf.getText());
				supervisorAuxiliar.setEmail(email.getText());
				supervisorAuxiliar.setPatio(null);

				if (repositorioSupervisorAuxiliarImplementacao.salvarSupervisorAuxiliar(supervisorAuxiliar)) {

					JOptionPane.showMessageDialog(null, "O dados foram salvos no banco");

					nome.setText(null);
					cpf.setText(null);
					email.setText(null);
					patio.setText(null);

				} else {
					JOptionPane.showMessageDialog(null, "os dados nao foram salvos no banco");
				}
			}

			break;
		}

		case "menu Inicial": {
			frameCadastroSupervisorAuxiliar.setVisible(false);
			frameTelaPrincipal.setVisible(true);
			break;
		}
		}

	}
}