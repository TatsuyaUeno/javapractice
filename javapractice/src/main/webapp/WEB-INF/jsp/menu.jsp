<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/template.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/menu.css">
<script src="<%= request.getContextPath() %>/js/menu.js"></script>

</head>
<body>
<div>
	<header class="header">
		<h1 class="header_title">メニュー</h1>
	</header>
	<main>
		<div class="main">
			<table>
				<tr>
					<th>日誌</th>
				</tr>
				<tr>
					<td><a href="/regist/diary">日誌登録</a></td>
				</tr>
				<tr>
					<td><a href="/view/diary">日誌閲覧</a></td>
				</tr>
			</table>
		</div>
	</main>
	<footer class="footer">
	</footer>
</div>
</body>
</html>