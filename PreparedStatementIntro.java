package jdbcpratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementIntro {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String url="jdbc:mysql://localhost:3306/employee?user=root&password=123456";
		
		try {
			Connection connection=DriverManager.getConnection(url);
			String query="insert into employee_db values(?,?,?,?,?,?)";
	PreparedStatement preparedStatement=connection.prepareStatement(query);
			System.out.print("Enter e_id: ");
			int e_id=Integer.parseInt(sc.nextLine());
			
			System.out.print("Enter e_name: ");
			String e_name=sc.nextLine();
			System.out.print("Enter e_email: ");
			String e_email=sc.nextLine();
		
			System.out.print("Enter e_age: ");
			int e_age=sc.nextInt();
			sc.nextLine();
		
			System.out.print("Enter e_salary: ");
			String e_salary=sc.nextLine();
			System.out.print("Enter department: ");
			String e_department=sc.nextLine();
			preparedStatement.setInt(1,e_id);
			preparedStatement.setString(2,e_name);
			preparedStatement.setString(3, e_email);
			preparedStatement.setInt(4, e_age);
			preparedStatement.setString(5, e_salary);
			preparedStatement.setString(6, e_department);
			//step3
			int rows=preparedStatement.executeUpdate();
			System.out.println(rows+" instered successfully");
			preparedStatement.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	

}
