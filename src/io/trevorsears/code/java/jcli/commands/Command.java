/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 3:31 PM -- August 31st, 2018.
 * Classpath: io.trevorsears.code.java.jcli.commands.Command
 */

package io.trevorsears.code.java.jcli.commands;

public interface Command extends CommandMethod, Helpable {
	
	String getName();
	
	Flag[] getRelevantFlags();
	
}