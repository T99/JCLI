/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 8:43 PM -- September 01st, 2018.
 * Classpath: io.trevorsears.code.java.jcli.output.formatting.LinuxTextFormatter
 */

package io.trevorsears.code.java.jcli.output.formatting;

final class LinuxTextFormatter extends TextFormatter {
	
	String getFormattedText(String input, Foregroundable foreground) {
	
		StringBuilder formattedText = new StringBuilder();
		
		formattedText.append(foreground.getEscapeCode());
		formattedText.append(input);
		formattedText.append(ResetCodes.ALL.getEscapeCode());
		
		return formattedText.toString();
	
	}
	
	private interface Escapable {
		
		String getEscapeCode();
		
		default String formatEscapeCode(String escapeCode) {
			
			return "\\e[" + escapeCode + "m";
			
		}
		
	}
	
	private interface Foregroundable extends Escapable {}
	
	private interface Backgroundable extends Escapable {}
	
	enum EightSixteenForegroundColorCodes implements Foregroundable {
		BLACK			("30"),
		RED				("31"),
		GREEN			("32"),
		YELLOW			("33"),
		BLUE			("34"),
		MAGENTA			("35"),
		CYAN			("36"),
		LIGHTGREY		("37"),
		DARKGREY		("90"),
		LIGHTRED		("91"),
		LIGHTGREEN		("92"),
		LIGHTYELLOW		("93"),
		LIGHTBLUE		("94"),
		LIGHTMAGENTA	("95"),
		LIGHTCYAN		("96"),
		WHITE			("97");
		
		private final String escapeCode;
		
		EightSixteenForegroundColorCodes(String escapeCode) {
			
			this.escapeCode = formatEscapeCode(escapeCode);
			
		}
		
		@Override
		public String getEscapeCode() {
			
			return escapeCode;
			
		}
		
	}
	
	enum EightSixteenBackgroundColorCodes implements Backgroundable {
		BLACK			("40"),
		RED				("41"),
		GREEN			("42"),
		YELLOW			("43"),
		BLUE			("44"),
		MAGENTA			("45"),
		CYAN			("46"),
		LIGHTGREY		("47"),
		DARKGREY		("100"),
		LIGHTRED		("101"),
		LIGHTGREEN		("102"),
		LIGHTYELLOW		("103"),
		LIGHTBLUE		("104"),
		LIGHTMAGENTA	("105"),
		LIGHTCYAN		("106"),
		WHITE			("107");
		
		private final String escapeCode;
		
		EightSixteenBackgroundColorCodes(String escapeCode) {
			
			this.escapeCode = formatEscapeCode(escapeCode);
			
		}
		
		@Override
		public String getEscapeCode() {
			
			return escapeCode;
			
		}
		
	}
	
	// TODO -- Add 88/256 colors as well as RGB colors.
	
	enum TextDecorationCodes implements Escapable {
	
		BOLD		("1"),
		DIM			("2"),
		UNDERLINED	("4"),
		BLINKING	("5"),
		INVERTED	("7"),
		HIDDEN		("8");
		
		private final String escapeCode;
		
		TextDecorationCodes(String escapeCode) {
			
			this.escapeCode = formatEscapeCode(escapeCode);
			
		}
		
		@Override
		public String getEscapeCode() {
			
			return escapeCode;
			
		}
		
	}
	
	enum ResetCodes implements Escapable {
		
		ALL			("0"),
		BOLD		("1"),
		DIM			("2"),
		UNDERLINED	("4"),
		BLINKING	("5"),
		INVERTED	("7"),
		HIDDEN		("8"),
		FOREGROUND	("39"),
		BACKGROUND	("49");
		
		private final String escapeCode;
		
		ResetCodes(String escapeCode) {
			
			this.escapeCode = formatEscapeCode(escapeCode);
			
		}
		
		@Override
		public String getEscapeCode() {
			
			return escapeCode;
			
		}
		
	}
	
}