package control;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cargo;
import model.FuncionarioInterno;
import repository.RepositorioFuncionarioInternoImplementacao;

@WebServlet("/FuncionarioInternoController")
public class FuncionarioInternoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RepositorioFuncionarioInternoImplementacao repositorio =
				new RepositorioFuncionarioInternoImplementacao();

		String acao = request.getParameter("acao");
		String cpf = request.getParameter("cpf");

		// DELETAR
		if ("deletar".equals(acao) && cpf != null && !cpf.isEmpty()) {
			repositorio.deletarFuncionarioInterno(cpf);
		}

		// BUSCAR PARA ATUALIZAR
		if ("buscar".equals(acao) && cpf != null && !cpf.isEmpty()) {
			FuncionarioInterno funcionario =
					repositorio.buscarFuncionarioInternoPorCpf(cpf);
			request.setAttribute("funcionarioAtualizar", funcionario);
		}

		// LISTAR
		request.setAttribute(
				"listaFuncionarioInterno",
				repositorio.listarFuncionarioInterno()
		);

		request.getRequestDispatcher("/FuncionarioInternoCrud.jsp")
		       .forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");

		RepositorioFuncionarioInternoImplementacao repositorio =
				new RepositorioFuncionarioInternoImplementacao();

		FuncionarioInterno funcionarioInterno = new FuncionarioInterno();

		funcionarioInterno.setCpf(request.getParameter("cpf"));
		funcionarioInterno.setNome(request.getParameter("nome"));
		funcionarioInterno.setDataNascimento(
				LocalDate.parse(request.getParameter("dataNascimento"))
		);
		funcionarioInterno.setMatricula(request.getParameter("matricula"));
		funcionarioInterno.setCargo(
				Cargo.valueOf(request.getParameter("cargo"))
		);
		funcionarioInterno.setSalario(
				new BigDecimal(request.getParameter("salario"))
		);

		if ("atualizar".equals(acao)) {
			repositorio.atualizarFuncionarioInterno(funcionarioInterno);
		} else {
			repositorio.salvarFuncionarioInterno(funcionarioInterno);
		}

		response.sendRedirect(request.getContextPath() + "/FuncionarioInternoController");
	}
}