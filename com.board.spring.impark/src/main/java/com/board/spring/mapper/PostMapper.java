package com.board.spring.mapper;

import java.util.ArrayList;

import com.board.spring.dto.PageDto;
import com.board.spring.dto.PostDto;

public interface PostMapper {
	
	 public ArrayList<PostDto> postList(PageDto page);
	 public ArrayList<PostDto> postListDesc(PageDto page);
	 public PostDto postInfo(String postNumber);
	 public PostDto userInfo(String userInfo);
	 public void postModify(PostDto postModify);
	 public void postDel(String postNumber);
	 public void postReading(String postReading);
	 public void postWrite(PostDto postWrite);
	 public int postCount(PageDto currentPage);
}