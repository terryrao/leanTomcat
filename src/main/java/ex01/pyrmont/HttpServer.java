package ex01.pyrmont;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


public class HttpServer {
	
	/*
	 * WEB_ROOT is  the directory where our html and other file aside
	 */
	public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "webroot";
	
	
	private static final String SHUT_DOWN = "/shutdown";
	
	//the shutdown command received
	private boolean shutdown = false;
	
	public static void main(String[] args) {
		HttpServer server = new HttpServer();
		server.await();
	
	}
	
	public void await(){
		int port = 8081;
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (!shutdown) {
			Socket socket = null;
			InputStream inputStream = null;
			OutputStream outputStream = null;
			try {
				socket = serverSocket.accept();
				inputStream = socket.getInputStream();
				outputStream = socket.getOutputStream();
				Request  request = new Request(inputStream);
				request.parse();
				Response response = new Response(outputStream);
				response.setRequest(request);
				response.sendStaticResource();
				shutdown = request.getUri().equals(SHUT_DOWN);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
