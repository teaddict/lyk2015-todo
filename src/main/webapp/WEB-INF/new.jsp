<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Todo</title>
</head>
<body>
<center><form action="new" method="post">
<h1><strong>Add New Todo</strong></h1>
  Yapilacak:<input type="text" name="name"><br>
  Aciklama:<input type="text" name="desc"><br>
 Tarih Giriniz :<input type="date" name="datetime"><br>
 <br>
 <center><input type="submit" value="Kaydet"></center></center>
</form>
</body>
</html>