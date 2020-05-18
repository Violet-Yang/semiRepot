<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${cp}/categoryInsert" method="post">
	상위 카테고리 번호<br>
	<input type="text" name="preCategoryNum"><br>
	(1.best 2.outer 3.top 4.pants 5.bag 6.shoes)<br>
	카테고리 이름<br>
	<input type="text" name="name"><br>
	<input type="submit" value="등록">
</form>
</body>
</html>