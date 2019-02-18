package me.vikhyat;
import java.io.File;
import java.io.IOException;
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
		String databaseDir = "C:\\Users\\vikhy\\Desktop\\DbtestFolder\\";
		
		try {
		ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
		List<FileItem> multifiles = sf.parseRequest(request);
		
		for(FileItem item : multifiles){
			item.write(new File(databaseDir + item.getName()));
		}
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("good job yal goof it works!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! yeet");
	}

}
