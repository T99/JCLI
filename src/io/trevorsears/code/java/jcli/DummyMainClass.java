/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 5:55 PM -- September 01st, 2018.
 * Classpath: io.trevorsears.code.java.jcli.DummyMainClass
 */

package io.trevorsears.code.java.jcli;

import io.trevorsears.code.java.jcli.commands.CommandInput;
import io.trevorsears.code.java.jcli.commands.Flag;
import io.trevorsears.code.java.jcli.exceptions.MalformedInputException;
import io.trevorsears.code.java.jcli.input.CharacterNode;
import io.trevorsears.code.java.jcli.input.StringTokenizer;
import io.trevorsears.code.java.jcli.output.OutputObject;
import io.trevorsears.code.java.jcli.output.formatting.Color;
import io.trevorsears.code.java.jcli.output.formatting.Decoration;

import java.util.ArrayList;
import java.util.Scanner;

public class DummyMainClass {
	
	public static void main(String... args) {
	
//		JCLI.initializeInstance(true);
//		JCLI jcli = JCLI.getInstance();
	
		while (true) {
			
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("> ");
			
			try {
				
				ArrayList<String> output = StringTokenizer.tokenize(scanner.nextLine());
				
				for (String string: output) {
					
					System.out.println(string);
					
				}
				
			} catch (MalformedInputException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
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
		
		System.out.println(new OutputObject(" FG: BLACK\tBG: NORMAL", Color.BLACK));
		System.out.println(new OutputObject(" FG: WHITE\tBG: NORMAL", Color.WHITE));
		System.out.println(new OutputObject(" FG: RED\tBG: NORMAL", Color.RED));
		System.out.println(new OutputObject(" FG: ORANGE\tBG: NORMAL", Color.ORANGE));
		System.out.println(new OutputObject(" FG: YELLOW\tBG: NORMAL", Color.YELLOW));
		System.out.println(new OutputObject(" FG: GREEN\tBG: NORMAL", Color.GREEN));
		System.out.println(new OutputObject(" FG: BLUE\tBG: NORMAL", Color.BLUE));
		System.out.println(new OutputObject(" FG: VIOLET\tBG: NORMAL", Color.VIOLET));
		System.out.println();
		System.out.println(new OutputObject(" FG: WHITE\tBG: BLACK ", Color.WHITE, Color.BLACK));
		System.out.println(new OutputObject(" FG: BLACK\tBG: WHITE ", Color.BLACK, Color.WHITE));
		System.out.println(new OutputObject(" FG: WHITE\tBG: RED ", Color.WHITE, Color.RED));
		System.out.println(new OutputObject(" FG: WHITE\tBG: ORANGE ", Color.WHITE, Color.ORANGE));
		System.out.println(new OutputObject(" FG: BLACK\tBG: YELLOW ", Color.BLACK, Color.YELLOW));
		System.out.println(new OutputObject(" FG: WHITE\tBG: GREEN ", Color.WHITE, Color.GREEN));
		System.out.println(new OutputObject(" FG: WHITE\tBG: BLUE ", Color.WHITE, Color.BLUE));
		System.out.println(new OutputObject(" FG: WHITE\tBG: VIOLET ", Color.WHITE, Color.VIOLET));
		System.out.println();
		System.out.println(new OutputObject("Bold", Decoration.BOLD));
		System.out.println(new OutputObject("Dim", Decoration.DIM));
		System.out.println(new OutputObject("Underlined", Decoration.UNDERLINED));
		System.out.println(new OutputObject("Blink", Decoration.BLINK));
		System.out.println(new OutputObject("Reverse", Decoration.REVERSE));
		System.out.println(new OutputObject("Hidden", Decoration.HIDDEN));
		
	}
	
}