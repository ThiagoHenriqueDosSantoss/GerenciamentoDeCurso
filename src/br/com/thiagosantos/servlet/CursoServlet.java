package br.com.thiagosantos.servlet;

import br.com.thiagosantos.dao.CursoDAO;
import br.com.thiagosantos.model.Curso;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/cursos")
public class CursoServlet extends HttpServlet {
    private final CursoDAO cursoDAO = new CursoDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String descricao = req.getParameter("descricao");
        int cargaHoraria = Integer.parseInt(req.getParameter("cargaHoraria"));

        Curso curso = new Curso(nome, descricao, cargaHoraria);
        cursoDAO.salvar(curso);

        resp.sendRedirect("cursos");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Curso> cursos = cursoDAO.listar();

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<html><head><title>Lista de Cursos</title></head><body>");
        out.println("<h1>Cursos Cadastrados</h1>");
        out.println("<a href='formCurso.html'>Cadastrar Novo Curso</a><br/><br/>");

        out.println("<table border='1'><tr><th>ID</th><th>Nome</th><th>Descrição</th><th>Carga Horária</th></tr>");
        for (Curso curso : cursos) {
            out.printf("<tr><td>%d</td><td>%s</td><td>%s</td><td>%d</td></tr>",
                    curso.getId(), curso.getNome(), curso.getDescricao(), curso.getCargaHoraria());
        }
        out.println("</table>");
        out.println("</body></html>");
    }
}