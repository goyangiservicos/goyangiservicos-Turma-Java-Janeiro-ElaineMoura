package repositorio;

import bancoDadosDao.DaoAtendente;
import entidade.Atendente;

public class RepositorioAtendenteImplementacao  implements RepositorioAtendente{
	DaoAtendente daoAtendente = new DaoAtendente();

	@Override
	public boolean salvarAtendente(Atendente atendente) {
		// TODO Auto-generated method stub
		return daoAtendente.salvarNoBanco(atendente);
	}
	

}



