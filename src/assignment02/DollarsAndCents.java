// Implement all the code for the following class
package assignment02;
/**
 * Class to manage money in dollars and cents *
 * @author CS140
 */
public class DollarsAndCents {
	// We need two private fields: a long called dollars and an int called cents
	private long dollars;
	private int cents;
	/**
	 * Constructor that initializes the dollars field to the given amount
	 * @param dlrs The amount of the dollars in the new account. The parameter 
	 * must be a long. If an int is provided a different constructor is
	 * called
	 * @throws IllegalArgumentException if the parameter is negative
	 */
	public DollarsAndCents(long dlrs) {
		// this one is implemented for you check how the exception is thrown  
		if (dlrs < 0){
			throw new IllegalArgumentException("argument cannot be negative");
		}
		dollars = dlrs;
		cents = 0;
	}

	/**
	 * Constructor that initializes the cents field to the given amount, or the * dollars and cents if the number of cents is one dollar or more.
	 * @param cts The amount of the cents in the new account. The parameter
	 * must be an int. If a long is provided a different constructor is
	 * called
	 * @throws IllegalArgumentException if the parameter is negative
	 */
	public DollarsAndCents(int cts) {
		// this one is done for you. Note that if we called new DollarsAndCents(456), // dollars would he 4 and cents would be 56 (cents cannot exceed 99)
		if (cts < 0){
			throw new IllegalArgumentException("argument cannot be negative");
		}
		dollars = cts/100;
		cents = cts%100;
	}

	/**
	 * Constructor that initializes both the dollars and the cents field to
	 * the given amounts. The cents are adjusted to be less than one dollar.
	 * @param dlrs The amount of dollars in the new account.
	 * @param cts The amount of the cents in the new account. if the number of
	 * cents exceeds a dollar, the excess dollars are added to the dollars field 
	 * and only the cents less than one dollar remain.
	 * @throws IllegalArgumentException if either of the parameters is negative */
	public DollarsAndCents(long dlrs, int cts) {
		// use the ideas from the previous constructors to see how to do this
		if(dlrs < 0 || cts < 0){
			throw new IllegalArgumentException("argument cannot be negative");
		}
		dollars = dlrs + cts/100;
		cents = cts%100;
	}

	/**
	 * A copy constructor that makes a new object with the same dollars and * cents values of the parameter
	 * @param dc an object that provides the initial values of the fields
	 * of the new object.
	 */
	public DollarsAndCents(DollarsAndCents dc) {
		// just copy the dollars and cents values from dc. Even though the fields are private 
		// you CAN access dc.dollars and dc.cents
		dollars = dc.dollars;
		cents = dc.cents;
	}
	
	/**
	 * A no argument constructor that creates an object with both fields zero. */
	public DollarsAndCents() {	
		this.dollars = 0;
		this.cents = 0;
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

		DollarsAndCents[] array = dcs;
		for(DollarsAndCents n : array){
//			dollars = n.dollars + n.cents/100;
//			cents = n.cents%100;	
			dollars += n.dollars;
			cents += n.cents;
		}
		DollarsAndCents dac = new DollarsAndCents(dollars, cents);
		return dac; // note you treat dcs as an array
		// the cents in the return value must be less than 100
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
		if(dollars < dc.dollars){
			return true;
		}else if(dollars == dc.dollars && cents < dc.cents){
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
		// make an return-value object with two fields that are 0
		// that is the return value if dollars and cents are equal to
		// dc.dollars and dc.cents.
		// if one or other of those values are different, throw an exception
		// if(!dc.lessThan(this)) -- this means dc is not lessThan this object
		// the code continues by making the dollars of the return-value object equal to 
		// dollars - dc.dollars and the cents of the return-value object equal to
		// cents - dc.cents. Now this may make the cents of the return-value negative 
		// and in that case you have to reduce the dollars by 1 and add 100 to cents
		if(dc.dollars > dollars || dc.cents > cents){
			throw new IllegalArgumentException("argument cannot be negative");
		}
		dollars = dollars - dc.dollars;
		cents = cents - dc.cents;
		DollarsAndCents dac = new DollarsAndCents(dollars, cents);
		return dac;
	}
	
	/**
	 * Returns a new object that based on the receiver's dollars and cents 
	 * modifies by a positive factor.
	 * @param factor the multiplying factor for the new object
	 * @return a new object with fields that are the receiver's fields 
	 * modified by the factor
	 * @throws IllegalArgumentException if the factor is zero
	 */
	public DollarsAndCents upOrDown(double factor) {
		// This computation must be done with doubles
		// double temp = (d+c/100.0)*factor;
		// the return value with have (long)temp for dollars and 
		// (int)Math.round((temp - (long)temp)*100);
		if(factor <= 0){
			throw new IllegalArgumentException("factor cannot be zero");
		}
		DollarsAndCents dac = new DollarsAndCents(dollars, cents);
		double temp = (dollars + cents/100.0) * factor;
		dac.dollars = (long) temp;
		dac.cents = (int)Math.round((temp-(long)temp)*100);
		return dac; 
	}
	
	@Override
	public String toString() {
		// this is a method overridden from class Object 
		return "$" + dollars + "." + cents;
	} 
	
	//Getter and setter methods for dollars and cents
	public long getDollars(){
		return this.dollars;
	}
	
	public void setDollars(long dollars){
		this.dollars = dollars;
	}
	
	public int getCents(){
		return this.cents;
	}
	
	public void setCents(int cents){
		this.cents = cents;
	}

}

