package tr.org.lkd.lyk2015.sampleservlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Calendar;
import java.util.Date;

@WebServlet(urlPatterns = "/new")
public class TodoServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		req.getRequestDispatcher("WEB-INF/new.jsp").forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		 String name= req.getParameter("name");
	     String desc = req.getParameter("desc");
	     String dt = req.getParameter("datetime");
	     Calendar datetime = Calendar.getInstance();
	     
	     try
	     {
	    	 DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		     Date date = formatter.parse(dt);
	    	 datetime.setTime(date);
	     }
	     catch (ParseException ex)
	     {
	            System.out.println("Exception "+ex);
	     }
	     Boolean done = false;
	     //nesne oluştur
	     Todo todo = new Todo(name,desc,datetime,done);
	     //storage e ekle nesnemizi
	     Storage.getInstance().add(todo);
	     
	     resp.sendRedirect("list");
	     
	}
}
