package tr.org.lkd.lyk2015.sampleservlet;

import java.util.Calendar;
import java.util.Date;

public class Todo {

	static int counter = 0;
	private final long id ;
	private String name;
	private String desc;
	private Calendar datetime;
	private Boolean done;
	
	public Todo(String name,String desc,Calendar datetime, Boolean done) {
		// TODO Auto-generated constructor stub
		this.id = counter++;
		this.name = name;
		this.desc = desc;
		this.datetime = datetime;
		this.done = done;
		
	}
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Calendar getDatetime() {
		return datetime;
	}
	public void setDatetime(Calendar datetime) {
		this.datetime = datetime;
	}
	
	public Boolean getDone() {
		return done;
	}
	public void setDone(Boolean done) {
		this.done = done;
	}
	
	
}
