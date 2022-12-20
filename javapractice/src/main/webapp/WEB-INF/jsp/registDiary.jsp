<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>日誌登録</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/template.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/registDiary.css">
<script src="<%= request.getContextPath() %>/js/diary.js"></script>
</head>
<body>
<header class="header">
	<h1 class="header_title">日誌登録</h1>
</header>
<main>
	<div class="main">
		<div>
			<p>内容種別 : <input type="text" id="subject_title"></p>
			<p>タイトル : <input type="text" id="title"></p>
		</div>
		<div>
			<p>内容1 : </p>
			<textarea class="tarea" id="content1"></textarea>
			<p>内容2 : </p>
			<textarea class="tarea" id="content2"></textarea>
			<p>内容3 : </p>
			<textarea class="tarea" id="content3"></textarea>
			<p>備考 : </p>
			<textarea class="tarea" id="remarks"></textarea>
		</div>
		<input type="button" value="登録" onClick="registInputDiary()">
	</div>
</main>
<footer class="footer">
</footer>
</body>
</html>