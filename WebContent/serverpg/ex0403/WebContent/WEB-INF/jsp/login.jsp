<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	boolean isLogin = (boolean)request.getAttribute("isLogin");
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
	<h1>ログイン</h1>
    <form action="Login" method="post">
        <dl>
            <dt><label for="id">ID</label></dt>
            <dd>
                <input type="text" name="id" id="id">
            </dd>
            <dt><label for="password">パスワード</label></dt>
            <dd>
                <input type="text" name="password" id="password">
            </dd>
        </dl>
        <button type="submit">ログイン</button>
    </form>
    
    <% if(!isLogin) {%>
    <p>ユーザーIDまたはパスワードが違います</p>
    <% } %>
</body>
</html>