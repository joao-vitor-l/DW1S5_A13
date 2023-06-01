package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Task;
import dao.TaskDao;

@WebServlet("/main")
public class MainServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
       
    public MainServlet(){
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/main.jsp");
		dispatcher.forward(request,  response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		/* Minha lógica:
		 * 
		 * LoginServlet envia o idUser para MainServlet através de 
		 * request.setAttribute("idUser", user.getId());
		 * 
		 * MainServlet utiliza esse id em taskDao.getTasks,
		 * e a lista de tarefas retornada é consultada pelo main.jsp.
		 * 
		 * No entanto, a lista está retornando vazia e a pág. principal
		 * não está sendo populada.
		 */
		
		int idUser = Integer.parseInt(request.getParameter("idUser"));
		
		TaskDao taskDao = new TaskDao();
		List<Task> tasks = null;
		
		try{
			tasks = taskDao.getTasks(idUser);
		}catch(Exception e){
            e.printStackTrace();
        }
		
		request.setAttribute("tasks", tasks);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/main.jsp");
        dispatcher.forward(request, response);
	}
}
