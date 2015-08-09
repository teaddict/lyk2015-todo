package tr.org.lkd.lyk2015.sampleservlet;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Storage {
	private static Storage storage = null;
	private Map<Long,Todo> myTodo = new HashMap<Long,Todo>();
	private static Object lock = new Object();
	
	private Storage() {
		// TODO Auto-generated constructor stub
	}
	
	public static Storage getInstance()
	{

		if(storage == null) 
		{
			//double check for duplicate and multi thread
			synchronized(lock) 
			{
				if(storage == null) 
				{
					storage = new Storage();
				}
			}
	        
			storage = new Storage();
	    }
	    return storage;
		
	}
	
	//todo ekle
	public void add(Todo todo) 
	{
		myTodo.put(todo.getId(), todo);
	}
	
	//tüm todo objelerini gönder
	public Collection<Todo> getAllTodos(){
		return myTodo.values();
	}
	
	//checkbox işaretlenirse
	public void mark(long id,String done)
	{
		Todo todo = myTodo.get(id);
		if(done == "true")
		{
			todo.setDone(true);
		}
		else
		{
			todo.setDone(false);
		}
		
	}
	
	public Todo getById(Long id)
	{
		return myTodo.get(id);
	}

}
