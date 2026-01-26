package interfaceGrafica;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import interfaceGrafica.TelaAlterarSupervisorAuxiliar;

import entidade.SupervisorAuxiliar;

public class TelaDetalharSupervisorAuxiliar {


	
	public void detalharSupervisorAuxiliar(SupervisorAuxiliar supervisorAuxiliar) {
		
		GridLayout grid = new GridLayout(0,2);
		
		JFrame frameTelaSupervisorAuxiliar = new JFrame("Detalhes do Supervisor Auxiliar");
		frameTelaSupervisorAuxiliar.setSize(300,180);
		
		JPanel panelTelaSupervisorAuxiliar = new JPanel();
		panelTelaSupervisorAuxiliar.setLayout(grid);
		
		panelTelaSupervisorAuxiliar.add(new JLabel("CPF:"));
		panelTelaSupervisorAuxiliar.add(new JLabel(supervisorAuxiliar.getCpf()));
		
		
		panelTelaSupervisorAuxiliar.add(new JLabel("NOME:"));
		panelTelaSupervisorAuxiliar.add(new JLabel(supervisorAuxiliar.getNome()));
		
		panelTelaSupervisorAuxiliar.add(new JLabel("PATIO:"));
		panelTelaSupervisorAuxiliar.add(new JLabel(supervisorAuxiliar.getPatio()));
		
		
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

		panelTelaSupervisorAuxiliar.add(new JLabel(""));
		panelTelaSupervisorAuxiliar.add(botaoEditar);
		frameTelaSupervisorAuxiliar.dispose();

		
		
		frameTelaSupervisorAuxiliar.add(panelTelaSupervisorAuxiliar);
		frameTelaSupervisorAuxiliar.setVisible(true);
		
		
		
		
		
		
		
	}
	
	
}
