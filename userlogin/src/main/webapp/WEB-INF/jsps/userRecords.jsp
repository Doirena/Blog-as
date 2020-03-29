<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Records</title>
</head>
<body>
<h2>Your records</h2>



<table>

<tr>
<th>Title</th>
<th>Message</th>
<th>Action</th>
</tr>

<c:forEach items="${records}" var="record" >

<tr>
<td>${record.title}</td>
<td>${record.message}</td>
<td>
<a href="deleteRecord?recordId=${record.id}&&userId=${userId}">Delete</a>
<a href="showUpdateRecord?recordId=${record.id}&&userId=${userId}">Update</a>
</td>
</tr>
</c:forEach>
</table>
<a href="showNewRecord?userId=${userId}">New</a>

</body>
</html>