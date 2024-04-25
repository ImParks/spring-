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

import com.board.spring.dto.LoginDto;
import com.board.spring.service.LoginService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/join/*")
@Controller
public class LoginController {

	@Setter(onMethod_ = @Autowired)
	private LoginService service;

	@GetMapping("/signUp")
	public String signUp(LoginDto mag, Model model) {
		LoginDto signUp = service.signUpMag(mag);
		model.addAttribute("signUp", signUp);
		return "/member/signUp";
	}

	@PostMapping("/signUp")
	public String signUpJoin(LoginDto signUp, Model model) {
		String nextPage = service.signUp(signUp);
		return nextPage;
	}

	@GetMapping("/login")
	public String login(LoginDto mag, Model model) {
		LoginDto login = service.loginMag(mag);
		model.addAttribute("login", login);
		return "/member/login";
	}

	@PostMapping("/login")
	public String loginJoin(LoginDto login) {
		String nextPage = service.login(login);
		return nextPage;
	}

	@GetMapping("/loginEnd")
	public String loginEnd(@RequestParam("userNo") String userNo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("LoginUserNo", userNo);
		return "redirect:/board/list";
	}
}
