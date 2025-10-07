package jdbcpratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ViewEmployeeDetails {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/employee?user=root&password=123456";
		String query="select * from employee_db";
		try {
			//step1:connection between java and db application
			Connection connection=DriverManager.getConnection(url);
			//step2:Create a aplatform
			Statement statement=connection.createStatement();
			//step3:
			ResultSet resultset=statement.executeQuery(query);
//			resultset.next();
			System.out.printf("|%-5s %-10s %-20s %-8s %-10s %-15s|\n", "e_id", "e_name", "e_email", "e_age", "e_salary","e_department");
			while(resultset.next()) {
			int e_id=resultset.getInt(1);
			String e_name=resultset.getString(2);
			String e_email=resultset.getString(3);
			int e_age=resultset.getInt(4);
			String e_salary=resultset.getString(5);
			String e_department=resultset.getString(6);
			  System.out.printf("|%-5d %-10s %-20s %-8d %-10s %-15s|\n", e_id, e_name, e_email, e_age, e_salary, e_department);
			
//			System.out.println(e_id);
//			System.out.println(e_name);
//			System.out.println(e_mail);
//			System.out.println(e_age);
//			System.out.println(e_salary);
//			System.out.println(e_department);
				
			}
			resultset.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
