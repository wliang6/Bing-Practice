package assignment06;

public class UndergradCourse extends Course{

	public UndergradCourse(){};

	
	@Override
	public boolean isUndergrad(){
		return true;
	}
	
	@Override
	public boolean isGrad(){
		return false;
	}
	
	

}
