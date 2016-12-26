package lab04;

public class Book {
	
	private String title;
	private int numPages;
	
	public Book(String title, int numPages){
		this.title = title;
		this.numPages = numPages;
		if(numPages < 0){
			throw new IllegalArgumentException("Integer passed should be positive!");
		}
	}
	
	//Getter methods
	public String getTitle(){
		return this.title;
	}
	
	public int getNumPages(){
		return this.numPages;
	}
	
	@Override
	public String toString(){
		return title + " (" + numPages + ")"; 
	}
	
}
