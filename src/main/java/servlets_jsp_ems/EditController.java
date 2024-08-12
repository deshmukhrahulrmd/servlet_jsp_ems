package servlets_jsp_ems;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/edit")
public class EditController extends HttpServlet {
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
			int result = crud.updateEmployeeDetails(employee);
			if (result != 0) {
				List<Employee> list = crud.getAllEmployees();
				req.setAttribute("list", list);
				req.setAttribute("message", "Updation successful !!!");
				
				/* Session tracking using cookies */
				Cookie cookies[] = req.getCookies();
				String Cookievalue = null;
				for (Cookie c : cookies) { /* 1st parameter is which type of date you want to iterate & 2nd is on which collection you want to iterate*/
					if (c.getName().equals("userInfo")) {
						Cookievalue = c.getValue();
					}
				}
				req.setAttribute("cookie", Cookievalue); /* 1st argument is key 2nd is value */
				/* Session tracking using cookies */
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("Success.jsp");
				dispatcher.forward(req, resp);
			} else {
				req.setAttribute("message", "Updation not successful !!!");
				RequestDispatcher dispatcher = req.getRequestDispatcher("Edit.jsp");
				dispatcher.forward(req, resp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
