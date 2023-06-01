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

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	UserDao userDao = new UserDao();

    public SignUpServlet(){}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/signup.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        if(!(("".equals(username)) || ("".equals(password) || ("".equals(name)) || ("".equals(email))))){
	        User user = new User();
	        user.setUsername(username);
	        user.setPassword(password);
	        user.setName(name);
	        user.setEmail(email);
	
	        try{
	            userDao.registerUser(user);
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
			dispatcher.forward(request, response);
        }
	}
}
