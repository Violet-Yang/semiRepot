<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form method="post" action="${pageContext.request.contextPath }/notice/notice_update">
	<input type="hidden" name="notice_num" value="${vo.notice_num }">
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