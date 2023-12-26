<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
//package ex0202;
class Employee {
	private String id;
	private String name;
	public Employee(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
}
Employee emp = new Employee("0001", "湊 雄輔");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ex0202 | 22jz0125</title>
</head>
<body>
	<!--
	<% for(int i = 0; i < 10; i++){ %>
	<% if(i % 3 == 0) { %>
	<p style="color:red">
	<% } else {%>
	<p>
	<% }%>
	IDは<%=emp.getId() %>、名前は<%=emp.getName() %>です</p>
	<% }%>
	-->

	<c:forEach var="i" begin="0" end="9" step="1">
		<c:choose>
			<c:when test="${i % 3 == 0}">
				<p style="color:red">IDは<%=emp.getId() %>、名前は<%=emp.getName() %>です</p>
			</c:when>
			<c:otherwise>
				<p>IDは<%=emp.getId() %>、名前は<%=emp.getName() %>です</p>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	

</body>
</html>