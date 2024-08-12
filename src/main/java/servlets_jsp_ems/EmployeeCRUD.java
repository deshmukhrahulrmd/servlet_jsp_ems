package servlets_jsp_ems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;

public class EmployeeCRUD {
	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp?user=root&password=root");
	}

//		@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Insert Details @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public int signUp(Employee employee) throws Exception {
//			1. load the driver.
//			2. Establish the connection.
		Connection connection = getConnection();

//			3. create statement.
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employee VALUES(?,?,?,?,?,?)");
		preparedStatement.setInt(1, employee.getId());
		preparedStatement.setString(2, employee.getName());
		preparedStatement.setLong(3, employee.getPhone());
		preparedStatement.setString(4, employee.getAddress());
		preparedStatement.setString(5, employee.getEmail());
		preparedStatement.setString(6, employee.getPassword());

//			4. Execute query.
		int result = preparedStatement.executeUpdate();

//			5.Close connection.
		connection.close();

//			we can return value from this method but not able to perform any operation on database.
		return result;
	}

//		@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Update Details @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public String login(String email) throws Exception {
//			1. load the driver.
//			2. Establish the connection.
		Connection connection = getConnection();

//			3. create statement.
		PreparedStatement preparedStatement = connection
				.prepareStatement("SELECT password FROM employee WHERE email=?");

		preparedStatement.setString(1, email);

//			4. Execute query.
		ResultSet result = preparedStatement.executeQuery();

		String pass = null;

		while (result.next()) {
			pass = result.getString("password");
		}

//			5.Close connection.
		connection.close();

//			we can return value from this method but not able to perform any operation on database.
		return pass;
	}

//	@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Get All the Emp @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public List<Employee> getAllEmployees() throws Exception {
		// 1. load the driver.
		// 2. Establish the connection.
		Connection connection = getConnection();

		// 3. create statement.
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee");

		// 4. Execute query.
		ResultSet result = preparedStatement.executeQuery();

		List<Employee> list = new ArrayList<Employee>();
		while (result.next()) {
			Employee employee = new Employee();
			employee.setId(result.getInt("id"));
			employee.setName(result.getString("name"));
			employee.setPhone(result.getLong("phone"));
			employee.setAddress(result.getString("address"));
			employee.setEmail(result.getString("email"));
			employee.setPassword(result.getString("password"));

			list.add(employee);
		}

		// 5.Close connection.
		connection.close();
		return list;
		// we can return value from this method but not able to perform any operation on
		// database.
	}

//	@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Delete employee by ID @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public int deleteEmployee(int id) throws Exception {
		// 1. load the driver.
		// 2. Establish the connection.
		Connection connection = getConnection();

		// 3. create statement.
		PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM employee WHERE ID=?");
		preparedStatement.setInt(1, id);

		// 4. Execute query.
		int result = preparedStatement.executeUpdate();

		// 5.Close connection.
		connection.close();
		return result;
		// we can return value from this method but not able to perform any operation on
		// database.
	}

//	@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Delete employee by ID @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public Employee getEmployeeByID(int id) throws Exception {
		// 1. load the driver.
		// 2. Establish the connection.
		Connection connection = getConnection();

		// 3. create statement.
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee WHERE id=?");

		preparedStatement.setInt(1, id);

		// 4. Execute query.
		ResultSet result = preparedStatement.executeQuery();

		Employee employee = new Employee();

		while (result.next()) {
			employee.setId(result.getInt("id"));
			employee.setName(result.getString("name"));
			employee.setPhone(result.getLong("phone"));
			employee.setAddress(result.getString("address"));
			employee.setEmail(result.getString("email"));
			employee.setPassword(result.getString("password"));
		}

		// 5.Close connection.
		connection.close();

		// we can return value from this method but not able to perform any operation on
		// database.
		return employee;
	}

	public int updateEmployeeDetails(Employee employee) throws Exception{
		//		1. load the driver.
		//		2. Establish the connection.
			Connection connection = getConnection();
		
		//		3. create statement.
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE employee SET name=?, phone=?, address=?, email=?, password=? WHERE id=?");
			
			preparedStatement.setString(1, employee.getName());
			preparedStatement.setLong(2, employee.getPhone());
			preparedStatement.setString(3, employee.getAddress());
			preparedStatement.setString(4, employee.getEmail());
			preparedStatement.setString(5, employee.getPassword());
			preparedStatement.setInt(6, employee.getId());
		
		//		4. Execute query.
			int result = preparedStatement.executeUpdate();
		
		//		5.Close connection.
			connection.close();
		
		//		we can return value from this method but not able to perform any operation on database.
			return result;
	}

}
