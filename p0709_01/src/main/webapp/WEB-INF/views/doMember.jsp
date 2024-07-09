<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
	</head>
	<body>
		<h2>회원가입</h2>
		<table>
			<tr>
				<th>데이터</th>
				<th>값</th>
			</tr>
			<tr>
				<td>아이디</td>
				<td>${id}</td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td>${pw}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${name}</td>
			</tr>			
			<tr>
				<td>성별</td>
				<td>${gender}</td>
			</tr>	
			<tr>
				<td>취미</td>
				<td>${hobby}</td>
			</tr>				
		
		</table>
	
	</body>
</html>