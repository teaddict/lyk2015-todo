package tr.org.lkd.lyk2015.sampleservlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/list")
public class ListServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		//tüm nesneleri çek
		req.setAttribute("todos", Storage.getInstance().getAllTodos());
		req.getRequestDispatcher("WEB-INF/list.jsp").forward(req,resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		String done = "false";
		String i = req.getParameter("id"); 
		Long id = Long.valueOf(i).longValue();
		
		//nesneyi id ile çağır ve "done" variable kontrol et
		//eğer true ise false
		//false ise true olarak değiştir
		Todo todo = Storage.getInstance().getById(id);
		if(todo.getDone())
			done = "false";
		else
			done = "true";
		
		//nesneyi güncelle
		Storage.getInstance().mark(id, done);
		
		//yönlendirme
		req.setAttribute("todos", Storage.getInstance().getAllTodos());
		req.getRequestDispatcher("WEB-INF/list.jsp").forward(req,resp);
	}

}
