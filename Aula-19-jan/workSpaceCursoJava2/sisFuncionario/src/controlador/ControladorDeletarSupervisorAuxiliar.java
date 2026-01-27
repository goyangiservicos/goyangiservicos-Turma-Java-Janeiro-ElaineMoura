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

		DaoSupervisorAuxiliar daoSupervisorAuxiliar = new DaoSupervisorAuxiliar();

		boolean deletou = daoSupervisorAuxiliar.deletarSupervisorAuxiliar(cpf);

		if (deletou) {
			JOptionPane.showMessageDialog(
				null,
				"Supervisor Auxiliar deletado com sucesso",
				"Sucesso",
				JOptionPane.INFORMATION_MESSAGE
			);

			// FECHA A TELA ATUAL
			JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(textCpf);
			frame.dispose();

			// RECARREGA A LISTA DO BANCO
			List<SupervisorAuxiliar> novaLista =
					daoSupervisorAuxiliar.listarSupervisorAuxiliar();

			// ABRE A TELA DE LISTAGEM ATUALIZADA
			TelaListarSupervisorAuxiliar tela =
					new TelaListarSupervisorAuxiliar();
			tela.listarSupervisorAuxiliar(novaLista);

		} else {
			JOptionPane.showMessageDialog(
				null,
				"Erro ao deletar Supervisor Auxiliar",
				"Erro",
				JOptionPane.ERROR_MESSAGE
			);
		}
	}
	}

