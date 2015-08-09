package tr.org.lkd.lyk2015.sampleservlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = ("/edit"))
public class EditServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		
		String i= req.getParameter("id");
		Long id = Long.valueOf(i).longValue();
		//id var mı yok mu kontrol edelim
		if(Storage.getInstance().getById(id)==null)
		{
			req.setAttribute("message", "hata");
		}
		else
		{
		req.setAttribute("todo", Storage.getInstance().getById(id));
		}
		req.getRequestDispatcher("WEB-INF/edit.jsp").forward(req,resp);
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		String name= req.getParameter("name");
	    String desc = req.getParameter("desc");
	    String i = req.getParameter("id");
		Long id = Long.valueOf(i).longValue();
	    String d = req.getParameter("check");
	    Boolean done = false;
	    if(d.equals("on"))
	    {
	    	done = true;
	    }
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
	     //storage e update et
	    Storage.getInstance().update(id, name, desc, datetime, done);
		req.setAttribute("todo", Storage.getInstance().getById(id));
	    req.setAttribute("message", "updated");
		req.getRequestDispatcher("WEB-INF/edit.jsp").forward(req,resp);
	}
	
}
