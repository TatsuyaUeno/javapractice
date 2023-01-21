<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.javapractice.app.mybatis.model.TbExecClass" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>クラス実行画面</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/template.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/template.css">
<script src="<%= request.getContextPath() %>/js/execClass.js"></script>
</head>
<body>
<header class="header">
	<h1 class="header_title"><a href="/menu">クラス実行画面</a></h1>
</header>
<main>
	<div class="main">
		<div>
			<!-- クラス実行と登録 -->
			<p>クラス名：
			<input type="text" id="className">
			<input type="button" value="登録" onClick="insertClassName()">
			<input type="button" value="実行" onClick="updateExecFlg()">
			</p>
		</div>
		<div>
			<!-- クラス実行テーブルの表示 -->
			<input type="button" value="再表示" onClick="reload()" >
			<p></p>
			<table class="table table-bordered border-primary">
				<% List<TbExecClass> list = (List<TbExecClass>)request.getAttribute("tbExecClassList"); %>
				<% String errorMessage = (String)request.getAttribute("errorMessage"); %>
				<!-- エラーが存在する場合、エラーメッセージのみ表示 -->
				<% if (!errorMessage.isEmpty()) { %>
					<%= errorMessage %>
				<% } else { %>
					<tr>
						<th>クラス名</th>
						<th>実行フラグ</th>
						<th>更新日時</th>
						<th>備考</th>
					</tr>
					<% for (TbExecClass tbExecClass: list) { %>
						<tr>
							<th><%= tbExecClass.getClassName() %></th>
							<th><%= tbExecClass.getExecFlg() %></th>
							<th><%= tbExecClass.getRegistDate() %></th>
							<th><%= tbExecClass.getRemarks() %></th>
						</tr>
					<% } %>
				<% } %>
			</table>
		</div>
	</div>
</main>
<footer class="footer">
</footer>
</body>
</html>