<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>スッキリ健康診断 | 22jz0125</title>
</head>
<body>
    <h1>スッキリ健康診断</h1>
    <form action="HealthCheck" method="POST">
        <label for="height">身長:</label>
        <input type="text" name="height" id="height">(cm)<br>
        <label for="weight">体重:</label>
        <input type="text" name="weight" id="weight">(kg)<br>
        <button type="submit">診断</button>
    </form>
</body>
</html>