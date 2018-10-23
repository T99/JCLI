/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 3:22 PM -- August 31st, 2018.
 * Classpath: io.trevorsears.code.java.jcli.commands.CommandMethod
 */

package io.trevorsears.code.java.jcli.commands;

public interface CommandMethod {
	
	public boolean run(CommandInput commandInput);
	
}