package interfaceGrafica;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.ControladorCadastroAssistenteAdministrativo;

public class TelaCadastroAssistenteAdministrativo {

	public void formularioAssistenteAdministrativo(JFrame frameTelaPrincipal) {
		String nomeAssistenteAdministrativo = "Digite o nome do Assistente Administrativo";
		String cpf = "Digite o cpf do Assistente Administrativo";
		String email = "Digite o email do Assistente Administrativo";
		String escritorio = "Digite o escritorio";

		JFrame frameCadastroAssistenteAdministrativo = new JFrame();
		frameCadastroAssistenteAdministrativo.setSize(500, 500);

		JPanel panelAssistenteAdministrativo = new JPanel();

		JLabel labelNome = new JLabel(nomeAssistenteAdministrativo);
		panelAssistenteAdministrativo.add(labelNome);
		JTextField textNome = new JTextField(10);
		panelAssistenteAdministrativo.add(textNome);

		JLabel labelCpf = new JLabel(cpf);
		panelAssistenteAdministrativo.add(labelCpf);

		JTextField textCpf = new JTextField(10);
		panelAssistenteAdministrativo.add(textCpf);

		JLabel labelEmail = new JLabel(email);
		panelAssistenteAdministrativo.add(labelEmail);

		JTextField textEmail = new JTextField(10);
		panelAssistenteAdministrativo.add(textEmail);

		JLabel labelEscritorio = new JLabel(escritorio);
		panelAssistenteAdministrativo.add(labelEscritorio);
		JTextField textEscritorio = new JTextField(10);
		panelAssistenteAdministrativo.add(textEscritorio);

		JButton botaoCadastrarAssistenteAdministrativo = new JButton("cadastrar");
		panelAssistenteAdministrativo.add(botaoCadastrarAssistenteAdministrativo);

		JButton botaoMenuInicial = new JButton("menu Inicial");
		panelAssistenteAdministrativo.add(botaoMenuInicial);

		frameCadastroAssistenteAdministrativo.add(panelAssistenteAdministrativo);
		frameCadastroAssistenteAdministrativo.setLocationRelativeTo(frameCadastroAssistenteAdministrativo);
		frameCadastroAssistenteAdministrativo.setVisible(true);

		ControladorCadastroAssistenteAdministrativo controladorCadastroAssistenteAdministrativo = new ControladorCadastroAssistenteAdministrativo(
				textNome, textCpf, textEmail, textEscritorio, frameCadastroAssistenteAdministrativo,
				frameTelaPrincipal);
		botaoCadastrarAssistenteAdministrativo.addActionListener(controladorCadastroAssistenteAdministrativo);
		botaoMenuInicial.addActionListener(controladorCadastroAssistenteAdministrativo);
	}
}
