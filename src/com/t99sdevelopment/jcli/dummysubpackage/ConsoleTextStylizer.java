package com.t99sdevelopment.jcli.dummysubpackage;

public class ConsoleTextStylizer {
	
	public static String getStylizedText(String string, Color color) {
		
		return Attribute.NORMAL.getAttributeCode() + color.getColorCode() + string + getResetCode();
		
	}
	
	public static String getStylizedText(String string, Attribute attribute, Color color) {
		
		return attribute.getAttributeCode() + color.getColorCode() + string + getResetCode();
		
	}
	
	private static String getResetCode() {
		
		return "\033[0m";
		
	}
	
	public enum Attribute {

		NORMAL		("\033[0;"),
		BOLD		("\033[1;"),
		UNDERLINE	("\033[4;");

		private final String attributeCode;

		Attribute(String attributeCode) {

			this.attributeCode = attributeCode;

		}

		String getAttributeCode() {

			return attributeCode;

		}

	}
	
	public enum Color {
		
		BLACK		("30m"),
		RED			("31m"),
		GREEN		("32m"),
		YELLOW		("33m"),
		BLUE		("34m"),
		PURPLE		("35m"),
		CYAN		("36m"),
		WHITE		("37m"),
		HIBLACK		("90m"),
		HIRED		("91m"),
		HIGREEN		("92m"),
		HIYELLOW	("93m"),
		HIBLUE		("94m"),
		HIPURPLE	("95m"),
		HICYAN		("96m"),
		HIWHITE		("97m");
		
		private final String colorCode;
		
		Color(String colorCode) {
			
			this.colorCode = colorCode;
			
		}
		
		String getColorCode() {
			
			return colorCode;
			
		}
		
		Color getIntensityShiftedVersion() {
			
			return getIntesityShiftedVersion(this);
			
		}
		
		static Color getIntesityShiftedVersion(Color color) {
			
			switch (color) {
				
				case BLACK:
					return HIBLACK;
				
				case RED:
					return HIRED;
				
				case GREEN:
					return HIGREEN;
				
				case YELLOW:
					return HIYELLOW;
				
				case BLUE:
					return HIBLUE;
				
				case PURPLE:
					return HIPURPLE;
				
				case CYAN:
					return HICYAN;
				
				case WHITE:
					return HIWHITE;
				
				case HIBLACK:
					return BLACK;
				
				case HIRED:
					return RED;
				
				case HIGREEN:
					return GREEN;
				
				case HIYELLOW:
					return YELLOW;
				
				case HIBLUE:
					return BLUE;
				
				case HIPURPLE:
					return PURPLE;
				
				case HICYAN:
					return CYAN;
				
				case HIWHITE:
					return WHITE;
					
				default:
					throw new IllegalArgumentException("That color doesn't exist -- I don't know how you did this.");
					
			}
			
		}
		
	}
	
}