package assignment02;
// /**
// This program computes how long it takes for an investment
// to double. */
public class InvestmentRunner {
  public static void main(String[] args) {
    //final double INITIAL_BALANCE = 10000;
    //final double RATE = 5;
    //Investment invest = new Investment(INITIAL_BALANCE, RATE); 
    //invest.waitForBalance(2 * INITIAL_BALANCE);
    //int years = invest.getYears();
    //System.out.println("The investment doubled after " + years + " years");

		DollarsAndCents dac = new DollarsAndCents();
		dac.setDollars(10000);
		DollarsAndCents targetBalance = new DollarsAndCents();
		targetBalance.setDollars((dac.getDollars()) * 2);

		final long RATE = 5;

		Investment invest = new Investment(dac, RATE);
		
		
		invest.waitForBalance(targetBalance);
		int years = invest.getYears();
		System.out.println("The investment doubled after "
				+ years + " years");
  }
}
