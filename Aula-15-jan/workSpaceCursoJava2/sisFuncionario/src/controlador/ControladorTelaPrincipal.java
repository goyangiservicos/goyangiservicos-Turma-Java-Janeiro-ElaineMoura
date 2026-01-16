package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import interfaceGrafica.TelaCadastroGerente;

//torna essa classe subclasse da classe eventListener(ActionListener)
public class ControladorTelaPrincipal implements ActionListener {

	JTextField opcao;
	TelaCadastroGerente telaCadastroGerente = new TelaCadastroGerente();
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
			telaCadastroGerente.formularioGerente();
			frameTelaPrincipal.setVisible(false);
			System.out.println("Cadastro de gerente");
			break;
		}
		case "2": {
			System.out.println("Cadastro de atendente");
			break;

		}

		case "3": {
			System.out.println("Cadastro de assistente administrativo");
			break;
		}

		case "4": {
			System.out.println("Cadastro de Supervisor auxiliar");
			break;
		}
		}

	}

}
