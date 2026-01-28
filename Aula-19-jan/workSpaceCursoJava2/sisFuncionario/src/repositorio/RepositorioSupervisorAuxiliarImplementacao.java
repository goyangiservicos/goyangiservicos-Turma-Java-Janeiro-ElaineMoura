package repositorio;
import java.util.List;

import bancoDadosDao.DaoSupervisorAuxiliar;
import entidade.SupervisorAuxiliar;
public class RepositorioSupervisorAuxiliarImplementacao implements RepositorioSupervisorAuxiliar {

		
	DaoSupervisorAuxiliar daoSupervisorAuxiliar = new DaoSupervisorAuxiliar();

	@Override
	public boolean salvarSupervisorAuxiliar(SupervisorAuxiliar supervisorAuxiliar) {
		supervisorAuxiliar.setNome(textoMaiusculo(supervisorAuxiliar.getNome()));
		supervisorAuxiliar.setPatio(textoMaiusculo(supervisorAuxiliar.getPatio()));
		return daoSupervisorAuxiliar.salvarNoBanco(supervisorAuxiliar);
	}

	@Override
	public List<SupervisorAuxiliar> listarSupervisorAuxiliar() {
		
		return daoSupervisorAuxiliar.listarSupervisorAuxiliar();
	}

	public String textoMaiusculo (String texto) {
		return texto.toUpperCase();
		
	}

}


