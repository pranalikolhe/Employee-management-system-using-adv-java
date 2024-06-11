package project2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/log")
 @SuppressWarnings("serial")
public class Login extends HttpServlet {
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s1 = request.getParameter("s1");
		if(s1.equals("Admin")) {
			RequestDispatcher rd=request.getRequestDispatcher("admin");
			 rd.forward(request, response);
		}
		if(s1.equals("Employee")) {
			RequestDispatcher rd=request.getRequestDispatcher("Employee");
			 rd.forward(request, response);
		}
		if(s1.equals("Manager")) {
			RequestDispatcher rd=request.getRequestDispatcher("Manager");
			 rd.forward(request, response);
		}
	}

}
