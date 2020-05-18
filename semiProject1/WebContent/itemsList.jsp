<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id = "newitems">
	<h1>신상품</h1>
</div>
<div id = "itemsList">
	<c:forEach var="vo" items="${itemsList}">
		<c:forEach var = "imgvo" items="${imgList}">
			<c:if test="${vo.items_num==imgvo.items_num}">
				<div>
					<img src = "${cp}/upload/${imgvo.getFile_type}"><br>
					${vo.name}<br>
					${vo.price}<br>
					${vo.info}<br>
				</div>
			</c:if>
		</c:forEach>
	</c:forEach>
</div>

<div>
	<c:if test="${startPageNum>5}">
		<a href="${cp}/itemSelete?pageNum=${startPageNum-1}&pre_categoryNum=${pre_categoryNum}&main_categoryNum=${main_categoryNum}">[이전]</a>
	</c:if>
	<c:forEach var ="i" begin="${startPageNum}" end="${endPageNum}">
		<c:choose>
			<c:when test="pageNum">
				<a href="${cp}/itemSelete?pageNum=${i}&pre_categoryNum=${pre_categoryNum}&main_categoryNum=${main_categoryNum}">
				<span style="color='blue'">[${i}]</span></a>
			</c:when>
			<c:otherwise>
				<a href="${cp}/itemSelete?pageNum=${i}&pre_categoryNum=${pre_categoryNum}&main_categoryNum=${main_categoryNum}">
				<span style="color='gray'">[${i}]</span></a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<c:if test="${pageCount>endPageNum}">
		<a href="${cp}/itemSelete?pageNum=${endPageNum+1}&pre_categoryNum=${pre_categoryNum}&main_categoryNum=${main_categoryNum}">[다음]</a>
	</c:if>
</div>