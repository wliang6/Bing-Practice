package assignment06;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Student {

	private static int nextID = 10001;
	private String name;
	private int id;
	private Set<Course> schedule;
	private String major;
	private ArrayList<Course> allCourses = new ArrayList<>();
	
	public Student(){
		this.major = new String();
		this.id = nextID;
		nextID++;
		this.schedule = new HashSet<>();
		this.name = Question1.name(id);
	}
	
	protected Set<Course> getSchedule(){
		return this.schedule;
	}
	
	public ArrayList<Course> getAllCourses(){
		return this.allCourses;
	}
	
	public boolean isUndergrad(){
		return false;
	}
	
	public boolean isGrad(){
		return false;
	}
	
	public void adjustSchedule(){}
	
	public boolean hasCourse(int crn){
		for(Course c : schedule){
			if(c.getCrn() == crn)
				return true;
		}
		return false;
	}
}
