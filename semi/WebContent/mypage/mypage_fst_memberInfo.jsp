<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	

	<form action="${cp}/memberInfoUpdate" method="post">
		회원정보 수정
		<table border="1px">

			<tr>
				<th>이름</th>
				<td>${vo.name } </td>
			</tr>

			<tr>
				<th>아이디</th>
				<td>${vo.id }</td>
			</tr>

			<tr>
				<th>비밀번호</th>
				<td>빈칸</td>
			</tr>

			<tr>
				<th>주소</th>
				<td><input type="text" value="${vo.addr }"></td>
			</tr>

			<tr>
				<th>전화번호</th>
				<td><input type="text" value="${vo.phone }" numberonly="true" placeholder="-없이 입력해주세요"> </td>
			</tr>

			<tr>
				<th>이메일</th>
				<td><input type="text" value="${vo.email }"></td>
			</tr>

		</table>
	<input type="submit" value="수정">
	</form>