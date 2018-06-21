package com.t99sdevelopment.jcli;

import com.t99sdevelopment.jcli.dummysubpackage.*;

public class DummyMainClass {

	public static void main(String[] args) {
		
		InterfaceFactory.createInterface("tom");
		InterfaceFactory.createInterface("bob");
		InterfaceFactory.createInterface("steve");

		CommandManager.registerAllCommands();
		
	}
	
}