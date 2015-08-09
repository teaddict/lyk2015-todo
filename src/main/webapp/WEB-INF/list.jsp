<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding='ISO-8859-9' %>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript">

</script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Todos</title>
</head>
<body>
<center>
<h1>List of Todos</h1>
<c:forEach items="${todos}" var="todo"> 
  <tr><b>
  	<c:choose>
    <c:when test="${todo.done}">
        <td><strike>${todo.name}</strike></td>
    </c:when>
    <c:otherwise>
     	<td>${todo.name}</td>
    </c:otherwise>
	</c:choose>
	</b>
	<br>
	<i>
    <td>${todo.desc}</td>
    </i>
    <br>
    <td>
    ${todo.datetime.getTime()}
    </td>
	<br>
  	<form action="list" method="post">
		<td><input class="checkbox" type="checkbox" value="${todo.id}" name="id" <c:if test="${todo.done}">checked</c:if> ></td>
		<input type="submit" value="Save">
	</form>
  	<form action="edit" method="get">
  		<input type="hidden" value="${todo.id}" name="id" />
		<input type="submit" value="Edit">
	</form>
  </tr>
  <br>
</c:forEach>
</center>
</body>
</html>