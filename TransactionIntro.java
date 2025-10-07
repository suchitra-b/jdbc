package jdbcpratice;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;

public class TransactionIntro {

	public static void main(String[] args) throws SQLException {
		String url="jdbc:mysql://localhost:3306/employee?user=root&password=123456";
		
		Connection connection=DriverManager.getConnection(url);
		
		connection.setAutoCommit(false);
		try {
			String query1="insert into employee_db values(106,'Jeshvitha','jeshu@gmail.com',34,'45678','Writer')";
			String query2="insert into employee_db values(107,'Jannu','janu@gmail.com',54,'35678','mentor')";
			Statement statement=connection.createStatement();
			statement.addBatch(query1);
			statement.addBatch(query2);
			statement.executeBatch();
			connection.commit();
			
			System.out.println("Successfuly");
		

			statement.close();
			
		}catch(Exception e) {
			connection.rollback();
			System.out.println(e.getMessage());
		}
		System.out.println("Successfuly");

		
		connection.close();
}
}
