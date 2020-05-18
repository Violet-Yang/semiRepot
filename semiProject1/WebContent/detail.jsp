<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기 임시페이지</title>
<link rel="stylesheet" href="${cp }/css/com.css">
<style type="text/css">.fit_product_basic__property_value--selected {
  border-radius: 0;
  background-color: #FF0000;
  padding: 5px 5px;
}

.fit_etc_description{
	text-align:center;
	border-top:2px solid gray;
}

.fit_size_description{
	margin-top: 10px;
	border-top:1px solid gray;
}

.fit_size_title{
	text-align: center;
	font-size:14px;
	margin-bottom: 5px;
}

.fit_title_col{
background-color: #e8e8e8;
border:1px solid black;
text-align:center;
}

.fit_content_col{
border:1px solid gray;
text-align:center;
background-color: white;
width:16.67%;
}

.fit_product_basic__size_table{
background-color: #e8e8e8;
}

.fit_product_basic__size {
  margin-top: 10px;
}

.fit_product_basic {
  padding-bottom: 20px; 
}
.fit_size_unit{
  margin-top:10px;
}
</style>
</head>
<body>
<div class="main_div">
	<div class="detail_main">
		<h2>의류 상세보기페이지 (제목 들어간다. 의류제목)</h2>
		<h4>인기상품</h4><h5>S~3XL(28~38)</h5>
		<table>
			<colgroup>
			<col style="width:px;"></col>
			</colgroup>
			<tbody>
				<tr>
					<th>판매가</th>
					<td class="price">금액받아오기(db)</td>
				</tr>
				<tr>
					<th>상품번호</th>
					<td>(상품번호 DB에서 받아오기 )</td>
				</tr>
				<tr>
					<th>????여유분</th>
					<td>(???? DB에서 받아오기)</td>
				</tr>
				<tr>
					<th>구매수량</th>
					<td>
						<div class="length">
							<input type="number" min="1" value="1"> 
							<a href="#a">증가</a> <!-- 이미지로 대체 위아래 화살표 -->
							<a href="#a">감소</a> <!-- 이미지로 대체 위아래 화살표 -->
						</div>
					</td>
				</tr>
				<tr>
					<th>옵션선택</th>
					<td>
						<select>
							<option>DB에서 받아오기</option>
							<option>DB에서 받아오기</option>
							<option>DB에서 받아오기</option>
							<option>DB에서 받아오기</option>
							<option>DB에서 받아오기</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>배송비</th>
					<td>무료배송</td>
				</tr>
				<tr>
					<th>결제금액</th>
					<td class="total"><b>DB에서 받아오기(금액 * 수량 계산필요)</b>원</td>
				</tr>
			</tbody>
		</table>
		<!-- 제품구매 왼쪽 작은 img -->
		<div class="img" >
			<img src="images/qq.gif" alt="">
		</div>
		<div class="btns">
			<a href="#a" class="btnbuy"><b>BUY NOW</b></a>
			<a href="#a" class="btncart"><b>CART</b></a>
		</div>
	</div>
	<div style="border-top:2px solid gray; margin-top:100px;"></div>
	<div class="img_detail">
		<!-- 상세페이지 이미지 -->
		<p align="center" style="margin: 50px;"><img src="images/ww.jpg"></p>
	</div>
    <div class="fit_product_basic__etc">
      <div class="fit_etc_description">
      모든 의류의 첫 세탁은 드라이크리닝을 권장합니다.<br>면 재질의 상품은 세탁방법에 따라 제품의 수명과 변형이 발생할 수 있습니다.<br>
      면 재질 상품의 변형을 최소화하기 위해서 단독 손세탁을 권장드립니다.</div>
    </div>
    <div class="fit_product_basic__size">
      <div class="fit_size_title">
          SIZE CHECK
      </div>
      <div class="fit_size_tables">
          <table
            class="fit_content" border="0" cellspacing="0" cellpadding="0">
            <thead>
              <tr class="fit__title_row">
                  <td class="fit_title_col">
                    사이즈
                  </td>
                  <td class="fit_title_col">
                    어깨<br>Shoulder
                  </td>
                  <td class="fit_title_col">
                    가슴<br>Chest
                  </td>
                  <td class="fit_title_col">
                    암홀<br>Arm hole
                  </td>
                  <td class="fit_title_col">
                    팔<br>Sleeve
                  </td>
                  <td class="fit_title_col">
                    총길이<br>Length
                  </td>
                <td style="width: 100%">&nbsp;</td>
              </tr>
            </thead>
            <tbody>
                <tr class="fit_content_row">
                    <td class="fit_content_col" >M(95~100)</td>
                    <td class="fit_content_col" >48 </td>
                    <td class="fit_content_col" >55 </td>
                    <td class="fit_content_col" >24 </td>
                    <td class="fit_content_col" >23.5 </td>
                    <td class="fit_content_col" >69 </td>
                    <td style="width: 100%">&nbsp;</td>
                </tr>
                
                <tr class="fit_content_row">
                    <td class="fit_content_col">L(100~105) </td>
                    <td class="fit_content_col">50 </td>
                    <td class="fit_content_col">57 </td>
                    <td class="fit_content_col">25 </td>
                    <td class="fit_content_col">24.5 </td>
                    <td class="fit_content_col">71 </td>
	                <td style="width: 100%">&nbsp;</td>
                </tr>
                <tr class="fit_content_row">
                    <td class="fit_content_col"> XL(105~110) </td>
                    <td class="fit_content_col"> 52 </td>
					<td class="fit_content_col"> 59 </td>
                    <td class="fit_content_col"> 26 </td>
                    <td class="fit_content_col"> 25.5 </td>
                    <td class="fit_content_col"> 73 </td>
                  <td style="width: 100%">&nbsp;</td>
                </tr>
                <tr class="fit_content_row">
                    <td class="fit_content_col"> 2XL~3XL(110~120)</td>
                    <td class="fit_content_col"> 54 </td>
                    <td class="fit_content_col"> 61 </td>
					<td class="fit_content_col"> 27 </td>
					<td class="fit_content_col"> 26.5 </td>
                    <td class="fit_content_col"> 75 </td>
                    <td style="width: 100%">&nbsp;</td>
                </tr>
            </tbody>
          </table>
      </div>
      <div class="fit_size_unit">단위: cm <br></div>
	      <div class="fit_size_description">
	      * 베이지, 라이트그레이의 경우 비침이 발생할 수 있습니다.<br>
	      * 측정방법에 따라 1~2cm 정도 오차가 있을 수 있습니다.<br>
	      * 품질보증기준 : 교환/반품 안내참고<br>
	      * 제조연월 : 주문일로부터 6개월 이내/판매시즌 상시제작<br>
	      * 제조사/제조국 : JOGUNSHOP / Made in Korea</div>
	   	  </div>
          </tbody>
    </div>
</body>
</html>