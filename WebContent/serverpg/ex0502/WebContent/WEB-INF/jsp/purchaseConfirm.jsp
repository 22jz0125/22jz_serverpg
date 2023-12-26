<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@
	page import="model.Item"
%>
<%
	Item item = (Item)request.getAttribute("item");
	int count = (int)request.getAttribute("count");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../confirmation/assets/css/style.css">
<title>Insert title here</title>
</head>
<body>
<main>
	<h2>購入のご確認</h2>
	<ul class="purchase-list">
		<li class="list-item">
			<figure class="item-image">
				<img src="${item.imageUrl }" alt="${item.name }" width="100">
			</figure>
			<div class="list-item-description">
			<p>${item.name }</p>
			<p>${count }個</p>
			<p>${count * item.price }円</p>

			</div>
		</li>
	</ul>
	<form action="ItemDetail" method="GET" class="form-purchase">
		<p>上記の商品を購入します。よろしいですか？</p>
		<button type="submit" class="btn negative">前のページへ戻る</a>
		<button type="button" class="btn">購入する</button>
	</form>
</main>
</body>
</html>