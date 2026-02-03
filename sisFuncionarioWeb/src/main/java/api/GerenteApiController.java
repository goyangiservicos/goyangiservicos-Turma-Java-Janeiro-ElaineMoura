package api;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Gerente;
import repository.RepositorioGerenteImplementacao;

/**
 * Servlet implementation class gerenteApiController
 */
@WebServlet("/GerenteApiController")
public class GerenteApiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private final RepositorioGerenteImplementacao repositorioGerenteImplementacao =new RepositorioGerenteImplementacao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GerenteApiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    //LISTAR TODOS OU BUSCAR POR CPF 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json; charset=UTF-8");
		
		String cpf = request.getParameter("cpf");
		
		
		if (cpf != null) {
		    Gerente gerente = repositorioGerenteImplementacao.buscarGerentePorCpf(cpf);

		    if (gerente == null) {
		        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		        response.getWriter().write(
		            "{\"ok\":false,\"message\":\"Gerente não encontrado\"}"
		        );
		    } else {
		        response.getWriter().write(
		            "{\"ok\":true,\"data\":" + atendenteToJson(gerente) + "}"
		        );
		    }
		    return;
		}
	    // LISTAR TODOS
	    List<Gerente> lista = repositorioGerenteImplementacao.listarGerente();
	    String json = listaToJson(lista);
	    response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    String cpf = request.getParameter("cpf");
	    String nome = request.getParameter("nome");
	    String gerencia = request.getParameter("gerencia");

	    
	    // Se não vier dados de salvar, faz o que já fazia antes
	    if (cpf == null && nome == null && gerencia == null) {
	        doGet(request, response);
	        return;
	    }

	    //  SALVAR
	    response.setContentType("application/json; charset=UTF-8");

	    if (cpf == null || nome == null || gerencia == null ||
	        cpf.isEmpty() || nome.isEmpty() || gerencia.isEmpty()) {

	        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	        response.getWriter().write(
	            "{\"ok\":false,\"message\":\"cpf, nome e gerencia são obrigatórios\"}"
	        );
	        return;
	    }

	    Gerente gerente = new Gerente();
	    gerente.setCpf(cpf);
	    gerente.setNome(nome);
	    gerente.setGerencia(gerencia);

	    boolean salvo = repositorioGerenteImplementacao.salvarGerente(gerente);

	    if (salvo) {
	        response.setStatus(HttpServletResponse.SC_CREATED);
	        response.getWriter().write(
	            "{\"ok\":true,\"message\":\"Gerente cadastrado\"}"
	        );
	    } else {
	        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	        response.getWriter().write(
	            "{\"ok\":false,\"message\":\"Erro ao cadastrar gerente\"}"
	        );
	    }
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    response.setContentType("application/json; charset=UTF-8");

	    String cpf = request.getParameter("cpf");

	    if (cpf == null || cpf.isEmpty()) {
	        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	        response.getWriter().write(
	            "{\"ok\":false,\"message\":\"CPF obrigatório\"}"
	        );
	        return;
	    }

	    boolean deletado = repositorioGerenteImplementacao.deletarGerente(cpf);

	    if (deletado) {
	        response.getWriter().write(
	            "{\"ok\":true,\"message\":\"Gerente deletado\"}"
	        );
	    } else {
	        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
	        response.getWriter().write(
	            "{\"ok\":false,\"message\":\"Gerente não encontrado\"}"
	        );
	    }
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    response.setContentType("application/json; charset=UTF-8");

	    
	    String body = request.getReader()
	            .lines()
	            .collect(java.util.stream.Collectors.joining("&"));

	    String cpf = null;
	    String nome = null;
	    String gerencia = null;

	    for (String param : body.split("&")) {
	        String[] kv = param.split("=");
	        if (kv.length == 2) {
	            String key = java.net.URLDecoder.decode(kv[0], "UTF-8");
	            String value = java.net.URLDecoder.decode(kv[1], "UTF-8");

	            if ("cpf".equals(key)) cpf = value;
	            if ("nome".equals(key)) nome = value;
	            if ("gerencia".equals(key)) gerencia = value;
	        }
	    }

	    // valida CPF
	    if (cpf == null || cpf.trim().isEmpty()) {
	        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	        response.getWriter().write(
	            "{\"ok\":false,\"message\":\"CPF obrigatório para atualização\"}"
	        );
	        return;
	    }

	    if (nome == null || nome.trim().isEmpty() ||
	        gerencia == null || gerencia.trim().isEmpty()) {

	        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	        response.getWriter().write(
	            "{\"ok\":false,\"message\":\"nome e gerencia são obrigatórios\"}"
	        );
	        return;
	    }

	    Gerente gerente = new Gerente();
	    gerente.setCpf(cpf);
	    gerente.setNome(nome);
	    gerente.setGerencia(gerencia);

	    boolean atualizado = repositorioGerenteImplementacao.atualizarGerente(gerente);

	    if (atualizado) {
	        response.getWriter().write(
	            "{\"ok\":true,\"message\":\"Gerente atualizado\"}"
	        );
	    } else {
	        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
	        response.getWriter().write(
	            "{\"ok\":false,\"message\":\"Gerente não encontrado\"}"
	        );
	    }
	}
	
	//daqui pra baixo os frameworks fazem 
	// Retorna uma lista de atendentes em JSON
	private String listaToJson(List<Gerente> lista) {
	    StringBuilder sb = new StringBuilder();
	    sb.append("{\"ok\":true,\"data\":[");
	    for (int i = 0; i < lista.size(); i++) {
	        sb.append(atendenteToJson(lista.get(i)));
	        if (i < lista.size() - 1) sb.append(",");
	    }
	    sb.append("]}");
	    return sb.toString();
	}

	private String atendenteToJson(Gerente a) {
	    return "{"
	        + "\"cpf\":\"" + esc(a.getCpf()) + "\","
	        + "\"nome\":\"" + esc(a.getNome()) + "\","
	        + "\"setor\":\"" + esc(a.getGerencia()) + "\""
	        + "}";
	}

	private String esc(String s) {
	    if (s == null) return "";
	    return s.replace("\\", "\\\\").replace("\"", "\\\"");
	}

}
