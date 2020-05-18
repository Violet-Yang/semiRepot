<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<a href="${cp }/review/review_insert">글쓰기</a>
<table border="1">
	<colgroup>
		<col width="75">
		<col width="140">
		<col width="180">
		<col width="1000">
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
	<c:choose>
		<c:when test="${startPageNum>3 }">
			<a href="${cp }/review/review_list?pageNum=${startPageNum-1}">[이전]</a>
		</c:when>
		<c:otherwise>
			[이전]
		</c:otherwise>
	</c:choose>
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
	<c:choose>
		<c:when test="${pageCount>endPageNum }">
			<a href="${cp }/review/review_list?pageNum=${endPageNum+1}">[다음]</a>
		</c:when>
		<c:otherwise>
			[다음]
		</c:otherwise>
	</c:choose>
</div>
<!-- paging -->
