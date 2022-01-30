package com.school.utils;

public interface IConstants {
	public String MSG_SYSTEM_ERROR = "System Error! Please try later";
	public String MSG_SUCCESS = "Success";

	public Integer MAX_ROLE_ID = 2;

	public String REG_GENERAL_NAME = "^.{1,100}";
	
	public String PATTERN_DATE = "dd-MM-yyyy";
	public String PATTERN_DATE_TIME = "dd-MM-yyyy HH:mm:ss";
	
	public int MAX_LENGTH_DESCRIPTION = 4000;
	public int MIN_LENGTH_DESCRIPTION = 10;
	public int MAX_LENGTH_ADDRESS = 255;
	
	public String ERR_MSG_NOT_FOUND = "Not found : ";
	public String ERR_MSG_BAD_REQUEST = "Invalid : ";
	
	public int MAX_LENGTH_NAME = 100;
	public int MAX_LENGTH_ROLL_NO = 3;
	public String REG_MOBILE_NO = "\\d{9,13}";
	
	
}
