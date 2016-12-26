package assignment07;

public class Mul implements Expr{

	private final Expr left;
	private final Expr right;
	
	public Mul(final Expr left, final Expr right){
		this.left = left;
		this.right = right;
	}
	
	@Override
	public int eval(){
		return this.left.eval() * this.right.eval();
	}
}
