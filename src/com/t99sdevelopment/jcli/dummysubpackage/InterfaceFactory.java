package com.t99sdevelopment.jcli.dummysubpackage;

public class InterfaceFactory {
	
	public static Interface createInterface() {
		
		return new Interface();
		
	}
	
	public static Interface createInterface(String name) {
		
		return new Interface(name);
		
	}
	
	public static Interface createYieldableInterface() {
		
		return new Interface(true);
		
	}
	
	public static Interface createYieldableInterface(String name) {
		
		return new Interface(name,true);
		
	}
	
}
