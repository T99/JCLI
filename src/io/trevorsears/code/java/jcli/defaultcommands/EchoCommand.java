/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 6:51 PM -- September 06th, 2018.
 * Classpath: io.trevorsears.code.java.jcli.defaultcommands.EchoCommand
 */

package io.trevorsears.code.java.jcli.defaultcommands;

import io.trevorsears.code.java.jcli.commands.Command;
import io.trevorsears.code.java.jcli.commands.CommandInput;
import io.trevorsears.code.java.jcli.commands.Flag;
import io.trevorsears.code.java.jcli.output.Output;
import io.trevorsears.code.java.jcli.output.OutputObject;

public class EchoCommand implements Command {
	
	private static final String NAME = "echo";
	private static Output output;
	
	@Override
	public String getName() {
		
		return NAME;
		
	}
	
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
		
		if (output == null) {
		
		
		
		}
		
//		OutputObject oo = new OutputObject(commandInput.getGeneralInput())
//		output.write();
		
		return false;
		
	}
	
}