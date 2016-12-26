package lab10;

public class Student implements Comparable<Student>{
	private Person person;
	private int GPA;
	
	public Student(Person person, int GPA) {
		this.person = person;
		this.GPA = GPA;
	}
	
	public Person getPerson() {
		return person;
	}
	
	public int getGPA() {
		return GPA;
	}
	
	@Override
	public String toString(){
		return person + " (" + GPA + ")"; 
	}
	
	@Override
	public int compareTo(Student other) {
		return this.person.compareTo(other.person);
	}
	
	public static int compareByGPA(Student a, Student b) {
		return a.GPA - b.GPA; 
	}
	
	public static int compareByNameLength(Student a, Student b){
		return fullnameLength(a) - fullnameLength(b);
	}
	
	public static int fullnameLength(Student s){
		return s.person.getFirstname().length() + s.person.getLastname().length();
	}
}
