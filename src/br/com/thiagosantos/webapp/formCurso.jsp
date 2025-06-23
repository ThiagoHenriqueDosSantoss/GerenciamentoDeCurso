<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Cadastrar Curso</title>
</head>
<body>
    <h1>Cadastro de Curso</h1>

    <form action="${pageContext.request.contextPath}/cursos" method="post">
        <label for="nome">Nome:</label>
        <input type="text" name="nome" id="nome" required><br><br>

        <label for="descricao">Descrição:</label>
        <textarea name="descricao" id="descricao" required></textarea><br><br>

        <label for="cargaHoraria">Carga Horária:</label>
        <input type="number" name="cargaHoraria" id="cargaHoraria" min="1" required><br><br>

        <input type="submit" value="Cadastrar Curso">
    </form>
</body>
</html>
