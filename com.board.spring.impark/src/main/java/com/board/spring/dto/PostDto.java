package com.board.spring.dto;

import lombok.Data;

@Data
public class PostDto {
	private String postNumber;
	private String title;
	private String content;
	private int hit;
	private int userNumber;
	private String userName;
	private int userTag;
	private String dateTime;
	private String postModifyTime;
	private String upDateTime;
	private int pageNumber;
}