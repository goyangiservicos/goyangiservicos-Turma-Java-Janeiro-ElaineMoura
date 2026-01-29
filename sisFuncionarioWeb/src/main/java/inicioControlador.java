
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class inicio
 */
@WebServlet("/inicioControlador")
public class inicioControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public inicioControlador() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/inicio.jsp").forward(request, response);
		// se chamar no browser iniciocontrolador vai direcionar para inicio.jsp
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// quando passamos informacoes para pagina ela envia a resposta para o dopost
		
		String texto = "O texto Digitado foi: " + request.getParameter("texto");

		// response.getOutputStream().write(texto.getBytes(StandardCharsets.UTF_8));
		request.setAttribute("texto", texto); //atributo para trabalhar na jsp pq sera direcionado para jsp
		request.getRequestDispatcher("/inicio.jsp").forward(request, response);
		doGet(request, response);
		
	}

}
