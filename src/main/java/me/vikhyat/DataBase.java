package me.vikhyat;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class DataBase {
	
	//stores the parsed names and their location.
	static ArrayList<String> DBArray = new ArrayList<String>();
	

	public static void update() {
		String path = Main.homeDirectory();
		File[] files = new File(path).listFiles();
		updateDB(files);
    }
	
	
	
	//goes through a given file and list or does something to the given file
	private static void updateDB(File[] files) {
		for(File file : files) {
			//lists directory names
			if(file.isDirectory()) {
				//System.out.println("Directory: "+file.getAbsolutePath());
				//Recursive method to list the files inside the directory.
				updateDB(file.listFiles());
			} else {
				addNew(file.getName(),file.getAbsolutePath());
				//lists file names in the given directory
				//System.out.println("  File: "+file.getAbsolutePath());
			}
		}	
	}
	
	//adds the name to the array if it already doesn't exist
	private static void addNew(String name, String directory){
		//checks existence of the name and gives the location
//		Object locationIfExists = checkExistance(name);
		//if i does not exist it adds the name of it too the list
//		if(locationIfExists == null) {
//			DBArray[DBArray.length+1][0] = name;
//			DBArray[DBArray.length+1][1] = directory;
//		}
		DBArray.add(name);
	}


	//checks if the string already exists 
	private static Object checkExistance(String name) {
//		for(int i = 0; i <= DBArray.length-1; i++) {
//			if(name == DBArray[i][0]) return i;
//		}
		return null;
	}
	
	public static void printArray(){
		System.out.println(DBArray);
		System.out.println("yeet");
	}
	
	
	
	
	
	
	
	
	
	
	
 
	}