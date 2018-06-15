package com.t99sdevelopment.jcli.dummysubpackage.commands;

import java.util.Arrays;
import java.util.LinkedList;

public class Arguments {
	
	LinkedList<String> args = new LinkedList<>();
	
	public Arguments(String[] args) {
		
		this.args.addAll(Arrays.asList(args));
		
	}
	
	public String poll() {
		
		return args.poll();
		
	}
	
	public String get(int i) {
		
		return args.get(i);
		
	}
	
	public String[] getRemainingArguments() {
		
		return args.toArray(new String[0]);
		
	}
	
	public int size() {
		
		return args.size();
		
	}
	
}