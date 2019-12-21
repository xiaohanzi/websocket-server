package com.fm.mingwsserver.frame.exception;

public class WebsocketException extends RuntimeException {

	private static final long serialVersionUID = 7814589873099789709L;
	
	public WebsocketException(String msg) {
		super(msg);
	}
	
	public WebsocketException(String msg,Exception e) {
		super(msg,e);
	}
	
	
}
