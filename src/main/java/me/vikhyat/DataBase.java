package me.vikhyat;

import java.io.File;

public class DataBase {

	public static void update(String path) {
		File[] files = new File(path).listFiles();
		showFiles(files);
    }
	//goes through a given file and list or does something to the given file
	private static void showFiles(File[] files) {
		for(File file : files) {
			if(file.isDirectory()) {
				System.out.println("Directory: "+file.getName());
				//Recursive method to list the files inside the directory.
				showFiles(file.listFiles());
			} else {
				System.out.println("  File: "+file.getName());
			}
		}
		
	}
 
	}