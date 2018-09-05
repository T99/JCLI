/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 1:46 PM -- September 05th, 2018.
 * Classpath: io.trevorsears.code.java.jcli.output.formatting.Color
 */

package io.trevorsears.code.java.jcli.output.formatting;

public class Color {
	
	int r, g, b;
	
	private Color(int r, int g, int b) {
		
		this.r = r;
		this.g = g;
		this.b = b;
		
	}
	
	public int getRComponent() {
		
		return r;
		
	}
	
	public int getGComponent() {
		
		return g;
		
	}
	
	public int getBComponent() {
		
		return b;
		
	}
	
	public enum ROYGBIV {
		
		RED		(200,   0,   0),
		ORANGE	(200, 122,   0),
		YELLOW	(225, 225,   0),
		GREEN	(  0, 200,   0),
		BLUE	(  0,   0, 200),
		INDIGO	( 50,   0, 255),
		VIOLET	(122,   0, 255);
		
		Color color;
		
		ROYGBIV(int r, int g, int b) {
			
			color = new Color(r, g, b);
			
		}
		
	}
	
}