package administration;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ControlPanel {
	
	private static ArrayList<Resource> directories;
	private static ArrayList<User> users;
	
	public static void main(String[]args){
		setupDomain();
		
		menu();
	}
	
	private static void generateUsers() {
		users.add(new User("User 1"));
		users.add(new User("User 2"));
		users.add(new User("User 3"));
	}

	private static void generateDirectories() {
		directories.add(new Directory("Dir1"));
		directories.add(new Directory("Dir2"));
		directories.add(new Directory("Dir3"));
	}

	private static void populateDirectories(){
		Random rand = new Random();
		for(int i = 0; i < directories.size(); i++){
			int randomNum = rand.nextInt(4);
			for(int j = 0; j < randomNum; j++){
				Directory directory = (Directory) directories.get(i);
				directory.addFile(new File("File"+j));
			}
		}
	}
	
	private static void populateUserRights(){
		for(int i = 0; i < users.size(); i++){
			users.get(i).generatePermissions(directories);
		}
	}
	
	private static void menu(){
		Scanner scan = new Scanner(System.in);
		
		String choice = "null";
		
		while(!choice.equals("exit")){
			choice = scan.nextLine();
			
			if(choice.toLowerCase().equals("list resources")){
				listResources();
			}
			else if(choice.toLowerCase().equals("list resource permissions")){
				listResourcePermissions();
			}
			else if(choice.toLowerCase().equals("list inaccessible resources")){
				listInaccessibleResources();
			}
			else if(choice.toLowerCase().equals("list powerless users")){
				listPowerlessUsers();
			}
		}
		scan.close();
	}
	
	private static void setupDomain(){
		directories = new ArrayList<Resource>();
		users = new ArrayList<User>();
		generateDirectories();
		populateDirectories();
		generateUsers();
		populateUserRights();
	}
	
	private static void listPowerlessUsers() {
		for(User user : users){
			if(user.getResourcePermissions().isEmpty()){
				System.out.println(user.getIdentifier());
			}
		}
	}

	private static void listInaccessibleResources() {
		for(Resource directory : directories){
			if(directory.getUsers().isEmpty()){
				System.out.println(directory.getName());
			}
			for(Resource file : ((Directory) directory).getFiles()){
				if(file.getUsers().isEmpty()){
					System.out.println(file.getName());
				}
			}
		}
	}

	private static void listResourcePermissions() {
		for(User user : users){
			System.out.print("\nUser Name: "+user.getIdentifier()+": \n");
			for(ResourcePermission resourcePermission : user.getResourcePermissions()){
				System.out.print("Resource Name: "+resourcePermission.getResource().getName());
				System.out.print("\nResource Rights:");
				for(Right right : resourcePermission.getRights()){
					System.out.print(" "+right.getRight()+" ");
				}
				System.out.print("\n");
			}
		}
	}

	private static void listResources() {
		for(Resource resource : directories){
			System.out.println(resource.getName());
			for(int i = 0; i < ((Directory) resource).getFiles().size(); i++){
				System.out.println(((Directory) resource).getFiles().get(i).getName());
			}
		}
	}
}
