package com.t99sdevelopment.jcli.dummysubpackage;

import com.t99sdevelopment.jcli.dummysubpackage.util.TextStylizer;

public class ConsoleManager {
	
	private static boolean debug = false; // TODO - Make the debug bool Interface specific.
	
	/**
	 * Used to print the standard prompt to the console.
	 *
	 * @param i The Interface for which a prompt will be printed.
	 */
	public static void printPrompt(Interface i) {
		
		System.out.print(LineType.PROMPT.useLineType(i.getName()));
		
	}
	
	/**
	 * Used to print standard text to the console.
	 *
	 * @param message The message to be printed.
	 */
	public static void printNormal(String message) {
		
		System.out.print(LineType.NORMAL.useLineType(message));
		
	}
	
	/**
	 * Used to print requested or important info to the console.
	 *
	 * @param message The message to be printed.
	 */
	public static void printInfo(String message) {
		
		System.out.print(LineType.INFO.useLineType(message));
		
	}
	
	/**
	 * Used to print to the toggleable debug stream of info.
	 * Any info printed here should be non-essential, mainly to be used for -- you guessed it -- debugging.
	 *
	 * @param message The message to be printed.
	 */
	public static void printDebug(String message) {
		
		if (debug) System.out.print(LineType.INFO.useLineType(message));
		
	}
	
	/**
	 * Used to print information that informs the user of possible issues that have not yet caused consequences within
	 * the program. This message type is not intended for failures or exception-level issues.
	 *
	 * @param message The message to be printed.
	 */
	public static void printWarn(String message) {
		
		System.out.print(LineType.WARN.useLineType(message));
		
	}
	
	/**
	 * Used to print information that informs the user of failures and consequential issues that have arisen, whether it
	 * be from the user's actions or otherwise.
	 *
	 * @param message The message to be printed.
	 */
	public static void printError(String message) {
		
		System.out.print(LineType.ERROR.useLineType(message));
		
	}
	
	public static boolean toggleDebug() {
		
		return debug = !debug;
		
	}
	
	public static void setDebug(boolean debug) {
		
		ConsoleManager.debug = debug;
		
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
			this.preText = formatPreText(preText);
			this.postText = posttext;
			
		}
		
		public String useLineType(String message) {
			
			return preText + TextStylizer.getStylizedText(message, attribute, color) + postText;
			
		}
		
		private String formatPreText(String preText) {
			
			if (!preText.equals("")) {
				
				return TextStylizer.getStylizedText(preText, TextStylizer.Attribute.BOLD, color.getIntensityShiftedVersion());
				
			} else return "";
			
			
			
		}
		
	}

}
