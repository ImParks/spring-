<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<div id="head">
			<h1>로그인</h1>
		</div>
		<div id="main">
			<div id="mag">${login.mag}</div>
			<div id="formBox">
				<form action="/join/login" method="post">
					<div id="login">
						<div id="formBoxID">
							아이디 : <input name="userID">
						</div>
						<div id="formBoxPW">
							비밀번호 : <input name="userPW">
						</div>
					</div>
					<div id="formBoxSubmit">
						<input type="submit" value="로그인">
					</div>
				</form>
				<hr>
			</div>
			<div id = "button">
				<a href="/join/signUp" id = "joinButton"><button>회원가입</button></a> <a href="/" id = ""><button>뒤로가기</button></a>
			</div>
		</div>
	</div>
</body>
</html>