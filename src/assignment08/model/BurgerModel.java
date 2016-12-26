package assignment08.model;

import assignment08.view.DynamicScreenManager;

public abstract class BurgerModel {
	String language = "English";
	DynamicScreenManager screen = DynamicScreenManager.getHandle();
	
	public void setLanguage(String s) {
		language = s;
		screen.update();
	}
	public String getLanguage() {
		return language;
	}	
	public abstract int getTotalCalories();
	public abstract Double getTotalCost();
	
}
