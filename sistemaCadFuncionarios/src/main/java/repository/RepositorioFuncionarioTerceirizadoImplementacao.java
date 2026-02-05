package repository;

import java.util.List;

import dao.DaoFuncionarioTerceirizado;
import model.FuncionarioTerceirizado;

public class RepositorioFuncionarioTerceirizadoImplementacao implements RepositorioFuncionarioTerceirizado {

	DaoFuncionarioTerceirizado daoFuncionarioTerceirizado = new DaoFuncionarioTerceirizado();

	@Override
	public boolean salvarFuncionarioTerceirizado(FuncionarioTerceirizado funcionarioTerceirizado) {
		return daoFuncionarioTerceirizado.salvarNoBanco(funcionarioTerceirizado);
	}

	@Override
	public List<FuncionarioTerceirizado> listarFuncionarioTerceirizado() {

		return daoFuncionarioTerceirizado.listarFuncionarioTerceirizado();
	}

	@Override
	public boolean deletarFuncionarioTerceirizado(String cpf) {
		return daoFuncionarioTerceirizado.deletarFuncionarioTerceirizado(cpf);
	}

	@Override
	public boolean atualizarFuncionarioTerceirizado(FuncionarioTerceirizado funcionarioTerceirizado) {
		// TODO Auto-generated method stub
		return daoFuncionarioTerceirizado.atualizarFuncionarioTerceirizado(funcionarioTerceirizado);
	}

	@Override
	public FuncionarioTerceirizado buscarFuncionarioTerceirizadoPorCpf(String cpf) {
		return daoFuncionarioTerceirizado.buscarPorCpf(cpf);
	}
}
