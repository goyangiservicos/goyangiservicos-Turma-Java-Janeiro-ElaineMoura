package interfaceGrafica;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bancoDadosDao.DaoSupervisorAuxiliar;
import entidade.SupervisorAuxiliar;

public class TelaAlterarSupervisorAuxiliar {

	public void alterarSupervisorAuxiliar(SupervisorAuxiliar supervisorAuxiliar) {

		JFrame frameTelaAlterar = new JFrame("Alterar Supervisor Auxiliar");
		frameTelaAlterar.setSize(420, 260);

		JPanel panelTelaAlterar = new JPanel();
		panelTelaAlterar.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 12, 10, 12);
		gbc.anchor = GridBagConstraints.WEST;

		Font fonteLabel = new Font("Dialog", Font.BOLD, 14);
		Font fonteCampo = new Font("Dialog", Font.PLAIN, 14);

		// CPF (não altera)
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(fonteLabel);
		panelTelaAlterar.add(lblCpf, gbc);

		gbc.gridx = 1;
		JTextField textCpf = new JTextField(supervisorAuxiliar.getCpf(), 18);
		textCpf.setFont(fonteCampo);
		textCpf.setEditable(false);
		panelTelaAlterar.add(textCpf, gbc);

		// Nome
		gbc.gridx = 0;
		gbc.gridy = 1;
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setFont(fonteLabel);
		panelTelaAlterar.add(lblNome, gbc);

		gbc.gridx = 1;
		JTextField textNome = new JTextField(supervisorAuxiliar.getNome(), 18);
		textNome.setFont(fonteCampo);
		panelTelaAlterar.add(textNome, gbc);

		// Patio
		gbc.gridx = 0;
		gbc.gridy = 2;
		JLabel lblPatio = new JLabel("PATIO:");
		lblPatio.setFont(fonteLabel);
		panelTelaAlterar.add(lblPatio, gbc);

		gbc.gridx = 1;
		JTextField textPatio = new JTextField(supervisorAuxiliar.getPatio(), 18);
		textPatio.setFont(fonteCampo);
		panelTelaAlterar.add(textPatio, gbc);

		JButton botaoSalvar = new JButton("Salvar");

		botaoSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				supervisorAuxiliar.setNome(textoMaiusculo(textNome.getText()));
				supervisorAuxiliar.setPatio(textoMaiusculo(textPatio.getText()));


				System.out.println("Salvar Supervisor Auxiliar");
				System.out.println("CPF: " + supervisorAuxiliar.getCpf());
				System.out.println("Nome: " + supervisorAuxiliar.getNome());
				System.out.println("Patio: " + supervisorAuxiliar.getPatio());

				DaoSupervisorAuxiliar daoSupervisorAuxiliar = new DaoSupervisorAuxiliar();

				boolean atualizou = daoSupervisorAuxiliar.atualizarSupervisorAuxiliar(supervisorAuxiliar);

				if (atualizou) {
					JOptionPane.showMessageDialog(
						null,
						"Supervisor Auxiliar atualizado com sucesso",
						"Sucesso",
						JOptionPane.INFORMATION_MESSAGE
					);

					// FECHA A TELA DE ALTERAÇÃO
					frameTelaAlterar.dispose();

					// RECARREGA LISTA DO BANCO
					List<SupervisorAuxiliar> novaLista =
							daoSupervisorAuxiliar.listarSupervisorAuxiliar();

					// ABRE A TELA DE LISTAGEM ATUALIZADA
					TelaListarSupervisorAuxiliar telaListar =
							new TelaListarSupervisorAuxiliar();
					telaListar.listarSupervisorAuxiliar(novaLista);

				} else {
					JOptionPane.showMessageDialog(
						null,
						"Erro ao atualizar Supervisor Auxiliar",
						"Erro",
						JOptionPane.ERROR_MESSAGE
					);
				}

				frameTelaAlterar.dispose();
			}
		});

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		panelTelaAlterar.add(botaoSalvar, gbc);

		frameTelaAlterar.add(panelTelaAlterar);
		frameTelaAlterar.setLocationRelativeTo(null);
		frameTelaAlterar.setVisible(true);
	}
	public String textoMaiusculo (String texto) {
		return texto.toUpperCase();
		
	}
}
