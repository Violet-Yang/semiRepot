<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="header_top_wrap">
	<div class="header_top">
		<div class="left">
			<ul>
				<li><a href="${cp }/review/review_home">리뷰게시판</a></li>
				<li><a href="${cp }/notice/notice_home">공지사항</a></li>
			</ul>
		</div>
		<div class="right">
			<ul>
				<c:choose>
					<c:when test="${id!=null}">
						<!-- 아이디값이 들어왔을때  -->
						<li><a href="${cp}/logout">LOGOUT</a></li>
						<li><a href="">JOIN</a></li>
						<c:choose>
							<c:when test="${a}">
								<!-- 관리자가 아닌경우(미구현) -->
								<li><a href="">MYPAGE</a></li>
								<li><a href="">ORDER</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="${cp}/itemsInsert">상품등록</a></li>
								<!--아이템 번호 넘기기(미구현) -->
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						<!-- 비회원 -->
						<li><a href="${cp}/login.do">LOGIN</a></li>
						<li><a href="${cp}/joinOk.do">JOIN</a></li>
						<li><a href="">MYPAGE</a></li>
						<li><a href="">장바구니</a></li>
						<li><a href="${cp}/itemsInsert">상품등록</a></li>
						<!--아이템 번호 넘기기(미구현) -->
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
</div>
<div class="header_mid_wrap">
	<div class="header_mid">
		<div class="logo_img">
			<a href="${cp}/home"> <img src="${cp}/images/logo.gif"
				alt="logoimg">
			</a>
		</div>
	</div>
</div>
<div class="header_bot_wrap">
	<div class="header_bot">
		<nav id="topMenu">
			<ul>
				<li class="topMenuLi"><a class="menuLink"
					href="${cp}/itemSelete?pre_categoryNum=1">Best</a>
				</li>
				<li>|</li>
				<li class="topMenuLi"><a class="menuLink"
					href="${cp}/itemSelete?pre_categoryNum=2">TOP</a>
					<ul class="submenu">
						<li><a class="submenuLink longLink"
							href="${cp}/itemSelete?pre_categoryNum=2&main_categoryNum=1">맨투맨</a></li>
						<li><a class="submenuLink longLink"
							href="${cp}/itemSelete?pre_categoryNum=2&main_categoryNum=2">반팔티</a></li>
						<li><a class="submenuLink longLink"
							href="${cp}/itemSelete?pre_categoryNum=2&main_categoryNum=3">후드티</a></li>
					</ul></li>
				<li>|</li>
				<li class="topMenuLi"><a class="menuLink"
					href="${cp}/itemSelete?pre_categoryNum=3">PANTS</a>
					<ul class="submenu">
						<li><a class="submenuLink longLink"
							href="${cp}/itemSelete?pre_categoryNum=3&main_categoryNum=4">슬랙스</a></li>
						<li><a class="submenuLink longLink"
							href="${cp}/itemSelete?pre_categoryNum=3&main_categoryNum=5">청바지</a></li>
						<li><a class="submenuLink longLink"
							href="${cp}/itemSelete?pre_categoryNum=3&main_categoryNum=6">반바지</a></li>
					</ul></li>
				<li>|</li>
				<li class="topMenuLi"><a class="menuLink"
					href="${cp}/itemSelete?pre_categoryNum=4">OUTER</a>
					<ul class="submenu">
						<li><a class="submenuLink longLink"
							href="${cp}/itemSelete?pre_categoryNum=4&main_categoryNum=7">코트</a></li>
						<li><a class="submenuLink longLink"
							href="${cp}/itemSelete?pre_categoryNum=4&main_categoryNum=8">자켓</a></li>
						<li><a class="submenuLink longLink"
							href="${cp}/itemSelete?pre_categoryNum=4&main_categoryNum=9">패팅</a></li>
					</ul></li>
				<li>|</li>
				<li class="topMenuLi"><a class="menuLink"
					href="${cp}/itemSelete?pre_categoryNum=5">SHOES</a>
					<ul class="submenu">
						<li><a class="submenuLink"
							href="${cp}/itemSelete?pre_categoryNum=5&main_categoryNum=10">스니커즈</a></li>
						<li><a class="submenuLink"
							href="${cp}/itemSelete?pre_categoryNum=5&main_categoryNum=11">슬립온</a></li>
						<li><a class="submenuLink"
							href="${cp}/itemSelete?pre_categoryNum=5&main_categoryNum=12">슬리퍼</a></li>
					</ul></li>
				<li>|</li>
				<li class="topMenuLi"><a class="menuLink"
					href="${cp}/itemSelete?pre_categoryNum=6">BAG</a>
					<ul class="submenu">
						<li><a class="submenuLink"
							href="${cp}/itemSelete?pre_categoryNum=6&main_categoryNum=13">백팩</a></li>
						<li><a class="submenuLink"
							href="${cp}/itemSelete?pre_categoryNum=6&main_categoryNum=14">클로스백</a></li>
						<li><a class="submenuLink"
							href="${cp}/itemSelete?pre_categoryNum=6&main_categoryNum=15">클러치</a></li>
					</ul></li>
				<li>|</li>
				<li class="topMenuLi"><a class="menuLink"
				 href="${cp}/itemSelete?pre_categoryNum=7">ACC</a>
					<ul class="submenu">
					</ul></li>
			</ul>
		</nav>
	</div>
</div>