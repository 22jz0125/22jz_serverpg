<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
class Person {
	private String name;
	private String course;
	private int grade;
	public Person(String name, String course, int grade) {
		this.name = name;
		this.course = course;
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public String getCourse() {
		return course;
	}
	public int getGrade() {
		return grade;
	}
}

Person[] people = {
		new Person("田中 亮太","高度情報処理科", 1),
		new Person("山田 美希","高度情報処理科", 2),
		new Person("鈴木 健太郎","高度情報処理科", 2),
		new Person("佐藤 さくら","高度情報処理科", 3),
		new Person("小林 太郎","情報処理科", 1),
		new Person("高橋 真理子","情報処理科", 2),
		new Person("渡辺 貴志","情報処理科", 2),
		new Person("伊藤 まどか","情報処理科", 2),
		new Person("中村 勇太","情報システム開発科", 2),
		new Person("斎藤 みゆき","情報システム開発科", 2)
	};

//for(int i = 0; i < people.length; i++) {
//	people[i] = new Person();
//}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ex0204 | 22jz0125</title>
<link rel="stylesheet" href="./assts/css/style.css">
</head>
<body>
	<h1>学生一覧</h1>
	
	<% for(int i = 0; i < people.length; i++) {%>
		<%if(people[i].getGrade() == 2){ %>
			<div>
				<p class="grade"><%=people[i].getName() %><br>
				<%=people[i].getCourse()%>    <%=people[i].getGrade() %>年</p>
			</div>
		<% }else{ %>
			<div>
				<p><%=people[i].getName() %><br>
				<%=people[i].getCourse()%>    <%=people[i].getGrade() %>年</p>
			</div>
		<% } %>
	<% } %>
	<%--- 	
	<% System.out.println(peple.length);
	for(int i = 0; i < people.length; i++) {%>
		<%if(people[i].getGrade() == 2){ %>
			<p><%=people[i].getName() %></p></br>
			<p><%=people[i].getCourse() %></p>
			<p><%=peopl[i]e.getGrade() %></p>
		<% } %>
		<% else { %>
			<p><%=people[i].getName() %></p></br>
			<p><%=people[i].getCourse() %></p>
			<p><%=people[i].getGrade() %></p>
		<% } %>
	<% } %>
	--%>

	
</body>
</html>