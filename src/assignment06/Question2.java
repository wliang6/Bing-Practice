package assignment06;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Question2 {
	
	public static Course[] courseArray = new Course[600];
	public static Student[] studentArray = new Student[6000];
	static Random rand = new Random();
	static{
		String x = Question1.name(rand.nextInt(308915776));
		for(int i = 0; i < 400; i++){
			courseArray[i] = new UndergradCourse();
		}
		for(int i = 400; i < 600; i++){
			courseArray[i] = new GraduateCourse();
		}
		for(int i = 0; i < 5000; i++){
			studentArray[i] = new UndergradStudent(); 
		}
		for(int i = 5000; i < 6000; i++){
			studentArray[i] = new GraduateStudent();
		}
		
		ArrayList<Course> courseList = new ArrayList<Course>(Arrays.asList(courseArray));
		Collections.shuffle(courseList);
		courseArray = courseList.toArray(courseArray);
		
		ArrayList<Student> studentList = new ArrayList<Student>(Arrays.asList(studentArray));
		Collections.shuffle(studentList);
		studentArray = studentList.toArray(studentArray);
		
		for(Student s : studentArray){
			while(s.getSchedule().size() != 4){
				s.getSchedule().add(courseArray[rand.nextInt(600)]);
				s.adjustSchedule();
			}
		}
		
		for(Course c : courseArray){
			c.tallyEnrollment(studentArray);
		}
		
	}
	
	public static void main(String[] args){
		System.out.println("Maximum class size: " + maxClassSize(courseArray));
		System.out.println("Minimum non-empty class size: " + minClassSize(courseArray));
		System.out.println("Average class size: " + avgClassSize(courseArray));
		System.out.println("Percentage of grad students taking an undergrad class: " +
				totalGradsTakingUGClasses(studentArray));
	}

	public static int maxClassSize(Course[] courses){
		int max = 0;
		for(Course c : courses){
			if(c.getEnrollment().size() > max){
				max = c.getEnrollment().size();
			}
		}
		return max;
	}
	
	public static int minClassSize(Course[] courses){
		int min = 100;
		for(Course c : courses){
			if(c.getEnrollment().size() <= min){
				min = c.getEnrollment().size();
			}
		}
		return min;
	}
	
	public static int avgClassSize(Course[] courses){
		int avg = 0;
		for(Course c : courses){
			avg += c.getEnrollment().size();
		}
		return avg/courses.length;
	}
	
	public static double totalGradsTakingUGClasses(Student[] students){
		double gradsInUGClass = 0;
		double grads = 1000;
		for(Student s : students){
			if(s.isGrad()){
				if(((GraduateStudent) s).hasUndergradClass()) gradsInUGClass++;
			}
		}
		return gradsInUGClass / grads;
	}

}
