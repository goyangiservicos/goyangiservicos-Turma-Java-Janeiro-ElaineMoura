package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTextField;

import entidade.SupervisorAuxiliar;
import interfaceGrafica.TelaDetalharSupervisorAuxiliar;

public class ControladorTelaListarSupervisorAuxiliar implements ActionListener {

	JTextField textCpf;
	List<SupervisorAuxiliar> listaSupervisorAuxiliar;
	
	TelaDetalharSupervisorAuxiliar telaDetalharSupervisorAuxiliar = new TelaDetalharSupervisorAuxiliar();
	

	public ControladorTelaListarSupervisorAuxiliar(JTextField textCpf, List<SupervisorAuxiliar> listaSupervisorAuxiliar) {
		
		this.textCpf = textCpf;
		this.listaSupervisorAuxiliar = listaSupervisorAuxiliar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		telaDetalharSupervisorAuxiliar.detalharSupervisorAuxiliar(buscarSupervisorAuxiliarPorCpf());
		
	}
	
	public SupervisorAuxiliar buscarSupervisorAuxiliarPorCpf() {
		
		for(SupervisorAuxiliar supervisorAuxiliar: listaSupervisorAuxiliar) {
			if(supervisorAuxiliar.getCpf().equals(textCpf.getText())) {
				return supervisorAuxiliar;
			}
		}
		
		return null;
	}

}

