package tr.org.lkd.lyk2015.sampleservlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/test","/init"})
public class TestServlet extends HttpServlet{

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			//super.doGet(req, resp);
			
			Todo t1 = new Todo("teknoloji","usb kablo alincak",Calendar.getInstance(),false);
			Todo t2 = new Todo("market","su alincak",Calendar.getInstance(),false);
			Todo t3 = new Todo("fatura","elektrik odencek",Calendar.getInstance(),true);
			Todo t4 = new Todo("beyaz esya","taksit odencek",Calendar.getInstance(),false);
			
			
			Storage.getInstance().add(t1);
			Storage.getInstance().add(t2);
			Storage.getInstance().add(t3);
			Storage.getInstance().add(t4);
			
			System.out.println("test created");
			resp.sendRedirect("list");
		}
}
