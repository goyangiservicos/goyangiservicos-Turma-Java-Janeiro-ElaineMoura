package api;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cargo;
import model.FuncionarioInterno;
import repository.RepositorioFuncionarioInternoImplementacao;

@WebServlet("/FuncionarioInternoApiController")
public class FuncionarioInternoApiController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final RepositorioFuncionarioInternoImplementacao repositorio = new RepositorioFuncionarioInternoImplementacao();

	// ================= GET =================
	// listar todos ou buscar por CPF
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json; charset=UTF-8");

		String cpf = request.getParameter("cpf");

		if (cpf != null && !cpf.isEmpty()) {
			FuncionarioInterno f = repositorio.buscarFuncionarioInternoPorCpf(cpf);

			if (f == null) {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
				response.getWriter().write("{\"ok\":false,\"message\":\"Funcionário não encontrado\"}");
				return;
			}

			response.getWriter().write("{\"ok\":true,\"data\":" + toJson(f) + "}");
			return;
		}

		List<FuncionarioInterno> lista = repositorio.listarFuncionarioInterno();
		response.getWriter().write(listaToJson(lista));
	}

	// ================= POST =================
	// salvar
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cpf = request.getParameter("cpf");

		if (cpf == null || cpf.trim().isEmpty() || cpf.length() != 11) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().write("{\"ok\":false,\"message\":\"CPF é obrigatório e deve ter 11 dígitos\"}");
			return;
		}
		response.setContentType("application/json; charset=UTF-8");

		try {
			FuncionarioInterno f = new FuncionarioInterno();
			f.setCpf(cpf);
			f.setNome(request.getParameter("nome"));
			f.setMatricula(request.getParameter("matricula"));
			f.setCargo(Cargo.valueOf(request.getParameter("cargo")));
			f.setSalario(new BigDecimal(request.getParameter("salario")));
			f.setDataNascimento(LocalDate.parse(request.getParameter("dataNascimento")));

			boolean salvo = repositorio.salvarFuncionarioInterno(f);

			if (salvo) {
				response.setStatus(HttpServletResponse.SC_CREATED);
				response.getWriter().write("{\"ok\":true}");
			} else {
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				response.getWriter().write("{\"ok\":false}");
			}

		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().write("{\"ok\":false,\"message\":\"Dados inválidos\"}");
		}
	}

	// ================= PUT =================
	// atualizar
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json; charset=UTF-8");

		String body = request.getReader().lines().collect(java.util.stream.Collectors.joining("&"));

		String cpf = null;
		String nome = null;
		String matricula = null;
		String cargo = null;
		String salario = null;
		String dataNascimento = null;

		for (String param : body.split("&")) {
			String[] kv = param.split("=");
			if (kv.length == 2) {
				String key = java.net.URLDecoder.decode(kv[0], "UTF-8");
				String value = java.net.URLDecoder.decode(kv[1], "UTF-8");

				if ("cpf".equals(key))
					cpf = value;
				if ("nome".equals(key))
					nome = value;
				if ("matricula".equals(key))
					matricula = value;
				if ("cargo".equals(key))
					cargo = value;
				if ("salario".equals(key))
					salario = value;
				if ("dataNascimento".equals(key))
					dataNascimento = value;
			}
		}

		// valida CPF
		if (cpf == null || cpf.trim().isEmpty() || cpf.length() != 11) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().write("{\"ok\":false,\"message\":\"CPF é obrigatório e deve ter 11 dígitos\"}");
			return;
		}

		try {
			FuncionarioInterno f = new FuncionarioInterno();
			f.setCpf(cpf);
			f.setNome(nome);
			f.setMatricula(matricula);
			f.setCargo(Cargo.valueOf(cargo));
			f.setSalario(new BigDecimal(salario));
			f.setDataNascimento(LocalDate.parse(dataNascimento));

			boolean atualizado = repositorio.atualizarFuncionarioInterno(f);

			if (atualizado) {
				response.getWriter().write("{\"ok\":true}");
			} else {
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
				response.getWriter().write("{\"ok\":false}");
			}

		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().write("{\"ok\":false,\"message\":\"Dados inválidos\"}");
		}
	}

	// ================= DELETE =================
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json; charset=UTF-8");

		String cpf = request.getParameter("cpf");

		if (cpf == null || cpf.isEmpty()) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().write("{\"ok\":false,\"message\":\"CPF obrigatório\"}");
			return;
		}

		boolean deletado = repositorio.deletarFuncionarioInterno(cpf);

		if (deletado) {
			response.getWriter().write("{\"ok\":true}");
		} else {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			response.getWriter().write("{\"ok\":false}");
		}
	}

	// ================= JSON =================
	private String listaToJson(List<FuncionarioInterno> lista) {
		StringBuilder sb = new StringBuilder();
		sb.append("{\"ok\":true,\"data\":[");
		for (int i = 0; i < lista.size(); i++) {
			sb.append(toJson(lista.get(i)));
			if (i < lista.size() - 1)
				sb.append(",");
		}
		sb.append("]}");
		return sb.toString();
	}

	private String toJson(FuncionarioInterno f) {
		return "{" + "\"cpf\":\"" + esc(f.getCpf()) + "\"," + "\"nome\":\"" + esc(f.getNome()) + "\","
				+ "\"matricula\":\"" + esc(f.getMatricula()) + "\"," + "\"cargo\":\"" + f.getCargo().name() + "\","
				+ "\"salario\":" + f.getSalario() + "," + "\"plr\":" + f.getPlr() + "}";
	}

	private String esc(String s) {
		if (s == null)
			return "";
		return s.replace("\\", "\\\\").replace("\"", "\\\"");
	}
}