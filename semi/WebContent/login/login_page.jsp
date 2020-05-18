<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<body>
	<div class="login_form">
		<h3>회원로그인</h3>
		<p>가입하신 아이디와 비밀번호를 입력해주세요</p>
		<form action="${cp }/login.do" method="post">
			<div>
				<input type="text" name="loginId" placeholder="아이디">
			</div>
			<div>
				<input type="password" name="loginPwd" placeholder="비밀번호">
			</div>
			<input type="submit" value="LOG-IN">
		</form>
	</div>
</body>