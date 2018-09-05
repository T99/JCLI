/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 5:32 PM -- September 03rd, 2018.
 * Classpath: io.trevorsears.code.java.jcli.output.OutputChannel
 */

package io.trevorsears.code.java.jcli.output;

import java.util.HashMap;

class OutputChannel implements OutputNode, OutputContainer {
	
	private String name;
	private boolean enabled;
	private OutputContainer parent;
	private HashMap<String, OutputNode> outputNodeMap = new HashMap<>();
	
	OutputChannel(OutputContainer parent, String name, boolean enabled) {
		
		this.parent = parent;
		this.name = name;
		this.enabled = enabled;
		
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
		
		if (!outputNodeMap.containsKey(name)) {
			
			outputNodeMap.put(name, new OutputChannel(this, name, enabled));
			return true;
			
		} else return false;
		
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
		
		if (outputNodeMap.containsKey(originalName) && !outputNodeMap.containsKey(newName)) {
			
			OutputNode node = outputNodeMap.get(originalName);
			outputNodeMap.remove(originalName);
			outputNodeMap.put(newName, node);
			node.setName(newName);
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
	public void enable() { this.enabled = true; }
	
	@Override
	public void disable() { this.enabled = false; }
	
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
	public boolean setName(String name) {
		
		if (getParent().renameOutputNode(this.name, name)) {
			
			this.name = name;
			return true;
			
		} else return false;
		
	}
	
	@Override
	public String getName() { return name; }
	
	@Override
	public OutputContainer getParent() { return parent; }
	
}