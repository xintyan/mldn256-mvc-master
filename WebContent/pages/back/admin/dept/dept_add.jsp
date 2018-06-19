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
	public static final String DEPT_ADD_URL = "pages/back/admin/dept/DeptAction!add.action" ;
%>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>雇员增加表单</h1>
	<form action="<%=DEPT_ADD_URL%>" method="post"> 
		部门编号（long）：<input type="text" name="deptno" value="10">${errors['deptno']}<br>
		部门名称（String）：<input type="text" name="dname" value="开发部">${errors['dname']}<br>
		部门位置（String）：<input type="text" name="loc" value="北京">${errors['loc']}<br>
		<input type="submit" value="注册">
	</form>
</body>
</html>