package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SupervisorAuxiliar;
import repository.RepositorioGerenteImplementacao;
import repository.RepositorioSupervisorAuxiliarImplementacao;

/**
 * Servlet implementation class SupervisorAuxiliarController
 */
@WebServlet("/SupervisorAuxiliarController")
public class SupervisorAuxiliarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupervisorAuxiliarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	

		String acao = request.getParameter("acao");
		String cpf = request.getParameter("cpf");
		
		
		
		RepositorioSupervisorAuxiliarImplementacao repositorioSupervisorAuxiliarImplementacao = new RepositorioSupervisorAuxiliarImplementacao();
		
		//para deletar
		if ("deletar".equals(acao) && cpf != null && !cpf.isEmpty()) {
    System.out.println("entrou aqui");
    repositorioSupervisorAuxiliarImplementacao.deletarSupervisorAuxiliar(cpf);
}
		
		request.setAttribute("listarSupervisorAuxiliar", repositorioSupervisorAuxiliarImplementacao.listarSupervisorAuxiliar());
		request.getRequestDispatcher("/SupervisorAuxiliarCrud.jsp")
         .forward(request, response);
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		  SupervisorAuxiliar supervisorAuxiliar = new SupervisorAuxiliar();
		  supervisorAuxiliar.setCpf(request.getParameter("cpf"));
		  supervisorAuxiliar.setNome(request.getParameter("nome"));
		  supervisorAuxiliar.setPatio(request.getParameter("patio"));

		  RepositorioSupervisorAuxiliarImplementacao repositorio =
		            new RepositorioSupervisorAuxiliarImplementacao();
		    repositorio.salvarSupervisorAuxiliar(supervisorAuxiliar);

		    // volta para o formulário
		    response.sendRedirect(request.getContextPath() + "/SupervisorAuxiliarController");
	}

}
