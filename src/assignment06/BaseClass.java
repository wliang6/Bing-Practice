package assignment06;

public class BaseClass {
private String field0;

public BaseClass(String s) {
	field0 = s;
	}

public String toString() {
	   return field0;
	}

public static void main(String[] args){
	System.out.println(new BaseClass("Hello World"));
	System.out.println(new Derived1("Hello World","Apple"));
	System.out.println(new Derived2("Hello World","Banana"));
}
}
