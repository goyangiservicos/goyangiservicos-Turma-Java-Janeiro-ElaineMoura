package repository;

import java.util.List;
import model.FuncionarioInterno;


public interface RepositorioFuncionarioInterno {

	public boolean salvarFuncionarioInterno(FuncionarioInterno FuncionarioInterno); // Assinatura

	public List<FuncionarioInterno> listarFuncionarioInterno();

	boolean deletarFuncionarioInterno(String cpf);

	boolean atualizarFuncionarioInterno(FuncionarioInterno FuncionarioInterno);

	FuncionarioInterno buscarFuncionarioInternoPorCpf(String cpf);
}