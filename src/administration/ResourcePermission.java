package administration;

import java.util.ArrayList;

public class ResourcePermission {
	private Resource resource;
	private ArrayList<Right> rights;
	
	public ResourcePermission(Resource resource, ArrayList<Right> rights){
		this.setResource(resource);
		this.setRights(rights);
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public ArrayList<Right> getRights() {
		return rights;
	}

	public void setRights(ArrayList<Right> rights) {
		this.rights = rights;
	}
}
