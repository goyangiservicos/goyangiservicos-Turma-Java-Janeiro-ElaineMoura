package repository;

import java.util.List;

import dao.DaoFuncionarioInterno;
import model.FuncionarioInterno;

public class RepositorioFuncionarioInternoImplementacao implements RepositorioFuncionarioInterno {

	DaoFuncionarioInterno daoFuncionarioInterno = new DaoFuncionarioInterno();
	
	@Override
	public boolean salvarFuncionarioInterno(FuncionarioInterno funcionarioInterno) {
		return daoFuncionarioInterno.salvar(funcionarioInterno);
	}

	@Override
	public List<FuncionarioInterno> listarFuncionarioInterno() {
		
		return daoFuncionarioInterno.listar();
	}

	@Override
    public boolean deletarFuncionarioInterno(String cpf) {
        return daoFuncionarioInterno.deletar(cpf);
    }

	@Override
	public boolean atualizarFuncionarioInterno(FuncionarioInterno funcionarioInterno) {
		// TODO Auto-generated method stub
		   return daoFuncionarioInterno.atualizarFuncionarioInterno(funcionarioInterno);
	}
	
	@Override
	public FuncionarioInterno buscarFuncionarioInternoPorCpf(String cpf) {
	    return daoFuncionarioInterno.buscarPorCpf(cpf);
	}
}