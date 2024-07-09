<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>login</title>
	</head>
	<body>
		<form>
			<label>아이디</label>
			<form action="doLogin" name="lfrm" method="post">
			<input type="text" name="id"><br>			
			<label>패스워드</label>
			<input type="password" name="pw"><br>
			<label>페이지번호</label>
			<input type="text" name="pno"><br>
			<input type="submit" value="로그인">
		</form>
	
	</body>
</html>