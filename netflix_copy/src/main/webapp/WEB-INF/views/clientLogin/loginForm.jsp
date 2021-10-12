<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<form:form commandName="loginVo">

		<p>
			이메일 : 
			<form:input path="email"/>
			<form:errors path="email"/>
		</p>		
		<p>
			비밀번호 :
			<form:input path="password"/>
			<form:errors path="password"/>
		</p>	
		<p>
			<form:checkbox path="rememberemail"/>
		</p>
		<input type="submit" value="로그인">	
	</form:form>
</body>
</html>