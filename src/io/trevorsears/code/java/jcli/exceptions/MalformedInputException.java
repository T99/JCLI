/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 11:32 PM -- September 06th, 2018.
 * Classpath: io.trevorsears.code.java.jcli.exceptions.MalformedInputException
 */

package io.trevorsears.code.java.jcli.exceptions;

public class MalformedInputException extends Exception {
	
	public MalformedInputException() {
		
		super("JCLI recieved a malformed input.");
		
	}
	
	public MalformedInputException(String string) {
		
		super(string);
		
	}
	
}