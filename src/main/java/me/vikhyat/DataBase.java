package me.vikhyat;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBase {
	
	//stores the parsed names and their location.
	static List<String> DBArray= new ArrayList<String>();
	
	
	public static void run() {
		String path = Main.homeDirectory();
		File[] files = new File(path).listFiles();
		updateDB(files);
	}
	
	public static List<String> getDataBase(){
		return DBArray;
	}

	//goes through a given file and list or does something to the given file
	private static void updateDB(File[] files) {
		for(File file : files) {
			//lists directory names
			if(file.isDirectory()) {
				//Recursive method to list the files inside the directory.
				updateDB(file.listFiles());
			} else {
				addNew(file.getName(),file.getAbsolutePath());
				//lists file names in the given directory
			}
		}	
	}
	
	//adds the name to the array if it already doesn't exist
	private static void addNew(String name, String directory){
		
		DBArray.add(name);
		DBArray.add(directory);
	}
	
	private static void printArray(){
		for(int i = 0; i< DBArray.size();i++) {
		System.out.println(DBArray.get(i));
		}
	}

}