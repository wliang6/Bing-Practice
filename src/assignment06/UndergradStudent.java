package assignment06;

import java.util.Random;
import java.util.Set;

public class UndergradStudent extends Student{

	
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
}
