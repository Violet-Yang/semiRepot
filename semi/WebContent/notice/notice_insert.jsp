<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form method="post" action="${cp }/notice/notice_insert">
	<table>
		<tr height="40">
			<th align="center" width="150">작성자(DB)</th>
			<td width="450"><input type="text" name="id" value="admin"
				readonly="readonly"></td>
		</tr>
		<tr height="40">
			<th align="center" width="150">제목</th>
			<td width="450"><input type="text" name="title" size="40"></td>
		</tr>
		<tr height="40">
			<th align="center" width="150">내용</th>
			<td width="450"><textarea rows="10" cols="50" name="content"></textarea></td>
		</tr>
		<tr height="40">
			<td align="center" colspan="2"><input type="submit" value="작성">
				<input type="reset" value="취소"></td>
		</tr>
	</table>
</form>