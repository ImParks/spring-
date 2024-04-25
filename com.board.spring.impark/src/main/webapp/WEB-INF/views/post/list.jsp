<%@page import="com.board.spring.dto.PostDto"%>
<%@page import="com.board.spring.util.PagingUtil"%>
<%@page import="com.board.spring.service.PostService"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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

	<c:choose>
		<c:when test="${page.listInTurn}">
			<form action="/board/list">
				<input type="hidden" value="${page.postSearch}" name="postSearch">
				<input type="hidden" name="listInTurn" value="false"> <input
					type="submit" value="오래된글">
			</form>
		</c:when>
		<c:otherwise>
			<form action="/board/list">
				<input type="hidden" value="${page.postSearch}" name="postSearch">
				<input type="hidden" name="listInTurn" value="true"> <input
					type="submit" value="최신글">
			</form>
		</c:otherwise>
	</c:choose>




	<c:forEach var="post" items="${list}" varStatus="loop">
		<!-- SELECT post.postNumber,post.title,post.content,post.hit,post.userNumber
		                   ,user.userName,user.userTag,post.dateTime,post.upDateTime-->
		<c:set var="postNo" value=" ${page.startPost + loop.index + 1}"></c:set>
 ${postNo} ||
<a href="/board/reading?postNumber=${post.postNumber}">${post.title}</a>
||
${post.userName} # ${post.userTag} ||
조회수 : ${post.hit}<br>
		<c:choose>
			<c:when test="${post.postModifyTime eq post.dateTime}">
작성일자 : ${post.postModifyTime}
</c:when>
			<c:otherwise>
작성일자 : ${post.postModifyTime} (수정됨)
</c:otherwise>
		</c:choose>

		<hr>
	</c:forEach>


	<!-- 페이징 블록 -->
	<c:if test="${page.currentPage > 1}">
		<form action="/board/pageBlock">
			<input type="hidden" value="${page.currentBlock}" name="currentBlock">
			<input type="hidden" value="${page.postSearch}" name="postSearch">
			<input type="hidden" value="${page.listInTurn}" name="listInTurn">
			<input type="hidden" value="pageDown" name="block"> <input
				type="submit" value="<=이전페이지">
		</form>
	</c:if>

	<c:forEach var="pageNo" begin="${page.startPage}" end="${page.endPage}">
		<a
			href="/board/list?currentPage= ${pageNo}&postSearch=${page.postSearch}&listInTurn=${page.listInTurn}">${pageNo}</a>
	</c:forEach>

	<c:if test="${page.currentPage < page.totalPage}">
		<form action="/board/pageBlock">
			<input type="hidden" value="${page.currentBlock}" name="currentBlock">
			<input type="hidden" value="${page.postSearch}" name="postSearch">
			<input type="hidden" value="${page.listInTurn}" name="listInTurn">
			<input type="hidden" value="${page.totalPage}" name="totalPage">
			<input type="hidden" value="pageUp" name="block"> 
			<input type="submit" value="다음페이지=>">
		</form>

	</c:if>
	<!--  글 쓰기 -->
	<hr>
	<a href="/board/write"><button>글 작성</button></a>
	<a href="/"><button>뒤로가기</button></a>
	<!--  글 검색 -->
	<form action="/board/list">
		<input type="hidden" value="${page.listInTurn}" name="listInTurn">
		<input value="${page.postSearch}" name="postSearch"> <input
			type="submit" value="검색">
	</form>
	<hr>

</body>
</html>