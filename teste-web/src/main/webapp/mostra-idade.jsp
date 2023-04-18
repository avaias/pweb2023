<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Mostra idade</title>
</head>
<body>
    <jsp:useBean id="pessoa" class="br.edu.ifgoiano.entidade.Pessoa"> </jsp:useBean>
    <span>Testando seus parâmetros: </span> <br>
    <span>A idade é ${param.idade} e a altura é ${pessoa.altura}</span>
</body>
</html>