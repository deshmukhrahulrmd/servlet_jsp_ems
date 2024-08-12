package servlets_jsp_ems;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		EmployeeCRUD crud = new EmployeeCRUD();
		try {
			String dbpassword = crud.login(email);
			RequestDispatcher dispatcher = null;
			
			if (dbpassword != null) {
				
				if (dbpassword.equals(password))
				{
					List<Employee> list = crud.getAllEmployees();
					req.setAttribute("list", list);
					
					/* Start Cookies */
						/* Creating cookies */
						Cookie cookie = new Cookie("userInfo", email);
						/* Sending cookies to client side so we send cookies with response object */
						resp.addCookie(cookie);
					/* End Cookies */
						
					//*******************************************************************************************************
						
					/* Start- Section tracking by using Http Section */
						HttpSession httpSession =  req.getSession();
						httpSession.setAttribute("session", email);
						System.out.println("Http Session");
					/* End- Section tracking by using Http Section */
					
						
					req.setAttribute("message", "Welcome "+email+" !!!");
					dispatcher = req.getRequestDispatcher("Success.jsp");
					
				}
				else{
					req.setAttribute("message", "Invalid Password !!!");
					dispatcher = req.getRequestDispatcher("Login.jsp");
				}
			} 
			else {
				req.setAttribute("message", "User not found, Register first !!!");
				dispatcher = req.getRequestDispatcher("Signup.jsp");
			}
			dispatcher.forward(req, resp);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
