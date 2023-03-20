			// 회원정보 업데이트
            $(function() {
                $("form[name='update']").validate({
                    rules: {
                        cus_name: "required",
                        cus_phone: {
                        	required: true,
                        	digits:true,
                        	rangelength:[11,11],
                        },
                        cus_email: {
                            required: true,
                            email: true
                        },
                    },
                    messages: {
                        cus_name: "이름을 입력하세요",
                        cus_phone: {
                        	required: "휴대폰 번호를 입력하세요",
                        	digits: "' - ' 제외 숫자만 입력하세요",
                        	rangelength: "휴대폰 번호는 11자리입니다",
                        },
                        cus_email: {
                        	required: "이메일을 입력하세요",
                        	email: "이메일 형식이 아닙니다"
                        },
                    },
                    submitHandler: function (form) {
                        form.submit();
                    }
                });
            });