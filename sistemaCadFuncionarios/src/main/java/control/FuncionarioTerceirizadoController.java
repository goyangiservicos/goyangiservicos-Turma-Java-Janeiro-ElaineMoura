package control;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Funcao;
import model.FuncionarioTerceirizado;
import repository.RepositorioFuncionarioTerceirizadoImplementacao;

@WebServlet("/FuncionarioTerceirizadoController")
public class FuncionarioTerceirizadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RepositorioFuncionarioTerceirizadoImplementacao repositorio = new RepositorioFuncionarioTerceirizadoImplementacao();

		String acao = request.getParameter("acao");
		String cpf = request.getParameter("cpf");

		// DELETAR
		if ("deletar".equals(acao) && cpf != null && !cpf.isEmpty()) {
			repositorio.deletarFuncionarioTerceirizado(cpf);
		}

		// BUSCAR PARA ATUALIZAR
		if ("buscar".equals(acao) && cpf != null && !cpf.isEmpty()) {
			FuncionarioTerceirizado funcionario = repositorio.buscarFuncionarioTerceirizadoPorCpf(cpf);
			request.setAttribute("funcionarioAtualizar", funcionario);
		}

		// LISTAR
		request.setAttribute("listaFuncionarioTerceirizado", repositorio.listarFuncionarioTerceirizado());

		request.getRequestDispatcher("/FuncionarioTerceirizadoCrud.jsp").forward(request, response);
	}

	
	// valida se a ação enviada pelo formulário. Se "atualizar", altera um registro, se n cria um novo funcionario terceirizado.
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");

		RepositorioFuncionarioTerceirizadoImplementacao repositorio = new RepositorioFuncionarioTerceirizadoImplementacao();

		FuncionarioTerceirizado funcionarioTerceirizado = new FuncionarioTerceirizado();

		funcionarioTerceirizado.setCpf(request.getParameter("cpf"));
		funcionarioTerceirizado.setNome(request.getParameter("nome"));
		funcionarioTerceirizado.setDataNascimento(LocalDate.parse(request.getParameter("dataNascimento")));
		funcionarioTerceirizado.setFuncao(Funcao.valueOf(request.getParameter("funcao")));
		funcionarioTerceirizado.setEmpresa(request.getParameter("empresa"));
		funcionarioTerceirizado.setHorasTrabalhadas(new BigDecimal(request.getParameter("horasTrabalhadas")));

		if ("atualizar".equals(acao)) {
			repositorio.atualizarFuncionarioTerceirizado(funcionarioTerceirizado);
		} else {
			repositorio.salvarFuncionarioTerceirizado(funcionarioTerceirizado);
		}

		response.sendRedirect(request.getContextPath() + "/FuncionarioTerceirizadoController");
	}
}