package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.AssistenteAdministrativo;
import gerenciaArquivo.ManipuladorArquivo;
import validacaoTela.ValidacaoTela;
public class ControladorCadastroAssistenteAdministrativo implements ActionListener {

		JTextField nome;
		JTextField cpf;
		JTextField email;
		JTextField escritorio;
		ManipuladorArquivo manipuladorArquivo = new ManipuladorArquivo();
		JFrame frameCadastroAssistenteAdministrativo;
		JFrame frameTelaPrincipal;

		public ControladorCadastroAssistenteAdministrativo(JTextField nome, JTextField cpf, JTextField email, JTextField escritorio,
				JFrame frameCadastroAssistenteAdministrativo, JFrame frameTelaPrincipal) {
			super();
			this.nome = nome;
			this.cpf = cpf;
			this.email = email;
			this.escritorio = escritorio;
			this.frameCadastroAssistenteAdministrativo = frameCadastroAssistenteAdministrativo;
			this.frameTelaPrincipal = frameTelaPrincipal;

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("iniciar cadastro");
			System.out.println(nome.getText());
			System.out.println(cpf.getText());
			System.out.println(email.getText());
			System.out.println(escritorio.getText());

			// manipuladorArquivo.registrarAssistenteAdmimnistrativo(assistenteAdministrativo);

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
				AssistenteAdministrativo assistenteAdministrativo = new AssistenteAdministrativo();
				assistenteAdministrativo.setNome(nome.getText());

				if (!assistenteAdministrativo.isCpfValido(cpf.getText())) {
					JOptionPane.showMessageDialog(null, "CPF invalido!");

				} else {
					assistenteAdministrativo.setCpf(cpf.getText());
					assistenteAdministrativo.setEmail(email.getText());
					assistenteAdministrativo.setEscritorio(escritorio.getText());

					if (manipuladorArquivo.registrarAssistenteAdministrativo(assistenteAdministrativo)) {

						JOptionPane.showMessageDialog(null, "O arquivo foi salvo");

						nome.setText(null);
						cpf.setText(null);
						email.setText(null);
						escritorio.setText(null);

					} else {
						JOptionPane.showMessageDialog(null, "O arquivo não salvo");
					}
				}

				break;
			}

			case "menu Inicial": {
				frameCadastroAssistenteAdministrativo.setVisible(false);
				frameTelaPrincipal.setVisible(true);

				break;
			}
			}

		}

	}

