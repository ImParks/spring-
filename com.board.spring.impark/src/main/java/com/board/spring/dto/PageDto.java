package com.board.spring.dto;

import lombok.Data;

@Data

public class PageDto {
	private final int pageSize = 10;
	private final int blockSize = 5;
	private int startPost; // 페이지에서 시작하는 번호
	private int currentPage = 1; // 현제 페이지
	private int currentBlock;// 현제 블록
	private int postCount; // 게시글 갯수
	private int startPage; // 블록에서 시작하는 번호
	private int endPage; // 끝나는 번호
	private int totalPage; // 토탈 페이지
	private boolean listInTurn = true;
	private String postSearch = "";//검색어
	private String PageNo = null; // 페이지 넘버 받는거
	private String block;
}
