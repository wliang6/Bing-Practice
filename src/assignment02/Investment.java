
// Here are the methods from Chapter 6 of the textbook for an Investment and testing class InvestmentRunner. 
// Copy the mover and modify Investment by replacing double balance, double aBalance, double targetBalance, and double getBalance() by DollarsAndCents balance, DollarsAndCents
// aBalance, DollarsAndCents targetBalance, and DollarsAndCents getBalance(). You will also need to make a couple of changes to InvestmentRunner.
package assignment02;
// /**
// A class to monitor the growth of an investment that
// accumulates interest at a fixed annual rate. */
public class Investment {
	private DollarsAndCents balance;
	private long rate;
	private int year = 0;
	// /**
	// Constructs an Investment object from a starting balance and interest rate.
	// @param aBalance the starting balance
	// @param aRate the interest rate in percent
	// */
	public Investment(DollarsAndCents aBalance, long aRate) {
		balance = aBalance;
		rate = aRate;
	}
	// /**
	// Keeps accumulating interest until a target balance has been reached.
	// @param targetBalance the desired balance
	// */
	public void waitForBalance(DollarsAndCents targetBalance) {
		long interest = balance.getDollars() * rate / 100;
		while (balance.getDollars() < targetBalance.getDollars()) { 
			year++;
			balance.setDollars(balance.getDollars() + interest);
		}   
	}
	// /**
	// Gets the current investment balance. @return the current balance*/
	public DollarsAndCents getBalance() {
		return balance;
	}
	// /**
	// Gets the number of years this investment has accumulated interest.
	// @return the number of years since the start of the investment
	//	          */
	public int getYears() {
		return year;
	} 
}
