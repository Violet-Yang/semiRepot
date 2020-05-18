<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${result=='success' }">
		<div>
			<h1>작업을 정상적으로 완료되었습니다.</h1>
		</div>
	</c:when>
	<c:otherwise>
		<div>
			<h1>작업이 실패했습니다.</h1>
			<h3>다시 시도하세요.</h3>
		</div>
	</c:otherwise>
</c:choose>
<a href="${pageContext.request.contextPath }/notice/notice_list">NOTICE</a>
