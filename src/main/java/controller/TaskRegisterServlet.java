package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Task;
import dao.TaskDao;

@WebServlet("/taskRegister")
public class TaskRegisterServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	TaskDao taskDao = new TaskDao();

    public TaskRegisterServlet(){}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/taskRegister.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String title = request.getParameter("title");
        String description = request.getParameter("description");
System.out.println(title);
        
		if(!(("".equals(title)) || ("".equals(description)))){
	        Task task = new Task();
	        task.setTitle(title);
	        task.setDescription(description);
	
	        try{
	            taskDao.registerTask(task);
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
			dispatcher.forward(request, response);
        }
	}
}
