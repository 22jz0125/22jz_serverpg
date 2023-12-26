<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
class Item {
	private String name;
	private int price;
	private int stock;
	
	public Item(String name, int price, int stock) {
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public int getStock() {
		return stock;
	}
}
Item item = new Item("ずんだもち", 130, 999);
%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
<h1>商品一覧</h1>
<ul>
    <li>
        <h2><%=item.getName() %></h2>
        <p>価格 : <%=item.getPrice() %>円</p>
        <p>在庫 : <%=item.getStock() %>個</p>
    </li>
</ul>

</body>
</html>