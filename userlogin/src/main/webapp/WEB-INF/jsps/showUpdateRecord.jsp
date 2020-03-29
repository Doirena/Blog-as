<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Location</title>
</head>
<body>
<form action="saveRec" method="post">
<pre>
<input type ="hidden"  value="${userId}" name="userId" >
Id: <input type="text" name="id" value="${record.id}" readonly/>
Title: <input type="text" name="title" value="${record.title}"/>
Message: <input type="text" name="message" value="${record.message}"/>
<input type="submit" value="save"/>
</pre>
</form>

</body>
</html>