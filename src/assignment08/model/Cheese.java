package assignment08.model;

public class Cheese extends BurgerDecorator {
	private static BurgerModel singleton = new Cheese();
	private Cheese () {
	}
	public static BurgerModel getHandle() {
		return singleton;
	}
	String str = getClass().getSimpleName().toLowerCase();
	
}
