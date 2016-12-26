package assignment03;
/**
 * Class to manage money in dollars and cents
 * 
 * @author CS140
 */
public class DollarsAndCents {
	//the fields are 
	private long DOLLARS;
	private final int CENTS;	

	/**
	 * Constructor that initializes the dollars field to the given amount
	 * @param dlrs The amount of the dollars in the new account. The parameter 
	 * must be a long. If an int is provided a different constructor is 
	 * called
	 * @throws IllegalArgumentException if the parameter is negative
	 */
	public DollarsAndCents(long dlrs) {
		if (dlrs < 0) throw new IllegalArgumentException("argument cannot be negative");
		DOLLARS = dlrs;
		CENTS = 0; // needed since CENTS is final
	}

	/**
	 * Constructor that initializes the cents field to the given amount, or the 
	 * dollars and cents if the number of cents is one dollar or more.
	 * @param cts The amount of the cents in the new account. The parameter 
	 * must be an int. If a long is provided a different constructor is 
	 * called
	 * @throws IllegalArgumentException if the parameter is negative
	 */
	public DollarsAndCents(int cts) {
		if (cts < 0) throw new IllegalArgumentException("argument cannot be negative");
		DOLLARS = cts/100;
		CENTS = cts%100;
	}
	
	/**
	 * Constructor that initializes both the dollars and the cents field to 
	 * the given amounts. The cents are adjusted to be less than one dollar.
	 * @param dlrs The amount of dollars in the new account.  
	 * @param cts The amount of the cents in the new account. if the number of 
	 * cents exceeds a dollar, the excess dollars are added to the dollars field
	 * and only the cents less than one dollar remain.
	 * @throws IllegalArgumentException if either of the parameters is negative
	 */
	public DollarsAndCents(long dlrs, int cts) {
// use the ideas from the previous constructors to see how to do this
		if(dlrs < 0 || cts < 0){
			throw new IllegalArgumentException("argument cannot be negative");
		}
		DOLLARS = dlrs + cts/100;
		CENTS = cts%100;
	}
	
	/**
	 * A copy constructor that makes a new object with the same dollars and
	 * cents values of the parameter
	 * @param dc an object that provides the initial values of the fields
	 * of the new object.
	 */
	public DollarsAndCents(DollarsAndCents dc) {
// just copy the DOLLARS and CENTS values from dc. Even though the fields are private
// you CAN access dc.DOLLARS and dc.CENTS
		DOLLARS = dc.DOLLARS;
		CENTS = dc.CENTS;
	}
	
	/**
	 * A no argument constructor that creates an object with both fields zero.
	 */
	public DollarsAndCents() {
// set DOLLARS and CENTS to 0, final fields cannot be initialized since the constructor may
// change them
		this.DOLLARS = 0;
		this.CENTS = 0;
	}

	/**
	 * Return a new object with the dollars and cents that are the sum of
	 * the fields the receiver and all the parameters. If the amount of cents exceeds 
	 * one dollar the excess is passed to the dollars field. 
	 * @param dcs a list of zero or more DollarsAndCents objects
	 * @return a DollarsAndCents object with the sum of all the dollars and
	 * cents in the receiver and the parameters. 
	 */
	public DollarsAndCents add(DollarsAndCents... dcs) {
// note you treat dcs as an array
// start with long localDlrs = DOLLARS and int localCts = CENTS and then
// add the DOLLARS and CENTS from the dcs elements to those local
// variables. Use these local variables to make the return value
// the constructor will adjust the CENTS to be less than 100
		long localDlrs = DOLLARS;
		int localCts = CENTS;
		DollarsAndCents[] array = dcs;
		for(DollarsAndCents n : array){
			localDlrs = localDlrs + n.DOLLARS;
			localCts = localCts + n.CENTS;
		}
		DollarsAndCents dac = new DollarsAndCents(localDlrs, localCts);
		return dac;
	}
	
//BY THE WAY, the following method suggests we should define an equals method but
//we will do this when we have a chance to talk about the hashCode method
	/**
	 * Tests if this object is less than the parameter. Consider the
	 * dollars and cents as money and test if this amount is less than
	 * the parameter's amount
	 * @param dc a DollarsAndCents object to be compared with this object
	 * @return true if this object is less than the other object in 
	 * terms of dollars and cents, otherwise false
	 */
	public boolean lessThan(DollarsAndCents dc) {
// if dollars is less than dc.dollars the return value is true
// if dollars is equal to dc.dollars then if cents is less
// than dc.cents the return value is true
// otherwise the return value is false
		if(DOLLARS < dc.DOLLARS){
			return true;
		}else if(DOLLARS == dc.DOLLARS && CENTS < dc.CENTS){
			return true;
		}
		return false;
	}
	
	/**
	 * This could produce negative money, so an exception is thrown if the resulting
	 * fields would be negative. Otherwise a new DollarsAndCents object is
	 * returned with the parameter's dollars and cents values subtracted
	 * from the receiver's fields 
	 * @param dc a DollarsAndCents object with values that are subtracted
	 * from the receiver to produce the new object
	 * @return a DollarsAndCents object with fields that are the difference between
	 * the receiver and the parameter
	 * @throws IllegalArgumentException if the parameter is not less than
	 * this object or has fields that are equal to this object 
	 */
	public DollarsAndCents subtract(DollarsAndCents dc) {
// declare a DollarsAndCents return value initially null
// if either of DOLLARS is different from dc.DOLLARS or CENTS is different
// from dc.CENTS then throw an exception if(!dc.lessThan(this)) 
// -- this means dc is not lessThan this object. 
// Continue by defining local variables dlrs and cts equal to
// DOLLARS - dc.DOLLARS and CENTS - dc.CENTS, respectively
// adjust dlrs and cts to make cts positive if necessary.
// the return value is set to a new object with arguments dlrs and cts
// else it is a new object with its fields equal to 0.
		if(!dc.lessThan(this)){
			throw new IllegalArgumentException("argument cannot be negative");
		}
		long localDlrs = DOLLARS;
		int localCts = CENTS;
		localDlrs = localDlrs - dc.DOLLARS;
		localCts = localCts - dc.CENTS;
		DollarsAndCents dac = new DollarsAndCents(localDlrs, localCts);
		return dac;
	}

	/**
	 * Returns a new object that based on the receiver's dollars and cents 
	 * modified by a positive factor.
	 * @param factor the multiplying factor for the new object 
	 * @return a new object with fields that are the receiver's fields
	 * modified by the factor 
	 * @throws IllegalArgumentException if the factor is zero
	 */
	public DollarsAndCents upOrDown(double factor) {
// This computation must be done with doubles
// double temp = (d+c/100.0)*factor;
// the return value will have (long)temp for dollars and
// (int)Math.round((temp - (long)temp)*100) for cents;
		if(factor <= 0){
			throw new IllegalArgumentException("factor cannot be zero");
		}
		long localDlrs = DOLLARS;
		int localCts = CENTS;
		double temp = (localDlrs + localCts/100.0) * factor;
		localDlrs = (long) temp;
		localCts = (int)Math.round((temp-(long)temp)*100);
		DollarsAndCents dac = new DollarsAndCents(localDlrs, localCts);
		return dac; 
	}
	
	public String toString() {
		// this is a method overridden from class Object
		String retVal = "$" + DOLLARS;
		if(CENTS < 10) {
				retVal += ".0" + CENTS;
		} else {
				retVal += "." + CENTS;
		}
		return retVal;
	}

}