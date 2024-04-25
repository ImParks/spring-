<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
회원가입 <hr>
${signUp.mag}
 <hr>
<form action="/join/signUp" method="post">
아이디 : <input name = "userID"  maxlength="20"><br>
비밀번호 : <input name = "userPW" maxlength="20"><br>
닉네임 : <input name = "userName" maxlength="8"><hr>
<input type="submit" value="회원가입">
</form>
<hr>
<a href="/join/login"><button>뒤로가기</button></a>




</body>
</html>