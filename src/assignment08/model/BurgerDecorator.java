package assignment08.model;

import assignment08.model.BurgerDecorator;
import assignment08.model.BurgerModel;
import assignment08.view.ToppingsManager;

public abstract class BurgerDecorator extends BurgerModel {
	protected BurgerModel next;
	protected int calories;
	protected Double price;
	public BurgerModel addTopping(BurgerModel burger) {
		this.next = burger;
		return this;  
	}
	public BurgerModel removeTopping (BurgerDecorator topping) {
		BurgerModel retVal = this;
		if(this==topping){
			retVal = next;
		}
		else
			next = ((BurgerDecorator)next).removeTopping (topping);
		return retVal;
	}
	
	public int getTotalCalories() {
		String str = getClass().getSimpleName().toLowerCase();
		return ToppingsManager.toppingsMap.get(str).getCalories() 
				+ next.getTotalCalories();
	}

	public Double getTotalCost() {
		String str = getClass().getSimpleName().toLowerCase();
		return  ToppingsManager.toppingsMap.get(str).getCost() + next.getTotalCost();
	}


}
