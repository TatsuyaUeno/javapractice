<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>csvダウンロード画面</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/template.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/csvDownload.css">
<script src="<%= request.getContextPath() %>/js/csvDownload.js"></script>
</head>
<body>
<!-- Javaから値を受け取る -->
<% List<String> pullDown = (List<String>)request.getAttribute("pullDownList"); %>

<header class="header">
	<h1 class="header_title"><a href="/menu">csvダウンロード画面</a></h1>
</header>
<main>
	<div class="main">
		<form action="/csv/download" method="get">
			<select name="tableName" style="height: 1.8rem;">
				<% for (String tableName: pullDown) { %>
					<option value=<%= tableName %>><%= tableName %></option>
				<% } %>
			</select>
			<button>ダウンロード</button>
		</form>
	</div>
</main>
<footer class="footer">
</footer>
</body>
</html>