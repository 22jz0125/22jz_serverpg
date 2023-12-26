<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String luck = (String)request.getAttribute("luck");
	String today = (String)request.getAttribute("today");
%>
<!DOCTYPE html>
<html lang="ja"
<head>
	<meta charset="UTF-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>スッキリ占い</title>
</head>
<body>
	<p>${today}の運勢は「${luck}」です</p>
</body>
</html>
</body>
</html>