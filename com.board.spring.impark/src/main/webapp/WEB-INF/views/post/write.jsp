<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/board/write" method="post">
	<input type="hidden" name = "userNumber"  value="1">
	제목 : <input type="text" name = "title"  maxlength="20"><br>
	내용 : <input type="text" name = "content"  maxlength="100">
	
	<input type="submit" value="작성">
	</form>

<a href="/board/list"><input type="submit" value="뒤로가기"></a>

</body>
</html>