package jdbcpratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateEmployeeDetails {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/employee?user=root&password=123456";
		String query="update employee_db "
				+ "set e_salary=50000 where e_department='HR'";
		try {
			//step1:connection between java and db application
			Connection connection=DriverManager.getConnection(url);
			//step2:Create a aplatform
			Statement statement=connection.createStatement();
			int rows=statement.executeUpdate(query);
			System.out.println(rows+" updated Successfully");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
