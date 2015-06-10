package java8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IoUtils {
	public static class BufferedInputRead {
		public static String read(String path) {
			BufferedReader bufferedReader = null;
			String s;
			StringBuilder sb = new StringBuilder();
			try {
				bufferedReader = new BufferedReader(new FileReader(new File(path)));
				while((s = bufferedReader.readLine()) != null) {
					sb.append(s);
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}finally {
				if (bufferedReader!= null) {
					try {
						bufferedReader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			return sb.toString();
		}
	}
}
