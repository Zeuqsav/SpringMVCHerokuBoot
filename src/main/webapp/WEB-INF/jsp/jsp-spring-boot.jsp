<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/sql" prefix="sql" %>
<%@ page import="demo.PruebaFruta" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Hello Amorsota</h1>
<c:forEach var="i" begin="1" end="5" step="1" >
<c:out value="${i}" /><br/>

<c:catch var= "errorMsg">
	<c:if test="${i <= 2}">
		<c:out value ="menor igual a 2"/>
	</c:if>
	<c:if test="${i > 2}">
		<c:out value ="mayor igual a 2"/>
	</c:if>
</c:catch>
<p>${errorMsg} </p>

</c:forEach>

<% 
pageContext.setAttribute("frutasBean", new PruebaFruta());
%>
<c:forEach var="MV" items="${frutasBean.frutasVarias}">
<p>
${MV}
</p>
</c:forEach>
<h1>FIN</h1>
 
</body>
</html>