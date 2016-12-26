package assignment07;

public class Neg implements Expr{

	private final Expr left;

	public Neg(final Expr left){
		this.left = left;
	}
	
	@Override
	public int eval() {
		return this.left.eval() == 0 ? 1 : 0;
	}

}
