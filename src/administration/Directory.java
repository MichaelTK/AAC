package administration;

import java.util.ArrayList;

public class Directory extends Resource {
	private ArrayList<File> files;
	
	public Directory(String name){
		super(name);
		isDirectory = true;
		files = new ArrayList<File>();
	}
	
	public ArrayList<File> getFiles(){
		return files;
	}
	
	public void addFile(File file){
		files.add(file);
	}
	
	public File getFile(int index){
		return files.get(index);
	}
}
