package com.board.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.spring.dto.LoginDto;
import com.board.spring.mapper.LoginMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
@Log4j
@Service
public class LoginServiceImpl implements LoginService {
	
	@Setter(onMethod_ = @Autowired)
	private LoginMapper mapper;
	private String nextPage;
	@Override
	public String signUp(LoginDto signUp) {	
		
		if(mapper.signUpCheck(signUp) == 0 && signUp.getUserID().length() > 3)	{
			signUp.setUserTag(mapper.signUpNameTag(signUp)+1);
			mapper.signUp(signUp);
			nextPage = String.format("redirect:/join/login");
		}else {
			nextPage = String.format("redirect:/join/signUp?mag=fail");
		}
		return nextPage;
	}

	public String login(LoginDto login) {
		
		if(mapper.loginCheck(login) == 1) {
			int userNo = mapper.login(login);
			nextPage = String.format("redirect:/join/loginEnd?userNo="+userNo);
		} else {
			nextPage = String.format("redirect:/join/login?mag=fail");
		}
		return nextPage;
	}
	
	public LoginDto signUpMag(LoginDto mag) {
		if(mag.getMag().equals("fail")) {
			mag.setMag("회원가입에 실패하였습니다.");
		}
		return mag;
	}
	
	public LoginDto loginMag(LoginDto mag) {
		if(mag.getMag().equals("fail")) {
			mag.setMag("로그인에 실패하였습니다.");
		}
		return mag;
	}

}
