<%@ page pageEncoding="UTF-8"%>
<%--
<jsp:include page="/pages/plugins/split_plugin_search_bar.jsp"/>
--%>
<%
	String basePath = request.getScheme() + "://" + 
		request.getServerName() + ":" + request.getServerPort() + 
		request.getContextPath() ;
%>
<%	
	request.setCharacterEncoding("UTF-8") ;
	String url = basePath + request.getAttribute("url") ;	// 提交路径
	String columnData = (String) request.getAttribute("columnData") ;	// 查询列
	String column = (String) request.getAttribute("column") ;
	String keyWord = (String) request.getAttribute("keyWord") ;
	int allRecorders = 0 ;
	if ("null".equals(column) || column == null || "".equals(column)) {
		column = "" ;
	}
	if ("null".equals(keyWord) || keyWord == null || "".equals(keyWord)) {
		keyWord = "" ;
	}
%>
<%
	try {
		allRecorders = (Integer) request.getAttribute("allRecorders") ;
	} catch (Exception e) {}
%>
<div id="searchDiv">
<form action="<%=url%>" method="post">
<%
	if (!(columnData==null || "".equals(columnData))) {
%>
	<select id="col" name="col">
<%
		String result [] = columnData.split("\\|") ;
		for (int x = 0 ; x < result.length ; x ++) {
			String temp [] = result[x].split(":") ;
%>
			<option value="<%=temp[1]%>" <%=temp[1].equals(column) ? "selected" : ""%>><%=temp[0]%></option>
<%
		}
%>
	</select>
<%
	}
%>
	<input type="text" name="kw" id="kw" value="<%=keyWord%>">
	<input type="submit" value="查询">
	<p>查询一共返回“<%=allRecorders%>”行记录。</p>
</form>
</div>