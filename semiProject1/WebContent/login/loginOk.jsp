<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${not empty loginError}">
    <script>
    window.addEventListener("load",function(){
         alert("${Try again!}");
    }
    </script>
</c:if>