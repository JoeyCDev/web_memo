<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<header class="bg-secondary text-light d-flex justify-content-between align-items-center">
			<h1 class="ml-3 pt-1">Memo</h1>
			<c:if test= "${not empty userName }">
			<div class="text-white mr-3">
				${userName } 님 <a href="/user/sign_out">[로그아웃]</a>
			</div>
			</c:if>
		</header>

</body>
</html>