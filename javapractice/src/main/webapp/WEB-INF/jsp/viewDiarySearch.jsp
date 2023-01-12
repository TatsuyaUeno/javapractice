<!DOCTYPE html>
<html lang="ja" id="changeView">
<%@page import="java.util.Objects"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.List"
    import="com.javapractice.app.mybatis.model.TbDiary"
    import="com.javapractice.app.mybatis.model.TbDiaryAk"
%>
<head>
<meta charset="UTF-8">
<title>日誌検索</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/template.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/viewDiary.css">
<script src="<%= request.getContextPath() %>/js/diary.js"></script>
</head>
<body>
<!-- Javaから受け取る変数 -->
<% List<String> pullDownList =  (List<String>)request.getAttribute("pullDownList"); %>
<% List<String> errorMessageList = (List<String>)request.getAttribute("errorMessageList"); %>
<% List<TbDiary> tbDiaryList = (List<TbDiary>)request.getAttribute("tbDiaryList"); %>
<% List<TbDiaryAk> tbDiaryAkList = (List<TbDiaryAk>)request.getAttribute("tbDiaryAkList"); %>

<header class="header">
	<h1 class="header_title"><a href="/menu">日誌検索</a></h1>
</header>

<main>
	<div class="main">
		<% if (!errorMessageList.isEmpty()) { %>
			<% for (String errorMessage: errorMessageList) { %>
				<%= errorMessage %>
			<% } %>
		<% } else { %>
		<label>内容種別：</label>
		<form name="form1">
		<select name="prefecture" id="subjectType">
			<% for (String name: pullDownList) { %>
			<option value=<%= name %>><%= name %></option>
			<% } %>
		</select>
		</form>
		<label>日誌アーカイブテーブルからも検索しますか？</label>
		<input type="checkbox" name="archiveFlg" checked>
		<input type="button" value="検索" onClick="viewDiarySearch()">
		<p></p>
		<table class="table table-bordered border-primary">
			<tr>
				<th>日誌番号</th>
				<th>内容種別</th>
				<th>タイトル</th>
				<th>内容1</th>
				<th>内容2</th>
				<th>内容3</th>
				<th>登録日時</th>
				<th>備考</th>
			</tr>
			<% if (!Objects.isNull(tbDiaryList)) { %>
				<% for (TbDiary tbDiary: tbDiaryList) { %>
					<tr>
						<th><%= tbDiary.getDiaryId() %></th>
						<th><%= tbDiary.getSubjectType() %></th>
						<th><%= tbDiary.getTitle() %></th>
						<th><%= tbDiary.getContent1() %></th>
						<th><%= tbDiary.getContent2() %></th>
						<th><%= tbDiary.getContent3() %></th>
						<th><%= tbDiary.getRegistDate() %></th>
						<th><%= tbDiary.getRemarks() %></th>
					</tr>
				<% } %>
			<% } %>
			<% if (!Objects.isNull(tbDiaryAkList)) { %>
				<% for (TbDiaryAk tbDiaryAk: tbDiaryAkList) { %>
					<tr>
						<th><%= tbDiaryAk.getDiaryId() %></th>
						<th><%= tbDiaryAk.getSubjectType() %></th>
						<th><%= tbDiaryAk.getTitle() %></th>
						<th><%= tbDiaryAk.getContent1() %></th>
						<th><%= tbDiaryAk.getContent2() %></th>
						<th><%= tbDiaryAk.getContent3() %></th>
						<th><%= tbDiaryAk.getRegistDate() %></th>
						<th><%= tbDiaryAk.getRemarks() %></th>
					</tr>
				<% } %>
			<% } %>
		</table>
		<% } %>
	</div>
</main>
<footer class="footer">
</footer>

<div id="aaa">
</div>

</body>
</html>