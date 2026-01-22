package repositorio;

import bancoDadosDao.DaoGerente;
import entidade.Gerente;

public class RepositorioGerenteImplementacao implements RepositorioGerente {

	DaoGerente daoGerente = new DaoGerente();

	@Override
	public boolean salvarGerente(Gerente gerente) {
		// TODO Auto-generated method stub
		return daoGerente.salvarNoBanco(gerente);
	}

}
