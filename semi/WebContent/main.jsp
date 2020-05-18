<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
	<form action="${cp}/itemSelete" method="post">	
		<input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>
</div>
<div id=contents">
	
</div>
<c:forEach begin="" end="">
	<div>
	
	</div>
</c:forEach>

<script>
	

</script>