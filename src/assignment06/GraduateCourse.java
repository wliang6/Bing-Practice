package assignment06;

public class GraduateCourse extends Course{


	@Override
	public boolean isUndergrad(){
		return false;
	}
	
	@Override
	public boolean isGrad(){
		return true;
	}
}
