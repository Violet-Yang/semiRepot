<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table border="5">
	<a href="${cp }/review/review_insert">글쓰기</a>
	<colgroup>
		<col width="50">
		<col width="140">
		<col width="180">
		<col width="300">
	</colgroup>
	<thead>
		<tr>
			<th scope="col">NO</th>
			<th scope="col">NAME</th>
			<th scope="col">ITEMS</th>
			<th scope="col">TITLE</th>
		</tr>
	</thead>
	<c:forEach var="vo" items="${list }">
		<tbody>
			<tr>
				<td>${vo.review_num }</td>
				<td>${vo.id }</td>
				<td>${vo.items_num }</td>
				<td><a
					href="${cp}/review/review_detail?review_num=${vo.review_num}">${vo.title }</a></td>
			</tr>
		</tbody>
	</c:forEach>
</table>

<!-- 페이징처리 -->
<div id="paging">
	<c:if test="${startPageNum>10 }">
		<a href="${cp }/review/review_list?pageNum=${startPageNum-1}">[이전]</a>
	</c:if>

	<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
		<c:choose>
			<c:when test="${i==pageNum }">
				<a href="${cp }/review/review_list?pageNum=${i }"> <span
					style='color: blue'>[${i }]</span></a>
			</c:when>

			<c:otherwise>
				<a href="${cp }/review/review_list?pageNum=${i }"> <span
					style='color: gray'>[${i }]</span>
				</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>

	<c:if test="${pageCount>endPageNum }">
		<a href="${cp }/review/review_list?pageNum=${endPageNum+1}">[다음]</a>
	</c:if>
</div>
<!-- paging -->
