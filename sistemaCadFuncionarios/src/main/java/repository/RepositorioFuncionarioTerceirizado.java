package repository;

import java.util.List;

import model.FuncionarioTerceirizado;

public interface RepositorioFuncionarioTerceirizado {
	public boolean salvarFuncionarioTerceirizado(FuncionarioTerceirizado funcionarioTerceirizado);

	public List<FuncionarioTerceirizado> listarFuncionarioTerceirizado();

	boolean deletarFuncionarioTerceirizado(String cpf);

	boolean atualizarFuncionarioTerceirizado(FuncionarioTerceirizado funcionarioTerceirizado);

	FuncionarioTerceirizado buscarFuncionarioTerceirizadoPorCpf(String cpf);

}
