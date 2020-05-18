<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>
	<c:choose>
		<c:when test="${msg=='success'}">
			<h1>회원가입 성공</h1>
			<a href="${cp}/home">메인페이지로 돌아가기</a>
		</c:when>
		<c:otherwise>
			<h1>가입을 다시 진행해주세요</h1>
			<li><a href="${cp}/home">뒤로가기</a></li>
		</c:otherwise>
	</c:choose>
</body>
