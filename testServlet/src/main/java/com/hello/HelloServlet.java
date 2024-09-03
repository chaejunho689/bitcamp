package com.hello;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/HelloServlet") // xml 또는 어노테이션 둘중 하나만 사용
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init...");
	}

	public void destroy() {
		System.out.println("destroy...");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet...");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>"); 
		out.println("<body>");
		out.println("Hello Servlet");
		out.println("안녕하세요 서블릿!");
		out.println("</body>");
		out.println("</html>");
		
		/*
		1. 콘솔
		System.out.println("<html>");
		
		2. 소켓
		PrintWriter out =  new PrintWriter(new FileWriter("result.txt"));
		out.println("<html>");
		
		3. 네트워크
		ObjectOutputStream out = new ObjectOutputStream(소켓.getOutputStream());
		out.printlm("<html>");
		*/
				
		
	}

}
