package assignment06;

import java.util.HashSet;
import java.util.Set;

public class Course {

	static int nextCRN = 10001;
	private String title;
	private int crn;
	private Set<Student> enrollment;
	
	public Course(){
		
	}
	
	public Course(String title){
		this.title = title;
		this.crn = nextCRN;
		nextCRN++;
		this.enrollment = new HashSet<>();
	}
	
	public boolean isUndergrad(){
		throw new UnsupportedOperationException("No information about level of the course");
	}
	
	public boolean isGrad(){
		throw new UnsupportedOperationException("No information about level of the course");
	}
	
	public int getCrn() {
		return crn;
	}
	
	public Set<Student> getEnrollment(){
		return this.enrollment;
	}
	
	public void tallyEnrollment(Student[] allStudents){
		Set<Student> e = new HashSet<Student>(); 
		for(Student s : allStudents){
			if(s.hasCourse(crn)){
				e.add(s);
			}
		}
		this.enrollment = e;
	}
}
