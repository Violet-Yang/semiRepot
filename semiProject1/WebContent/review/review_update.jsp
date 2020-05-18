<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REVIEW</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath }/review/review_update">
		<input type="hidden" name="review_num" value="${vo.review_num }">
		상품번호(db) <br>
		<input type="text" name="items_num" value="${vo.items_num }" readonly="readonly"> <br>
		작성자 <br>
		<input type="text" name="id" value="${vo.id}" readonly="readonly"> <br>
		제목 <br>
		<input type="text" name="title" value="${vo.title }" size="40"> <br>
		내용 <br>
		<textarea rows="10" cols="50" name="content">${vo.content }</textarea>
		<br>
		<input type="submit" value="수정">
		<input type="reset" value="취소">
	</form>
</body>
</html>