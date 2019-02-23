package me.vikhyat;

import java.io.File;
import java.util.ArrayList;

public class DataBase {
	private static ArrayList< ArrayList<String> > DBArray = new ArrayList<ArrayList<String>>();
	
//	Usable methods that are public
//	DataBase.run();
//	DataBase.printArray();
//	DataBase.getDataBase();

	//stores the parsed names and their location.
	
	
	public static void run() {
		String path = Main.homeDirectory();
		File[] files = new File(path).listFiles();
		updateDB(files);
		System.out.println(DBArray.toString());
	}
	// returns DataBase in word then directory order
	public static ArrayList<ArrayList<String>> getDataBase(){
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
		setWord(name,directory);
	}
	
	
	public static void setWord(String word, String dir) {
		int checkExistance = checkExistance(word); 
		if(checkExistance == -1){
		   DBArray.add( new ArrayList<String>() );
		   int arraySize = DBArray.size()-1;
		   DBArray.get(arraySize).add(word);
		   DBArray.get(arraySize).add(dir);
		   System.out.println(DBArray.toString());
		}else {
			DBArray.get(checkExistance).add(dir);
		}
		   }   
	


	private static int checkExistance(String word) {
		for(int i = 0; i < DBArray.size(); i++) {
			if((DBArray.get(i).get(0)) == word) {
				System.out.println("word match found");
				return i;
			}
		}
		return -1;
	}



}