/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 5:52 PM -- September 03rd, 2018.
 * Classpath: io.trevorsears.code.java.jcli.output.Output
 */

package io.trevorsears.code.java.jcli.output;

class Output implements OutputNode {
	
	private OutputContainer parent;
	private String name;
	private boolean enabled;
	
	Output(OutputContainer parent, String name, boolean enabled) {
		
		this.parent = parent;
		this.name = name;
		this.enabled = enabled;
		
	}
	
	@Override
	public void enable() { enabled = true; }
	
	@Override
	public void disable() { enabled = false; }
	
	@Override
	public boolean setName(String newName) {
		
		/*
		 * For some idiotic reason, I spent nearly an hour getting bi-directional renaming to work.
		 * I realize this should not need to be this complicated, and once I finished I thought,
		 * "Hmm, I'll probably never use this.". But at that point, I'd already finished and just
		 * couldn't delete it. Don't ask me why I did it or why I kept it, I have no rational
		 * reasons, only complaints of time lost.
		 */
		
		if (this.name.equals(newName)) return true;
		else if (getParent().hasOutputNode(newName)) {
			
			if (getParent().getOutputNode(newName) == this) {
				
				this.name = newName;
				return true;
				
			} else return false;
			
		} else {
			
			if (getParent().renameOutputNode(this.name, newName)) {
				
				this.name = newName;
				return true;
				
			} else return false;
			
		}
	
	}
	
	@Override
	public String getName() { return name; }
	
	@Override
	public OutputContainer getParent() { return parent; }
	
}