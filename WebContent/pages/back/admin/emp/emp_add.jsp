<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<%!
	public static final String EMP_ADD_URL = "pages/back/admin/emp/EmpAction!add.action" ;
%>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>雇员增加表单</h1>
	<form action="<%=EMP_ADD_URL%>" method="post" enctype="multipart/form-data"> 
		雇员编号（long）：<input type="text" name="empno" value="10"><br>
		雇员姓名（String）：<input type="text" name="ename" value="SMITH"><br>
		雇员工资（double）：<input type="text" name="sal" value="1000.99"><br>
		雇员年龄（int）：<input type="text" name="age" value="23"><br>
		雇佣日期（Date）：<input type="text" name="hiredate" value="1989-10-10"><br>
		照片：<input type="file" name="photo" id="photo"><br>
		<input type="submit" value="注册">
	</form>
</body>
</html>