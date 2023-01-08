<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customer/joinForm.jsp</title>
<link href="./css/menu.css" rel="stylesheet" type="text/css">
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script type="text/javascript">

// 카카오 회원가입
window.Kakao.init('46649a5dcd99d3819c79c2f83892ddb9');
function kakaoJoin() {
	Kakao.Auth.login({
		scope:'account_email',
        success: function (response) {
            Kakao.API.request({
                url: '/v2/user/me',
                success: (res) => {
//                 	alert(res.id)
//                 	alert(res.properties.nickname)
//                 	alert(res.kakao_account.email)
					alert('회원가입 성공! 메인페이지에서 로그인해주세요')
                    kakaojoin.id.value=res.id;
                	kakaojoin.pass.value=res.kakao_account.email;
                	kakaojoin.name.value=res.properties.nickname;
                	kakaojoin.email.value=res.kakao_account.email;
					kakaojoin.submit()
                },
				
                fail: function (error) {
                    console.log(error);
                },
            })
        },
        fail: function (error) {
            console.log(error);
        },
    })
}

//아이디 중복체크
function winopen(){
	if(document.join.id.value =="" || document.join.id.value.length < 0){
		alert("아이디를 먼저 입력해주세요")
		document.join.id.focus();
	}else{
		window.open("./CustomerIdCheck.cu?id="+document.join.id.value,"","width=500, height=300");
	}
}

//핸드폰 중복체크
function winopen2(){
	if(document.join.phone.value =="" || document.join.phone.value.length < 0){
		alert("휴대폰 번호를 먼저 입력해주세요")
		document.join.phone.focus();
	}else{
		window.open("./CustomerPhoneCheck.cu?phone="+document.join.phone.value,"","width=500, height=300");
	}
}

var checkIdResult = false;
var checkPassResult = false;
var checkPass2Result = false;
var checkPhoneResult = false;

// 아이디 검사
function checkId(id) {
	var span = document.getElementById('checkIdResult');
	
	//아이디 (4자리 이상)
	var regex = /^[A-Za-z0-9]{4,30}$/;
	if(regex.test(id)){
		checkIdResult = true;
		
		span.innerHTML = '사용 가능한 아이디입니다.';
		span.style.color = 'GREEN';
	} else {
		checkIdResult = false;
		
		span.innerHTML = '아이디는 최소 4자리 이상입니다.';
		span.style.color = 'RED';
	}
}

// 비밀번호 검사
function checkPass(pass) {
	
	// 패스워드 검사를 위한 정규표현식 패턴 작성 및 검사 결과에 따른 변수값 변경
	var span = document.getElementById('checkPassResult');
	
	//비밀번호 (영문+숫자, 6 ~ 12자)
	var regex = /^(?=.*[a-zA-Z])(?=.*[0-9]).{6,30}$/;
	if(regex.test(pass)){
		checkPassResult = true;
		
		span.innerHTML = '사용 가능한 비밀번호입니다.';
		span.style.color = 'GREEN';
	} else {
		checkPassResult = false;
		
		span.innerHTML = '비밀번호는 최소 6자리 이상 영문자+숫자 입니다.';
		span.style.color = 'RED';
	}
}

// 비밀번호 확인
function checkRetypePass() {
	
	var span = document.getElementById('checkRetypePassResult');
	
	var pass = document.getElementById('pass').value;
	var pass2 = document.getElementById('pass2').value;
	
	if(pass == pass2) {
		span.innerHTML = '비밀번호 일치';
		span.style.color = 'GREEN';
		checkPass2Result = true;
	} else {
		span.innerHTML = '비밀번호 불일치';
		span.style.color = 'RED';
		checkPass2Result = false;
	}
}

// 전화번호 검사
function checkPhone(phone) {
	var span = document.getElementById('checkPhoneResult');
	
	//전화번호 (숫자만) -- 숫자+알파벳 조합으로 가입되는 오류 발생
	var regex = /[0-9]/;
	if(!regex.test(phone)){
		checkPhoneResult = false;
		
		span.innerHTML = '숫자만 입력가능합니다.';
		span.style.color = 'RED';
	}
}

function valid() {
	let join = document.join;
	if(checkIdResult && checkPassResult && checkPass2Result && checkPhoneResult) {
		return true;
	}
	
	if(join.id.value == ""){
		alert("id를 입력해 주세요.");
		join.id.focus();
		return false;
	}
	if(join.pass.value == ""){
		alert("비밀번호를 입력해 주세요.");
		join.pass.focus();
		return false;
	}
	if(join.pass2.value == ""){
		alert("비밀번호 확인을 입력해 주세요.");
		join.pass2.focus();
		return false;
	}
	if(join.name.value == ""){
		alert("이름을 입력해 주세요.");
		join.name.focus();
		return false;
	}
	if(join.phone.value == ""){
		alert("전화번호를 입력해 주세요.");
		join.focus();
		return false;
	}
}
</script>

</head>
<body>
<jsp:include page="../inc/headerMenu.jsp"></jsp:include>
<h1>회원가입</h1>
<fieldset>
<legend>카카오 회원가입</legend>
<form action="./KakaoJoin.cu" name="kakaojoin" method="post">
     <input type="hidden" name="id">
     <input type="hidden" name="pass">
     <input type="hidden" name="name">
     <input type="hidden" name="email">
</form>
카카오 간편 회원가입
<a href="javascript:kakaoJoin();"><img src="./img/kakao_join.png"></a>
</fieldset>
<fieldset>
<legend>인적사항 입력</legend>
<form action="./CustomerJoinPro.cu" method="post" name="join" onsubmit="return valid()">
	* 아이디 :  <input type="text" name="id" id="id" placeholder="영문 숫자 4~8자" onkeyup="checkId(this.value)" >
			  <input type="button" value="중복확인" class="dup" onclick="winopen()"><br><!-- 아이디 중복체크 -->
			  <span id="checkIdResult"><!--  아이디 규칙 판별 결과 표시 영역 --></span><br>
	* 비밀번호 : <input type="password" name="pass" id="pass" placeholder="영문 숫자 6~12자" onkeyup="checkPass(this.value)" ><br> 
		   	  <span id="checkPassResult"><!--  패스워드 규칙 판별 결과 표시 영역 --></span><br>
	* 비밀번호 확인 : <input type="password" name="pass2" id="pass2" placeholder="비밀번호를 확인해 주세요." onkeyup="checkRetypePass()" ><br> 
				  <span id="checkRetypePassResult"><!--  패스워드 확인 판별 결과 표시 영역 --></span><br>
	* 이름 : <input type="text" name="name" id="name" placeholder="이름을 입력해 주세요."><br>
	* 휴대폰 번호 : <input type="text" name="phone" id="phone" placeholder=" '-'없이 입력해 주세요." onkeyup="checkPhone(this.value)">
				 <input type="button" value="중복확인" class="dup" onclick="winopen2()"><br><!-- 핸드폰 중복체크 -->
				 <span id="checkPhoneResult"><!--  휴대폰 번호 규칙 판별 결과 표시 영역 --></span><br>
	* 이메일 : <input type="email" name="email"><br><br>
			 
	<input type="submit" value="회원가입"> <input type="reset" value="다시 작성"><br>
</form>
</fieldset>

</body>
</html> 