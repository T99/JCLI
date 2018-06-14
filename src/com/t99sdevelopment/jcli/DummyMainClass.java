package com.t99sdevelopment.jcli;

import com.t99sdevelopment.jcli.dummysubpackage.CommandInterpreter;
import com.t99sdevelopment.jcli.dummysubpackage.CommandManager;
import com.t99sdevelopment.jcli.dummysubpackage.Interface;
import com.t99sdevelopment.jcli.dummysubpackage.InterfaceFactory;

public class DummyMainClass {

	static Interface inter1 = InterfaceFactory.getInterface("bolo");
	static Interface inter2 = InterfaceFactory.getInterface("reed");
	static Interface inter3 = InterfaceFactory.getInterface("plep");
	
	public static void main(String[] args) {
		
		CommandManager.registerAllCommands();
		
		if (inter1.connect()) System.out.println("Interface connected.");
		else System.out.println("Interface did not connect.");
		
//		String[] strings = CommandInterpreter.groupDelimitedStrings(CommandInterpreter.normalize("How 'is everyone' \"doing\" `today my` guys?"));
//		for (String s: strings) System.out.println(s);
		
	}
	
}