<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.List"
    import="com.javapractice.app.mybatis.model.TbDiary"
%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>日誌表示</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/template.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/viewDiary.css">
<script src="<%= request.getContextPath() %>/js/diary.js"></script>
</head>
<body>

<header class="header">
	<h1 class="header_title">日誌閲覧</h1>
</header>
<main>
	<div class="main">
		<div class="search">
			<p>年を入力してください：<input type="text" placeholder="例：2022" id="year"></p>
			<p>月を入力してください：<input type="text" placeholder="0を入力するとすべて表示" id="month"></p>
			<input type="button" value="表示" onClick="selectDate()"/>
			<input type="button" value="非表示" onClick="hiddenDate()"/>
		</div>
		<div class="view">
			<table id="viewTable" border="1">
				<!-- JavaScriptで記述したHTML -->
			</table>
		</div>
	</div>
</main>
<footer class="footer">
</footer>

</body>
</html>