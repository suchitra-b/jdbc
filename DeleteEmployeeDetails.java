package jdbcpratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteEmployeeDetails {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/employee?user=root&password=123456";
		String query="delete from  employee_db  where e_id=105";
		try {
			//step1:connection between java and db application
			Connection connection=DriverManager.getConnection(url);
			//step2:Create a aplatform
			Statement statement=connection.createStatement();
			int rows=statement.executeUpdate(query);
			System.out.println(rows+" deleted Successfully");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}


	}

}
