/*
 * Created by Trevor Sears <trevorsears.main@gmail.com>.
 * 3:11 PM -- September 10th, 2018.
 * Classpath: io.trevorsears.code.java.jcli.ConfigurationReader
 */

package io.trevorsears.code.java.jcli;

import java.io.File;

public class ConfigurationReader {
	
	File file;
	
	protected ConfigurationReader(String filepath) {
		
		file = new File(filepath);
		
	}
	
}