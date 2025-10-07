package jdbcpratice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertEmployeeDetails {

	public static void main(String[] args)  {
		String url = "jdbc:mysql://localhost:3306/employee?user=root&password=123456";
		//insert
		String query="insert INTO employee_db values(101,'suchitra','suchi@gmail.com',23,'34000','HR'),"
				+ "(102,'vamshi','vamsgi@gmail.com',25,'45000','Developer'),"
				+ "(103,'Bittu','bittu@gmail.com',23,'25000','BPO'),"
				+ "(104,'Sai','sai@gmail.com',34,'34563','Content module'),"
				+ "(105,'Hanvi','hanvi@gmail.com',34,'34563','Manager')";

try {
	Connection connection=DriverManager.getConnection(url);
	Statement statement=connection.createStatement();
	int row=statement.executeUpdate(query);
	System.out.println(row+" inserted successfully");
	statement.close();
	connection.close();
	
} catch (SQLException e) {
	
	e.printStackTrace();
	
}


	}
}