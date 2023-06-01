package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import model.Task;
import model.User;

public class TaskDao{
	public int registerTask(Task task) throws ClassNotFoundException{
        String INSERT_TASKS_SQL = "INSERT INTO task" +
            " (title, description) VALUES " +
            " (?, ?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/tasklist", "root", "");

        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TASKS_SQL)){
    	
            preparedStatement.setString(1, task.getTitle());
            preparedStatement.setString(2, task.getDescription());

            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    
		return result;
    }
	
	public List<Task> getTasks(int idUser) throws ClassNotFoundException{
		String SELECT_TASK = "SELECT id, title, description, creationDate, conclusionDate, status, idUser FROM task" +
				" WHERE idUser=?";
		
		List<Task> tasks = null;
		Task task = null;
		
		Class.forName("com.mysql.jdbc.Driver");
		 
		try(Connection connection = DriverManager
		            .getConnection("jdbc:mysql://localhost:3306/tasklist", "root", "");
				 
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TASK)){
			preparedStatement.setInt(1, idUser);
			 
			System.out.println(preparedStatement);
			 
			try(ResultSet resultSet = preparedStatement.executeQuery();){
				tasks = new ArrayList<>();
				while(resultSet.next()){
					task = new Task();
					task.setId(resultSet.getInt("id"));
					task.setTitle(resultSet.getString("title"));
					task.setDescription(resultSet.getString("description"));
					task.setCreationDate_Str(resultSet.getString("creationDate"));
					task.setConclusionDate_Str(resultSet.getString("conclusionDate"));
					task.setStatus(resultSet.getString("status"));
					task.setIdUser(resultSet.getInt("idUser"));
            		tasks.add(task);
            		}
			 }catch(SQLException e){
		            e.printStackTrace();
	        }
		 }catch(SQLException e){
	            e.printStackTrace();
		 }
		return tasks;
	}
}
