/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 5:55 PM -- September 01st, 2018.
 * Classpath: io.trevorsears.code.java.jcli.DummyMainClass
 */

package io.trevorsears.code.java.jcli;

import io.trevorsears.code.java.jcli.commands.CommandInput;
import io.trevorsears.code.java.jcli.commands.Flag;

import java.time.LocalDate;

public class DummyMainClass {
	
	public static void main(String... args) {
		
//		JCLI.initializeInstance(true);
//		JCLI jcli = JCLI.getInstance();
	
	
		
	}
	
	public static void commandInputTest() {
		
		CommandInput ci = new CommandInput(new String[] {"arg1", "argument 2"});
		ci.addFlag(new Flag('c', "force check", "Force the command to check the directory."), "ticked");
		ci.addFlag(new Flag('n', "no force check", "Prevent the command from checking the directory."), "unticked");
		System.out.println(ci.toString());
		
	}
	
	public static void flagTest() {
		
		Flag flag = new Flag('c', "character", "Returns the character.");
		
		System.out.println("Simple flag:\t" + flag.getSimpleFlag());
		System.out.println("Extended flag:\t" + flag.getExtendedFlag());
		System.out.println("Help text:\t\t" + flag.getHelpText());
		
	}
	
}