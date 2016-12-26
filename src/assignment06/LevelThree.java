package assignment06;

public class LevelThree extends LevelFour {
	private BankAccount[] array;
	
	public BankAccount[] getArray() {
		return array;
	}
	
	public LevelThree(double[] balances) {
		super(balances.length);
		BankAccount[] array = new BankAccount [balances.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = new BankAccount(balances[i]);
		}
		}
	
	@Override
	public double measure() {
		double sum = 0.0;
		for (int i = 0 ; i < array.length ; i++) {
			sum = sum + array[i].getBalance();
		}
		return sum;
	}
	
	public double distance(int i, double mean) {
		double difference;
		difference = array[i].getBalance() - mean;
		return Math.abs(difference);
	}
}

