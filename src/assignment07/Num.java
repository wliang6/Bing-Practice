package assignment07;

public class Num implements Expr{

	private final int value;
	
	public Num(final int value) {
		this.value = value;
	}
	
	public int eval(){
		return this.value;
	}
}
