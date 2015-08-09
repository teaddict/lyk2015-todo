<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding='ISO-8859-9' %>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Todo</title>
</head>
<body>
<c:if test="${message != 'hata'}">
<center><form action="edit" method="post">
<h1><strong>Edit Todo</strong></h1>

 <input type="hidden" value="${todo.id }" name="id" />	
 Yapilacak:<input type="text" name="name" value="${todo.name }"><br>
 Aciklama:<input type="text" name="desc" value="${todo.desc }"><br>
 Tarih Giriniz :<input type="date" name="datetime" value="${todo.getDate()}"><br>
 Yapýldý mý: <input class="checkbox" type="checkbox" name="check" <c:if test="${todo.done}">checked</c:if> />
 <center><input type="submit" value="Kaydet"></center></center>
</form>
</c:if>
<center>
<br>
<h3>Mesaj:<td> ${message}</td></h3>
</center>
</body>
</html>