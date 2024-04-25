<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- post.postNumber,post.title,post.content,post.hit,post.userNumber,user.userName,user.userTag,post.dateTime,post.upDateTime -->
	글 번호 : ${postInfo.postNumber } || 제목 : ${postInfo.title }
	<hr>
	작성자 : ${postInfo.userName } # ${postInfo.userTag}
	<hr>
	<c:choose>
		<c:when test="${postInfo.dateTime eq postInfo.postModifyTime}">
작성일자 : ${postInfo.postModifyTime}
</c:when>
		<c:otherwise>
작성일자 : ${postInfo.postModifyTime} (수정됨)
</c:otherwise>
	</c:choose>
	<hr>
	${postInfo.content }
	<hr>
	조회수 : ${postInfo.hit }
	<hr>
	<form action="/board/list">
	<input type="hidden" name=postNumber value="${postInfo.postNumber }">
	<input type="submit" value="뒤로가기">
	</form>
	<form action="/board/modify">
		<input type="hidden" name=postNumber value="${postInfo.postNumber }">
		<input type="submit" value="수정">
	</form>
	<form action="/board/del">
			<input type="hidden" name=postNumber value="${postInfo.postNumber }">
		<input type="submit" value="삭제">
	</form>

</body>
</html>