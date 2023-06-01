package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.User;
import dao.UserDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	UserDao userDao = new UserDao();
       
    public LoginServlet(){
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/login.jsp");
		dispatcher.forward(request,  response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = null;
        
        try{
            user = userDao.logUser(username, password);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        if(user != null){
        	request.setAttribute("idUser", user.getId());
        	
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/main.jsp");
    		dispatcher.forward(request, response);
        }else{
        	System.out.println("Incorrect username/password.");
        	
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
    		dispatcher.forward(request, response);
        }
	}
}
