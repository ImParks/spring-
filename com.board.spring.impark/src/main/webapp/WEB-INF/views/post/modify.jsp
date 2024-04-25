<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/board/modify" method="post">
<input type="hidden" name="postNumber" value="${postInfo.postNumber}">
	제목 : <input type="text" name = "title"  maxlength="20"><br>
	내용 : <input type="text" name = "content"  maxlength="100">
<input type="submit" value="수정">
</form>
<form action="/board/read" method="get">
<input type="hidden" name="postNumber" value="${postInfo.postNumber}">
<input type="submit" value="뒤로가기">
</form>

</body>
</html>