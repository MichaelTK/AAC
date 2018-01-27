package bankmodel;

public class Resource {
	private String name;
	private String location;
	
	public Resource(String name, String location){
		this.name = name;
		this.location = location;
	}
	
	public String getName(){
		return name;
	}
	
	public String getLocation(){
		return location;
	}
}
