package assignment06;

public class LevelOne extends LevelTwo {
	
	public LevelOne(double[] balances) {
		super(balances);
	}

	@Override
	public double measure() {
		BankAccount[] array = getArray();
		if(array.length == 0) {
			return 0;
		}
		double difference = array[0].getBalance() - super.measure();
		for (int i = 1 ; i < array.length ; i++) {
			double temp = array[i].getBalance() - super.measure();
			if (temp > difference) {
				difference = temp;
			}
		}
		return difference;
	} 
}
