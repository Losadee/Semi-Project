<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customer/joinForm.jsp</title>
<script type="text/javascript" src="./script/jquery-3.6.3.js"></script>
<script type="text/javascript" src="./script/joinForm.js"></script>
	
</head>
<body>

<h1>회원가입</h1>

	<form action="./CustomerInsertPro.cu" method="post" name="join" onsubmit="return valid();">
	* 아이디 : <input type="text" name="id" id="id" placeholder="영문 숫자 4~8자"  ><br>
<!-- 			<input type="button" value="중복확인" ><br> -->
			 <span id="checkIdResult"></span><br>
	
	* 비밀번호 : <input type="password" name="pass" id="pass" placeholder="영문 숫자 6~12자"><br> 
			  <span id="checkPassResult"></span><br>
	
	* 비밀번호 확인 : <input type="password" name="pass2" id="pass2" placeholder="비밀번호를 확인해 주세요."><br> 
				  <span id="checkRetypePassResult"></span><br>
	
	* 이름 : <input type="text" name="name" id="name" placeholder="이름을 입력해 주세요."> <br>
	 			<span id="checkName"></span><br>
	* 휴대폰 번호 : <input type="text" name="phone" id="phone" placeholder="'-'없이 입력해 주세요." >
				<input type="button" id="btnPh" value="중복 확인"><br>
	 			 <span id="checkPhone" class="dupdiv"></span><br>
	  이메일 : <input type="email" name="email"><br><br>
	<input type="submit" value="회원가입"> <input type="reset" id="reset" value="다시 작성"><br>
	</form>


</body>
</html>