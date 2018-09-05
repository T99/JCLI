/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 5:34 PM -- September 03rd, 2018.
 * Classpath: io.trevorsears.code.java.jcli.output.OutputNode
 */

package io.trevorsears.code.java.jcli.output;

public interface OutputNode {
	
	void enable();
	
	void disable();
	
	boolean setName(String name);
	
	String getName();
	
	OutputContainer getParent();
	
}