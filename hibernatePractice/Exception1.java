package com.te.hibernatePractice;

public class Exception1 extends RuntimeException {
	private String msg;

	public Exception1(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		
		return this.msg;
	}
	
	

}