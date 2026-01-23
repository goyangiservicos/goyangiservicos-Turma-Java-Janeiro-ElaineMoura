package repositorio;
import java.util.List;

import bancoDadosDao.DaoSupervisorAuxiliar;
import entidade.SupervisorAuxiliar;
public class RepositorioSupervisorAuxiliarImplementacao implements RepositorioSupervisorAuxiliar {

		
	DaoSupervisorAuxiliar daoSupervisorAuxiliar = new DaoSupervisorAuxiliar();

	@Override
	public boolean salvarSupervisorAuxiliar(SupervisorAuxiliar supervisorAuxiliar) {
		// TODO Auto-generated method stub
		return daoSupervisorAuxiliar.salvarNoBanco(supervisorAuxiliar);
	}

	@Override
	public List<SupervisorAuxiliar> listarSupervisorAuxiliar() {
		
		return daoSupervisorAuxiliar.listarSupervisorAuxiliar();
	}

	

}


