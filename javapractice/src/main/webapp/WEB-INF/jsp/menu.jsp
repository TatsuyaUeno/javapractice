<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/template.css">
<script src="<%= request.getContextPath() %>/js/menu.js"></script>

</head>
<body>
<div>
	<header class="header">
		<h1 class="header_title">メニュー</h1>
	</header>
	<main>
		<div class="main">
			<table class="table table-bordered border-success">
				<tr>
					<th>日誌</th>
					<th>クラス実行</th>
				</tr>
				<tr>
					<td><a href="/regist/diary">日誌登録</a></td>
					<td><a href="/exec/class">クラス実行</a></td>
				</tr>
				<tr>
					<td><a href="/view/diary">日誌検索</a></td>
					<td></td>
				</tr>
			</table>
		</div>
	</main>
	<footer class="footer">
	</footer>
</div>
</body>
</html>