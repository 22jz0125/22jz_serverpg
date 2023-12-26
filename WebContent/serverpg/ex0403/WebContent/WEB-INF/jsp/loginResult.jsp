<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User"
%>
<%	
	User user = (User)session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>login | 22jz0125</title>
</head>
<body>
    <p>ようこそ<%= user.getId() %></p>
    <a href="Login">ログアウト</a>
</body>
</html>