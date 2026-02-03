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

import model.Gerente;
import repository.RepositorioGerenteImplementacao;

/**
 * Servlet implementation class LoginControler
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	
    	HttpSession session =request.getSession(false);
    	if(session !=null) {
    		session.invalidate();
    	}
    	
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		RepositorioGerenteImplementacao repositorioGerenteImplementacao = new RepositorioGerenteImplementacao();
		
        
		String cpf = request.getParameter("cpf");
        String senha = request.getParameter("senha");
        Gerente gerente = repositorioGerenteImplementacao.buscarGerentePorCpf(cpf);

        if (gerente != null) {
            String senhaDescrip = decodificar(gerente.getSenha());

            if (cpf.equals(gerente.getCpf()) && senha.equals(senhaDescrip)) {
            	
            HttpSession session = request.getSession();
            session.setAttribute("usuarioLogado", gerente);
            
            response.sendRedirect(request.getContextPath() + "/home.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/erro.jsp");
         } 
       }else {
            response.sendRedirect(request.getContextPath() + "/erro.jsp");
        
         }
       
       }
	 public static String decodificar(String base64) {
  	   byte[] bytes = Base64.getDecoder().decode(base64);
  	   return new String (bytes, StandardCharsets.UTF_8);
     }
     
}

