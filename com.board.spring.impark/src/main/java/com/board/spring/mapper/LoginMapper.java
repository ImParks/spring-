package com.board.spring.mapper;

import com.board.spring.dto.LoginDto;

public interface LoginMapper {

	public int signUpCheck(LoginDto id);
	public int signUpNameTag(LoginDto name);
	public void signUp (LoginDto signUp);
	public int loginCheck(LoginDto login);
	public int login(LoginDto login);
	
}
