package jdbcpratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ResultSetIntro {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String url="jdbc:mysql://localhost:3306/employee?user=root&password=123456";
		
		try {
			Connection connection=DriverManager.getConnection(url);
			String query="select * from employee_db";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
//			System.out.print("Enter e_id: ");
//			int e_id=Integer.parseInt(sc.nextLine());
//			preparedStatement.setInt(1,e_id);
			
			//step3
			ResultSet resultset=preparedStatement.executeQuery();
			
				System.out.printf("|%-5s %-10s %-20s %-8s %-10s %-15s|\n", "e_id", "e_name", "e_email", "e_age", "e_salary","e_department");
				while(resultset.next()) {
				int e_id1=resultset.getInt(1);
				String e_name=resultset.getString(2);
				String e_email=resultset.getString(3);
				int e_age=resultset.getInt(4);
				String e_salary=resultset.getString(5);
				String e_department=resultset.getString(6);
				  System.out.printf("|%-5d %-10s %-20s %-8d %-10s %-15s|\n",e_id1 , e_name, e_email, e_age, e_salary, e_department);
				
			}
			preparedStatement.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
