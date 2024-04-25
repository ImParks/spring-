package com.board.spring.dto;

import lombok.Data;

@Data
public class LoginDto {

private String mag = "환영합니다.";

private String userNumber;
private String userID = "";
private String userPW = "";
private String userName;
private int userTag;
private int check;

}
