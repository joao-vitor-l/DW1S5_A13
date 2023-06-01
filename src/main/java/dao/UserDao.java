package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDao{
	public int registerUser(User user) throws ClassNotFoundException{
        String INSERT_USERS_SQL = "INSERT INTO user" +
            "  (username, password, name, email) VALUES " +
            " (?, ?, ?, ?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tasklist", "root", "");

        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
    	
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getName());
            preparedStatement.setString(4, user.getEmail());

            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    
		return result;
    }
 
	 public User logUser(String username, String password) throws ClassNotFoundException{
	        String LOG_USERS_SQL = "SELECT id, username, password, name, email FROM user" +
	        		" WHERE username=? AND password=?";
	
        User user = null;

        Class.forName("com.mysql.jdbc.Driver");

        try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tasklist", "root", "");

        PreparedStatement preparedStatement = connection.prepareStatement(LOG_USERS_SQL)){
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            try(ResultSet resultSet = preparedStatement.executeQuery();){
            	if(resultSet.next()){
            		user = new User();
            		user.setId(resultSet.getInt("id"));
            		user.setUsername(resultSet.getString("username"));
            		user.setPassword(resultSet.getString("password"));
            		user.setName(resultSet.getString("name"));
            		user.setEmail(resultSet.getString("email"));
            	}
            }catch(SQLException e){
	            e.printStackTrace();
	        }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    
        return user;
 	}
}
