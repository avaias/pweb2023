<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
		O valor de R$
		<fmt:formatNumber value="${reais}" pattern="#,##0.00" />
		equivale a $
		<fmt:formatNumber value="${dolares}" pattern="#,##0.00" />
		na contação atual do dólar
	</p>
</body>
</html>