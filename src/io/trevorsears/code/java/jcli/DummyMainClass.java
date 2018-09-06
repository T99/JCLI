/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 5:55 PM -- September 01st, 2018.
 * Classpath: io.trevorsears.code.java.jcli.DummyMainClass
 */

package io.trevorsears.code.java.jcli;

import io.trevorsears.code.java.jcli.commands.CommandInput;
import io.trevorsears.code.java.jcli.commands.Flag;
import io.trevorsears.code.java.jcli.output.OutputObject;
import io.trevorsears.code.java.jcli.output.formatting.Color;
import io.trevorsears.code.java.jcli.output.formatting.LinuxOutputFormatter;
import io.trevorsears.code.java.jcli.output.formatting.OutputFormatter;

public class DummyMainClass {
	
	public static void main(String... args) {
		
//		JCLI.initializeInstance(true);
//		JCLI jcli = JCLI.getInstance();
		
		OutputObject oo = new OutputObject("Hello there!", Color.RED);
		System.out.println(oo.toString());
		
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
	
	public static void formattingTest() {
		
		OutputFormatter of;
		
		
		LinuxOutputFormatter lof = new LinuxOutputFormatter();
		
		System.out.println(lof.getFormattedText("Black", Color.BLACK));
		System.out.println(lof.getFormattedText("White", Color.WHITE));
		System.out.println(lof.getFormattedText("Red", Color.RED));
		System.out.println(lof.getFormattedText("Orange", Color.ORANGE));
		System.out.println(lof.getFormattedText("Yellow", Color.YELLOW));
		System.out.println(lof.getFormattedText("Green", Color.GREEN));
		System.out.println(lof.getFormattedText("Blue", Color.BLUE));
		System.out.println(lof.getFormattedText("Violet", Color.VIOLET));
		System.out.println();
		System.out.println(lof.getFormattedText("Black", Color.WHITE, Color.BLACK));
		System.out.println(lof.getFormattedText("White", Color.WHITE, Color.WHITE));
		System.out.println(lof.getFormattedText("Red", Color.WHITE, Color.RED));
		System.out.println(lof.getFormattedText("Orange", Color.WHITE, Color.ORANGE));
		System.out.println(lof.getFormattedText("Yellow", Color.WHITE, Color.YELLOW));
		System.out.println(lof.getFormattedText("Green", Color.WHITE, Color.GREEN));
		System.out.println(lof.getFormattedText("Blue", Color.WHITE, Color.BLUE));
		System.out.println(lof.getFormattedText("Violet", Color.WHITE, Color.VIOLET));
		System.out.println();
		System.out.println(lof.getFormattedText(" Indigo with Violet Background ", Color.BLUE, Color.VIOLET));
		
	}
	
}