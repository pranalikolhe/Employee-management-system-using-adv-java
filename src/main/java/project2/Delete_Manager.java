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
@WebServlet("/Mdel")
public class Delete_Manager extends HttpServlet {
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
			String s1 = request.getParameter("id");
			PreparedStatement ps = con.prepareStatement("delete from ManagerDetail1 where Manager_ID=?");
			ps.setString(1, s1);
			ps.execute();
			PrintWriter pw = response.getWriter();
			pw.println("<h1>data deleted succesfully</h1>");
			pw.println(" <a href=\"admin_login.html\">Go Back</a>");
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	}

