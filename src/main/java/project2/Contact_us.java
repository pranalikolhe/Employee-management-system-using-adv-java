package project2;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/cont")
public class Contact_us extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	   public void init(ServletConfig config) {
		   try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
		   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			} catch (Exception e) {
				 e.printStackTrace();
			}
	   }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		 String s1=request.getParameter("name");
		 String s2=request.getParameter("email");
		 String s3=request.getParameter("Phone");
		 String s4=request.getParameter("message");
		 PreparedStatement ps= con.prepareStatement("insert into  Contact1 values(?,?,?,?)");
		 ps.setString(1,s1);
		 ps.setString(2,s2);
		 ps.setString(3,s3);
		 ps.setString(4,s4);
		  ps.executeQuery();
		
		  PrintWriter pw=response.getWriter();
		 pw.println("<body bgcolor=\"#87CEEB\"><body>");
		  pw.println("<center>");
		  pw.println("<h1>message has been send  succesfully<h1>");
		  pw.println("</center>");
		  
		} catch (Exception e) {
			 e.printStackTrace();
		}
		 
	}
	

}