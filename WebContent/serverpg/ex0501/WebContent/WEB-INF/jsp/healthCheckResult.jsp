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
    <h1>スッキリ健康診断の結果</h1>
    <p>

        身長:${health.height}<br>
        体重:${health.weight}<br>
        BMI:${health.bmi}<br>
        体型:${health.bodyType}<br>
    </p>
    <a href="HealthCheck">戻る</a>
</body>
</html>