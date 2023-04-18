<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Digita idade</title>
</head>
<body>
    <span>Digite sua idade e pressione o botão: </span> <br>
    <form action="mostra-idade.jsp">
        <span>Idade: </span>
        <input type="text" name="idade" />
        <input type="submit" value="Mostrar">
    </form>
</body>
</html>