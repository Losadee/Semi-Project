<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>login</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tutorialjinni.com/jquery/3.4.1/jquery.min.js"></script>
    <script src="./js/jquery.validate.js"></script>
    <script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
    <script src="./js/login.js"></script>
    <link href="https://cdn.tutorialjinni.com/twitter-bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="https://cdn.tutorialjinni.com/twitter-bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap" rel="stylesheet">
    <link href="./css/login.css" rel="stylesheet" type="text/css">
    
</head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-5 mx-auto">
                    <div id="first">
                        <div class="myform form ">
                        <!-- 창닫기 -> 메인으로 이동 -->
                        <div class="close">
                            <a href="javascript:history.back();">X</a>
                        </div>
                        <!-- 창닫기 -> 메인으로 이동 끝 -->
                            <div class="logo mb-3">
                                <div class="col-md-12 text-center">
                                    <h2>로그인</h2>
                                </div>
                            </div>
                            
                            <form action="./CustomerLoginPro.cu" method="post" name="login">
                                <div class="form-group">
                                    <input type="text" name="cus_id" class="form-control" id="cus_id" aria-describedby="emailHelp" placeholder="아이디">
                                </div>
                                <div class="form-group">
                                    <input type="password" name="cus_pass" id="cus_pass" class="form-control" aria-describedby="emailHelp" placeholder="비밀번호">
                                </div>
                                
                                <div class="col-md-12 mb-3">
                                    <button type="submit" class="btn btn-block mybtn btn-primary tx-tfm">로그인</button>
                                </div>
                            </form>   
                            
                            <!-- 카카오 회원 로그인 시작 -->
							<form action="./CustomerLoginPro.cu" method="post" name="kakaologin">
							     <input type="hidden" name="cus_id">
							     <input type="hidden" name="cus_pass">
                                <div class="col-md-12 mb-3">
                                   <p class="text-center">
                                       <a href="javascript:kakaoLogin();" class="kakao btn mybtn"><i class="fa fa-google-plus">
                                           </i> 카카오 회원 로그인
                                       </a>
                                   </p>
                                </div>  
                            </form>
                            <!-- 카카오 회원 로그인 끝 -->
                            
                            	<div class="col-md-12 mb-3">
                                  <p class="text-center">
                                    <a href="#" id="signup" style="color: black;">회원가입</a>
                                    |
                                    <a href="./CustomerFindIdPw.cu" target='_blank' id="findidpw" style="color: black;">아이디 · 비밀번호 찾기</a>
                                  </p>
                                </div>
                             
                        </div>
                    </div>
                    <div id="second">
                        <div class="myform form ">
                         <!-- 창닫기 -> 메인으로 이동 -->
	                        <div class="close">
	                            <a href="./MainPage.cu">X</a>
	                        </div>
                            <div class="logo mb-3">
                                <div class="col-md-12 text-center">
                                    <h2>회원가입</h2>
                                </div>
                            </div>
                            <form action="./CustomerJoinPro.cu" method="post" name="registration">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">아이디</label>
                                    <i aria-hidden="true" class="icon-required"></i> <!-- 파란아이콘 -->
                                    <input type="text"  name="cus_id" class="form-control" id="cus_id" placeholder="아이디">
                                </div>
								<div class="dupdiv"></div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">비밀번호</label>
                                    <i aria-hidden="true" class="icon-required"></i> <!-- 파란아이콘 -->
                                    <input type="password" name="cus_pass1" class="form-control" id="cus_pass1" placeholder="비밀번호">
                                    <input type="password" name="cus_pass2" class="form-control" id="cus_pass2" placeholder="비밀번호 확인">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">이름</label>
                                    <i aria-hidden="true" class="icon-required"></i> <!-- 파란아이콘 -->
                                    <input type="text"  name="cus_name" class="form-control" id="cus_name" placeholder="이름을 입력하세요">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">휴대폰 번호</label>
                                    <i aria-hidden="true" class="icon-required"></i> <!-- 파란아이콘 -->
                                    <input type="text"  name="cus_phone" class="form-control" id="cus_phone" placeholder="휴대폰 번호">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">이메일</label>
                                    <i aria-hidden="true" class="icon-required"></i> <!-- 파란아이콘 -->
                                    <input type="email" name="cus_email"  class="form-control" id="cus_email" placeholder="이메일">
                                </div>
                                <div class="form-group">
                                    <p class="text-center">이용약관 및 개인정보수집 및 이용 안내 <a href='./CustomerAgree.cu' target='_blank'>자세히 보기</a></p>
                                </div>
                                <div class="form-group">
                                	<input type="checkbox" name="ch1" value="이용약관">이용약관 동의(필수)<br>
                                	<input type="checkbox" name="ch2" value="개인정보수집">개인정보수집 및 이용 동의(필수)
                                </div>	
                                <div class="col-md-12 text-center mb-3">
                                    <button type="submit" class="btn btn-block mybtn btn-primary tx-tfm">가입하기</button>
                                </div>
                        	</form>
                        	<!-- 카카오 회원가입 -->
                       	    <form action="./KakaoJoin.cu" name="kakaojoin" method="post">
							     <input type="hidden" name="cus_id">
							     <input type="hidden" name="cus_pass">
							     <input type="hidden" name="cus_name">
							     <input type="hidden" name="cus_email">
								<div class="col-md-12 text-center mb-3">    
                                   <a href="javascript:kakaoJoin();" class="kakao btn mybtn"><i class="fa fa-google-plus">
                                     </i> 카카오 간편회원가입
                                   </a>
                               </div> 
                               
                               <div class="col-md-12 ">
                                    <div class="form-group">
                                        <p class="text-center"><a href="#" id="signin" style="color: black;">기존 회원 로그인</a></p>
                                    </div>
                                </div>
							</form>
                        </div>
                    </div>
                </div>
            </div>
        </div>   
    </body>
</html>
