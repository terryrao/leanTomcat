package ex01.pyrmont;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

public class Response {
	private static int BUFF_SIZE = 1024;
	private OutputStream outputStream;
	private Request request;
	
	public Response(OutputStream outputStream) {
		this.outputStream = outputStream;
	}
	
	public void setRequest(Request request) {
		this.request = request;
	}
	
	public void sendStaticResource(){
		byte[] buff = new byte[BUFF_SIZE];
		FileInputStream fis = null;
		try {
			File file = new File(HttpServer.WEB_ROOT + request.getUri());
			if (file.exists()) {
				fis = new FileInputStream(file);
				int ch = fis.read(buff,0,BUFF_SIZE);
				while (ch != -1) {
					outputStream.write(buff,0,ch);
					ch = fis.read(buff,0,BUFF_SIZE);
				}
			}else {
				String errorMessage = "HTTP/1.1 404 File Not Found\r\n" + "Content-Type: text/html\r\n" + "Content-Length: 23\r\n" +"\r\n" +"<h1>File Not Found</h1>";
				outputStream.write(errorMessage.getBytes());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
