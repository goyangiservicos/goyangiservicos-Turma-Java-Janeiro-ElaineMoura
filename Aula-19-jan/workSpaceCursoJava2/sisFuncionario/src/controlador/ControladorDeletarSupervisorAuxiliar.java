package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import bancoDadosDao.DaoSupervisorAuxiliar;
import entidade.SupervisorAuxiliar;
import interfaceGrafica.TelaListarSupervisorAuxiliar;

public class ControladorDeletarSupervisorAuxiliar implements ActionListener {

	JTextField textCpf;

	public ControladorDeletarSupervisorAuxiliar(JTextField textCpf) {
		this.textCpf = textCpf;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String cpf = textCpf.getText();

		// 1) campo vazio
		if (cpf == null || cpf.trim().isEmpty()) {
			JOptionPane.showMessageDialog(
				null,
				"Digite um CPF para deletar",
				"Atenção",
				JOptionPane.WARNING_MESSAGE
			);
			return;
		}

		DaoSupervisorAuxiliar daoSupervisorAuxiliar = new DaoSupervisorAuxiliar();

		boolean deletou = daoSupervisorAuxiliar.deletarSupervisorAuxiliar(cpf);

		// 2) CPF não encontrado
		if (!deletou) {
			JOptionPane.showMessageDialog(
				null,
				"CPF não encontrado",
				"Atenção",
				JOptionPane.WARNING_MESSAGE
			);
			return;
		}

		// 3) sucesso
		JOptionPane.showMessageDialog(
			null,
			"Supervisor Auxiliar deletado com sucesso",
			"Sucesso",
			JOptionPane.INFORMATION_MESSAGE
		);

		// fecha a tela atual
		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(textCpf);
		frame.dispose();

		// recarrega lista
		List<SupervisorAuxiliar> novaLista =
				daoSupervisorAuxiliar.listarSupervisorAuxiliar();

		// abre listagem atualizada
		TelaListarSupervisorAuxiliar tela =
				new TelaListarSupervisorAuxiliar();
		tela.listarSupervisorAuxiliar(novaLista);
	}
}
