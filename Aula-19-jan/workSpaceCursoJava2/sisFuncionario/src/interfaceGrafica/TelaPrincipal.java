package interfaceGrafica;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

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
		frameMenuPrincipal.setSize(400, 300);

		JPanel panelMenuPrincipal = new JPanel(); // Painel para comportar os itens no painel
		panelMenuPrincipal.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(8, 8, 8, 8);
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.CENTER;

		JLabel labelOpcao1 = new JLabel("1 - PARA GERENTE"); // Criar uma label
		gbc.gridy = 0;
		panelMenuPrincipal.add(labelOpcao1, gbc); // Adiciona label dentro do painel

		JLabel labelOpcao2 = new JLabel("2 - ATENDENTE"); // Cria outra Label
		gbc.gridy = 1;
		panelMenuPrincipal.add(labelOpcao2, gbc); // Adiciona a label no painel

		JLabel labelOpcao3 = new JLabel("3 - PARA ASSISTENTE ADMINISTRATIVO"); // Criar uma label
		gbc.gridy = 2;
		panelMenuPrincipal.add(labelOpcao3, gbc); // Adiciona label dentro do painel

		JLabel labelOpcao4 = new JLabel("4 - SUPERVISOR AUXILIAR"); // Cria outra Label
		gbc.gridy = 3;
		panelMenuPrincipal.add(labelOpcao4, gbc); // Adiciona a label no painel

		JTextField caixaTextoOpcao = new JTextField(10); // Cria a caixa de textbox
		gbc.gridy = 4;
		panelMenuPrincipal.add(caixaTextoOpcao, gbc); // Adiciona caixa de texto

		JButton botaoEnviar = new JButton("Enviar"); // Cria o botão
		gbc.gridy = 5;
		panelMenuPrincipal.add(botaoEnviar, gbc); // Adiciona o botão no painel

		frameMenuPrincipal.add(panelMenuPrincipal);
		frameMenuPrincipal.setLocationRelativeTo(frameMenuPrincipal); // pra centralizar a tela
		frameMenuPrincipal.setVisible(true); // Liberando a visualização desse frame
		ControladorTelaPrincipal controladorTelaPrincipal = new ControladorTelaPrincipal(caixaTextoOpcao,
				frameMenuPrincipal);
		botaoEnviar.addActionListener(controladorTelaPrincipal); // aqui add o botao dentro do controlador, para poder
																	// fazer acoes
	}
}
