/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 5:18 PM -- September 03rd, 2018.
 * Classpath: io.trevorsears.code.java.jcli.exceptions.JCLINotInitializedException
 */

package io.trevorsears.code.java.jcli.exceptions;

public class JCLINotInitializedException extends RuntimeException {
	
	// TODO - move to runtimeexception subpackage
	
	public JCLINotInitializedException() {
		
		super("JCLI singleton instance was not initialized. Ensure #initializeInstance is called before #getInstance is ever called.");
		
	}
	
}