/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 5:30 PM -- September 01st, 2018.
 * Classpath: io.trevorsears.code.java.jcli.defaultcommands.ClearCommand
 */

package io.trevorsears.code.java.jcli.defaultcommands;

import io.trevorsears.code.java.jcli.commands.Command;
import io.trevorsears.code.java.jcli.commands.CommandInput;
import io.trevorsears.code.java.jcli.commands.Flag;
import io.trevorsears.code.java.jcli.commands.Helpable;

public class ClearCommand implements Command, Helpable {
	
	@Override
	public Flag[] getRelevantFlags() {
		
		return new Flag[0];
		
	}
	
	@Override
	public String getHelpText() {
		
		return null;
		
	}
	
	@Override
	public boolean run(CommandInput commandInput) {
		
		return false;
		
	}
	
}