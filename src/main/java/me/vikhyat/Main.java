package me.vikhyat;

public class Main {
	static String homeDirectory = "C:\\Users\\vikhy\\Desktop\\DbtestFolder\\";
	
	public static String homeDirectory(){
		return homeDirectory;
	}
	
	
	public static void main(String[] args) {
		DataBase.update(homeDirectory);

	}


}