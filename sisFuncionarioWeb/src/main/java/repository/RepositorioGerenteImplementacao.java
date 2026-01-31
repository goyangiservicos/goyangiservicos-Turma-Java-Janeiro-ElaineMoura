package repository;

import java.util.List;

import dao.DaoGerente;
import model.Gerente;

public class RepositorioGerenteImplementacao implements RepositorioGerente {

	DaoGerente daoGerente = new DaoGerente();
	
	@Override
	public boolean salvarGerente(Gerente gerente) {
		return daoGerente.salvarNoBanco(gerente);
	}

	@Override
	public List<Gerente> listarGerente() {
		
		return daoGerente.listarGerenteDoBanco();
	}

	@Override
    public boolean deletarGerente(String cpf) {
        return daoGerente.deletarGerente(cpf);
    }

	@Override
	public boolean atualizarGerente(Gerente gerente) {
		// TODO Auto-generated method stub
		   return daoGerente.atualizarGerente(gerente);
	}
	
	@Override
	public Gerente buscarGerentePorCpf(String cpf) {
	    return daoGerente.buscarGerentePorCpf(cpf);
	}
}