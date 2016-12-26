package assignment06;

public class LevelTwo extends LevelThree {

	public LevelTwo(double[] balances) {
		super(balances);	
	}

	@Override
	public double measure() {
		double average;
		if (value() == 0) {
			return 0;
		}
		else {
		average = super.measure() / value(); 
		}
		return average;
	}
}
