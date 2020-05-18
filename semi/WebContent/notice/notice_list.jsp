<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div id="notice_wrap">
	<div id="notice_main_wrap">
		<a href="${cp }/notice/notice_insert">글쓰기</a>
		<table border="1">
			<colgroup>
				<col width="75">
				<col width="180">
				<col width="*">
			</colgroup>
			<thead>
				<tr>
					<th scope="col">NO</th>
					<th scope="col">ID</th>
					<th scope="col">TITLE</th>
				</tr>
			</thead>
			<c:forEach var="vo" items="${list}">
				<tbody>
					<tr>
						<td>${vo.notice_num }</td>
						<td>${vo.id }</td>
						<td><a
							href="${cp }/notice/notice_detail?notice_num=${vo.notice_num}">${vo.title }</a>
						</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
		<!-- 페이징처리 -->
		<div id="paging">
			<c:if test="${startPageNum>10 }">
				<a href="${cp }/notice/notice_list?pageNum=${startPageNum-1}">[이전]</a>
			</c:if>
			<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
				<c:choose>
					<c:when test="${i==pageNum }">
						<a href="${cp }/notice/notice_list?pageNum=${i }"> <span
							style='color: blue'>[${i }]</span></a>
					</c:when>

					<c:otherwise>
						<a href="${cp }/notice/notice_list?pageNum=${i }"> <span
							style='color: gray'>[${i }]</span>
						</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<c:if test="${pageCount>endPageNum }">
				<a href="${cp }/notice/notice_list?pageNum=${endPageNum+1}">[다음]</a>
			</c:if>
		</div>
	</div>
	<!-- mainwrap -->
</div>