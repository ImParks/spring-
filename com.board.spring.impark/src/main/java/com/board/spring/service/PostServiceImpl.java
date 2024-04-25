package com.board.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.spring.dto.PageDto;
import com.board.spring.dto.PostDto;
import com.board.spring.mapper.PostMapper;
import com.board.spring.util.PagingUtil;

import lombok.Setter;
import lombok.extern.log4j.Log4j;


@Log4j
@Service
public class PostServiceImpl implements PostService{

	@Setter(onMethod_ = @Autowired)
	private PostMapper mapper;	
	private PagingUtil util = new PagingUtil();
	@Override
	public ArrayList<PostDto> postList(PageDto page) {
		ArrayList<PostDto> list = new ArrayList<PostDto>();
		if(page.isListInTurn()) {
			list = mapper.postList(page);
		} else {
			list = mapper.postListDesc(page);
		}
		
		return list;
		
	}
	
	@Override
	 public PostDto postInfo(String postNumber) {
		 return mapper.postInfo(postNumber);
		 
	 }
	 
	@Override
	 public PostDto userInfo(String userInfo) {
		 return mapper.userInfo(userInfo);
	 }
	
	@Override
	public void postModify(PostDto postModifyr) {
		mapper.postModify(postModifyr);
	}
	
	@Override
	 public void postDel(String postNumber) {
		mapper.postDel(postNumber);
	}
	
	@Override
	public void postReading(String postNumber) {
		mapper.postReading(postNumber);
	}

	@Override
	public void postWrite(PostDto postWrite) {
		mapper.postWrite(postWrite);
		
	}
	
	@Override
	public PageDto page(PageDto currentPage) {
		return util.paging(currentPage,mapper.postCount(currentPage));
	}
	
	@Override
	public int pageBlock(PageDto pageBlock) {
		return util.pageBlock(pageBlock);
	}
	
}
