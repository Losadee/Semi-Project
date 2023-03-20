<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Resto">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- External CSS -->
<link rel="stylesheet" href="./vendor/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="./vendor/select2/select2.min.css">
<link rel="stylesheet" href="./vendor/owlcarousel/owl.carousel.min.css">
<link rel="stylesheet"
	href="https://cdn.rawgit.com/noelboss/featherlight/1.7.13/release/featherlight.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/css/tempusdominus-bootstrap-4.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.1/css/brands.css">

<!-- Fonts -->
<link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.linearicons.com/free/1.0.0/icon-font.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
	integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
	crossorigin="anonymous">

<!-- CSS -->
<link rel="stylesheet" href="./css/style.min.css">

<!-- Modernizr JS for IE8 support of HTML5 elements and media queries -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.js"></script>
<title>Reservation Info</title>
</head>
<jsp:include page="../inc/headerMenu.jsp"></jsp:include>
<body data-spy="scroll" data-target="#navbar">
<div id="canvas-overlay"></div>
<div class="boxed-page">
	<section id="gtco-menu" class="section-padding">
		<div class="container">
			<div class="section-content">
				<div class="row mb-5">
					<div class="col-md-12">
						<div class="heading-section text-left">
							<div class="container">
								<div class="section-content">
									<div class="heading-section text-center">
										<h2>INFORMATION</h2>
									</div>
									<div class="row mt-5">
				                <div class="col-lg-6 col-md-6 align-self-center py-5">
				                    <h2 class="special-number">01.</h2>
				                    <div class="dishes-text">
				                        <h3><span>CAUTIONS</span></h3>
				                        <p class="pt-3">
										· 흡연은 지정된 장소에서 가능합니다.(화재 예방 및 냄새로 인한불쾌감 조성 예방)<br><br>
										· 카페 내에는 외부 음식 반입을 자제 부탁드립니다.<br><br>
										· 카페지기에게 보관하지 않은 귀중품은 분실 도난시 이용객의 책임입니다. 이용객의 부주의로 발생한사고에 대해서는 책임지지 않습니다.<br><br>
										· 관리인의 허락없이 예약인원 초과 또는 무단 입실하는 경우는 퇴실 조치됩니다. 성숙한 카페문화를 위하여 무단입실을 삼가해 주시기 바랍니다.<br><br>
										· 조용하고 편안한 휴식과 성숙한 카페문화를 위하여 고성방가, 무분별한 음주, 가무는 삼가하여 주십시오.<br><br>
										· 주문이 밀리는 시간대에는 주문이 다소 지연될 수 있습니다. 고객님의 너그러운 이해 부탁 드립니다.<br><br>
				                    </div>
				                </div>
				                <div class="col-lg-5 offset-lg-1 col-md-6 align-self-center mt-4 mt-md-0">
				                    <img src="./img/9.jpg" alt="" class="img-fluid shadow w-100" style="border-radius: 7px;">
				                </div>
				            </div>
				            <div class="row mt-5">
				                <div class="col-lg-6 col-md-6 align-self-center py-5">
				                    <h2 class="special-number">02.</h2>
				                    <div class="dishes-text">
				                        <h3><span>REFUND</span></h3>
				                        <p class="pt-3">
				                        취소 및 환불 규정 취소, 환불 시 수수료가 발생할 수 있습니다.<br> 예약 후 이용일까지 남은 기간 취소수수료<br><br> 
										이용 10일 전까지 없음<br> 
										이용 9일 전 &emsp;총 결제금액의 10% 환불<br>
										이용 8일 전 &emsp;총 결제금액의 20% 환불<br> 
										이용 7일 전 &emsp;총 결제금액의 30% 환불<br>
										이용 6일 전 &emsp;총 결제금액의 40% 환불<br> 
										이용 5일 전 &emsp;총 결제금액의 50% 환불<br>
										이용 4일 전 &emsp;총 결제금액의 60% 환불<br> 
										이용 3일 전 &emsp;총 결제금액의 70% 환불<br>
										이용 2일 전 &emsp;총 결제금액의 80% 환불<br> 
										이용 1일 전 &emsp;총 결제금액의 90% 환불<br>
										이용 당일 &emsp;&emsp;환불불가<br>
				                    </div>
				                </div>
				                <div class="col-lg-5 offset-lg-1 col-md-6 align-self-center mt-4 mt-md-0">
				                    <img src="./img/10.jpg" alt="" class="img-fluid shadow w-100" style="border-radius: 7px;">
				                </div>
				            </div>
				            </div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>	
</section>
</div>
<!-- footer -->
<jsp:include page="../inc/footerMain.jsp"></jsp:include>
	<!-- External JS -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
	<script src="./vendor/bootstrap/popper.min.js"></script>
	<script src="./vendor/bootstrap/bootstrap.min.js"></script>
	<script src="./vendor/select2/select2.min.js "></script>
	<script src="./vendor/owlcarousel/owl.carousel.min.js"></script>
	<script src="https://cdn.rawgit.com/noelboss/featherlight/1.7.13/release/featherlight.min.js"></script>
	<script src="./vendor/stellar/jquery.stellar.js" type="text/javascript" charset="utf-8"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.0.1/js/tempusdominus-bootstrap-4.min.js"></script>

	<!-- Main JS -->
	<script src="./js/app.min.js "></script>
</body>
</html>