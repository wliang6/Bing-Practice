package assignment06;

public class Derived1 extends BaseClass {
	private String field1;
	
	public Derived1(String s1, String s2) {
		super(s1);
		field1=s2;
	}
	
	public String toString() {
		return super.toString() + " " + field1;
		 
		}
}
