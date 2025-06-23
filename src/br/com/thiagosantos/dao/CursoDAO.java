package br.com.thiagosantos.dao;

import br.com.thiagosantos.model.Curso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {
    private final String url = "jdbc:postgresql://localhost:5432/gerenciamentodecurso";
    private final String user = "admin";
    private final String password = "admin";

    public CursoDAO(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void salvar(Curso curso) {
        String sql = "INSERT INTO curso (nome, descricao, carga_horaria) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getDescricao());
            stmt.setInt(3, curso.getCargaHoraria());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Curso> listar() {
        List<Curso> cursos = new ArrayList<>();
        String sql = "SELECT * FROM curso";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Curso curso = new Curso();
                curso.setId(rs.getInt("id"));
                curso.setNome(rs.getString("nome"));
                curso.setDescricao(rs.getString("descricao"));
                curso.setCargaHoraria(rs.getInt("carga_horaria"));

                cursos.add(curso);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cursos;
    }
}
