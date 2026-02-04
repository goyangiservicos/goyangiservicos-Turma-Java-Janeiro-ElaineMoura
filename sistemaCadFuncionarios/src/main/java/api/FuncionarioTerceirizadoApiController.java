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

import model.Funcao;
import model.FuncionarioTerceirizado;
import repository.RepositorioFuncionarioTerceirizadoImplementacao;

@WebServlet("/FuncionarioTerceirizadoApiController")
public class FuncionarioTerceirizadoApiController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private final RepositorioFuncionarioTerceirizadoImplementacao repositorio =
            new RepositorioFuncionarioTerceirizadoImplementacao();

    // ================= GET =================
    // listar todos ou buscar por CPF
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json; charset=UTF-8");

        String cpf = request.getParameter("cpf");

        if (cpf != null && !cpf.isEmpty()) {
            FuncionarioTerceirizado f = repositorio.buscarFuncionarioTerceirizadoPorCpf(cpf);

            if (f == null) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.getWriter().write("{\"ok\":false,\"message\":\"Funcionário não encontrado\"}");
                return;
            }

            response.getWriter().write("{\"ok\":true,\"data\":" + toJson(f) + "}");
            return;
        }

        List<FuncionarioTerceirizado> lista = repositorio.listarFuncionarioTerceirizado();
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
    	    response.getWriter().write(
    	        "{\"ok\":false,\"message\":\"CPF é obrigatório e deve ter 11 dígitos\"}"
    	    );
    	    return;
    	}
        response.setContentType("application/json; charset=UTF-8");

        try {
            FuncionarioTerceirizado f = new FuncionarioTerceirizado();
            f.setCpf(cpf);
            f.setNome(request.getParameter("nome"));
            f.setEmpresa(request.getParameter("empresa"));
            f.setFuncao(Funcao.valueOf(request.getParameter("funcao")));
            f.setHorasTrabalhadas(new BigDecimal(request.getParameter("horasTrabalhadas")));
            f.setDataNascimento(LocalDate.parse(request.getParameter("dataNascimento")));

            boolean salvo = repositorio.salvarFuncionarioTerceirizado(f);

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

        String body = request.getReader()
                .lines()
                .collect(java.util.stream.Collectors.joining("&"));

        String cpf = null;
        String nome = null;
        String empresa = null;
        String funcao = null;
        String horasTrabalhadas = null;
        String dataNascimento = null;

        for (String param : body.split("&")) {
            String[] kv = param.split("=");
            if (kv.length == 2) {
                String key = java.net.URLDecoder.decode(kv[0], "UTF-8");
                String value = java.net.URLDecoder.decode(kv[1], "UTF-8");

                if ("cpf".equals(key)) cpf = value;
                if ("nome".equals(key)) nome = value;
                if ("empresa".equals(key)) empresa = value;
                if ("funcao".equals(key)) funcao = value;
                if ("horasTrabalhadas".equals(key)) horasTrabalhadas = value;
                if ("dataNascimento".equals(key)) dataNascimento = value;
            }
        }

        // valida CPF
        if (cpf == null || cpf.trim().isEmpty() || cpf.length() != 11) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write(
                "{\"ok\":false,\"message\":\"CPF é obrigatório e deve ter 11 dígitos\"}"
            );
            return;
        }

        try {
            BigDecimal horas = new BigDecimal(horasTrabalhadas);
            if (horas.compareTo(BigDecimal.ZERO) < 0) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write(
                    "{\"ok\":false,\"message\":\"Horas trabalhadas não podem ser negativas\"}"
                );
                return;
            }

            FuncionarioTerceirizado f = new FuncionarioTerceirizado();
            f.setCpf(cpf);
            f.setNome(nome);
            f.setEmpresa(empresa);
            f.setFuncao(Funcao.valueOf(funcao));
            f.setHorasTrabalhadas(horas);
            f.setDataNascimento(LocalDate.parse(dataNascimento));

            boolean atualizado = repositorio.atualizarFuncionarioTerceirizado(f);

            if (atualizado) {
                response.getWriter().write("{\"ok\":true}");
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.getWriter().write("{\"ok\":false}");
            }

        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write(
                "{\"ok\":false,\"message\":\"Dados inválidos\"}"
            );
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

        boolean deletado = repositorio.deletarFuncionarioTerceirizado(cpf);

        if (deletado) {
            response.getWriter().write("{\"ok\":true}");
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write("{\"ok\":false}");
        }
    }

    // ================= JSON =================
    private String listaToJson(List<FuncionarioTerceirizado> lista) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"ok\":true,\"data\":[");
        for (int i = 0; i < lista.size(); i++) {
            sb.append(toJson(lista.get(i)));
            if (i < lista.size() - 1) sb.append(",");
        }
        sb.append("]}");
        return sb.toString();
    }

    private String toJson(FuncionarioTerceirizado f) {
        return "{"
            + "\"cpf\":\"" + esc(f.getCpf()) + "\","
            + "\"nome\":\"" + esc(f.getNome()) + "\","
            + "\"funcao\":\"" + f.getFuncao().name() + "\","
            + "\"empresa\":\"" + esc(f.getEmpresa()) + "\","
            + "\"horasTrabalhadas\":" + f.getHorasTrabalhadas() + ","
            + "\"custo\":" + f.getCusto()
            + "}";
    }

    private String esc(String s) {
        if (s == null) return "";
        return s.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}