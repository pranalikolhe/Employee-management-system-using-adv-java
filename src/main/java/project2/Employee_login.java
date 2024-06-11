package project2;

import jakarta.servlet.RequestDispatcher;
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

 @SuppressWarnings("serial")
@WebServlet("/Employee")
public class Employee_login extends HttpServlet {
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
				 response.setContentType("text/html");
				 String s1=request.getParameter("id");
			 String s2=request.getParameter("pass");
			 PreparedStatement ps= con.prepareStatement("select * from EmployeeDetail1 where Employee_ID=? and PassWord=?");
			 ps.setString(1,s1);
			 ps.setString(2,s2);
			 ResultSet rs=ps.executeQuery();
			 PrintWriter pw=response.getWriter();
			 if(rs.next()) {
				RequestDispatcher r=request.getRequestDispatcher("Employee_login.html");
				r.include(request, response);
			 }
			 else {
				 pw.println("invalid name or pass");
				 
			 } 
			} catch (Exception e) {
				 e.printStackTrace();
			}
			 
		}

	}
