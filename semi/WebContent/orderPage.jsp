<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>buypage.jsp</title>
<style>
	

</style>
</head>
<body>
	<div id="content">
		<div id="order">
			<div class="page-body">
				<form action="/orderpage.do" method="post">
						<h3>주문 리스트</h3>
						<div class="tbl-order">
							<table>
							<colgroup>
							<col style="width: 50px">
							<col style="width: 200px">
							<col style="width: 80px">
							<col style="width: 80px">
							<col style="width: 100px">
							</colgroup>
							<thead>
							<tr>
								<th scope="col"></th>
								<th scope="col">제품</th>
								<th scope="col">수량</th>
								<th scope="col">가격</th>
								<th scope="col">적립</th>
							</tr>
							</thead>
							<tbody>
								<tr class="ngb">
									<td>
										<div class="tb-center">
											<div class="orderimg">
												<img src="images/ee.jpg" width="40">
											</div>
										</div>
									</td>
									<td>
										<div class="tb-left">
											<a href="#a">상품명갖고오기,링크걸기</a>
										</div>
									</td>
									<td>
										<div class="tb-center">
											제품수량받아오기(상세페이지)
										</div>
									</td>
									<td class="tb-left">
										<div class="te-center">
											제품금액 받아오기(DB)
										</div>
									</td>
									<td class="tb-center">
										<div>적립금 받아오기 (금액*0.01)</div>
									</td>
								</tr>
								<tr class="nbg">
									<td colspan="5">
										<div style="padding-left:25px">
											옵션 : (정보받아와서 뿌려주기) 색상&사이즈: ??,?? 수량:??개
										</div>
									</td>
								</tr>
							</tbody>
							</table>
							<h3>주문자 정보</h3>
							<div class="tbl-order">
								<table>
									<colgroup>
									<col style="width:130px">
									<col>
									</colgroup>
									<tbody>
										<th>
											이름
										</th>
										<td>
											vlaue값에 구매자이름넣기
											<input type="text" name="username" value=""> <!-- 벨류에 구매자 이름받아서 넣어주기 -->
										</td>
										<tr>
											<th>이메일</th>
										<td>
											value값에 구매자 메일 넣기
											<input type="text" name="useremail" value="">
										</td>
										</tr>
										<tr>
											<th>연락처</th>
										<td>
											value값에 구매자 연락처 넣기
											<input type="text" name="phone1" value="" style="width:3em">-<input type="text" name="phone2" value="" style="width:4em">-<input type="text" name="phone3" value="" style="width:4em">
										</td>
										</tr>
									</tbody>
								</table>
									<h3>배송지정보</h3>
									<div class="tbl-order">
									<table>
									<colgroup>
									<col style="width:130px">
									<col>
									<col style="width:100px">
									<col>
									</colgroup>
									<tbody>
										<tr>
										<th>이름</th>
										<td><input type="text" name="ordername"></td>
										</tr>
										<tr>
										<th>연락처1</th>
										<td>
											<input type="text" name="phone1" value="" style="width:3em">-<input type="text" name="phone2" value="" style="width:4em">-<input type="text" name="phone3" value="" style="width:4em">
										</td>
										</tr>
										<tr>
										<th>배송지</th>
										<td><input type="text" name="addrnum" style="width:6em;"><label>우편번호</label></td><br>
										</tr>
										<tr>
										<th></th>
										<td><input type="text" name="addr" style="width:20em";><br></td>
										</tr>
										<tr>
										<th>배송메세지</th>
										<td><textarea name="ordermsg" cols="50" rows="4"></textarea></td>
										</tr>
									</tbody>
									</table>
									<div class="tot-order">
										최종결제금액: <label><b>(계산값 넣기)</b>원</label>
									</div>
								</div>
							</div>
						</div>
				</form>
			</div>
			<div id="paybtns">
				<input type="submit" value="주문하기" style="background:black; width:260px; height:42px; color:#fff; margin-right:10px;">
				<input type="submit" value="주문취소" style="background:#fff; color:black; width:260px; height:42px;">
			</div>
		</div>
	</div>
</body>
</html>