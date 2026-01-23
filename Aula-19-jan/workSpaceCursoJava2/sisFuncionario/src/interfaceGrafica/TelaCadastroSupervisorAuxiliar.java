package interfaceGrafica;
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
				frameCadastroSupervisorAuxiliar.setSize(500, 500);

				JPanel panelSupervisorAuxiliar = new JPanel();

				JLabel labelNome = new JLabel(nomeSupervisorAuxiliar);
				panelSupervisorAuxiliar.add(labelNome);
				JTextField textNome = new JTextField(10);
				panelSupervisorAuxiliar.add(textNome);

				JLabel labelCpf = new JLabel(cpf);
				panelSupervisorAuxiliar.add(labelCpf);

				JTextField textCpf = new JTextField(10);
				panelSupervisorAuxiliar.add(textCpf);

				JLabel labelEmail = new JLabel(email);
				panelSupervisorAuxiliar.add(labelEmail);

				JTextField textEmail = new JTextField(10);
				panelSupervisorAuxiliar.add(textEmail);

				JLabel labelSupervisorAuxiliar = new JLabel(patio);
				panelSupervisorAuxiliar.add(labelSupervisorAuxiliar);
				JTextField textSupervisorAuxiliar = new JTextField(10);
				panelSupervisorAuxiliar.add(textSupervisorAuxiliar);

				JButton botaoCadastrarSupervisorAuxiliar = new JButton("cadastrar");
				panelSupervisorAuxiliar.add(botaoCadastrarSupervisorAuxiliar);

				JButton botaoMenuInicial = new JButton("menu Inicial");
				panelSupervisorAuxiliar.add(botaoMenuInicial);
				
				JButton botaoListar = new JButton("Listar");
				panelSupervisorAuxiliar.add(botaoListar);
				
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


