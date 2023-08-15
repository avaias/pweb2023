<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
	<main class="container-fluid vh-100 d-flex align-items-center justify-content-center bg-dark">
		<div class="d-flex flex-column justify-content-center align-items-center bg-white border border-5 border-secondary rounded">
			<h1 class="fs-4">Alteração de Usuário</h1>
			<form action="alterarUsuario" method="post" class="d-flex flex-column  p-5">
				<label for="nome" class="form-label" value= "${usuario.nome}">Nome: </label> 
				<input type="text" name="nome" id="nome" class="form-control" value="${usuario.nome}"> 
				<label for="email" class="form-label">E-mail:</label> 
				<input type="text" name="email" id="email" class="form-control" value="${usuario.email}"> 
				<label for="senha01" class="form-label">Senha:</label> 
				<input type="password" name="senha01" id="senha01" class="form-control">

				<label for="senha02" class="form-label">Senha confirmada:</label> 
				<input type="password" name="senha02" id="senha02" class="form-control">
				
				<input type="hidden" name="id" id="id" value="${usuario.id}">
				
				<div class="d-flex align-items-center justify-content-evenly mt-3">
					<input type="submit" value="Salvar" class="btn btn-success">
					<a href="usuarioListagem.jsp" class="btn btn-danger">Voltar</a>
				</div>
			</form>
			<c:if test="${not empty mensagem}">
				<div class="alert alert-danger" role="alert">
						<span>${mensagem}</span>
				</div>
			</c:if>
		</div>
	</main>
</body>
</html>