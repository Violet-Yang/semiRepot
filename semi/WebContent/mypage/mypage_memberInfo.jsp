<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
.mypage_container{
	background-color: gray;
}

.mypage_leftnav{
	background-color: violet;
}

.mypage_contents{
	background-color: light-green;
}

</style>
	<div id="mypage_container" style="background-color: gray; width=900px;">
		<div id="mypage_leftnav"  style="background-color: violet; width=300px;">
			<div>
				<h3>마이페이지</h3>
			</div>
			<div>
				<ul>
					<li class="title">나의 구매내역</li>
					<li><a href="">주문/배송 조회</a></li>
					<li><a href="">교환/환불 신청 </a></li>
				</ul>
			</div>
			<div>
				<ul>
					<li class="title">나의 장바구니</li>
				</ul>
			</div>
			<div>
				<ul>
					<li class="title">회원정보</li>
					
					<li><a href="${cp}/memberInfo.do">회원정보 수정</a></li>
					<li><a href="">회원 탈퇴</a></li>
				</ul>
			</div>
		</div>
		
		<div class="mypage_contents" style="background-color:pink; width=600px;">
		컨텐츠 영역입니다.
		</div>
	</div>
