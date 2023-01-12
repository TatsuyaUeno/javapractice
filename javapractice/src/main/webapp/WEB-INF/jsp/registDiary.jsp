<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>日誌登録</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/template.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/registDiary.css">
<script src="<%= request.getContextPath() %>/js/diary.js"></script>
</head>
<body>
<header class="header">
	<h1 class="header_title"><a href="/menu">日誌登録</a></h1>
</header>
<main>
	<div class="main">
		<div class="test">
			<label>内容種別 : </label>
			<input type="text" id="subject_title">
			<label>タイトル :</label> 
			<input type="text" id="title">
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