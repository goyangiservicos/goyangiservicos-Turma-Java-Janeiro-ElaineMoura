package interfaceGrafica;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entidade.SupervisorAuxiliar;

public class TelaDetalharSupervisorAuxiliar {

	public void detalharSupervisorAuxiliar(SupervisorAuxiliar supervisorAuxiliar) {

		JFrame frameTelaSupervisorAuxiliar = new JFrame("Detalhes do Supervisor Auxiliar");
		frameTelaSupervisorAuxiliar.setSize(350, 220);

		JPanel panelTelaSupervisorAuxiliar = new JPanel();
		panelTelaSupervisorAuxiliar.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(6, 6, 6, 6);
		gbc.anchor = GridBagConstraints.WEST;

		gbc.gridx = 0;
		gbc.gridy = 0;
		panelTelaSupervisorAuxiliar.add(new JLabel("CPF:"), gbc);

		gbc.gridx = 1;
		panelTelaSupervisorAuxiliar.add(new JLabel(supervisorAuxiliar.getCpf()), gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		panelTelaSupervisorAuxiliar.add(new JLabel("NOME:"), gbc);

		gbc.gridx = 1;
		panelTelaSupervisorAuxiliar.add(new JLabel(supervisorAuxiliar.getNome()), gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		panelTelaSupervisorAuxiliar.add(new JLabel("PATIO:"), gbc);

		gbc.gridx = 1;
		panelTelaSupervisorAuxiliar.add(new JLabel(supervisorAuxiliar.getPatio()), gbc);

		JButton botaoEditar = new JButton("Editar");

		botaoEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// CPF já está no objeto recebido
				String cpf = supervisorAuxiliar.getCpf();

				System.out.println("CPF selecionado para edicao: " + cpf);

				TelaAlterarSupervisorAuxiliar telaAlterar = new TelaAlterarSupervisorAuxiliar();
				telaAlterar.alterarSupervisorAuxiliar(supervisorAuxiliar);

			}
		});

		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.CENTER;
		panelTelaSupervisorAuxiliar.add(botaoEditar, gbc);

		frameTelaSupervisorAuxiliar.add(panelTelaSupervisorAuxiliar);
		frameTelaSupervisorAuxiliar.setLocationRelativeTo(null);
		frameTelaSupervisorAuxiliar.setVisible(true);
	}
}
