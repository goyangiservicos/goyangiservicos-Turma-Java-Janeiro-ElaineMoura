package interfaceGrafica;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.ControladorCadastroSupervisorAuxiliar;
public class TelaCadastroSupervisorAuxiliar {


			public void formularioSupervisorAuxiliar(JFrame frameTelaPrincipal) {
				String nomeSupervisorAuxiliar = "Digite o nome do Supervisor Auxiliar";
				String cpf = "Digite o cpf do Assistente Supervisor Auxiliar";
				String email = "Digite o email do Assistente Supervisor Auxiliar";
				String patio = "Digite o patio";

				JFrame frameCadastroSupervisorAuxiliar = new JFrame();
				frameCadastroSupervisorAuxiliar.setSize(500, 400);

				JPanel panelSupervisorAuxiliar = new JPanel();
				panelSupervisorAuxiliar.setLayout(new GridBagLayout());

				GridBagConstraints gbc = new GridBagConstraints();
				gbc.insets = new Insets(8, 8, 8, 8);
				gbc.fill = GridBagConstraints.HORIZONTAL;

				gbc.gridx = 0;
				gbc.gridy = 0;
				panelSupervisorAuxiliar.add(new JLabel(nomeSupervisorAuxiliar), gbc);

				gbc.gridx = 1;
				JTextField textNome = new JTextField(15);
				panelSupervisorAuxiliar.add(textNome, gbc);

				gbc.gridx = 0;
				gbc.gridy = 1;
				panelSupervisorAuxiliar.add(new JLabel(cpf), gbc);

				gbc.gridx = 1;
				JTextField textCpf = new JTextField(15);
				panelSupervisorAuxiliar.add(textCpf, gbc);

				gbc.gridx = 0;
				gbc.gridy = 2;
				panelSupervisorAuxiliar.add(new JLabel(email), gbc);

				gbc.gridx = 1;
				JTextField textEmail = new JTextField(15);
				panelSupervisorAuxiliar.add(textEmail, gbc);

				gbc.gridx = 0;
				gbc.gridy = 3;
				panelSupervisorAuxiliar.add(new JLabel(patio), gbc);

				gbc.gridx = 1;
				JTextField textSupervisorAuxiliar = new JTextField(15);
				panelSupervisorAuxiliar.add(textSupervisorAuxiliar, gbc);

				gbc.gridx = 0;
				gbc.gridy = 4;
				JButton botaoCadastrarSupervisorAuxiliar = new JButton("cadastrar");
				panelSupervisorAuxiliar.add(botaoCadastrarSupervisorAuxiliar, gbc);

				gbc.gridx = 1;
				JButton botaoMenuInicial = new JButton("menu Inicial");
				panelSupervisorAuxiliar.add(botaoMenuInicial, gbc);

				gbc.gridx = 1;
				gbc.gridy = 5;
				JButton botaoListar = new JButton("Listar");
				panelSupervisorAuxiliar.add(botaoListar, gbc);
				

				frameCadastroSupervisorAuxiliar.add(panelSupervisorAuxiliar);
				frameCadastroSupervisorAuxiliar.setLocationRelativeTo(frameCadastroSupervisorAuxiliar);
				frameCadastroSupervisorAuxiliar.setVisible(true);

				ControladorCadastroSupervisorAuxiliar controladorCadastroSupervisorAuxiliar = new ControladorCadastroSupervisorAuxiliar(textNome, textCpf,
						textEmail, textSupervisorAuxiliar, frameCadastroSupervisorAuxiliar, frameTelaPrincipal);
				botaoCadastrarSupervisorAuxiliar.addActionListener(controladorCadastroSupervisorAuxiliar);
				botaoMenuInicial.addActionListener(controladorCadastroSupervisorAuxiliar);
				botaoListar.addActionListener(controladorCadastroSupervisorAuxiliar);
			}
		}
