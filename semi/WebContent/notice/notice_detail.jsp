<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="wrap">
	<div id="mainwrap">
		<div id="main">
			<a href="${cp }/notice/notice_list">목록</a>
			<table border="1">
				<colgroup>
					<col width="130">
					<col width="800">
				</colgroup>
				<tbody>
					<tr>
						<th scope="row">제목</th>
						<td>${vo.title }</td>
					</tr>
					<tr>
						<th scope="row">작성자</th>
						<td>${vo.id }</td>
					</tr>
					<tr>
						<th scope="row">내용</th>
						<td>${vo.content }</td>
					</tr>
				</tbody>
			</table>
			<a href="${cp }/notice/notice_update?notice_num=${vo.notice_num}">수정</a>
			<a href="${cp }/notice/notice_delete?notice_num=${vo.notice_num}">삭제</a>
		</div>
	</div>
</div>