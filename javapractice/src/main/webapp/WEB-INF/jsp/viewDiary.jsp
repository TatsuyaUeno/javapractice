<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h1 class="header_title">日誌登録</h1>
</header>
<main>
	<div class="main">
		<div class="search">
			<input type="button" value="表示" onClick="selectAll()"/>
		</div>
		<div class="view">
			<table border="1">
				<tr>
					<th>日誌番号</th>
					<th>種別</th>
					<th>タイトル</th>
					<th>内容1</th>
					<th>内容2</th>
					<th>内容3</th>
					<th>登録日時</th>
					<th>備考</th>
				</tr>
				<tr>
					<td id="diary_id"></td>
					<td id="subject_type"></td>
					<td id="title"></td>
					<td id="content1"></td>
					<td id="content2"></td>
					<td id="content3"></td>
					<td id="regist_date"></td>
					<td id="remarks"></td>
				</tr>
			</table>
		</div>
	</div>
</main>
<footer class="footer">
</footer>

</body>
</html>