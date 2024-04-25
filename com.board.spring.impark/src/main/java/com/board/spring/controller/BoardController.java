package com.board.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.spring.dto.PageDto;
import com.board.spring.dto.PostDto;
import com.board.spring.service.PostService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

	@Log4j
	@RequestMapping("/board/*")
	@Controller
	public class BoardController{

		
		@Setter(onMethod_ = @Autowired)
		private PostService service;
		
		@GetMapping("/list")
		public String postlist(PageDto currentPage,Model model) {
			PageDto page = service.page(currentPage);
			model.addAttribute("list",service.postList(page));
			model.addAttribute("page",page);
			return"/post/list";
		}
		
		@GetMapping("/reading")
		public String reading(@RequestParam("postNumber")String postNumber,Model model) {
			service.postReading(postNumber);
			return "redirect:/board/read?postNumber=" + postNumber;
			
		}
		
		@GetMapping("/read")
		public String postRead(@RequestParam("postNumber")String postNumber,Model model) { 
			model.addAttribute("postInfo",service.postInfo(postNumber));
			return "/post/read";
		}
		
		@GetMapping("/modify")
		public String modifyPage(@RequestParam("postNumber")String postNumber,Model model) { 
			model.addAttribute("postInfo",service.postInfo(postNumber));
			return "/post/modify";
		}
		
		@PostMapping("/modify")
		public String postModify(PostDto postModify) {
		
			service.postModify(postModify);
			return"redirect:/board/read?postNumber="+postModify.getPostNumber();
		}
		
		@GetMapping("/del")
		public String postDel(@RequestParam("postNumber")String postNumber) {
			service.postDel(postNumber);
			return"redirect:/board/list";
		}
		
		@PostMapping("/write")
		public String postWrite(PostDto postWrite,HttpServletRequest request) {
			HttpSession session = request.getSession();
			postWrite.setUserNumber(Integer.parseInt((String) session.getAttribute("LoginUserNo")));
			service.postWrite(postWrite);
			return"redirect:/board/list";
		}
		@GetMapping("/write")
		public String postWritePage() {
			return "/post/write";
		}
		
		
		@GetMapping("/pageBlock")
		public String pageBlock(PageDto pageBlock) {
			return "redirect:/board/list?currentPage=" + service.pageBlock(pageBlock)+"&postSearch="+pageBlock.getPostSearch()+"&listInTurn="+pageBlock.isListInTurn();
		}
		
}
