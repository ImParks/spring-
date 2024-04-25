package com.board.spring.service;

import com.board.spring.dto.LoginDto;

public interface LoginService {
	
	
	public String signUp(LoginDto signUp);
	public String login(LoginDto login);
	public LoginDto signUpMag(LoginDto mag);
	public LoginDto loginMag(LoginDto mag);

}
