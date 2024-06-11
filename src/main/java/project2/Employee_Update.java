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
@WebServlet("/upd")
public class Employee_Update extends HttpServlet {
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
			String s1 = request.getParameter("id"); 
			String s2 = request.getParameter("data");
			String s3 = request.getParameter("s1");
			PreparedStatement ps = con.prepareStatement("update EmployeeDetail1 set "+s2+"='"+s3+"' where Employee_ID=?");
			ps.setString(1, s1);
			ps.execute();                                  
			PrintWriter pw=response.getWriter();
		 pw.println("<h1>data  update succesfully</h1>");
		 pw.println(" <a href=\" home.html\">Go Back</a>");
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

}