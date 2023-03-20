
<%@page import="com.itwillbs.menu.db.MenuDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>menuList</title>

<link rel="stylesheet" type="text/css" href="./css/default.css">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<link rel="stylesheet" type="text/css" href="./css/menuList.css">
</head>


</head>

<body>
	<%
		String cus_id = (String) session.getAttribute("cus_id");
		//로그인이 안된 상태면 장바구니 담기 불가----------------------------------------------------
		List<MenuDTO> goodsList = (List<MenuDTO>) request.getAttribute("goodsList");
	%>

		<h1>Drink</h1>


		<div class="category_select">
			<form action="" method="post">
				<fieldset>
					<!-- 관련컨텐츠를 하나의 그룹으로 묶음 -->
					<legend> 분류보기 </legend>
					<!-- fieldset의 제목 명령어 -->

					<ul class="cate_list">
						<!--  순서없는 항목  -->
						<li><input type="radio" style='vertical-align: middle'
							name="category_1" id="category_all" checked="checked"> <label
							for="category_all">모두보기</label></li>

						<li><input type="radio" style='vertical-align: middle;'
							name="category_1" id="category_1"> <label
							for="category_1">DRINK</label></li>

						<li><input type="radio" style='vertical-align: middle;'
							name="category_1" id="category_2"> <label
							for="category_2">FOOD</label></li>

						<li><input type="radio" style='vertical-align: middle;'
							name="category_1" id="category_3"> <label
							for="category_3">카테고리3</label></li>

					</ul>
				</fieldset>
			</form>
			
			
			
			
		</div>
		
		<%
		
					for (int i = 0; i < goodsList.size(); i++) {
						MenuDTO dto = goodsList.get(i);
				%>
				<form action="./CartAddPro.ca" method="post" name="menudata" >
			<ul>
		</ul>
		<ul>



			<div class="box-wrap">
			<input type="hidden" id="menu_num" name="menu_num" value="<%=dto.getMenu_num()%>">
				<div style="font-size: 30px;"><%=dto.getMenu_name()%></div>
				<div class="box">
					<div class="img">
						<img src="./upload/<%=dto.getMenu_img()%>" width="400"
							height="300">
					</div>
					<div class="info">
						<span class="name"> <%=dto.getMenu_name()%>
						</span>
						<p class="detail"><%=dto.getMenu_detail()%></p>
						<span class="price"> <%=dto.getMenu_price()%>원
						</span>

						<p class="addToCart">
							수량 <input type="number" step="1" min="0" id="crt_num" name="crt_count"
								style="text-align: left; width: 40px; height: 17px;">
								<%
								if(cus_id == null ){
									%>
									<input type="button" class="btn1" value="로그인하고 담기" onclick="location.href='./LoginForm.ca'"></p>
									<%
								}else{
									%>
									<input type="submit" class="btn2" value="장바구니담기" ></p>
									<%
								}
								%>

						</div>
					</div>
				</div>
			</div>
		</ul>
		</form>
		<%
		}
		%>






</body>
</html>