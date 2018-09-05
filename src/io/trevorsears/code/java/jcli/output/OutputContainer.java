/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 6:15 PM -- September 03rd, 2018.
 * Classpath: io.trevorsears.code.java.jcli.output.OutputContainer
 */

package io.trevorsears.code.java.jcli.output;

public interface OutputContainer {
	
	boolean addOutput(String name, boolean enabled);
	
	boolean addOutputChannel(String name, boolean enabled);
	
	boolean removeOutputNode(String name);
	
	boolean renameOutputNode(String originalName, String newName);
	
	boolean hasOutputNode(String name);
	
	OutputNode getOutputNode(String name);
	
	void enableRecursively();
	
	void disableRecursively();
	
	default boolean isRootContainer() { return false; }
	
}
