/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 11:07 PM -- September 04th, 2018.
 * Classpath: io.trevorsears.code.java.jcli.output.OutputContainer
 */

package io.trevorsears.code.java.jcli.output;

import io.trevorsears.code.java.jcli.JCLI;
import io.trevorsears.code.java.jcli.exceptions.runtime.ParentlessOutputContainerException;

import java.util.Collection;
import java.util.HashMap;

public class OutputContainer extends OutputNode {
	
	private HashMap<String, OutputNode> outputNodeMap;
	
	protected OutputContainer(OutputContainer parent, String name, boolean enabled) {
		
		super(parent, name, enabled);
		if (parent == null) throw new ParentlessOutputContainerException();
		outputNodeMap = new HashMap<>();
	
	}
	
	private OutputContainer() {
		
		super(null, "JCLI", true);
		
	}
	
	public static OutputContainer getRootContainer(JCLI jcli) {
	
		return new OutputContainer();
	
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
	
	public boolean removeOutput(String name) {
		
		if (outputNodeMap.containsKey(name) && outputNodeMap.get(name) instanceof Output) {
			
			outputNodeMap.remove(name);
			return true;
			
		} else return false;
		
	}
	
	public boolean removeOutputContainer(String name) {
		
		if (outputNodeMap.containsKey(name) && outputNodeMap.get(name) instanceof OutputContainer) {
			
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
	
	public Output getOutput(String name) {
		
		if (outputNodeMap.containsKey(name) && outputNodeMap.get(name) instanceof Output) {
			
			return (Output) outputNodeMap.get(name);
			
		} else return null;
		
	}
	
	public OutputContainer getOutputContainer(String name) {
		
		if (outputNodeMap.containsKey(name) && outputNodeMap.get(name) instanceof OutputContainer) {
			
			return (OutputContainer) outputNodeMap.get(name);
			
		} else return null;
		
	}
	
	public Collection<OutputNode> getChildren() {
		
		return outputNodeMap.values();
		
	}
	
}