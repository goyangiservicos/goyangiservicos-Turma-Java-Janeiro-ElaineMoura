
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
@WebServlet("/inicio")
public class inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public inicio() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// endereco- solicitando uma requisicao chama o doget, recebendo um response

		response.setContentType("text/html; charset=UTF-8");// tipo do documento criado
		String html = "<!DOCTYPE HTML>\r\n" + "\r\n" + "<html lang=\"pt-br\">\r\n" + "<head>\r\n"
				+ "<meta charset = 'UTF-8>\r\n" + "<title>Teste Get/Post</title>\r\n" + "</head>\r\n"
				+ "<body syyle = font-family:Arial; padding:20px'>\r\n" + "\r\n" + "<h2>Teste GET -> POST</h2>\r\n"
				+ "<form method='post' action='" + request.getContextPath() + "/inicio'>\r\n"
				+ "<label>Digite algo:</label><br>\r\n" + "<input type='text'name='texto' required>\r\n"
				+ "<br><br>\r\n" + "<button type='submit'>Enviar</button>\r\n" + "</form>\r\n" + "</body>\r\n"
				+ "</html>";
		// PrintWriter writer = response.getWriter();// envia pra tela
		// writer.println(html);// envia pra tela
		response.getOutputStream().write(html.getBytes(StandardCharsets.UTF_8)); // envia tela tambem
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// quando passamos informacoes para pagina ela envia a resposta para o dopost
	

		 String texto = "O texto Digitado foi: " + request.getParameter("texto");
		    response.getOutputStream().write(texto.getBytes(StandardCharsets.UTF_8));

		    doGet(request, response);
	}

}
