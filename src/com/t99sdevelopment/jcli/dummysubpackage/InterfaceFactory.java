package com.t99sdevelopment.jcli.dummysubpackage;

public class InterfaceFactory {
	
	public static Interface getInterface() {
		
		return new Interface();
		
	}
	
	public static Interface getInterface(String name) {
		
		return new Interface(name);
		
	}
	
	public static Interface getYieldableInterface() {
		
		return new Interface(true);
		
	}
	
	public static Interface getYieldableInterface(String name) {
		
		return new Interface(name,true);
		
	}
	
}
