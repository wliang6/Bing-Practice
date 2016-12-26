package assignment07;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import assignment06.Course;
import assignment06.Student;
import assignment06.UndergradCourse;

public class UndergradStudent extends Student{

//	public UndergradStudent(String major){
//		super(major);
//	}

	@Override
	public boolean isUndergrad(){
		return true;
	}

	@Override
	public void adjustSchedule(){
		Random rand = new Random();
		Set<Course> schedule = this.getSchedule();
		Course[] copy = new Course[schedule.size()];
		schedule.toArray(copy);
		while(countGradCourses(schedule) > 2){
			for(Course c : copy){
				if(c.isGrad()){
					schedule.remove(c);
					while(schedule.size() != 4){
						UndergradCourse u = new UndergradCourse();
						if(!this.hasCourse(u.getCrn())){
							schedule.add(u);
						} 
					}
				}
			}
		}
	}

	public int countGradCourses(Set<Course> schedule){
		int counter = 0;
		for(Course c : schedule){
			if(c.isGrad()) counter++;
		}
		return counter;
	}

	public boolean satifiesCSGened(){
		try (PrintWriter out = new PrintWriter("src/assignment07/test.log")) {

			ArrayList<Set<CSGened>> waysToSatisfy = new ArrayList<>();
			waysToSatisfy.add(new HashSet<CSGened>());
			boolean Csatisfied = false, Osatisfied = false, F1satisfied = false;
			for(Course crs : getAllCourses()){
				if(crs instanceof CSGenedCourse){
					CSGenedCourse gecrs = (CSGenedCourse) crs;
					out.println(Arrays.toString(gecrs.getGeneds()));
					
					int sz = waysToSatisfy.size();
					int len = gecrs.getGeneds().length;
					if(len > 1){
						for(int i = 0; i < len-1; i++){
							for(int j = 0; j < sz; j++){
								HashSet<CSGened> hs = new HashSet<>();
								hs.addAll(waysToSatisfy.get(j));
								waysToSatisfy.add(hs);
								
								if(gecrs.getGeneds()[i] == CSGened.C) Csatisfied = true;
								else if(gecrs.getGeneds()[i] == CSGened.O) Osatisfied = true;
								else if(gecrs.getGeneds()[i] == CSGened.J){ Csatisfied = true; Osatisfied = true;}
								else if(gecrs.getGeneds()[i] == CSGened.F1) F1satisfied = true;
								else{
									waysToSatisfy.get(j).add(gecrs.getGeneds()[i]);
								}
							}
						}
					}			
				}
			}
			for(Set<CSGened> s : waysToSatisfy){ 
				out.println(s);
				if(s.contains(CSGened.B)){
					s.remove(CSGened.B);
					s.add(CSGened.S);
					s.add(CSGened.Y);
				}
				out.println(s + " " + Csatisfied + " " + Osatisfied + " " + F1satisfied);
				return (s.size() == 9 && Csatisfied && Osatisfied && F1satisfied) ? true : false;
			}
			
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	public static void main(String[] args){
		UndergradStudent ugstu = new UndergradStudent();
		ugstu.getAllCourses().add(new CSGenedCourse(new CSGened[] {CSGened.B}));
		ugstu.getAllCourses().add(new CSGenedCourse(new CSGened[] {CSGened.H}));
		ugstu.getAllCourses().add(new CSGenedCourse(new CSGened[] {CSGened.C, CSGened.P, CSGened.N}));
		ugstu.getAllCourses().add(new CSGenedCourse(new CSGened[] {CSGened.G, CSGened.C}));
		ugstu.getAllCourses().add(new CSGenedCourse(new CSGened[] {CSGened.G}));
		ugstu.getAllCourses().add(new CSGenedCourse(new CSGened[] {CSGened.G, CSGened.O, CSGened.P}));
		ugstu.getAllCourses().add(new CSGenedCourse(new CSGened[] {CSGened.F1, CSGened.A, CSGened.J}));
		
		ugstu.satifiesCSGened();
	}
}
