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

 @WebServlet("/ViewE")
public class EmployeeE_View extends HttpServlet {
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
			response.setContentType("text/html");
		String s1=request.getParameter("id");
			 PreparedStatement ps=con.prepareStatement("select * from EmployeeDetail1 where Employee_ID="+s1);
		 ResultSet rs=ps.executeQuery();
		
		 ArrayList<EmployeeBean> a=new ArrayList<EmployeeBean>();
		 while(rs.next()) {
			 //b=null;
			 EmployeeBean b = new EmployeeBean();
			    b.setEmployee_ID(rs.getInt(1));
			    b.setPassWord(rs.getString(2));
			    b.setFirst_Name(rs.getString(3));
			    b.setMiddle_Name(rs.getString(4));
			    b.setLast_Name(rs.getString(5));
			    b.setFather_Name(rs.getString(6));
			    b.setMother_Name(rs.getString(7));
			    b.setPhone(rs.getString(8));
			    b.setEmail(rs.getString(9));
			    b.setCity(rs.getString(10));
			    b.setAddress(rs.getString(11));
			    b.setPostal_Code(rs.getString(12));
			    b.setQualification(rs.getString(13));
			    b.setUserType(rs.getString(14));
			    b.setGender(rs.getString(15));
			    b.setMarital_Status(rs.getString(16));
			    b.setDepartment(rs.getString(17));
			  a.add(b);
		 }
		 PrintWriter pw=response.getWriter();
		 pw.println("<body bgcolor=\"#87CEEB\">");
		 pw.println("data is:");
		 pw.println("<br>");
		 Iterator<EmployeeBean> i=a.iterator();
		 while(i.hasNext()){
		 pw.println(i.next());
		 pw.println("<br>");}
		 pw.println("<br>");
		 pw.println(" <a href=\"Employee_login.html\">Go Back</a>");
		} catch (Exception e) {
			 e.printStackTrace();
		}
		 }
		 
		 
	} 
 
