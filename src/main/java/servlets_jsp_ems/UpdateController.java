package servlets_jsp_ems;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/update")
public class UpdateController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		EmployeeCRUD crud =new EmployeeCRUD();
		
		try {
			
			Employee employee = crud.getEmployeeByID(id);
			
			if (employee != null)
			{
				RequestDispatcher dispatcher = null;
				/* Start- validation of Http Session */
					HttpSession httpSession = req.getSession();

					System.out.println(httpSession);// just for understanding purpose
					
					String email = (String) httpSession.getAttribute("session");
					if (email!=null)
					{
						req.setAttribute("Emp", employee);
						dispatcher = req.getRequestDispatcher("Edit.jsp");
					}
					else {
						req.setAttribute("Emp", employee);
						req.setAttribute("message", "Session not found, please login !!");
						dispatcher = req.getRequestDispatcher("Login.jsp");
					}
				/* End- validation of Http Session */
					
					dispatcher.forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
