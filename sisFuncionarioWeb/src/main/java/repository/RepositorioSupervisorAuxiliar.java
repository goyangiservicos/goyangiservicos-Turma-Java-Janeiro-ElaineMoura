package repository;


import java.util.List;

import model.SupervisorAuxiliar;

public interface RepositorioSupervisorAuxiliar {
	public boolean salvarSupervisorAuxiliar(SupervisorAuxiliar supervisorAuxiliar);
	
	public List<SupervisorAuxiliar> listarSupervisorAuxiliar();

	boolean deletarSupervisorAuxiliar(String cpf);

}
