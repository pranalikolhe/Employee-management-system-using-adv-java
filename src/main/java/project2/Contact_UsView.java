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
import java.util.ArrayList;
import java.util.Iterator;


@WebServlet("/con1")
public class Contact_UsView extends HttpServlet {
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
		@SuppressWarnings("unused")
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				 response.setContentType("text/html");
				PreparedStatement p1 = con.prepareStatement("SELECT * FROM  Contact");
				ResultSet rs = p1.executeQuery();
				ArrayList<Contact_usBean> a = new ArrayList<Contact_usBean>();
				while (rs.next()) {
					Contact_usBean c= new Contact_usBean();
					c.setName(rs.getString(1));
					c.setEmail(rs.getString(2));
					c.setPhone(rs.getString(3));
					 c.setMessage(rs.getString(4)); 
					  a.add(c);
				}
				 PrintWriter pw=response.getWriter();
				 pw.println("<body bgcolor=\"#87CEEB\">");
				 pw.println("data is:");
				 pw.println("<br>");
				 Iterator<Contact_usBean> i=a.iterator();
				 while(i.hasNext()){
				 pw.println(i.next());
				 pw.println("<br>");
				 }
				 pw.println("<br>");
				 pw.println("<a href=\"admin_login.html\">Go Back</a>");
				}catch (Exception e) {
					 e.printStackTrace();
				}
			}}