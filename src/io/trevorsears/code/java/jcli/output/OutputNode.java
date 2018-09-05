/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 10:59 PM -- September 04th, 2018.
 * Classpath: io.trevorsears.code.java.jcli.output.OutputNode
 */

package io.trevorsears.code.java.jcli.output;

public class OutputNode {
	
	private String name;
	private boolean enabled;
	private OutputContainer parent;
	
	protected OutputNode(OutputContainer parent, String name, boolean enabled) {
		
		this.name = name;
		this.parent = parent;
		this.enabled = enabled;
		
	}
	
	public void enable() {
		
		enabled = true;
	
	}
	
	public void disable() {
		
		enabled = false;
	
	}
	
	public boolean isEnabled() {
		
		return enabled;
		
	}
	
	public boolean setName(String newName) {
		
		if (parent.renameOutputNode(this.name, newName)) {
			
			name = newName;
			return true;
			
		} else return false;
		
	}
	
	public String getName() {
		
		return name;
	
	}
	
	public OutputContainer getParent() {
		
		if (parent != null) return parent;
		else return null;
		
	}
	
}