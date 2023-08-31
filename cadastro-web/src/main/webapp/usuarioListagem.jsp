-<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<html lang="en" class="light-style layout-menu-fixed" dir="ltr"
	data-theme="theme-default" data-assets-path="assets/"
	data-template="vertical-menu-template-free">
<head>
    <meta charset="utf-8" />
    <meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />

    <title>Tables - Basic Tables | Sneat - Bootstrap 5 HTML Admin Template - Pro</title>

    <meta name="description" content="" />

    <!-- Favicon -->
    <link rel="icon" type="image/x-icon"
	href="assets/img/favicon/favicon.ico" />

    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
	href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
	rel="stylesheet" />

    <!-- Icons. Uncomment required icon fonts -->
    <link rel="stylesheet" href="assets/vendor/fonts/boxicons.css" />

    <!-- Core CSS -->
    <link rel="stylesheet" href="assets/vendor/css/core.css"
	class="template-customizer-core-css" />
    <link rel="stylesheet" href="assets/vendor/css/theme-default.css"
	class="template-customizer-theme-css" />
    <link rel="stylesheet" href="assets/css/demo.css" />

    <!-- Vendors CSS -->
    <link rel="stylesheet"
	href="assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.css" />

    <!-- Page CSS -->

    <!-- Helpers -->
    <script src="assets/vendor/js/helpers.js"></script>

    <!--! Template customizer & Theme config files MUST be included after core stylesheets and helpers.js in the <head> section -->
    <!--? Config:  Mandatory theme config file contain global vars & default theme options, Set your preferred theme option in this file.  -->
    <script src="assets/js/config.js"></script>
  </head>

<body>
	<div class="content-wrapper">
		<div class="container-xxl flex-grow-1 container-p-y">
			<div class="card">
				<h5 class="card-header">Listagem de Usuários</h5>
				<div class="table-responsive text-nowrap">
					<table class="table table-striped">
						<tr>
							<th>ID</th>
							<th>Nome</th>
							<th>E-mail</th>
							<th colspan="2">&nbsp;</th>
						</tr>
						<c:forEach var="usuario" items="${listaUsuarios}" varStatus="id">
							<tr>
								<td>${usuario.id}</td>
								<td>${usuario.nome}</td>
								<td><a href="mailto:${usuario.email}"> ${usuario.email}
								</a></td>
								<td><a href="alterarUsuario?usuarioId=${usuario.id}"
									class="btn btn-success">Editar</a></td>
								<td><a href="excluirUsuario?usuarioId=${usuario.id}"
									class="btn btn-danger">Excluir</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
			<a href="usuarioCadastro.jsp" class="btn btn-primary mt-2">Voltar</a>
		</div>
	</div>



	<script src="assets/vendor/libs/jquery/jquery.js"></script>
		<script src="assets/vendor/libs/popper/popper.js"></script>
		<script src="assets/vendor/js/bootstrap.js"></script>
		<script
			src="assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>

		<script src="assets/vendor/js/menu.js"></script>
		<!-- endbuild -->

		<!-- Vendors JS -->

		<!-- Main JS -->
		<script src="assets/js/main.js"></script>

		<!-- Page JS -->

		<!-- Place this tag in your head or just before your close body tag. -->
		<script async defer src="https://buttons.github.io/buttons.js"></script>
</body>
</html>