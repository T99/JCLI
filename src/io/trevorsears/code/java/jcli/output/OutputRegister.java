/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 5:32 PM -- September 03rd, 2018.
 * Classpath: io.trevorsears.code.java.jcli.output.OutputRegister
 */

package io.trevorsears.code.java.jcli.output;

import java.util.HashMap;

public class OutputRegister implements OutputContainer {
	
	// TODO - Oh boy, this all needs rewriting.
	
	private static OutputRegister instance;
	
	private HashMap<String, OutputNode> outputNodeMap = new HashMap<>();
	
	public static OutputRegister getInstance() {
		
		if (instance == null) instance = new OutputRegister();
		return instance;
		
	}
	
	@Override
	public boolean addOutput(String name, boolean enabled) {
		
		if (!outputNodeMap.containsKey(name)) {
			
			outputNodeMap.put(name, new Output(this, name, enabled));
			return true;
			
		} else return false;
		
	}
	
	@Override
	public boolean addOutputChannel(String name, boolean enabled) {
		
		return false;
		
	}
	
	@Override
	public boolean removeOutputNode(String name) {
		
		if (outputNodeMap.containsKey(name)) {
			
			outputNodeMap.remove(name);
			return true;
			
		} else return false;
		
	}
	
	@Override
	public boolean renameOutputNode(String originalName, String newName) {
		
		if (outputNodeMap.containsKey(originalName)) {
			
			OutputNode node = outputNodeMap.get(originalName);
			outputNodeMap.remove(originalName);
			outputNodeMap.put(newName, node);
			return true;
			
		} else return false;
		
	}
	
	@Override
	public boolean hasOutputNode(String name) {
		
		return outputNodeMap.containsKey(name);
		
	}
	
	@Override
	public OutputNode getOutputNode(String name) {
		
		return outputNodeMap.get(name);
		
	}
	
	@Override
	public void enableRecursively() {
		
		for (OutputNode node: outputNodeMap.values()) {
			
			if (node instanceof OutputContainer) ((OutputContainer) node).enableRecursively();
			else node.enable();
			
		}
		
	}
	
	@Override
	public void disableRecursively() {
		
		for (OutputNode node: outputNodeMap.values()) {
			
			if (node instanceof OutputContainer) ((OutputContainer) node).disableRecursively();
			else node.disable();
			
		}
		
	}
	
	@Override
	public boolean isRootContainer() { return true; }
	
}