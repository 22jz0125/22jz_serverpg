<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
<%
class Teacher {
	private String name;	//名前
	private String course;	//学科
	private String subject; //担当科目
	
	public Teacher(String name, String course, String subject) {
		this.name = name;
		this.course = course;
		this.subject = subject;
	}
	
	public String getName() {
		return name;
	}
	public String getCourse() {
		return course;
	}
	public String getSubject() {
		return subject;
	}
}

Teacher teacher = new Teacher("菅原", "JZ", "サーバPG");


System.out.println(teacher.getName());
%>


<h1><%=teacher.getName()%></h1>
<p><%=teacher.getCourse()%>で<%=teacher.getSubject()%>を教えています</p>




</body>
</html>