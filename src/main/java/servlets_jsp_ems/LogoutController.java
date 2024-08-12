package servlets_jsp_ems;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/* Start- validation of Http Session */
		HttpSession httpSession = req.getSession();

		System.out.println(httpSession);// just for understanding purpose

		
		String email = (String) httpSession.getAttribute("session");
		if (email !=null) {
		 
			httpSession.invalidate();
			req.setAttribute("message", "Session not found, please login !!");
			RequestDispatcher dispatcher = req.getRequestDispatcher("Login.jsp");
			dispatcher.forward(req, resp);
		}
		/* End- validation of Http Session */
	}
}
