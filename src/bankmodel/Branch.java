package bankmodel;

import java.util.ArrayList;

public class Branch {
	private String identifier;
	private ArrayList<User> employees;
	
	public Branch(String identifier, ArrayList<User> employees){
		this.setIdentifier(identifier);
		this.setEmployees(employees);
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public ArrayList<User> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<User> employees) {
		this.employees = employees;
	}
	
	
}
