package com.board.spring.service;

import java.util.ArrayList;

import com.board.spring.dto.PageDto;
import com.board.spring.dto.PostDto;



public interface PostService {
 public ArrayList<PostDto> postList(PageDto page);
 public PostDto postInfo(String postNumber);
 public PostDto userInfo(String userInfo);
 public void postModify(PostDto postModify);
 public void postDel(String postNumber);
 public void postReading(String postNumber);
 public void postWrite(PostDto postWrite);
 public PageDto page(PageDto currentPage);
 public int pageBlock(PageDto pageBlock);
}
