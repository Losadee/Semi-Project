			// 로그인, 회원가입 전환 페이지
			$(function() {
				$("#signup").click(function() {
	                $("#first").fadeOut("fast", function () {
	                    $("#second").fadeIn("fast");
	                });
	            });
	            $("#signin").click(function() {
	                $("#second").fadeOut("fast", function () {
	                    $("#first").fadeIn("fast");
	                });
	            });	
			});
			
            // 로그인폼
            $(function() {
                $("form[name='login']").validate({
                    rules: {
                        cus_id: {
                            required: true
                        },
                        cus_pass: {
                            required: true
                        }
                    },
                    messages: {
                        cus_id: "아이디를 입력하세요",
                        cus_pass: {
                            required: "비밀번호를 입력하세요",
                        }
                    },
                    submitHandler: function (form) {
                        form.submit();
                    }
                });
            });
            
            //
			$.validator.addMethod("regexPass", function(value, element, regex){
			  var regExp = new RegExp(regex);
			  return regExp.test(value);
			});
			
            
            // 회원가입폼
            $(function() {
                $("form[name='registration']").validate({
                    rules: {
                    	cus_id: {
                    		required: true,
                    		rangelength:[4,30],
                			remote: { // 아이디 중복체크
                				url: "./CustomerIdCheck.cu",
                				type: "post",
                				data: {
                					id: function() {
                						return $("#cus_id").val();
                					}
                				}
                			}
                    	},
                    	cus_pass1: {
                            required: true,
                            regex: "^(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$"
                        },
                        cus_pass2: {
            				equalTo: '#cus_pass1'
            			},
                        cus_name: "required",
                        cus_phone: {
                        	required: true,
                        	digits:true,
                        	rangelength:[11,11],
                        	remote: {
                				url: "./CustomerPhoneCheck.cu",
                				type: "post",
                				data: {
                					phone: function() {
                						return $("#cus_phone").val();
                					}
                				}
                			}
                        },
                        cus_email: {
                            required: true,
                            email: true
                        },
                        ch1: "required",
                       	ch2: "required"
                    },
                    messages: {
                    	cus_id: {
                            required: "아이디를 입력하세요",
                            rangelength: "아이디는 4-30자 사이 영문,숫자만 허용합니다",
                            remote: "중복된 아이디입니다"
                        },
                        
                        cus_pass1: {
                            required: "비밀번호를 입력하세요",
                            regex: "8자 이상 숫자,특수문자를 포함해야 합니다"
                        },
                        cus_pass2: {
                        	equalTo: "비밀번호를 재확인하세요"
                        },
                        cus_name: "이름을 입력하세요",
                        cus_phone: {
                        	required: "휴대폰 번호를 입력하세요",
                        	digits: "' - ' 제외 숫자만 입력하세요",
                        	rangelength: "휴대폰 번호는 11자리입니다",
                        	remote: "중복된 휴대폰 번호입니다"
                        },
                        cus_email: {
                        	required: "이메일을 입력하세요",
                        	email: "이메일 형식이 아닙니다"
                        },
                       	ch1: "필수",
                        ch2: "필수"
                    },
                    submitHandler: function (form) {
                        form.submit();
                    }
                });
            });
            
            // 카카오 회원가입
            window.Kakao.init('46649a5dcd99d3819c79c2f83892ddb9');
            
            function kakaoJoin() {
            	Kakao.Auth.login({
            		scope:'account_email',
                    success: function (response) {
                        Kakao.API.request({
                            url: '/v2/user/me',
                            success: (res) => {
                                kakaojoin.cus_id.value=res.id;
                            	kakaojoin.cus_pass.value=res.kakao_account.email;
                            	//kakaojoin.cus_name.value=res.properties.nickname;
                            	kakaojoin.cus_email.value=res.kakao_account.email;
            					kakaojoin.submit()
            					alert('회원가입 성공! 메인페이지에서 로그인해주세요')
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
            
            // 카카오 로그인
            function kakaoLogin() {
            	Kakao.Auth.login({
            		scope:'account_email',
                    success: function (response) {
                        Kakao.API.request({
                            url: '/v2/user/me',
                            success: (res) => {
                                kakaologin.cus_id.value=res.id;
                                kakaologin.cus_pass.value=res.kakao_account.email;
            					kakaologin.submit()
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