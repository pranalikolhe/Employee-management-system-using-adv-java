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

 @SuppressWarnings("serial")
@WebServlet("/man")
public class managerRegister extends HttpServlet {
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
			 String s1=request.getParameter("id");
		 String s2=request.getParameter("pass");
		 String s3=request.getParameter("first");
		 String s4=request.getParameter("middle");
		 String s5=request.getParameter("last");
		 String s6=request.getParameter("father");
		 String s7=request.getParameter("mother");
		 String s8=request.getParameter("phno");
		 String s9=request.getParameter("email"); 
		 String s10=request.getParameter("city");
		 String s11=request.getParameter("address");
		 String s12=request.getParameter("code");
		 String s13=request.getParameter("quali");
		 String s14=request.getParameter("s1");
		 String s15=request.getParameter("gender");
		 String s16=request.getParameter("Marital");
		 String s17=request.getParameter("dept");
		 PreparedStatement ps= con.prepareStatement("insert into ManagerDetail1 values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		 ps.setString(1,s1);
		 ps.setString(2,s2);
		 ps.setString(3,s3);
		 ps.setString(4,s4);
		 ps.setString(5,s5);
		 ps.setString(6,s6);
		 ps.setString(7,s7);
		 ps.setString(8,s8);
		 ps.setString(9,s9);
		 ps.setString(10,s10);
		 ps.setString(11,s11);
		 ps.setString(12,s12);
		 ps.setString(13,s13);
		 ps.setString(14,s14);
		 ps.setString(15,s15);
		 ps.setString(16,s16);
		 ps.setString(17,s17);
		 
		 ps.executeQuery();
		 PrintWriter pw=response.getWriter();
		 pw.println("<body bgcolor=\"#87CEEB\">");
		  pw.println("<h1>data entered succesfully<h1>");
		  pw.println("<br>");
		  pw.println("<br>");
		  pw.println(" <a href=\"home.html\">Go Back</a>");
		} catch (Exception e) {
			 e.printStackTrace();
		}
		 
	}

}