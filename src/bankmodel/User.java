package bankmodel;

import java.util.HashMap;

public class User {
	private String name;
	private HashMap<Resource, String> accessRights;
	private String status;
	
	public User(String name, HashMap<Resource, String> accessRights, String status){
		this.name = name;
		this.accessRights = accessRights;
		this.status = status;
	}
	
	public User(String name, String status){
		this.name = name;
		this.status = status;
	}
	
	public String getName(){
		return name;
	}
	
	public HashMap<Resource, String> getAccessRights(){
		return accessRights;
	}
	
	public void setAccessRights(HashMap<Resource, String> accessRights){
		this.accessRights = accessRights;
	}
	
	public void addAccessRight(Resource res, String rights){
		accessRights.put(res, rights);
	}
	
	public void removeAccessRight(Resource res, String rights){
		accessRights.remove(res);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
