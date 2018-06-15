package com.t99sdevelopment.jcli;

import com.t99sdevelopment.jcli.dummysubpackage.*;

public class DummyMainClass {

//	static Interface inter1 = InterfaceFactory.getInterface("bolo");
//	static Interface inter2 = InterfaceFactory.getInterface("reed");
//	static Interface inter3 = InterfaceFactory.getInterface("plep");

	
	
	public static void main(String[] args) {
		
		Interface inter1 = InterfaceFactory.getInterface("bolo");
		InterfaceFactory.getInterface("reed");
		InterfaceFactory.getInterface("plep");
		
		CommandManager.registerAllCommands();
		inter1.connect();

//		String[] strings = CommandInterpreter.groupDelimitedStrings(CommandInterpreter.normalize("How 'is everyone' \"doing\" `today my` guys?"));
//		for (String s: strings) System.out.println(s);
		
	}
	
}