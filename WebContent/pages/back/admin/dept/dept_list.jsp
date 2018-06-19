<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<%
	String basePath = request.getScheme() + "://" + 
		request.getServerName() + ":" + request.getServerPort() + 
		request.getContextPath() + "/" ;
%>
<%!
	public static final String DEPT_LIST_URL = "pages/back/admin/goods/goods_list.jsp" ;
%>
<base href="<%=basePath%>"/>
<title>部门列表</title>
<meta name="viewport" content="width=device-width,initial-scale=1">
<script type="text/javascript" src="js/common/mldn_util.js"></script>
<script type="text/javascript" src="jquery/jquery.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="h1"><strong><span class="glyphicon glyphicon-th-list"></span>&nbsp;商品信息列表</strong></div>
		</div>
		<div class="row">
			<jsp:include page="/pages/plugins/split_plugin_search_bar.jsp"/>
			<table class="table table-striped table-bordered table-hover">
				<tr>
					<td>部门编号</td>
					<td>部门名称</td>
					<td>部门位置</td>
				</tr>
				<c:forEach items="${allDepts}" var="dept">
					<tr>
						<td>${dept.deptno}</td>
						<td>${dept.dname}</td>
						<td>${dept.loc}</td>
					</tr>				
				</c:forEach>
			</table>
			<jsp:include page="/pages/plugins/split_plugin_page_bar.jsp"/>
		</div>
	</div>
</body>
</html>
