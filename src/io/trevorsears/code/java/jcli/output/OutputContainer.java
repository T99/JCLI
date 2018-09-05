/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 11:07 PM -- September 04th, 2018.
 * Classpath: io.trevorsears.code.java.jcli.output.OutputContainer
 */

package io.trevorsears.code.java.jcli.output;

import java.util.HashMap;

public class OutputContainer extends OutputNode {
	
	private HashMap<String, OutputNode> outputNodeMap;
	
	protected OutputContainer(OutputContainer parent, String name, boolean enabled) {
		
		super(parent, name, enabled);
		outputNodeMap = new HashMap<>();
	
	}
	
	public boolean addOutput(String name) {
		
		return addOutput(name, true);
		
	}
	
	public boolean addOutput(String name, boolean enabled) {
		
		if (!outputNodeMap.containsKey(name)) {
			
			outputNodeMap.put(name, new Output(this, name, enabled));
			return true;
			
		} else return false;
		
	}
	
	public boolean addOutputContainer(String name) {
		
		return addOutputContainer(name, true);
		
	}
	
	public boolean addOutputContainer(String name, boolean enabled) {
		
		if (!outputNodeMap.containsKey(name)) {
			
			outputNodeMap.put(name, new OutputContainer(this, name, enabled));
			return true;
			
		} else return false;
		
	}
	
	public boolean removeOutputNode(String name) {
		
		if (outputNodeMap.containsKey(name)) {
			
			outputNodeMap.remove(name);
			return true;
			
		} else return false;
		
	}
	
	protected boolean renameOutputNode(String oldName, String newName) {
		
		if (!outputNodeMap.containsKey(newName)) {
			
			OutputNode node = outputNodeMap.get(oldName);
			outputNodeMap.remove(oldName);
			outputNodeMap.put(newName, node);
			return true;
			
		} else return false;
		
	}
	
}