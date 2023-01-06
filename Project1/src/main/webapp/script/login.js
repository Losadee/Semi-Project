/**
 * 
 */
 
            $("#signup").click(function () {
                $("#first").fadeOut("fast", function () {
                    $("#second").fadeIn("fast");
                });
            });
            $("#signin").click(function () {
                $("#second").fadeOut("fast", function () {
                    $("#first").fadeIn("fast");
                });
            });
            
            $(function () {
                $("form[name='login']").validate({
                    rules: {
                        id: {
                            required: true,
                        },
                        pass: {
                            required: true,
                        }
                    },
                    messages: {
                        id: "아이디를 입력하세요",
                        pass: {
                            required: "비밀번호를 입력하세요",
                        }
                    },
                    submitHandler: function (form) {
                        form.submit();
                    }
                });
            });
            $(function () {
                $("form[name='registration']").validate({
                    rules: {
                    	id: {
                    		required: true,
                    		rangelength:[4,30]
                    	},
                    	pass1: {
                            required: true,
                            rangelength:[6,30]
                        },
                        pass2: {
            				equalTo: '#pass1'
            			},
                        name: "required",
                        phone: {
                        	required: true,
                        	digits:true
                        },
                        email: {
                            required: true,
                            email: true
                        },
                        ch1: "required",
                       	ch2: "required"
                    },
                    messages: {
                    	id: {
                            required: "아이디를 입력하세요",
                            rangelength: "아이디는 4-30자 사이 영문,숫자만 허용합니다"
                        },
                        
                        pass1: {
                            required: "비밀번호를 입력하세요",
                            rangelength: "비밀번호는 6-30자 사이 영문,숫자만 허용합니다"
                        },
                        pass2: {
                        	equalTo: "비밀번호를 재확인하세요"
                        },
                        name: "이름을 입력하세요",
                        phone: {
                        	required: "휴대폰 번호를 입력하세요",
                        	digits: "' - ' 제외 숫자만 입력하세요"
                        },
                        email: {
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