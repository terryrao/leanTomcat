package java8;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * 方法引用 
 * @author terryrao
 *
 */
public class TestMethodReference {
	public static void main(String[] args) throws IOException { 
		 
//        JFrame frame = new JFrame(); 
//        frame.setLayout(new FlowLayout()); 
//        frame.setVisible(true); 
//         
//        JButton button1 = new JButton("点我!"); 
//        JButton button2 = new JButton("也点我!"); 
//         
//        frame.getContentPane().add(button1); 
//        frame.getContentPane().add(button2); 
//        //这里addActionListener方法的参数是ActionListener，是一个函数式接口 
//        //使用lambda表达式方式 
//        button1.addActionListener(e -> { System.out.println("这里是Lambda实现方式"); }); 
//        //使用方法引用方式 
//        button2.addActionListener(TestMethodReference::doSomething);
		
//		        int a = 100_100;
//		        System.out.print(a);
		BufferedReader bufferedReader = new BufferedReader(new StringReader(IoUtils.BufferedInputRead.read("D:/temp/testExt/nav.html")));
		PrintWriter pw = new PrintWriter(new File("D:/temp/testExt/test.html"));
		int lineCount = 1;
		String string;
		while ((string = bufferedReader.readLine())!= null) {
			string = lineCount++ + " : " + string;
			pw.append(string);
		}
		pw.close();
		System.out.println(IoUtils.BufferedInputRead.read("D:/temp/testExt/test.html"));
         
    } 
    /** 
     * 这里是函数式接口ActionListener的实现方法 
     * @param e  
     */ 
    public static void doSomething(ActionEvent e) { 
         
        System.out.println("这里是方法引用实现方式"); 
         
    } 
}
