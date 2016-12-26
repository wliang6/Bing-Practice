package assignment06;

import java.util.Random;
import java.util.Set;

public class GraduateStudent extends Student{

	private String undergradMajor;
	
	
	@Override
	public boolean isGrad(){
		return true;
	}
	
	@Override
	public void adjustSchedule(){
		Random rand = new Random();
		Set<Course> schedule = this.getSchedule();
		Course[] copy = new Course[schedule.size()];
		schedule.toArray(copy);
		while(countUndergradCourses(schedule) > 1){
			for(Course c : copy){
				if(c.isUndergrad()){
					schedule.remove(c);
					while(schedule.size() != 4){
						GraduateCourse g = new GraduateCourse();
						if(!this.hasCourse(g.getCrn())){
							schedule.add(g);
						}
					}
				}
			}
		}
	}
	
	public int countUndergradCourses(Set<Course> schedule){
		int counter = 0;
		for(Course c : schedule){
			if(c.isUndergrad()) counter++;
		}
		return counter;	
	}
	
	public boolean hasUndergradClass(){
		Set<Course> schedule = getSchedule();
		for(Course c : schedule){
			if(c.isUndergrad())
				return true;
		}
		return false;
	}
}
