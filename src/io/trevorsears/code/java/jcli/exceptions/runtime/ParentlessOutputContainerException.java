/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 3:33 PM -- September 06th, 2018.
 * Classpath: io.trevorsears.code.java.jcli.exceptions.runtime.ParentlessOutputContainerException
 */

package io.trevorsears.code.java.jcli.exceptions.runtime;

public class ParentlessOutputContainerException extends RuntimeException {
	
	public ParentlessOutputContainerException() {
		
		super("Cannot create a parentless OutputContainer (an OutputContainer where the parent is null).");
		
	}
	
}