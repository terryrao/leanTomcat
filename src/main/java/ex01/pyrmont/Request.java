package ex01.pyrmont;

import java.io.IOException;
import java.io.InputStream;

public class Request {
	private InputStream inputStream;
	private String uri;
	
	public Request(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	public String getUri(){
		return this.uri;
	}
	
	public void parse() {
		StringBuilder sb = new StringBuilder(2048);
		byte[] buff = new byte[2048];
		int i;
		try {
			i = this.inputStream.read(buff);
			
		} catch (IOException e) {
			e.printStackTrace();
			i = -1;
		}
		for(int j = 0; j <i; j++) {
			sb.append((char)buff[j]);
		}
		System.out.println(sb.toString());
		this.uri = this.parseUri(sb.toString());
		
	}
	
	public String parseUri(String uri){
		int index1,index2;
		index1 = uri.indexOf(" ");
		if (index1 != -1) {
			index2 = uri.indexOf(" ", index1 + 1);
			if (index2 > index1) {
				return uri.substring(index1+1, index2);
			}
		}
		return null;
	}
}
