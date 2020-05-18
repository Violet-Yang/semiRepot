<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<form action="" method="post">
		회원정보 수정
		<table border="1px">

			<tr>
				<th>이름</th>
				<td>${voInfo.name}</td>
			</tr>

			<tr>
				<th>아이디</th>
				<td>아이디뿌리기</td>
			</tr>

			<tr>
				<th>비밀번호</th>
				<td>빈칸</td>
				<input type="button" value="비밀번호변경">
			</tr>

			<tr>
				<th>주소</th>
				<td>번호나오는 곳</td>
			</tr>

			<tr>
				<th>전화번호</th>
				<td>번호나오는 곳</td>
			</tr>

			<tr>
				<th>이메일</th>
				<td>이메일 나오는 곳</td>
			</tr>

		</table>
	<input type="submit" value="수정">
	</form>

