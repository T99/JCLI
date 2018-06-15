package com.t99sdevelopment.jcli.dummysubpackage.exceptions;

public class CommandDoesNotExistException extends Exception {
	
	public CommandDoesNotExistException() {
		
		super();
		
	}
	
	public CommandDoesNotExistException(String s) {
		
		super(s);
		
	}
	
	public CommandDoesNotExistException(String s, Throwable throwable) {
		
		super(s, throwable);
		
	}
	
	public CommandDoesNotExistException(Throwable throwable) {
		
		super(throwable);
		
	}
	
	protected CommandDoesNotExistException(String s, Throwable throwable, boolean b, boolean b1) {
		
		super(s, throwable, b, b1);
		
	}
	
}