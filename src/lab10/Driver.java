package lab10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Driver {
	public static void main(String[] args){
		//Person objects
		Person p1 = new Person("Chris", "Rock");
		Person p2 = new Person("Michael", "Pratt");
		Person p3 = new Person("Chris", "Pratt");
		Person p4 = new Person("Jennifer", "Lawrence");
		Person p5 = new Person("Emma", "Watson");
		Person p6 = new Person("Michael", "Phelps");
		
		List<Person> people = new ArrayList<Person>();
		people.add(p1); people.add(p2); people.add(p3); 
		people.add(p4); people.add(p5); people.add(p6);
		
		System.out.println("People sort by last names");
		sortCopy(people);
		System.out.println("");
		
		//Student objects
		Student s1 = new Student(p1, 100);
		Student s2 = new Student(p2, 95);
		Student s3 = new Student(p3, 80);
		Student s4 = new Student(p4, 85);
		Student s5 = new Student(p5, 92);
		Student s6 = new Student(p6, 87);
		
		List<Student> students = new ArrayList<Student>();
		students.add(s1); students.add(s2); students.add(s3); 
		students.add(s4); students.add(s5); students.add(s6);
		
		System.out.println("Students sort by last names");
		sortCopy(students);
		System.out.println("");
		
		System.out.println("Students sort by GPA");
		Comparator<Student> byStudents = Student::compareByGPA;
		sortCopyBy(students, byStudents);
		System.out.println("");
		
		System.out.println("Students sort by fullname length");
		Comparator<Student> byFullnameLength = Student::compareByNameLength;
		sortCopyBy(students, byFullnameLength);
		System.out.println("");
		
		//BONUS CREDIT
		System.out.println("BONUS: Sort by descending GPA");
		Collections.sort(students, byStudents.reversed());
		System.out.println(students);
		System.out.println("");
		
		System.out.println("BONUS: Sort by ascending length of full name");
		Collections.sort(students, byFullnameLength);
		System.out.println(students);
		System.out.println("");
	}
	
	
	public static <T extends Comparable<T>> void sortCopy(List<T> list) {
		List<T> copy = new ArrayList<>(list);
	    System.out.println(copy);
	    Collections.sort(copy);
	    System.out.println(copy);
	}
	
	public static <T> void sortCopyBy(List<T> list, Comparator<? super T> comp) {
	    List<T> copy = new ArrayList<>(list);
	    System.out.println(copy);
	    Collections.sort(copy, comp);
	    System.out.println(copy);
	}
}
