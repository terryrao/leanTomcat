package ex02.pymont;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class PrimitiveServlet implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init....");
	}

	@Override
	public ServletConfig getServletConfig() {
		
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("from server");
		PrintWriter os = res.getWriter();
		os.write("Hello rose are red");
		os.write("Violets are blue");
		
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {
		System.out.println("destory");
	}

}
