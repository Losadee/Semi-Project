<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/findIdForm.jsp</title>
<script type="text/javascript">
function check() {
	// 필수
	let join = document.join;
	if(join.name.value == ""){
		alert("이름을 입력해 주세요.");
		join.name.focus();
		return false;
	}
	
	if(join.phone.value == ""){
		alert("휴대폰 번호를 입력해 주세요.");
		join.phone.focus();
		return false;
	}
}
</script>
</head>
<body>
<h1>아이디 찾기</h1>


<form action="./MemberFindIdPro.me" method="post" onsubmit="return check();">
<fieldset> 
이름 :  <input type="text" name="name" placeholder="등록한 이름"><br>
휴대폰 번호 : <input type="text" name="phone" placeholder=" '-' 없이 입력해 주세요."><br>
</fieldset>
<input type="submit" value="아이디 찾기"><br>
비밀번호가 기억나지 않는다면? <a href="./MemberFindPw.me">비밀번호 찾기</a>
</form>

</body>
</html>