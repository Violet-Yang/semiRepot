<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${cp}/css/index.css">
</head>
<body>
<div id= "wrap">
	<div id = "header">
		<jsp:include page="${top}"/>
	</div>
	<div id = "main">
		<jsp:include page="${main}"/>	
	</div>
	<div id = "bot">
		<jsp:include page="${bot}"/>
	</div>
</div>
<script>
	

</script>
</body>
</html>