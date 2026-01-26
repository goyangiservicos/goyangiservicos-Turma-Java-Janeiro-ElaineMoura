package repositorio;

import java.util.List;

import entidade.SupervisorAuxiliar;

public interface RepositorioSupervisorAuxiliar {
	public boolean salvarSupervisorAuxiliar(SupervisorAuxiliar supervisorAuxiliar);
	
	public List<SupervisorAuxiliar> listarSupervisorAuxiliar();

}
