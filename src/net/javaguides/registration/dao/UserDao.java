package net.javaguides.registration.dao;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.text.SimpleDateFormat;
import java.util.Date;

import net.javaguides.registration.model.User;

public class UserDao {
	public int registerEmployee(User employee) throws ClassNotFoundException {
		
		
        String INSERT_USERS_SQL = "INSERT INTO user" +
            "  (first_name, last_name, email, password, address, contact,reg_date) VALUES " +
            " ( ?, ?, ?, ?,?,?,?);";

         int result = 0;
         

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/employees?useSSL=false", "root", "root");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
        	
            Date date=new Date();
            java.sql.Date sqlDate=new java.sql.Date(date.getTime());
            //preparedStatement.setInt(1,1); 
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getPassword());
            preparedStatement.setString(5, employee.getAddress());
            preparedStatement.setString(6, employee.getContact());
            preparedStatement.setDate(7, sqlDate);
            
            
            
            System.out.println(preparedStatement);
            
            result = preparedStatement.executeUpdate();
           

        } catch (SQLException e) {
            // process sql exception
            e.printStackTrace();
        }
        return result;
    }
	private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

