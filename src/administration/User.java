package administration;

import java.util.ArrayList;
import java.util.Random;

public class User {
	private String identifier;
	private ArrayList<ResourcePermission> resourcePermissions;
	
	public User(String identifier){
		this.setIdentifier(identifier);
		resourcePermissions = new ArrayList<ResourcePermission>();
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public ArrayList<ResourcePermission> getResourcePermissions() {
		return resourcePermissions;
	}

	public void setResourcePermissions(ArrayList<ResourcePermission> resourcePermissions) {
		this.resourcePermissions = resourcePermissions;
	}
	
	public void generatePermissions(ArrayList<Resource> resources){
		generatePermissionsForResources(resources);
		ArrayList<Resource> files = new ArrayList<Resource>();
		for(Resource resource : resources){
			Directory directory = (Directory) resource;
			for(int i = 0; i < directory.getFiles().size(); i++){
				files.add((Resource) directory.getFile(i));
			}
			generatePermissionsForResources(files);
		}
	}

	private void generatePermissionsForResources(ArrayList<Resource> resources) {
		Random rand = new Random();
		for(Resource resource : resources){
			int randNum = rand.nextInt(4);
			switch(randNum){
			case 0:
				break;
			case 1:
				addRight("read",resource);
				break;
			case 2:
				addRight("write",resource);
				break;
			case 3:
				addRight("execute",resource);
				break;
			}
		}
	}
	
	private void addRight(String right, Resource resource){
		ArrayList<Right> rights = new ArrayList<Right>();
		rights.add(new Right(right));
		resourcePermissions.add(new ResourcePermission(resource, rights));
		resource.getUsers().add(this);
	}

}
