<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Record</title>
</head>
<body>

<form action="saveRec" method="post">
<pre>
 <input type ="hidden"  value="${userId}" name="userId" >
Title: <input type="text" name="title"/>
Message: <input type="text" name="message"/>
<input type="submit" value="Save"/>
</pre>
</form>
</body>
</html>