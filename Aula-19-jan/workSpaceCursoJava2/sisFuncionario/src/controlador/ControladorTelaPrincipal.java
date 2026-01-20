package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import interfaceGrafica.TelaCadastroAssistenteAdministrativo;
import interfaceGrafica.TelaCadastroAtendente;
import interfaceGrafica.TelaCadastroGerente;
import interfaceGrafica.TelaCadastroSupervisorAuxiliar;

//torna essa classe subclasse da classe eventListener(ActionListener)
public class ControladorTelaPrincipal implements ActionListener {

	JTextField opcao;
	TelaCadastroGerente telaCadastroGerente = new TelaCadastroGerente();
	TelaCadastroAssistenteAdministrativo telaCadastroAssistenteAdministrativo = new TelaCadastroAssistenteAdministrativo();
	TelaCadastroSupervisorAuxiliar telaCadastroSupervisorAuxiliar = new TelaCadastroSupervisorAuxiliar();
	TelaCadastroAtendente telaCadastroAtendente = new TelaCadastroAtendente();
	JFrame frameTelaPrincipal;

	public ControladorTelaPrincipal(JTextField opcao, JFrame frameTelaPrincipal) {
		this.opcao = opcao;
		this.frameTelaPrincipal = frameTelaPrincipal;
	}

	@Override
	public void actionPerformed(ActionEvent evento) {

		System.out.println("digitou" + opcao.getText());
		switch (opcao.getText()) {
		case "1": {
			telaCadastroGerente.formularioGerente(frameTelaPrincipal);
			frameTelaPrincipal.setVisible(false);
			System.out.println("Cadastro de gerente");
			break;
		}
		case "2": {
			System.out.println("Cadastro de atendente");
			telaCadastroAtendente.formularioAtendente(frameTelaPrincipal);
			frameTelaPrincipal.setVisible(false);
			System.out.println("Cadastro de atendente");
			break;

		}

		case "3": {
			System.out.println("Cadastro de assistente administrativo");
			telaCadastroAssistenteAdministrativo.formularioAssistenteAdministrativo(frameTelaPrincipal);
			frameTelaPrincipal.setVisible(false);
			System.out.println("Cadastro de assistente administrativo");
			break;
		}

		case "4": {
			System.out.println("Cadastro de Supervisor auxiliar");
			telaCadastroSupervisorAuxiliar.formularioSupervisorAuxiliar(frameTelaPrincipal);
			frameTelaPrincipal.setVisible(false);
			System.out.println("Cadastro de Supervisor auxiliar");
			break;
		}
		}

	}

}
