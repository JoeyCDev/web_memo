<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메모 게시판 - 회원가입</title>
<!-- bootstrap CDN link -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<%-- AJAX를 사용하려면 더 많은 함수가 있는 js를 포함해야 한다. --%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
<!--  datepicker -->
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"
	integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!-- styleshet -->
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
<!-- Font Awesome -->
<script src="https://kit.fontawesome.com/904eedb8ad.js"
	crossorigin="anonymous"></script>
</head>
<body>

	<div id="wrap">
		<header class="bg-secondary text-light">
			<h1 class="ml-3 pt-1">Memo</h1>
		</header>

		<section
			class="content d-flex justify-content-center align-items-center">
			<div class="signup-box">
				<h2 class="text-center">회원가입</h2>
				<br>
				<form id="signupForm">
					<div class="input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-user"></i></span>
						</div>
						<input type="text" class="form-control" placeholder="아이디" id="idInput" name="id" />
					</div>
					<div class="input-group mt-3">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-key"></i></span>
						</div>
						<input type="password" class="form-control" placeholder="비밀번호" id="pwdInput" name="pwd" />
					</div>
					<div class="input-group mt-3">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-key"></i></span>
						</div>
						<input type="password" class="form-control" placeholder="비밀번호 확인"id="pwdCheckInput" name="pwdCheck" />
					</div>
					<input type="text" class="form-control mt-3" placeholder="이름" id="nameInput" name="name" />
					<input type="text"class="form-control mt-3" placeholder="이메일 주소" id="emailInput"name="email" />
					<button type="submit"class="btn btn-info btn-block mt-3" id="registerBtn">가입</button>
				</form>
			</div>
		</section>

		<footer class="bg-secondary text-light text-center"> © 2021.
			memo Co. all rights reserved. </footer>

	</div>

	<script>
		$(document).ready(function() {

			$("#signupForm").on("submit", function(e) {
				
				e.preventDefault();

				var id = $("#idInput").val().trim();
				var pwd = $("#pwdInput").val().trim();
				var pwdCheck = $("#pwdCheckInput").val().trim();
				var name = $("#nameInput").val().trim();
				var email = $("#emailInput").val().trim();

				if (id == null || id == "") {
					alert("아이디를 입력하세요.");
					return;
				}
				if (pwd == null || pwd == "") {
					alert("비밀번호를 입력하세요.");
					return;
				}
				if (pwdCheck == null || pwdCheck == "") {
					alert("비밀번호 확인을 입력하세요.");
					return;
				}
				if (name == null || name == "") {
					alert("이름을 입력하세요.");
					return;
				}
				if (email == null || email == "") {
					alert("이메일을 입력하세요.");
					return;
				}
				
				if(pwd!=pwdCheck){
					alert("비밀번호가 일치하지 않습니다.");
					return;
				}

				$.ajax({
					type : "post",
					url : "/user/sign_up",
					data : {
						"loginId" : id,
						"password" : pwd,
						"name" : name,
						"email" : email
					},
					success : function(data) {
						if (data.result == "success") {
							location.href = "/user/signin_view";
						}else{
							alert("가입실패");
						}
					},
					error : function(e) {
						alert("error");
					}
				});
			});
		});
	</script>

</body>
</html>