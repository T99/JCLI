package com.t99sdevelopment.jcli.dummysubpackage;

import com.t99sdevelopment.jcli.dummysubpackage.util.EnvironmentHelper;
import com.t99sdevelopment.jcli.dummysubpackage.util.TextStylizer;

public class PrintManager {
	
	private static boolean debug = false; // TODO - Make the debug bool Interface specific.
	private static boolean isOnNewLine = true;
	
	/**
	 * Used to print the standard prompt to the console.
	 *
	 * @param i The Interface for which a prompt will be printed.
	 */
	public static void printPrompt(Interface i) {
		
		print(i.getName(), LineType.PROMPT);
		
	}
	
	/**
	 * Used to print standard text to the console.
	 *
	 * @param message The message to be printed.
	 */
	public static void printNormal(String message) {
		
		print(message, LineType.NORMAL);
		
	}
	
	/**
	 * Used to print requested or important info to the console.
	 *
	 * @param message The message to be printed.
	 */
	public static void printInfo(String message) {
		
		print(message, LineType.INFO);
		
	}
	
	/**
	 * Used to print to the toggleable debug stream of info.
	 * Any info printed here should be non-essential, mainly to be used for -- you guessed it -- debugging.
	 *
	 * @param message The message to be printed.
	 */
	public static void printDebug(String message) {
		
		if (debug) print(message, LineType.DEBUG);
		
	}
	
	/**
	 * Used to print information that informs the user of possible issues that have not yet caused consequences within
	 * the program. This message type is not intended for failures or exception-level issues.
	 *
	 * @param message The message to be printed.
	 */
	public static void printWarn(String message) {
		
		print(message, LineType.WARN);
		
	}
	
	/**
	 * Used to print information that informs the user of failures and consequential issues that have arisen, whether it
	 * be from the user's actions or otherwise.
	 *
	 * @param message The message to be printed.
	 */
	public static void printError(String message) {
		
		print(message, LineType.ERROR);
		
	}
	
	private static void print(String message, LineType lineType) {
		
		ensureNewLine();
		
		if (EnvironmentHelper.getEnvironment() == EnvironmentHelper.Environment.LINUX) {
			
			System.out.print(lineType.use(message));
			
		} else {
			
			System.out.print(lineType.useWithoutStylization(message));
			
		}
		
		isOnNewLine = lineType.doesEndLine();
		
	}
	
	public static void confirmNewLine() {
		
		isOnNewLine = true;
		
	}
	
	private static void ensureNewLine() {
		
		if (!isOnNewLine) {
			
			System.out.print(System.lineSeparator());
			isOnNewLine = true;
			
		}
		
	}
	
	public static void toggleDebug() {
		
		setDebug(!debug);
		
	}
	
	public static void setDebug(boolean debug) {
		
		if (PrintManager.debug == debug) {
			
			PrintManager.printInfo("Debug output is already " + ((debug) ? "on" : "off") + ".");
			
		} else  {
			
			if (debug) {
				
				PrintManager.debug = debug;
				PrintManager.printDebug("Debug output is now on.");
				
			} else {
				
				PrintManager.printDebug("Debug output is now off.");
				PrintManager.debug = debug;
				
			}
			
			
		
		}
		
		
	}
	
	private enum LineType {

		PROMPT	(TextStylizer.Attribute.NORMAL,
				TextStylizer.Color.BLACK,
				"",
				" ~> "),
		
		NORMAL	(TextStylizer.Attribute.NORMAL,
				TextStylizer.Color.BLACK,
				"",
				System.lineSeparator()),
		
		INFO	(TextStylizer.Attribute.NORMAL,
				TextStylizer.Color.BLUE,
				"[INFO] ",
				System.lineSeparator()),
		
		DEBUG	(TextStylizer.Attribute.NORMAL,
				TextStylizer.Color.PURPLE,
				"[DEBUG] ",
				System.lineSeparator()),
		
		WARN	(TextStylizer.Attribute.NORMAL,
				TextStylizer.Color.YELLOW,
				"[WARN] ",
				System.lineSeparator()),
		
		ERROR	(TextStylizer.Attribute.NORMAL,
				TextStylizer.Color.HIRED,
				"[ERROR] ",
				System.lineSeparator());
		
		private final TextStylizer.Attribute attribute;
		private final TextStylizer.Color color;
		private final String preText;
		private final String postText;
		
		LineType(TextStylizer.Attribute attribute, TextStylizer.Color color, String preText, String posttext){
			
			this.attribute = attribute;
			this.color = color;
			this.preText = preText;
			this.postText = posttext;
			
		}
		
		private String use(String message) {
			
			return formatPreText(preText) + TextStylizer.getStylizedText(message, attribute, color) + postText;
			
		}
		
		private String useWithoutStylization(String message) {
			
			return preText + message + postText;
			
		}
		
		private boolean doesEndLine() {
			
			return postText.equals(System.lineSeparator());
			
		}
		
		private String formatPreText(String preText) {
			
			if (!preText.equals("")) {
				
				return TextStylizer.getStylizedText(preText, TextStylizer.Attribute.BOLD, color.getIntensityShiftedVersion());
				
			} else return "";
			
			
			
		}
		
	}

}
