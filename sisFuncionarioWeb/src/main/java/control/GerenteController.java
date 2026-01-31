package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Gerente;
import repository.RepositorioGerenteImplementacao;

/**
 * Servlet implementation class GerenteController
 */
@WebServlet("/GerenteController")
public class GerenteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GerenteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Gerente gerente =new Gerente();
		//gerente.setCpf("32786097860");
		//gerente.setNome("ELAINE");
		//gerente.setGerencia("GERENCIA GERAL");
		
		RepositorioGerenteImplementacao repositorioGerenteImplementacao = new RepositorioGerenteImplementacao();
		//repositorioGerenteImplementacao.salvarGerente(gerente);
		
		String acao = request.getParameter("acao");
		String cpf = request.getParameter("cpf");
		
		//para deletar
				if ("deletar".equals(acao) && cpf != null && !cpf.isEmpty()) {
		    System.out.println("entrou aqui deletar");
		    repositorioGerenteImplementacao.deletarGerente(cpf);
		}
				//para atualizar
				if ("atualizar".equals(acao) && cpf != null && !cpf.isEmpty()) {
		    System.out.println("entrou aqui atualizar ");
		    Gerente gerenteAtualizar = repositorioGerenteImplementacao.buscarGerentePorCpf(cpf);
		request.setAttribute("gerenteAtualizar", gerenteAtualizar);
		
				}
				
		request.setAttribute("listarGerente", repositorioGerenteImplementacao.listarGerente());
		request.getRequestDispatcher("/GerenteCrud.jsp").forward(request, response);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		// TODO Auto-generated method stub
		//doGet(request, response);
		RepositorioGerenteImplementacao repositorioGerenteImplementacao = new RepositorioGerenteImplementacao();
		Gerente gerente = new Gerente();
		    gerente.setCpf(request.getParameter("cpf"));
		    gerente.setNome(request.getParameter("nome"));
		    gerente.setGerencia(request.getParameter("gerencia"));
		 

		
		    
		    if ("atualizar".equals(acao)) {
		        repositorioGerenteImplementacao.atualizarGerente(gerente);
		    } else {
		        repositorioGerenteImplementacao.salvarGerente(gerente);
		    }
		   

		    // volta para o formulário
		    response.sendRedirect(request.getContextPath() + "/GerenteController");
		
	}

}
