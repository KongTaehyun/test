<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인완료</title>
</head>
<body>
	<p>
		로그인완료 <br>
		이메일 : ${authInfo.email }<br>
	</p>
	<p>
		<a href="<c:url value='/main'/>">메인으로가기</a>
	</p>
</body>
</html>