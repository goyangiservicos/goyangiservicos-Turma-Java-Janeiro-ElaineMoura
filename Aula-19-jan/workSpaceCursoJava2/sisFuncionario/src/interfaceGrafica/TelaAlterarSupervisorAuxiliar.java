package interfaceGrafica;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import bancoDadosDao.DaoSupervisorAuxiliar;


import entidade.SupervisorAuxiliar;

public class TelaAlterarSupervisorAuxiliar {

	public void alterarSupervisorAuxiliar(SupervisorAuxiliar supervisorAuxiliar) {

		GridLayout grid = new GridLayout(0, 2);

		JFrame frameTelaAlterar = new JFrame("Alterar Supervisor Auxiliar");
		frameTelaAlterar.setSize(300, 200);

		JPanel panelTelaAlterar = new JPanel();
		panelTelaAlterar.setLayout(grid);

		// CPF (não altera)
		panelTelaAlterar.add(new JLabel("CPF:"));
		JTextField textCpf = new JTextField(supervisorAuxiliar.getCpf());
		textCpf.setEditable(false);
		panelTelaAlterar.add(textCpf);

		// Nome
		panelTelaAlterar.add(new JLabel("NOME:"));
		JTextField textNome = new JTextField(supervisorAuxiliar.getNome());
		panelTelaAlterar.add(textNome);

		// Patio
		panelTelaAlterar.add(new JLabel("PATIO:"));
		JTextField textPatio = new JTextField(supervisorAuxiliar.getPatio());
		panelTelaAlterar.add(textPatio);

		JButton botaoSalvar = new JButton("Salvar");

		botaoSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				supervisorAuxiliar.setNome(textNome.getText());
				supervisorAuxiliar.setPatio(textPatio.getText());

				System.out.println("Salvar Supervisor Auxiliar");
				System.out.println("CPF: " + supervisorAuxiliar.getCpf());
				System.out.println("Nome: " + supervisorAuxiliar.getNome());
				System.out.println("Patio: " + supervisorAuxiliar.getPatio());

				DaoSupervisorAuxiliar daoSupervisorAuxiliar = new DaoSupervisorAuxiliar();

				boolean atualizou = daoSupervisorAuxiliar.atualizarSupervisorAuxiliar(supervisorAuxiliar);

				if (atualizou) {
					System.out.println("Supervisor Auxiliar atualizado com sucesso");
				} else {
					System.out.println("Erro ao atualizar Supervisor Auxiliar");
				}

				frameTelaAlterar.dispose();
			}
		});

		panelTelaAlterar.add(new JLabel(""));
		panelTelaAlterar.add(botaoSalvar);

		frameTelaAlterar.add(panelTelaAlterar);
		frameTelaAlterar.setVisible(true);
	}
}
