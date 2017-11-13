package blog.techrevel.service;

public interface CourseImport {
	//Import pages, videos and assessment 
	public abstract void importContent();
	
	//Identify the service which would be able to process current file
	public abstract boolean canProcess(String fileName);
}
