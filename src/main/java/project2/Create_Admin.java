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

 @WebServlet("/adm")
public class Create_Admin extends HttpServlet {
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
		  
		 PreparedStatement ps= con.prepareStatement("insert into user9  values(?,?)");
		 ps.setString(1,s1);
		 ps.setString(2,s2);
		 
		 ps.executeQuery();
		 PrintWriter pw=response.getWriter();
		  pw.println("<h1>data entered succesfully<h1>");
		  pw.println(" <a href=\"home.html\">Go Back</a>");
		} catch (Exception e) {
			 e.printStackTrace();
		}
		 
	}

}
