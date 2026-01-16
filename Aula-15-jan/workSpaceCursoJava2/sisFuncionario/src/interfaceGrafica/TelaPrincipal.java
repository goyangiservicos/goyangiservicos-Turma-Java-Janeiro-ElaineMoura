package interfaceGrafica;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.ControladorTelaPrincipal;

public class TelaPrincipal {

	public void menuPrincipal() {
		System.out.println("Inicio do metodo menuPrincipal");

		JFrame frameMenuPrincipal = new JFrame(); // Cria o objeto Frame
		frameMenuPrincipal.setSize(300, 300);

		JPanel panelMenuPrincipal = new JPanel();// Painel para comportar os itens no painel

		JLabel labelOpcao1 = new JLabel("1 - PARA GERENTE");// Criar uma label
		panelMenuPrincipal.add(labelOpcao1);// Adiciona label dentro do painel

		JLabel labelOpcao2 = new JLabel("2 - ATENDENTE");// Cria outra Label
		panelMenuPrincipal.add(labelOpcao2);// Adiciona a label no painel

		JLabel labelOpcao3 = new JLabel("3 - PARA ASSISTENTE ADMINISTRATIVO");// Criar uma label
		panelMenuPrincipal.add(labelOpcao3);// Adiciona label dentro do painel

		JLabel labelOpcao4 = new JLabel("4 - SUPERVISOR AUXILIAR");// Cria outra Label
		panelMenuPrincipal.add(labelOpcao4);// Adiciona a label no painel

		JTextField caixaTextoOpcao = new JTextField(10);// Cria a caixa de textbox
		panelMenuPrincipal.add(caixaTextoOpcao);// Adiciona caixa de texto

		JButton botaoEnviar = new JButton("Enviar");// Cria o botão
		panelMenuPrincipal.add(botaoEnviar);// Adiciona o botão no painel

		frameMenuPrincipal.add(panelMenuPrincipal);
		frameMenuPrincipal.setLocationRelativeTo(frameMenuPrincipal);// pra centralizar a tela
		frameMenuPrincipal.setVisible(true); // Liberando a visualização desse frame
		ControladorTelaPrincipal controladorTelaPrincipal = new ControladorTelaPrincipal(caixaTextoOpcao, frameMenuPrincipal);
		botaoEnviar.addActionListener(controladorTelaPrincipal); // aqui add o botao dentro do controlador, para poder
																	// fazer acoes

	}

}
