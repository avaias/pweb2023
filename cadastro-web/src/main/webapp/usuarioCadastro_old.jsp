<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-BR">

<head>
<!-- Required meta tags -->
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>Cadastro</title>
</head>

<body>
	<main class="container-fluid vh-100 d-flex align-items-center justify-content-center bg-dark">
		<div class="d-flex flex-column justify-content-center align-items-center bg-white border border-5 border-secondary rounded">
			<h1 class="fs-4">Cadastro de Usuário</h1>
			<form action="cadastrarUsuario" method="post" class="d-flex flex-column  p-5">
				<label for="nome" class="form-label">Nome: </label> 
				<input type="text" name="nome" id="nome" class="form-control" value="${param.nome}"> 
				<label for="email" class="form-label">E-mail:</label> 
				<input type="text" name="email" id="email" class="form-control" value="${param.email}"> 
				<label for="senha01" class="form-label">Senha:</label> 
				<input type="password" name="senha01" id="senha01" class="form-control">

				<label for="senha02" class="form-label">Confirme a sua senha:</label> 
				<input type="password" name="senha02" id="senha02" class="form-control">
				<div class="d-flex align-items-center justify-content-evenly mt-3">
					<input type="submit" value="Salvar" class="btn btn-success">
					<a href="cadastrarUsuario" class="btn btn-primary"> Listar Usuário </a> 
					<a href="index.html" class="btn btn-danger">Voltar</a>
				</div>
			</form>
			<c:if test="${not empty param.nome || not empty param.email}">
				<div class="alert alert-danger" role="alert">
						<span>${param.nome.concat(", as senhas informadas não são iguais.")}</span>
				</div>
			</c:if>
		</div>
	</main>
</body>

</html>