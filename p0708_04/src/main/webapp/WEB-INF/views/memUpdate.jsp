<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원정보수정</title>
	</head>
	<body>
		<h2>회원정보수정</h2>
			<form action="doMember" name="frm" method="post">
				<label>아이디</lable>
				<input type="text" id="id" name="id" value="${id}"><br>
				<label>비밀번호</lable>
				<input type="password" id="pw" name="pw" value="${pw}"><br>
				<label>이름</lable>
				<input type="text" id="name" name="name" value="name"><br>
				<label>핸드폰</lable>
				<input type="text" id="phone" name="phone" value="phone"><br>
				<label>성별</lable>
				<input type="radio" id="gender" name="gender" value="male">
				<label for="male">남자</label><br>
				<input type="radio" id="gender" name="gender" value="female">
				<label for="female">여자</label><br>
				
				<label>취미</lable>
				<input type="checkbox" id="hobby" name="game" value="game">
				<label for="game">게임</label><br>
				<input type="checkbox" id="hobby" name="golf" value="golf">
				<label for="golf">골프</label><br>
				<input type="checkbox" id="hobby" name="swim" value="swim">
				<label for="swim">수영</label><br>
				<input type="checkbox" id="hobby" name="run" value="run">
				<label for="run">조깅</label><br>
				<input type="checkbox" id="hobby" name="book" value="book">
				<label for="book">독서</label><br>
				
				
				<input type="submit" value="전송"><br>
			</form>
	
	</body>
</html>