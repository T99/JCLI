package com.t99sdevelopment.jcli.dummysubpackage;

public class ConsoleManager {
	
	private static boolean debug = true;
	
	public static void printPrompt(Interface i) {
		
		System.out.print(LineType.PROMPT.useLineType(i.getName()));
		
	}
	
	public static void printNormal(String message) {
		
		System.out.print(LineType.NORMAL.useLineType(message));
		
	}
	
	public static void printInfo(String message) {
		
		System.out.print(LineType.INFO.useLineType(message));
		
	}
	
	public static void printDebug(String message) {
		
		if (debug) System.out.print(LineType.INFO.useLineType(message));
		
	}
	
	public static void printWarn(String message) {
		
		System.out.print(LineType.WARN.useLineType(message));
		
	}
	
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

		PROMPT	(ConsoleTextStylizer.Attribute.NORMAL,
				ConsoleTextStylizer.Color.BLACK,
				"",
				" ~> "),
		
		NORMAL	(ConsoleTextStylizer.Attribute.NORMAL,
				ConsoleTextStylizer.Color.BLACK,
				"",
				System.lineSeparator()),
		
		INFO	(ConsoleTextStylizer.Attribute.NORMAL,
				ConsoleTextStylizer.Color.BLUE,
				"[INFO] ",
				System.lineSeparator()),
		
		DEBUG	(ConsoleTextStylizer.Attribute.NORMAL,
				ConsoleTextStylizer.Color.PURPLE,
				"[DEBUG] ",
				System.lineSeparator()),
		
		WARN	(ConsoleTextStylizer.Attribute.NORMAL,
				ConsoleTextStylizer.Color.YELLOW,
				"[WARN] ",
				System.lineSeparator()),
		
		ERROR	(ConsoleTextStylizer.Attribute.NORMAL,
				ConsoleTextStylizer.Color.HIRED,
				"[ERROR] ",
				System.lineSeparator());
		
		private final ConsoleTextStylizer.Attribute attribute;
		private final ConsoleTextStylizer.Color color;
		private final String preText;
		private final String postText;
		
		LineType(ConsoleTextStylizer.Attribute attribute, ConsoleTextStylizer.Color color, String preText, String posttext){
			
			this.attribute = attribute;
			this.color = color;
			this.preText = formatPreText(preText);
			this.postText = posttext;
			
		}
		
		public String useLineType(String message) {
			
			return preText + ConsoleTextStylizer.getStylizedText(message, attribute, color) + postText;
			
		}
		
		private String formatPreText(String preText) {
			
			if (!preText.equals("")) {
				
				return ConsoleTextStylizer.getStylizedText(preText, ConsoleTextStylizer.Attribute.BOLD, color.getIntensityShiftedVersion());
				
			} else return "";
			
			
			
		}
		
	}

}
