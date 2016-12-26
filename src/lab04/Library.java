package lab04;
import java.util.ArrayList;

public class Library {
	
	private static ArrayList<Book> books;
	
	public Library(){
		books = new ArrayList<>();
	}
	
	public void addBook(Book b){
		if(b != null){
			books.add(b);
		}else{
			throw new NullPointerException("Book is null!");
		}
	}
	
	public int numBooks(){
		return books.size();
	}
	
	public static void printLibrary(){
		System.out.println(books);
	}
	
	public double averageLengthOfBooks(){
		double sum = 0;
		if(!books.isEmpty()){
			for(Book book : books){
				sum += book.getNumPages();
			}
		}else{
			return -1.0;
		}
		return sum/books.size();
	}
	
	public Book checkOutBook(int index){
		return books.remove(index);	
	}
	
	
	public static void main(String[] args){
		Library lib = new Library();
		Book b1 = new Book("Of Mice and Men", 187);
		Book b2 = new Book("Lord of the Flies", 202);
		Book b3 = new Book("Gone with the Wind", 1037);
		lib.addBook(b1);
		lib.addBook(b2);
		lib.addBook(b3);
		
		System.out.println("Current library: ");
		printLibrary();
		System.out.println("The expected average length of the 3 books is : 475.3333333333333");
		System.out.println("The actual average length is: " + lib.averageLengthOfBooks());
		Book removedBook = lib.checkOutBook(2);
		System.out.println("Updated library after checking a book out at index 2: ");
		printLibrary();
		System.out.println("Name of removed book: ");
		System.out.println(removedBook.getTitle());
		
		
		
	}

	
}



