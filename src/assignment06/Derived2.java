package assignment06;

public class Derived2 extends BaseClass {
	private String field2;
	
	public Derived2(String s1,String s2) {
		super(s1);
		field2=s2;
	}
	
	public String toString() {
		   return field2 + " " + super.toString();
		   
		}
}
