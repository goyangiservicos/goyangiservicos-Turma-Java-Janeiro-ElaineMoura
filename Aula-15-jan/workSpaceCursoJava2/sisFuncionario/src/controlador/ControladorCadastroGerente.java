package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.Gerente;
import gerenciaArquivo.ManipuladorArquivo;

public class ControladorCadastroGerente implements ActionListener {

	JTextField nome;
	JTextField cpf;
	JTextField email;
	JTextField gerencia;
	ManipuladorArquivo manipuladorArquivo = new ManipuladorArquivo();
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
		
		
	
	
	//	manipuladorArquivo.registrarGerente(gerente);
		
			switch (e.getActionCommand()){
				case "cadastrar":{
					Gerente gerente =new Gerente();
					gerente.setNome(nome.getText());
					gerente.setCpf(cpf.getText());
					gerente.setEmail(email.getText());
					gerente.setGerencia(gerencia.getText());
					
					if (manipuladorArquivo.registrarGerente(gerente)) {
						JOptionPane.showMessageDialog(null, "o arquivo foi salvo");
					}else {
						JOptionPane.showMessageDialog(null, "o arquivo nao foi salvo");
					}
									break;
			}
				case "menu Inicial":{
					frameCadastroGerente.setVisible(false);
					frameTelaPrincipal.setVisible(true);
				}
			}
		
		
		

	}
}
