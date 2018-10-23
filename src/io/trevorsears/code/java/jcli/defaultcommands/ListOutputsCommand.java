/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 11:45 PM -- September 06th, 2018.
 * Classpath: io.trevorsears.code.java.jcli.defaultcommands.ListOutputsCommand
 */

package io.trevorsears.code.java.jcli.defaultcommands;

import io.trevorsears.code.java.jcli.JCLI;
import io.trevorsears.code.java.jcli.commands.Command;
import io.trevorsears.code.java.jcli.commands.CommandInput;
import io.trevorsears.code.java.jcli.commands.Flag;
import io.trevorsears.code.java.jcli.output.Output;
import io.trevorsears.code.java.jcli.output.OutputContainer;
import io.trevorsears.code.java.jcli.output.OutputNode;

import java.util.ArrayList;
import java.util.Iterator;

public class ListOutputsCommand implements Command {
	
	private Output output;
	private static final String COMMAND_NAME = "lso";
	
	private static final String VERTICAL_BAR = "│";
	private static final String HORIZONTAL_BAR = "─";
	private static final String T_BAR = "├";
	private static final String L_BAR = "└";
	
	@Override
	public String getName() {
		
		return COMMAND_NAME;
		
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
			
			output = JCLI.getInstance().getOutputRegistry().getOutputContainer("Standard Log Levels").getOutput("Stdout");
			
		}
		
		printTreeLevel(JCLI.getInstance().getOutputRegistry(), 0);
		
		return false;
		
	}
	
	public void printTreeLevel(OutputContainer parent, int level) {
		
		ArrayList<OutputContainer> containers = new ArrayList<>();
		ArrayList<Output> outputs = new ArrayList<>();
		
		for (OutputNode child : parent.getChildren()) {
			
			if (child instanceof OutputContainer) containers.add((OutputContainer) child);
			else if (child instanceof Output) outputs.add((Output) child);
			
		}
		
		for (OutputContainer outputContainers: containers) {
		
		
		
		}
		
	}
	
}