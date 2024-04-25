package com.board.spring.util;

import org.springframework.beans.factory.annotation.Autowired;

import com.board.spring.dto.PageDto;
import com.board.spring.dto.PostDto;
import com.board.spring.service.PostService;

import lombok.Setter;

public class PagingUtil {

	@Setter(onMethod_ = @Autowired)
	private PostService service;

	public PageDto paging(PageDto currentPage, int postCount) {
		// 게시글 수와 한페이지 당 게시글수를 나누어서 총 몇페이지 인지 구하는함수
		PageDto page = currentPage;
		page.setPostCount(postCount);
		if (page.getCurrentPage() <= 0) {
			page.setCurrentPage(1);
		}
		if (postCount % page.getPageSize() == 0) {
			page.setTotalPage(postCount / page.getPageSize());

			// 나머지가 있으면 else 로빠지고 1을 더해준다, 페이지가 하나 더 있어야하기 때문
		} else {
			page.setTotalPage((postCount / page.getPageSize()) + 1);
		}

		// 현제 내가 있는 페이지 블럭을 계산해준다
		if (page.getCurrentPage() % page.getBlockSize() == 0) {
			page.setCurrentBlock(page.getCurrentPage() / page.getBlockSize());
			// 나머지가 있으면 else 로빠지고 1을 더해준다, 위와 똑같이 블럭이 하나 있어야하기때문에
		} else {
			page.setCurrentBlock((page.getCurrentPage() / page.getBlockSize()) + 1);
		}
		// 지금 내가 있는 블럭에서 블럭사이즈만큼 곱하면 시작해야하는 숫자가 된다
		// 시작하는 숫자이고 페이지 시작을 1부터 하기때문에 0으로 만들어주어야한다
		page.setStartPage(((page.getCurrentBlock() - 1) * page.getBlockSize()) + 1);

		// 끝나는 숫자를 지정해주어야 하는데 전체 페이지 숫자가 끝나는숫자보다 작을때가 있을수 있기에
		// if 문으로 설정해준다.
		int EndPage = page.getCurrentBlock() * page.getBlockSize();
		if (EndPage >= page.getTotalPage()) {
			page.setEndPage(page.getTotalPage());
		} else {
			page.setEndPage(EndPage);
		}
		page.setStartPost((page.getCurrentPage() - 1) * page.getPageSize());

		return page;

	}

	public int pageBlock(PageDto pageBlock) {

		int currentPage = 0;
		if (pageBlock.getBlock().equals("pageDown")) {
			int currentBlock = pageBlock.getCurrentBlock() - 1;
			currentPage = (currentBlock * pageBlock.getBlockSize());
			if (currentPage <= 1) {
				currentPage = 1;
			}

		} else if (pageBlock.getBlock().equals("pageUp")) {
			currentPage = (pageBlock.getCurrentBlock() * pageBlock.getBlockSize()) + 1;
			if (currentPage >= pageBlock.getTotalPage()) {
				currentPage = pageBlock.getTotalPage();
			}
		}
		return currentPage;
	}
}
