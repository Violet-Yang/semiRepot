<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#main{
	margin-top: 50px;
	margin-left: 140px;
	text-align: center;
	width: 800px;
}
#btns{
	text-align: center;
	float:right;
	width:200px;
	height: 50px;
	margin-top: 20px;
}
</style>
</head>
<body>
<div id="main">
<form action="${cp}/itemsInsert" method="post" enctype="multipart/form-data">
<fieldset>
	<legend> 상품등록 </legend>
	<div id="detail">
		카테고리이름<input type="text" name="categoryName"><br>
		상품이름
		<input type="text" name="itemName"><br>
		글제목
		<input type="text" name="title"><br>
		가격
		<input type="text" name="price"><br>
		정보
		<textarea rows="10" cols="50" name="info"></textarea><br>
		옵션정보<br>
		사이즈  : <input type="text" name="size"> 색상 : <input type="text" name="color"> 수량 : <input type="text" name="count"><br>
		<input type="button" value="추가" onclick = "addInfo()">
		<div id="itemsInfo">
		</div>
		첨부파일<br>
		<input type="file" name="file1"><br>
	</div>
</fieldset>
	<div id="btns">
	<input type="submit" value="등록" id="regbtn">
	<input type="reset" value="취소" id="canbtn">
	</div>
</form>
</div>
<script>
	function addInfo(){
		var itemsInfo = document.getElementById("itemsInfo");
		itemsInfo.innerHTML += "사이즈 : <input type='text' name='size'> ";
		itemsInfo.innerHTML += " 색상: <input type='text' name='color'> ";
		itemsInfo.innerHTML += " 수량: <input type='text' name='count'><br>";
	}
</script>
</body>
</html>