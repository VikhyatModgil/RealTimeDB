package me.vikhyat;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//gets the location on where to store the data once its uploaded
		String homeDirectory = Main.homeDirectory();
		//Prints the given object to the website.
		PrintWriter printWeb = response.getWriter();
		//tries to upload data to the given directory
	try {
		ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
		List<FileItem> multifiles = sf.parseRequest(request);
		//downloads the user given files to the server.
		for(FileItem item : multifiles){
			item.write(new File(homeDirectory + item.getName()));
			printWeb.println("File \""+ item.getName() +"\" was uploaded successfully");
		}
		//updates the database after the files have been uploaded to make files searchable.
		DataBase.update();
		}
	catch(Exception e) {
			System.out.println(e);
		}
	}
}
