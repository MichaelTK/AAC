package administration;

import java.util.ArrayList;

public abstract class Resource {
	protected String name;
	protected ArrayList<User> users;
	protected boolean isDirectory;
	
	public Resource(String name){
		this.name = name;
		users = new ArrayList<User>();
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public ArrayList<User> getUsers(){
		return users;
	}
	
	public boolean isDirectory(){
		return isDirectory;
	}
}
