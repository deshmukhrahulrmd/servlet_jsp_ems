package servlets_jsp_ems;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
;

@WebServlet("/signup")
public class SignUpController extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		long phone = Long.parseLong(req.getParameter("phone"));
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setPhone(phone);
		employee.setAddress(address);
		employee.setEmail(email);
		employee.setPassword(password);
		
		EmployeeCRUD crud = new EmployeeCRUD();
		try {
			int result = crud.signUp(employee);
			RequestDispatcher dispatcher = null;
			if (result!=0)
			{				
				req.setAttribute("message", "Signup Successful, please login !!!");
				dispatcher = req.getRequestDispatcher("Login.jsp");
				dispatcher.forward(req, resp);
			}
			else
			{
				req.setAttribute("message", "Chose correct option !!!");
				dispatcher = req.getRequestDispatcher("Home.jsp");
				dispatcher.forward(req, resp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
