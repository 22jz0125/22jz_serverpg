<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@
	page import="model.Item"
%>
<%
	Item item = (Item)request.getAttribute("item");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="assets/css/style.css">
<title>革財布 | Claft Lether</title>
</head>
<body>
  <header>
    <h1>Claft Lether</h1>
  </header>
  <main>
    <section>
      <h2>${item.name }</h2>
      <div class="flexdiv">
        <img src="${item.imageUrl }" alt="${item.name }">
        <div>
          <p class="infomation">
            ${item.description}
          </p>
          <form action="/ex0502//PurchaseConfirm" method="GET" class="numform">
           <p>${item.price }円</p>
            <span class="labeldiv">
              <label for="count">数量 : </label>
              <input type="number" name="count" id="count" value="1" max="${item.stock }" min="1">
            </span>
            <button type="submit">購入手続きへ</button>
          </form>
        </div>
      </div>
    </section>
  </main>
</body>
</html>