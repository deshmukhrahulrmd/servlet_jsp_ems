package servlets_jsp_ems;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		EmployeeCRUD crud = new EmployeeCRUD();
		try {
			RequestDispatcher dispatcher = null;
			int result = crud.deleteEmployee(id);

			if (result != 0) {
				List<Employee> list = crud.getAllEmployees();
				req.setAttribute("list", list);
				req.setAttribute("message", "Data successfully deleted !!!");
				dispatcher = req.getRequestDispatcher("Success.jsp");
				dispatcher.forward(req, resp);
			} else {
				req.setAttribute("message", "Data not deleted !!!");
				dispatcher = req.getRequestDispatcher("Success.jsp");
				dispatcher.forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
