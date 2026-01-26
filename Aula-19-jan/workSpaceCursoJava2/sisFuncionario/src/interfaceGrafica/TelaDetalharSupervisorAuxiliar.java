package interfaceGrafica;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
		
		frameTelaSupervisorAuxiliar.add(panelTelaSupervisorAuxiliar);
		frameTelaSupervisorAuxiliar.setVisible(true);
		
		
		
		
		
		
		
	}
	
	
}
