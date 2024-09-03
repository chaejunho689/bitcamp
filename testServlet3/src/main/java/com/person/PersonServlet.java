package com.person;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/person")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//데이터
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String color = request.getParameter("color");
		String[] hobby = request.getParameterValues("hobby");
		String[] subject = request.getParameterValues("subject");
		
		
		
		//응답
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body style='color:" + color+";' >");
		out.println("<p> 이름 : " + name + "</p>");
		out.println("<p> 성별 : " + gender + "</p>");
		out.println("<p> 색깔 : " + color + "</p>");
		out.println("<p> 취미 : ");
		for(int i=0; i<hobby.length; i++) {
			out.println(hobby[i]);
			if(hobby.length > 1 && hobby.length != i) {
				out.println(", ");
			}
		}
		out.println("</p>");
//		out.println("<p> 과목 : " + subject + "</p>");
		for(String data : subject) {
			out.println(data + "&npsp;");
		}
	 	out.println("<br><br>");
	 	out.println("<input type='button' value='뒤로' onclick='history.go(-1)'>");
	 	out.println("</body>");
		out.println("</html>");
		
	}


}
