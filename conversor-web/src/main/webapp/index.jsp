<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Conversor de Moedas</title>
</head>
<body>
	<h1>Conversor de Moedas</h1>
	<form action="conversorDeMoeda" method="post">
	<!-- <form action="conversorDeMoeda" method="post"> -->
		<label>Cotação do Dólar:</label>
		<input type="text" name="cotacao">
		<label>Valor em Reais:</label>
		<input type="text" name="reais">
		<input type="submit" value="Calcular!">
	</form>
</body>
</html>