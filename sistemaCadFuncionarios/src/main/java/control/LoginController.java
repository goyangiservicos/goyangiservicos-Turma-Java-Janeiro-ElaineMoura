package control;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.FuncionarioInterno;
import model.FuncionarioTerceirizado;
import repository.RepositorioFuncionarioInternoImplementacao;
import repository.RepositorioFuncionarioTerceirizadoImplementacao;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// LOGOUT
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}

		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}

	// LOGIN
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cpf = request.getParameter("cpf");
		String senha = request.getParameter("senha");

		HttpSession session = request.getSession();

		// TENTA FUNCIONÁRIO INTERNO
		RepositorioFuncionarioInternoImplementacao repoInterno = new RepositorioFuncionarioInternoImplementacao();

		FuncionarioInterno interno = repoInterno.buscarFuncionarioInternoPorCpf(cpf);

		if (interno != null && interno.getSenha() != null) {
			if (senha.equals(decodificar(interno.getSenha()))) {
				session.setAttribute("usuarioLogado", interno);
				response.sendRedirect(request.getContextPath() + "/home.jsp");
				return;
			}
		}

		// TENTA FUNCIONÁRIO TERCEIRIZADO
		RepositorioFuncionarioTerceirizadoImplementacao repoTerceirizado = new RepositorioFuncionarioTerceirizadoImplementacao();

		FuncionarioTerceirizado terceirizado = repoTerceirizado.buscarFuncionarioTerceirizadoPorCpf(cpf);

		if (terceirizado != null && terceirizado.getSenha() != null) {
			if (senha.equals(decodificar(terceirizado.getSenha()))) {
				session.setAttribute("usuarioLogado", terceirizado);
				response.sendRedirect(request.getContextPath() + "/home.jsp");
				return;
			}
		}

		//  ERRO
		response.sendRedirect(request.getContextPath() + "/erro.jsp");
	}

	private String decodificar(String base64) {
		byte[] bytes = Base64.getDecoder().decode(base64);
		return new String(bytes, StandardCharsets.UTF_8);
	}

}