package com.school.exceptionhandling;

public class StudentNotFoundByNameException extends RuntimeException {
	
	private String msg;
	

	public StudentNotFoundByNameException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	

}
